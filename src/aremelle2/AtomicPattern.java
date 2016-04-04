package aremelle2;

public class AtomicPattern extends Token {
	
	private static final String ANY = ".+?";
	private static final String ANY_OR_EMPTY = ".*?";
	
	private String identifier;
	private String regexp;
	private Expression expression;

	public AtomicPattern(String identifier, Expression expression, int lineNumber, int columnNumber) {
		super(lineNumber, columnNumber);
		this.identifier = identifier;
		this.expression = expression;
		
		if (identifier != null) {
			regexp = identifier.charAt(0) == '$' ? ANY_OR_EMPTY : ANY;
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
			regexp = identifier.charAt(0) == '$' ? ANY_OR_EMPTY : ANY;
		}
		return regexp;
	}

	public boolean hasExpression() {
		return getExpression() != null;
	}

	public int getNumberOfCaptureGroups() {
		// TODO Auto-generated method stub
		return 0;
	}

}
