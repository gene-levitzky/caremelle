package aremelle2;

public class RewriteRule extends TokenList<Signature> {

	private final Expression expression;
	
	public RewriteRule(Signature[] signatures, Expression expression, int lineNumber, int columnNumber) {
		super(lineNumber, columnNumber, signatures);
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}

}
