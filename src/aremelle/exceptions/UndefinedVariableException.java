package aremelle.exceptions;

public class UndefinedVariableException extends Throwable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1564666434331131813L;

	public UndefinedVariableException(String varName) {
		System.err.println("Referenced variable '" + varName + "' before its value was defined.");
	}
}
