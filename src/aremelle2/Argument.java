package aremelle2;

public class Argument {
	
	private final Function function;
	private final Expression expression;
	
	public Argument(Function function) {
		this.function = function;
		this.expression = null;
	}
	
	public Argument(Expression expression) {
		this.expression = expression;
		this.function = null;
	}

	public Function getFunction() {
		return function;
	}
	
	public Expression getExpression() {
		return expression;
	}

}
