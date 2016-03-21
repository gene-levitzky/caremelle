package aremelle;

import aremelle.exceptions.UndefinedVariableException;
import share.NamedEntity;

public class AtomicExpressionIdentifier extends NamedEntity implements AtomicExpression {
	
	public AtomicExpressionIdentifier(String name) {
		super(name);
	}

	public String evaluate(Scope scope) throws UndefinedVariableException {
		try {
			return scope.getParameter(getName()).getValue();
		} 
		catch (NullPointerException e) {
			throw new UndefinedVariableException(getName());
		}
	}

}
