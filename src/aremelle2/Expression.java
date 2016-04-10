package aremelle2;

public class Expression extends TokenList<AtomicExpression> {

	public Expression(AtomicExpression[] atoms, int lineNumber, int columnNumber) {
		super(lineNumber, columnNumber, atoms);
	}
	
	public Expression(AtomicExpression atom, int line, int col) {
		this(new AtomicExpression[]{ atom }, line, col);
	}
	
	@Override
	public String toString() {
		return "Expression@ " + super.toString();
	}

}
