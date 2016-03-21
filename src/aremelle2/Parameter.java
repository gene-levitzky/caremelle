package aremelle2;

public class Parameter {
	
	private final String identifier;
	private final String value;
	private final Function function;
	
	public Parameter(String identifier, String value, Function function) {
		this.identifier = identifier;
		this.value = value;
		this.function = function;
	}

	public String getIdentifier() {
		return identifier;
	}

	public String getValue() {
		return value;
	}

	public Function getFunction() {
		return function;
	}

}
