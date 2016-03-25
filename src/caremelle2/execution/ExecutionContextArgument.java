package caremelle2.execution;

import aremelle2.Argument;
import aremelle2.Expression;
import aremelle2.Function;
import caremelle2.exceptions.CaremelleBaseException;
import caremelle2.exceptions.NoMatchingSignatureException;

public class ExecutionContextArgument extends ExecutionContext {

	private final Argument argument;
	private final Function function;
	
	public ExecutionContextArgument(Argument argument, Function function) {
		this.argument = argument;
		this.function = function;
	}

	@Override
	public void executeStepDelegate(ExecutionContextResult previousResult)
			throws NoMatchingSignatureException, CaremelleBaseException {
		if (previousResult == null) {
			Function function = argument.getFunction();
			if (argument.getFunction() != null) {
				ExecutionContextResult result = new ExecutionContextResult(function);
				setResult(result);
			}
			else {
				Expression expression = argument.getExpression();
				ExecutionContext next = new ExecutionContextExpression(expression, this.function);
				setNextContext(next);
			}
		}
		else {
			setResult(previousResult);
		}
	}

}
