package aremelle2;

public class Expression extends TokenList<AtomicExpression> {

	public Expression(AtomicExpression[] atoms, int lineNumber, int columnNumber) {
		super(lineNumber, columnNumber, atoms);
	}

}
