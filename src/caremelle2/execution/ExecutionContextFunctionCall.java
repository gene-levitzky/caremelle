package caremelle2.execution;

import java.util.Map;

import caremelle2.exceptions.CannotProceedBeforeResultException;
import caremelle2.exceptions.CaremelleBaseException;
import caremelle2.exceptions.ExecutionContextDoneException;
import caremelle2.exceptions.ExecutionContextErrorException;
import caremelle2.exceptions.ExecutionContextNextContextReadyException;
import caremelle2.exceptions.NextExecutionContextAccessedBeforeResolvedException;
import caremelle2.exceptions.NoMatchingSignatureException;
import caremelle2.exceptions.ResultAccessedBeforeResolvedException;
import aremelle2.Argument;
import aremelle2.AtomicExpressionFunctionCall;
import aremelle2.Expression;
import aremelle2.Function;
import aremelle2.AtomicPattern;
import aremelle2.Parameter;
import aremelle2.Pattern;
import aremelle2.RewriteRule;
import aremelle2.Signature;

public class ExecutionContextFunctionCall extends ExecutionContext {
	
	private ExecutionContextResult result;
	
	private ExecutionContext nextContext;
	
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
	public ExecutionContextResult getResult() throws ResultAccessedBeforeResolvedException {
		if (getState() == ExecutionState.DONE) {
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
	
	
	@Override
	public void executeStep(ExecutionContextResult previousResult) 
			throws NoMatchingSignatureException, CaremelleBaseException {
		
		switch(getState()) {
			case INITIAL:
				setState(ExecutionState.RUNNING);
				break;
			case WAITING:
				if (previousResult != null) {
					setState(ExecutionState.RUNNING);
					break;
				}
				else {
					throw new CannotProceedBeforeResultException(
							"Execution invoked while this context is waiting for result.");
				}
			case NEXT_CONTEXT_READY:
				throw new ExecutionContextNextContextReadyException(
						"Execution invoked while this context has the next context ready");
			case ERROR:
				throw new ExecutionContextErrorException("Execution Context is in ERROR state.");
			case DONE:
				throw new ExecutionContextDoneException("This Execution Context has finished executing.");
			default:
				break;				
		}
		
		if (calledFunction.getExpression() != null) {
			if (previousResult == null) {
				setNextContext(new ExecutionContextExpression());
			}
			else {
				result = previousResult;
				setState(ExecutionState.DONE);
			}
		}
		else if (argumentIndex < arguments.length) {
			if (previousResult == null) {
				setNextContext(new ExecutionContextArgument());
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
					// TODO we have a matching signature at signatureIndex
					// use expression from called function
					setNextContext(new ExecutionContextExpression());
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
						if (atomIndex < pattern.size() &&
								(atom.isLiteral() || atom.isFunction())) {
							currentRegexp.append(atom.getRegexp());
							atomIndex++;
						}
						else if (atom.isExpression()) {
							if (previousResult != null) {
								currentRegexp.append(previousResult.getStringValue());
								atomIndex++;
							}
							else {
								setNextContext(new ExecutionContextExpression());
							}
						}
						else {
							// for test purposes only
							setState(ExecutionState.ERROR);
						}
					}
				}
			}
		}
		else {
			// for testing purposes only
			setState(ExecutionState.ERROR);
		}
	}

	private void setNextContext(ExecutionContext nextContext) {
		if (this.nextContext != null) {
			// TODO throw some error 
		}
		this.nextContext = nextContext;
		setState(ExecutionState.WAITING);		
	}

	@Override
	public ExecutionContextFunctionCall toFunctionCall() {
		return this;
	}

	@Override
	public ExecutionContext getNextExecutionContext()
			throws NextExecutionContextAccessedBeforeResolvedException {
		if (getState() != ExecutionState.NEXT_CONTEXT_READY || this.nextContext == null) {
			throw new NextExecutionContextAccessedBeforeResolvedException("Next ExecutionContext not yet ready.");
		}
		ExecutionContext nextContext = this.nextContext;
		setState(ExecutionState.WAITING);
		this.nextContext = null;
		return nextContext;
	}
	
	
}
