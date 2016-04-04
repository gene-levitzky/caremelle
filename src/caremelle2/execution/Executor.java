package caremelle2.execution;

import java.util.Stack;

import caremelle2.execution.exceptions.CaremelleBaseException;
import caremelle2.execution.exceptions.ExecutionContextErrorException;
import caremelle2.execution.exceptions.NoMatchingSignatureException;

public class Executor {
	
	public String execute(ExecutionContext initial) throws CaremelleBaseException, NoMatchingSignatureException {
		
		Stack<ExecutionContext> contextStack = new Stack<ExecutionContext>();
		contextStack.push(initial);
		
		ExecutionContextResult result = null;
		
		while (!contextStack.isEmpty()) {
			
			ExecutionContext context = contextStack.pop();
			
			switch(context.getState()) {
				case DONE:
					result = context.getResult();
					break;
				case NEXT_CONTEXT_READY:
					ExecutionContext nextContext = context.getNextExecutionContext();
					contextStack.push(context);
					contextStack.push(nextContext);
					break;
				case INITIAL:
				case RUNNING:
					context.executeStep(null);
					contextStack.push(context);
					break;
				case WAITING:
					context.executeStep(result);
					contextStack.push(context);
					result = null;
					break;
				case ERROR:
					throw new ExecutionContextErrorException("Execution Context in ERROR state.");
			}
		}
		
		return result.getStringValue();
	}

}
