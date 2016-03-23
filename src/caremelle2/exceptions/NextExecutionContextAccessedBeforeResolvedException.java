package caremelle2.exceptions;

public class NextExecutionContextAccessedBeforeResolvedException extends
		CaremelleBaseException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1682244641132171180L;

	public NextExecutionContextAccessedBeforeResolvedException(String errorMessage) {
		super(errorMessage);
	}

}
