package aremelle2;

public class AtomicExpressionFunctionCall extends AtomicExpression {
	
	private final Function callee, caller;
	private final Argument[] arguments;

	public AtomicExpressionFunctionCall(
			Function callee, 
			Function caller, 
			Argument[] arguments, 
			int line, 
			int col
			) {
		super(line, col);
		
		this.callee = callee;
		this.caller = caller;
		this.arguments = arguments;
	}

	public Argument[] getArguments() {
		return arguments;
	}

	public Function getCallee() {
		return callee;
	}

	public Function getCaller() {
		return caller;
	}
	
	@Override public String toString() {
		return "FunctionCall::" + callee.getIdentifier() + "@ " + super.toString();
	}
}
