package exceptions;

public class UndeclaredVariableException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7587978921011673892L;

	public UndeclaredVariableException(String varName) {
		System.err.println("Referenced undeclared variable '" + varName + "'.");
	}
}
