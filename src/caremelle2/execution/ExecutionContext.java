package caremelle2.execution;

import caremelle2.exceptions.CaremelleBaseException;
import caremelle2.exceptions.NextExecutionContextAccessedBeforeResolvedException;
import caremelle2.exceptions.NoMatchingSignatureException;
import caremelle2.exceptions.ResultAccessedBeforeResolvedException;

public abstract class ExecutionContext {
	
	private ExecutionState state;
	
	public ExecutionContext() {
		setState(ExecutionState.INITIAL);
	}
	
	public abstract ExecutionContextFunctionCall toFunctionCall();

	/**
	 * 
	 * @param previousResult
	 *     Result from previous ExecutonContext, if any.
	 * @return
	 *     Returns the result of evaluating this execution context.
	 *     
	 * @throws NoMatchingSignatureException
	 *     Thrown if arguments supplied to FunctionExecutionContext do no match any of its
	 *     function's signatures.
	 * @throws CaremelleBaseException 
	 */
	public abstract void executeStep(ExecutionContextResult previousResult) 
			throws NoMatchingSignatureException, CaremelleBaseException;

	public abstract ExecutionContextResult getResult() throws ResultAccessedBeforeResolvedException;
	
	public abstract ExecutionContext getNextExecutionContext() 
			throws NextExecutionContextAccessedBeforeResolvedException;

	public ExecutionState getState() {
		return state;
	}

	protected void setState(ExecutionState state) {
		this.state = state;
	}
}
