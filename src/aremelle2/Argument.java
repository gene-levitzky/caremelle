package aremelle2;

public class Argument {
	
	public String toString() {
		if (getFunction() != null) {
			return getFunction().getIdentifier();
		}
		return getLiteral();
	}

	public Function getFunction() {
		return null;
	}
	
	public String getLiteral() {
		return null;
	}
	
	public String getLiteralValue() {
		if (getLiteral().startsWith("'") && getLiteral().endsWith("'")) {
			return getLiteral().substring(1, getLiteral().length() - 1);
		}
		return getLiteral();
	}

}
