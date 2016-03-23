package aremelle2;

public class AtomicExpressionFunctionCall extends AtomicExpression {
	
	private final Function calledFunction, callingFunction;
	private final Argument[] arguments;

	public AtomicExpressionFunctionCall(
			Function calledFunction, 
			Function callingFunction, 
			Argument[] arguments, 
			int line, 
			int col
			) {
		super(line, col);
		
		this.calledFunction = calledFunction;
		this.callingFunction = callingFunction;
		this.arguments = arguments;
	}

	public Argument[] getArguments() {
		return arguments;
	}

	public Function getCalledFunction() {
		return calledFunction;
	}

	public Function getCallingFunction() {
		return callingFunction;
	}
}
