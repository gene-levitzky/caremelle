package aremelle;

import exceptions.NoMatchingSignatureException;
import exceptions.NotANumberException;
import exceptions.UndefinedVariableException;

public class Program {

	private final Function function, baseFunction;
	private final AtomicExpressionFunctionCall functionCall;
	
	public Program(Function function, String[] inputArgs) {
		
		Expression[] args = new Expression[inputArgs.length];
		for (int i = 0; i < args.length; i++) {
			args[i] = new Expression(new AtomicExpressionLiteral(inputArgs[i]));
		}
		functionCall = new AtomicExpressionFunctionCall(function.getName(), args);
		baseFunction = new Function("$", new Function[]{function}, new Expression(functionCall), null);
		
		this.function = function;

		function.setParentScope(baseFunction.getScope());
		baseFunction.getScope().addFunction(function);
		
		for (Function f : Function.getNativeFunctions()) {
			f.setParentScope(baseFunction.getScope());
			baseFunction.getScope().addFunction(f);
		}
	}
	
	public String run(Argument ... args) 
			throws UndefinedVariableException, NoMatchingSignatureException, NotANumberException {
		return function.evaluate(args);
	}

	public Function getFunction() {
		return function;
	}

	public Function getBaseFunction() {
		return baseFunction;
	}
	
	public AtomicExpressionFunctionCall getFunctionCall() {
		return functionCall;
	}
	
}
