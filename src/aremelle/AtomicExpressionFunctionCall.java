package aremelle;

import aremelle.exceptions.NoMatchingSignatureException;
import aremelle.exceptions.NotANumberException;
import aremelle.exceptions.UndefinedVariableException;
import share.NamedEntity;

public class AtomicExpressionFunctionCall extends NamedEntity implements
		AtomicExpression {
	
	private final Expression[] rawArgs;

	public AtomicExpressionFunctionCall(String name, Expression[] rawArgs) {
		super(name);
		this.rawArgs = rawArgs;
	}
	
	private Argument[] resolveArguments(Expression[] rawArgs, Scope scope) 
			throws UndefinedVariableException, NoMatchingSignatureException, NotANumberException {
		Argument[] args = new Argument[rawArgs.length];
		for (int i = 0; i < args.length; i++) {
			args[i] = new Argument(rawArgs[i].evaluate(scope));
		}
		return args;
	}

	@Override
	public String evaluate(Scope scope) throws UndefinedVariableException, NoMatchingSignatureException, NotANumberException {
		try {
			return scope.getFunction(getName()).evaluate(resolveArguments(rawArgs, scope));
		}
		catch (NullPointerException npe) {
			throw new UndefinedVariableException(getName());
		}
	}

	public Expression[] getRawArguments() {
		return rawArgs;
	}

}
