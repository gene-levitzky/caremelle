package caremelle2.execution.exceptions;

import aremelle2.Argument;

public class NoMatchingSignatureException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5311135009069053822L;


	public NoMatchingSignatureException(String identifier, int lineNumber,
			int columnNumber, aremelle2.Argument[] arguments) {
		StringBuilder builder = new StringBuilder();
		for (Argument arg : arguments) {
			builder.append(arg.toString() + ", ");
		}
		builder.delete(builder.length() - 2, builder.length());
		String errorMessage = String.format(
				"Function %s at line %d column %d has no signature that matches %s.",
				identifier,
				lineNumber,
				columnNumber,
				builder.toString());
		System.err.println(errorMessage);
	}
}
