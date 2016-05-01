package aremelle2;

public class AtomicPattern extends Token {
	
	private static final String ANY_NONEMPTY = ".+?";
	private static final String ANY = ".*?";
	
	private String identifier;
	private String regexp;
	private Expression expression;

	public AtomicPattern(String identifier, Expression expression, int lineNumber, int columnNumber) {
		super(lineNumber, columnNumber);
		this.identifier = identifier;
		this.expression = expression;
		
		if (identifier != null) {
			regexp = identifier.charAt(0) == '$' ? ANY : ANY_NONEMPTY;
		}
	}
	
	public Expression getExpression() {
		return expression;
	}
	
	public String getIdentifier() {
		return identifier;
	}

	public String getRegexp() {
		if (regexp == null && identifier != null) {
			regexp = identifier.charAt(0) == '$' ? ANY : ANY_NONEMPTY;
		}
		return regexp;
	}

	public boolean hasExpression() {
		return getExpression() != null;
	}
}
