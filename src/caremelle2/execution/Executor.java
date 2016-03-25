package caremelle2.execution;

import java.util.Stack;

import aremelle2.AtomicExpressionFunctionCall;
import aremelle2.Expression;
import aremelle2.Argument;
import aremelle2.Function;
import aremelle2.Token;
import caremelle2.exceptions.CaremelleBaseException;
import caremelle2.exceptions.ExecutionContextErrorException;
import caremelle2.exceptions.NoMatchingSignatureException;

public class Executor {
	
	private Function getBaseFunction(Function func, Argument[] args) {
		AtomicExpressionFunctionCall functionCall = new AtomicExpressionFunctionCall(func, null, args, -1, -1);
		Expression expr = new Expression(new AtomicExpressionFunctionCall[]{ functionCall }, -1, -1);
		Function $ = new Function("$", "$", null, expr, -1, -1);
		addNativeFunctionsToScope($);
		return $;
	}
	
	private void addNativeFunctionsToScope(Function f) {
		
	}
	
	public String execute(Token token, Argument[] args) throws CaremelleBaseException, NoMatchingSignatureException {
		if (token instanceof Function) {
			Function function = (Function) token;
			Function $ = getBaseFunction(function, args);
			ExecutionContext context = new ExecutionContextFunctionCall(
					new AtomicExpressionFunctionCall(function, $, args, -1, -1));
			return execute(context);
		}
		return null;
	}
	
	private String execute(ExecutionContext initial) throws CaremelleBaseException, NoMatchingSignatureException {
		
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
