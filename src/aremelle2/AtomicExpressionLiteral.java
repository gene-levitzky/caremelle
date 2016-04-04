package aremelle2;

public class AtomicExpressionLiteral extends AtomicExpression {
	
	private final String literal;

	public AtomicExpressionLiteral(final String literal, final int lineNumber, final int columnNumber) {
		super(lineNumber, columnNumber);
		this.literal = literal;
	}

	public String getLiteral() {
		return literal;
	}

}
