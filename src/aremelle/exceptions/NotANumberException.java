package aremelle.exceptions;

public class NotANumberException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6374099371779537589L;

	public NotANumberException(String arg) {
		System.err.println("Number expected but received '" + arg + "'.");
	}
}
