package aremelle2;

public class Atom extends Token {

	public Atom(String identifier, int lineNumber, int columnNumber) {
		super(lineNumber, columnNumber);
	}
	
	public String getIdentifier() {
		return null;
	}

	public boolean isLiteral() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isFunction() {
		// TODO Auto-generated method stub
		return false;
	}

	public Object getRegexp() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isExpression() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getNumberOfCaptureGroups() {
		// TODO Auto-generated method stub
		return 0;
	}

}
