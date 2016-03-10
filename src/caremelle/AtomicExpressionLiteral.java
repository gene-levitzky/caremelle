package caremelle;

public class AtomicExpressionLiteral implements AtomicExpression {
	
	private final String value;
	
	public AtomicExpressionLiteral(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String evaluate(Scope scope) {
		return value;
	}

}
