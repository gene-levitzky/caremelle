package aremelle;

import aremelle.exceptions.NoMatchingSignatureException;
import aremelle.exceptions.NotANumberException;
import aremelle.exceptions.UndefinedVariableException;

public interface AtomicExpression {
	
	public String evaluate(Scope scope) throws UndefinedVariableException, NoMatchingSignatureException, NotANumberException;
}
