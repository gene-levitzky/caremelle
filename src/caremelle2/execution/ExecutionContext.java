package caremelle2.execution;

import caremelle2.exceptions.CannotProceedBeforeResultException;
import caremelle2.exceptions.CaremelleBaseException;
import caremelle2.exceptions.ExecutionContextDoneException;
import caremelle2.exceptions.ExecutionContextErrorException;
import caremelle2.exceptions.ExecutionContextNextContextReadyException;
import caremelle2.exceptions.NextExecutionContextAccessedBeforeResolvedException;
import caremelle2.exceptions.NoMatchingSignatureException;
import caremelle2.exceptions.ResultAccessedBeforeResolvedException;

public abstract class ExecutionContext {
	
	/*
	 * State of current execution context.
	 */
	private ExecutionContextState state;
	/*
	 * Execution context generated in the course of executing this execution context.
	 */
	private ExecutionContext nextContext;
	/*
	 * The final result produced by executing this execution context, including all of its children contexts.
	 */
	private ExecutionContextResult result;
	/*
	 * Contains scope and variable tables.
	 */
	private final ExecutionResources resources;
	
	
	public static final String DEFAULT_RESULT_ACCESSED_BEFORE_RESOLVED_ERROR_MESSAGE =
			"An attempt was made to access the result before this execution context was finished executing.";
	
	
	public ExecutionContext() {
		setState(ExecutionContextState.INITIAL);
		setNextContext(null);
		resources = new ExecutionResources();
	}

	public ExecutionContextResult getResult() throws ResultAccessedBeforeResolvedException {
		if (getState() == ExecutionContextState.DONE) {
			return result;
		}
		throw new ResultAccessedBeforeResolvedException(getResultAccesssedBeforeResolvedError());
	}
	
	protected void setResult(ExecutionContextResult result) {
		if (getState() == ExecutionContextState.RUNNING || result != null) {
			// TODO throw some error
		}
		this.result = result;
		setState(ExecutionContextState.DONE);
	}
	
	public ExecutionContext getNextExecutionContext()
			throws NextExecutionContextAccessedBeforeResolvedException {
		if (getState() != ExecutionContextState.NEXT_CONTEXT_READY || this.nextContext == null) {
			throw new NextExecutionContextAccessedBeforeResolvedException("Next ExecutionContext not yet ready.");
		}
		ExecutionContext nextContext = this.nextContext;
		setState(ExecutionContextState.WAITING);
		this.nextContext = null;
		return nextContext;
	}
	
	protected void setNextContext(ExecutionContext nextContext) {
		if (this.nextContext != null) {
			// TODO throw some error 
		}
		this.nextContext = nextContext;
		setState(ExecutionContextState.WAITING);
	}

	public ExecutionContextState getState() {
		return state;
	}

	protected void setState(ExecutionContextState state) {
		this.state = state;
	}
	
	
	
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
	public void executeStep(ExecutionContextResult previousResult) 
			throws NoMatchingSignatureException, CaremelleBaseException {
		
		switch(getState()) {
			case INITIAL:
				setState(ExecutionContextState.RUNNING);
				break;
			case WAITING:
				if (previousResult != null) {
					setState(ExecutionContextState.RUNNING);
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
		
		executeStepDelegate(previousResult);
		
	}
	
	protected String getResultAccesssedBeforeResolvedError() {
		return DEFAULT_RESULT_ACCESSED_BEFORE_RESOLVED_ERROR_MESSAGE;
	}
	
	protected ExecutionResources getResources() {
		return resources;
	}
	
	@Override
	public String toString() {
		return this.stringify();
	}
	
	protected abstract String stringify();
	
	protected abstract void executeStepDelegate(ExecutionContextResult previousResult)
			throws NoMatchingSignatureException, CaremelleBaseException;
}
