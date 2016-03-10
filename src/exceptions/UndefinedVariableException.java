package exceptions;

public class UndefinedVariableException extends Throwable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1564666434331131813L;

	public UndefinedVariableException(String varName) {
		System.err.println("Referenced undefined variable '" + varName + "'.");
	}
}
