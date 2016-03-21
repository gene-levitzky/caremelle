package aremelle;

import aremelle.exceptions.NoMatchingSignatureException;
import aremelle.exceptions.NotANumberException;
import aremelle.exceptions.UndefinedVariableException;
import share.ListWrapper;

public class Expression extends ListWrapper<AtomicExpression> {
	
	public Expression(AtomicExpression ... atoms) {
		super(atoms);
	}

	public String evaluate(Scope scope) 
			throws UndefinedVariableException, NoMatchingSignatureException, NotANumberException {
		StringBuffer buffer = new StringBuffer();
		for (AtomicExpression atom : this) {
			buffer.append(atom.evaluate(scope));
		}
		return buffer.toString();
	}
}
