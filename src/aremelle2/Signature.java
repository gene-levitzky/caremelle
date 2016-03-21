package aremelle2;

public class Signature extends TokenList<Pattern> {

	public Signature(Pattern[] patterns, int lineNumber, int columnNumber) {
		super(lineNumber, columnNumber, patterns);
	}

}
