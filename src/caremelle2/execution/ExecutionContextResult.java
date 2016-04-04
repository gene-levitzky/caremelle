package caremelle2.execution;

import caremelle2.execution.exceptions.InvalidExecutionContextResultTypeException;
import aremelle2.Function;

public class ExecutionContextResult {
	
	private final ExecutionContextResultType type;
	private final Function function;
	private final String string;
	
	public ExecutionContextResult(Function function) {
		type = ExecutionContextResultType.FUNCTION;
		this.function = function;
		this.string = null;
	}

	public ExecutionContextResult(String string) {
		type = ExecutionContextResultType.STRING;
		this.function = null;
		this.string = string;
	}

	public String getStringValue() {
		if (type == ExecutionContextResultType.FUNCTION) {
			throw new InvalidExecutionContextResultTypeException(
					"Execution Context Result of type FUNCTION does not contain a literal value.");
		}
		return string;
	}

	public Function getFunctionValue() {
		if (type == ExecutionContextResultType.STRING) {
			throw new InvalidExecutionContextResultTypeException(
					"Execution Context Result of type STRING does not contain a function value.");
		}
		return function;
	}

	
	public ExecutionContextResultType getType() {
		return type;
	}

}
