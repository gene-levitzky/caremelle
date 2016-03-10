package caremelle;

import exceptions.UndefinedVariableException;

public class AtomicExpressionIdentifier extends NamedEntity implements AtomicExpression {
	
	public AtomicExpressionIdentifier(String name) {
		super(name);
	}

	public String evaluate(Scope scope) throws UndefinedVariableException {
		try {
			return scope.getAtomicParameter(getName()).getValue();
		} 
		catch (NullPointerException e) {
			throw new UndefinedVariableException(getName());
		}
	}

}
