package aremelle2;

public class AtomicExpressionLiteral extends AtomicExpression {
	
	private final String literal;

	public AtomicExpressionLiteral(final String literal, final int lineNumber, final int columnNumber) {
		super(lineNumber, columnNumber);
		this.literal = literal;
	}

	@Override
	public boolean isLiteral() {
		return true;
	}

	@Override
	public String getLiteralValue() {
		return literal;
	}

	@Override
	public boolean isIdentifier() {
		return false;
	}

	@Override
	public String getIdentifier() {
		return null;
	}

	@Override
	public boolean isFunction() {
		return false;
	}

	@Override
	public Function getFunction() {
		return null;
	}

}
