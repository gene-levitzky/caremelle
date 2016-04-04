package caremelle2.execution;

import aremelle2.Argument;
import aremelle2.AtomicExpressionFunctionCall;
import aremelle2.Expression;
import aremelle2.Function;

public class ExecutionContextFactory {
	
	private ExecutionContextFactory() {}
	
	public static ExecutionContextArgument createExecutionContextArgument(Argument arg, Function func) {
		return new ExecutionContextArgument(arg, func);
	}
	
	public static ExecutionContextExpression createExecutionContextExpression(Expression exp, Function func) {
		return new ExecutionContextExpression(exp, func);
	}
	
	public static ExecutionContextFunctionCall createExecutionContextFunctionCall(AtomicExpressionFunctionCall aefc) {
		return new ExecutionContextFunctionCall(aefc);
	}
	
	public static ExecutionContextResult createExecutionContextResult(Function func) {
		return new ExecutionContextResult(func);
	}
	
	public static ExecutionContextResult createExecutionContextResult(String string) {
		return new ExecutionContextResult(string);
	}

}
