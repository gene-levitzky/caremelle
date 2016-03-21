package aremelle.exceptions;

public class CannotImportFunctionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4330889243563453035L;
	
	public CannotImportFunctionException(String filename) {
		super(filename);
		System.err.println("Cannot import function @ '" + filename + "'.");
	}

}
