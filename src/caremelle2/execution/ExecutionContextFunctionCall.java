package caremelle2.execution;

import java.util.Map;

import caremelle2.exceptions.CaremelleBaseException;
import caremelle2.exceptions.NoMatchingSignatureException;
import aremelle2.Argument;
import aremelle2.AtomicExpressionFunctionCall;
import aremelle2.Function;
import aremelle2.AtomicPattern;
import aremelle2.Parameter;
import aremelle2.Pattern;
import aremelle2.RewriteRule;
import aremelle2.Signature;

public class ExecutionContextFunctionCall extends ExecutionContext {
	
	private final Function callingFunction;
	private final Function calledFunction;
	private final Argument[] arguments;
	
	private Map<String, Parameter> parameterMap;
	
	private int argumentIndex;
	private int rewriteRuleIndex;
	private int signatureIndex;
	private int patternIndex;
	private int atomIndex;
	
	private StringBuilder currentRegexp;
	
	public ExecutionContextFunctionCall(AtomicExpressionFunctionCall call) {
		
		super();
		
		this.callingFunction = call.getCallingFunction();
		this.calledFunction = call.getCalledFunction();
		this.arguments = call.getArguments();
		
		argumentIndex = 0;
		rewriteRuleIndex = 0;
		signatureIndex = 0;
		patternIndex = 0;
		atomIndex = 0;
	}
	
	@Override
	public String getResultAccesssedBeforeResolvedError() {		
		String problem = null;
		if (argumentIndex < arguments.length) {
			problem = String.format("%d of %d arguments processed", argumentIndex, arguments.length);
		}
		else if (rewriteRuleIndex < calledFunction.size()) {
			problem = String.format("%d of %d rewrite rules considered", rewriteRuleIndex, calledFunction.size());
		}
		else {
			problem = "All arguments processed and all rewrite rules considered. This should never happen";
		}
		return String.format(
				"Result of function %s, called by %s, has not yet been resolved; %d.", 
				calledFunction.getIdentifier(),
				callingFunction.getIdentifier(),
				problem);
	}
	
	
	@Override
	public void executeStepDelegate(ExecutionContextResult previousResult) 
			throws NoMatchingSignatureException, CaremelleBaseException {
		
		if (calledFunction.getExpression() != null) {
			if (previousResult == null) {
				setNextContext(new ExecutionContextExpression(calledFunction.getExpression(), calledFunction));
			}
			else {
				setResult(previousResult);
			}
		}
		else if (argumentIndex < arguments.length) {
			if (previousResult == null) {
				Argument arg = arguments[argumentIndex];
				setNextContext(new ExecutionContextArgument(arg, callingFunction));
			}
			else {
				argumentIndex++;
			}
		}
		else if (rewriteRuleIndex < calledFunction.size()) {
			RewriteRule rewriteRule = calledFunction.get(rewriteRuleIndex);
			if (signatureIndex == rewriteRule.size()) {						
				throw new NoMatchingSignatureException(
						calledFunction.getIdentifier(),
						calledFunction.getLineNumber(),
						calledFunction.getColumnNumber(),
						arguments);
			}
			else {
				Signature signature = rewriteRule.get(signatureIndex);
				if (patternIndex == 0) {
					// We're starting a new patter, so reset the regexp.
					currentRegexp = new StringBuilder("^");
				}
				else if (patternIndex == signature.size()) {
					// We have a matching signature at signatureIndex, 
					// so use expression from rewrite rule with matching signature
					setNextContext(new ExecutionContextExpression(rewriteRule.getExpression(), calledFunction));
				}
				else {
					Pattern pattern = signature.get(patternIndex);
					if (atomIndex == pattern.size()) {
						// The pattern is complete, it is stored in currentRegexp
						currentRegexp.append("$");
						Parameter[] parameters = ParameterFactory.buildParameters(
								arguments[patternIndex], 
								currentRegexp.toString(), 
								pattern);
						if (parameters != null) {
							for (Parameter parameter : parameters) {
								parameterMap.put(parameter.getIdentifier(), parameter);
							}
							patternIndex++;
						}
						else {
							patternIndex = 0;
							signatureIndex++;
							parameterMap.clear();
						}
					}
					else {
						AtomicPattern atom = pattern.get(atomIndex);
						if (atom.isExpression()) {
							if (previousResult != null) {
								currentRegexp.append(previousResult.getStringValue());
								atomIndex++;
							}
							else {
								setNextContext(new ExecutionContextExpression(atom.getExpression(), callingFunction));
							}
						}
						else if (atom.isLiteral()) {
							currentRegexp.append(atom.getRegexp());
							atomIndex++;
						}
						else {
							// for test purposes only
							setState(ExecutionContextState.ERROR);
						}
					}
				}
			}
		}
		else {
			// for testing purposes only
			setState(ExecutionContextState.ERROR);
		}
	}	
}
