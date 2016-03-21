package aremelle2;

public class Function extends TokenList<RewriteRule> {
	
	private final Expression expression;
	
	private final String identifier;
	private final String uniqueID;

	public Function(
			String identifier, 
			String uniqueID, 
			RewriteRule[] rewriteRules, 
			Expression expression, 
			int lineNumber, 
			int columnNumber
			) {
		super(lineNumber, columnNumber, rewriteRules);
		
		this.expression = expression;
		
		this.identifier = identifier;
		this.uniqueID = uniqueID;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String toString() {
		return "Function: " + super.toString();
	}

	public String getUniqueID() {
		return uniqueID;
	}
	
	public Expression getExpression() {
		return expression;
	}

}
