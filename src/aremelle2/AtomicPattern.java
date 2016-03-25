package aremelle2;

public class AtomicPattern extends Token {

	public AtomicPattern(String identifier, int lineNumber, int columnNumber) {
		super(lineNumber, columnNumber);
	}
	
	public Expression getExpression() {
		return null;
	}
	
	public String getIdentifier() {
		return null;
	}

	public boolean isLiteral() {
		// TODO Auto-generated method stub
		return false;
	}

	public Object getRegexp() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isExpression() {
		return getExpression() != null;
	}

	public int getNumberOfCaptureGroups() {
		// TODO Auto-generated method stub
		return 0;
	}

}
