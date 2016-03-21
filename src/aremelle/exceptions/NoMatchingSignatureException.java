package aremelle.exceptions;

import aremelle.Argument;

public class NoMatchingSignatureException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5311135009069053822L;

	public NoMatchingSignatureException(String functionName, Argument[] arguments) {
		StringBuffer buffer = new StringBuffer("(");
		for (Argument a : arguments) {
			buffer.append(a.toString() + ", ");
		}
		buffer.deleteCharAt(buffer.length() - 1);
		buffer.deleteCharAt(buffer.length() - 1);
		buffer.append(")");
		System.err.println("Function '" + functionName + "' has no signature that matches arguments " + buffer.toString() + ".");
	}
}
