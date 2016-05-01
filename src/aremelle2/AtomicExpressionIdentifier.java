package aremelle2;

public class AtomicExpressionIdentifier extends AtomicExpression {
	
	private final String identifier;

	public AtomicExpressionIdentifier(String identifier, int lineNumber, int columnNumber) {
		super(lineNumber, columnNumber);
		this.identifier = identifier;
	}

	@Override
	public boolean isLiteral() {
		return false;
	}

	@Override
	public String getLiteralValue() {
		return null;
	}

	@Override
	public boolean isIdentifier() {
		return true;
	}

	@Override
	public String getIdentifier() {
		return identifier;
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
