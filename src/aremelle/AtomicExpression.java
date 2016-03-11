package aremelle;

import exceptions.NoMatchingSignatureException;
import exceptions.NotANumberException;
import exceptions.UndefinedVariableException;

public interface AtomicExpression {
	
	public String evaluate(Scope scope) throws UndefinedVariableException, NoMatchingSignatureException, NotANumberException;
}
