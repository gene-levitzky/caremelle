package aremelle2;

public class Pattern extends TokenList<AtomicPattern> {

	public Pattern(AtomicPattern[] parameters, int lineNumber, int columnNumber) {
		super(lineNumber, columnNumber, parameters);
	}

}
