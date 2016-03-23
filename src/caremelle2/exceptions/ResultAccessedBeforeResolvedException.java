package caremelle2.exceptions;

public class ResultAccessedBeforeResolvedException extends CaremelleBaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 745554459816099935L;
	
	public ResultAccessedBeforeResolvedException(String errorMessage) {
		super(errorMessage);
	}

}
