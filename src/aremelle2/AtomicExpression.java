package aremelle2;

public abstract class AtomicExpression extends Token {

	public AtomicExpression(int lineNumber, int columnNumber) {
		super(lineNumber, columnNumber);
	}

	public boolean isLiteral() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getLiteralValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isIdentifier() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

}
