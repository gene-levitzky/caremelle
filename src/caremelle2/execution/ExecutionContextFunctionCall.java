package caremelle2.execution;

import java.util.Map;

import caremelle2.exceptions.NoMatchingSignatureException;
import caremelle2.exceptions.ResultAccessedBeforeResolvedException;
import aremelle2.Argument;
import aremelle2.Expression;
import aremelle2.Function;
import aremelle2.Atom;
import aremelle2.Parameter;
import aremelle2.Pattern;
import aremelle2.RewriteRule;
import aremelle2.Signature;

public class ExecutionContextFunctionCall extends ExecutionContext {
	
	private ExecutionContextResult result;
	
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
	
	private boolean isDone;
	
	public ExecutionContextFunctionCall(
			Function callingFunction, 
			Function calledFunction, 
			Argument[] arguments
			) {
		this.callingFunction = callingFunction;
		this.calledFunction = calledFunction;
		this.arguments = arguments;
		
		argumentIndex = 0;
		rewriteRuleIndex = 0;
		signatureIndex = 0;
		patternIndex = 0;
		atomIndex = 0;
		
		isDone = false;
	}

	public boolean isDone() {
		return isDone;
	}
	
	public ExecutionContextResult getResult() throws ResultAccessedBeforeResolvedException {
		if (isDone()) {
			return result;
		}
		
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
		String msg = String.format(
				"Result of function %s, called by %s, has not yet been resolved; %d.", 
				calledFunction.getIdentifier(),
				callingFunction.getIdentifier(),
				problem);
		throw new ResultAccessedBeforeResolvedException(msg);
	}
	
	public ExecutionContext execute(ExecutionContextResult previousResult) 
			throws Exception, 
			NoMatchingSignatureException {
		
		if (calledFunction.getExpression() != null) {
			if (previousResult == null) {
				return new ExecutionContextExpression();				
			}
			else {
				result = previousResult;
				isDone = true;
				return null;
			}
		}
		
		if (argumentIndex < arguments.length) {
			if (previousResult == null) {
				return new ExecutionContextArgument();
			}
			else {
				argumentIndex++;
				return null;
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
				currentRegexp = new StringBuilder("^");
				if (patternIndex == signature.size()) {
					// TODO we have a matching signature at signatureIndex
					// use expression from called function
					return new ExecutionContextExpression();
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
						
						return null;
					}
					else {
						Atom atom = pattern.get(atomIndex);
						if (atomIndex < pattern.size() &&
								(atom.isLiteral() || atom.isFunction())) {
							currentRegexp.append(atom.getRegexp());
							atomIndex++;
							return null;
						}
						else if (atom.isExpression()) {
							if (previousResult != null) {
								currentRegexp.append(previousResult.getStringValue());
								atomIndex++;
								return null;
							}
							else {
								return new ExecutionContextExpression();
							}
						}
						else {
							// for test purposes only
							throw new Exception("Should never be here");
						}
					}
				}
			}
		}
		else {
			// for testing purposes only
			throw new Exception("Should never be here.");
		}
	}

	@Override
	public ExecutionContextFunctionCall toFunctionCall() {
		return this;
	}
	
	
}
