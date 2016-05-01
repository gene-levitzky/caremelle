package aremelle2;

public abstract class AtomicExpression extends Token {

	public AtomicExpression(int lineNumber, int columnNumber) {
		super(lineNumber, columnNumber);
	}

	public abstract boolean isLiteral();

	public abstract String getLiteralValue();

	public abstract boolean isIdentifier();

	public abstract String getIdentifier();
	
	public abstract boolean isFunction();
	
	public abstract Function getFunction();

}
