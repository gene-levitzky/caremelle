package aremelle2;

public abstract class TokenNamed extends Token {
	
	private String identifier;

	public TokenNamed(String identifier, int lineNumber, int columnNumber) {
		super(lineNumber, columnNumber);
		this.identifier = identifier;
	}
	
	public String getIdentifier(){
		return identifier;
	}
	
	public String toString() {
		return identifier;
	}

}
