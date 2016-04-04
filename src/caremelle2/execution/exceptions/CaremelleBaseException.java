package caremelle2.execution.exceptions;

public class CaremelleBaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1584093121095497177L;
	
	public CaremelleBaseException(String errorMessage) {
		System.err.println(errorMessage);
	}

}
