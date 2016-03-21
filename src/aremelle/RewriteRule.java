package aremelle;

import aremelle.exceptions.NoMatchingSignatureException;
import aremelle.exceptions.NotANumberException;
import aremelle.exceptions.UndefinedVariableException;

public class RewriteRule {
	
	// if a set of arguments matches any of our Parameters in parametersList
	private Signature[] signatures;
	// then we evaluate these expressions and return the result
	private Expression expression;
	
	public RewriteRule(Signature[] signatures, Expression expression) {
		this.signatures = signatures;
		this.expression = expression;
	}
	
	public Signature getMatchingSignature(Argument[] args, Scope scope) {
		for (Signature signature : signatures) {
			signature.resolve(scope);
			if (signature.fitArguments(args)) {
				return signature;
			}
		}
		return null;
	}
	
	public String evaluate(Scope scope) throws UndefinedVariableException, NoMatchingSignatureException, NotANumberException {
		return expression.evaluate(scope);
	}

	public Expression getExpression() {
		return expression;
	}

}
