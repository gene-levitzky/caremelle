package aremelle2;

public abstract class Token {
	
	private final int lineNumber;
	private final int columnNumber;
	
	public Token(int lineNumber, int columnNumber) {
		this.lineNumber = lineNumber;
		this.columnNumber = columnNumber;
	}
	
	public int getLineNumber() {
		return lineNumber;
	}
	
	public int getColumnNumber() {
		return columnNumber;
	}

}
