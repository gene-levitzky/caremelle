package caremelle2.execution;

import aremelle2.Function;

public class ExecutionContextResult {
	
	private final ExecutionContextResultType type;
	
	public ExecutionContextResult(Function function) {
		type = ExecutionContextResultType.FUNCTION;
	}

	public ExecutionContextResult(String string) {
		type = ExecutionContextResultType.STRING;
	}

	public String getStringValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public ExecutionContextResultType getType() {
		return type;
	}

}
