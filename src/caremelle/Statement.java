package caremelle;

import exceptions.NoMatchingSignatureException;
import exceptions.NotANumberException;
import exceptions.UndefinedVariableException;

public class Statement {
	
	// if a set of arguments matches any of our Parameters in parametersList
	private Parameters[] parametersList;
	// then we evaluate these expressions and return the result
	private Expression expression;
	
	public Statement(Parameters[] parametersList, Expression expression) {
		this.parametersList = parametersList;
		this.expression = expression;
	}
	
	public Parameters getMatchingParameters(Argument[] args, Scope scope) {
		for (Parameters parameters : parametersList) {
			parameters.resolve(scope);
			if (parameters.fitArguments(args)) {
				return parameters;
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
