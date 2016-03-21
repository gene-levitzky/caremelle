package caremelle2.exceptions;

public class ResultAccessedBeforeResolvedException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 745554459816099935L;
	
	public ResultAccessedBeforeResolvedException(String message) {
		System.err.println(message);
	}

}
