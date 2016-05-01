package aremelle2;

public class Function extends Token {
	
	private Expression expression;
	private RewriteRule[] rewriteRules;
	
	private final String identifier;
	private final String uniqueID;

	public Function(
			String identifier, 
			String uniqueID, 
			int lineNumber, 
			int columnNumber
			) {
		super(lineNumber, columnNumber);
				
		this.identifier = identifier;
		this.uniqueID = uniqueID;
	}
	
	public void setExpression(Expression expression) {
		this.expression = expression;
	}
	
	public void setRewriteRules(RewriteRule[] rewriteRules) {
		this.rewriteRules = rewriteRules;
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
	
	public RewriteRule[] getRewriteRules() {
		return this.rewriteRules;
	}
	
	public int size() {
		return rewriteRules == null ? 0 : rewriteRules.length;
	}
	
	public RewriteRule get(int i) {
		return rewriteRules[i];
	}

}
