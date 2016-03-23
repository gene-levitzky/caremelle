package caremelle2.exceptions;

public class CaremelleBaseException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1584093121095497177L;
	
	public CaremelleBaseException(String errorMessage) {
		System.err.println(errorMessage);
	}

}
