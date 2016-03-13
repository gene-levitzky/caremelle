package caremelle;

import java.util.Stack;

import aremelle.Argument;
import aremelle.AtomicExpression;
import aremelle.AtomicExpressionFunctionCall;
import aremelle.AtomicExpressionIdentifier;
import aremelle.AtomicExpressionLiteral;
import aremelle.Expression;
import aremelle.Function;
import aremelle.Parameter;
import aremelle.Program;
import aremelle.RewriteRule;
import exceptions.NoMatchingSignatureException;
import exceptions.NotANumberException;
import exceptions.UndeclaredVariableException;
import exceptions.UndefinedVariableException;

public class AremelleProgramExecutor {

	public String evaluateProgram(Program program) 
			throws UndefinedVariableException, 
			NoMatchingSignatureException, 
			NotANumberException, 
			UndeclaredVariableException {

		ExecutionContext programContext = new ExecutionContext(
				program.getBaseFunction(), 
				program.getFunction(), 
				program.getFunctionCall());
		Stack<ExecutionContext> contextStack = new Stack<ExecutionContext>();
		contextStack.push(programContext);

		while (!contextStack.isEmpty()) {

			ExecutionContext context = contextStack.pop();
			Argument result = context.getResult();

			if (context.isDone()) {
				// this expression has been fully evaluated

				ExecutionContext previousContext = contextStack.isEmpty() ? null : contextStack.pop();

				if (context.getMode() == ExecutionMode.ExpressionMode && previousContext == null) {
					// this was the initial function call and we finished evaluating it;
					// just return to what it evaluated, and we're done!
					return result.toString();
				}

				switch (previousContext.getMode()) {
				case FunctionCallMode:
					// this result is an argument to a function calls
					previousContext.setCalledFunctionArgument(
							previousContext.getCalledFunctionArgumentIndex(), result);
					previousContext.setCalledFunctionArgumentIndex(
							previousContext.getCalledFunctionArgumentIndex() + 1);
					break;
				case ExpressionMode:
					// this result is an evaluated atomic expression\
					previousContext.appendResult(result);
					previousContext.setAtomIndex(previousContext.getAtomIndex() + 1);
					if (previousContext.getAtomIndex() == previousContext.getExpression().size()) {
						previousContext.setDone(true);
						contextStack.push(previousContext);
						continue;
					}
					break;
				}
				// hand control back to calling function argument, and possibly move on to next
				// argument, or finish this context
				context = previousContext;
			}

			switch(context.getMode()) {
			case FunctionCallMode:
				int callFuncArgIdx = context.getCalledFunctionArgumentIndex();
				int numCalledFuncArgs = context.getCalledFunctionArguments().length;
				if (callFuncArgIdx == numCalledFuncArgs) {
					
					// we've evaluated all of this function's arguments, so now we need 
					// to evaluate the function; we do this by creating a new context
					
					Function newFunction = context.getCalledFunction();
					Expression expression = newFunction.getExpression();
					Argument[] calledFuncArgs = context.getCalledFunctionArguments();
					
					if (expression == null) {
						
						// this is not a constant function
						
						RewriteRule rule = newFunction.getRuleWithMatchingPattern(calledFuncArgs);
						if (rule == null) {
							String calledFunc = context.getCalledFunction().getName();
							throw new NoMatchingSignatureException(calledFunc, calledFuncArgs);
						}
						expression = rule.getExpression();
					}
					contextStack.push(new ExecutionContext(newFunction, expression, calledFuncArgs));
					continue;
				}
				else {
					
					// we have a few more arguments to process
					
					int calledFuncArgIdx = context.getCalledFunctionArgumentIndex();
					AtomicExpressionFunctionCall atomExprFuncCall = context.getAtomicExpressionFunctionCall();
					Function callingFunction = context.getCallingFunction();
					Argument[] calledFuncArgs = context.getCalledFunctionArguments();
					Expression expression = atomExprFuncCall.getRawArguments()[calledFuncArgIdx];
					
					contextStack.push(context);
					contextStack.push(new ExecutionContext(callingFunction, expression, calledFuncArgs));
					continue;
				}
			case ExpressionMode:

				int atomIndex = context.getAtomIndex();

				AtomicExpression atom = context.getExpression().get(atomIndex);

				if (atom instanceof AtomicExpressionLiteral) {
					String value = ((AtomicExpressionLiteral) atom).getValue();
					context.appendResult(new Argument(value));
					context.setAtomIndex(atomIndex + 1);
					if (context.getAtomIndex() == context.getExpression().size()) {
						context.setDone(true);
					}
					contextStack.push(context);
					continue;
				}
				else {
					if (atom instanceof AtomicExpressionIdentifier) {
						AtomicExpressionIdentifier identifier = (AtomicExpressionIdentifier) atom;
						String atomId = identifier.getName();
						Function callingFunc = context.getCallingFunction();
						Parameter parameter = callingFunc.getScope().getParameter(atomId);
						if (parameter != null) {
							String value = parameter.getValue();
							if (value != null) {
								context.appendResult(new Argument(value));
								context.setAtomIndex(atomIndex + 1);
								if (context.getAtomIndex() == context.getExpression().size()) {
									context.setDone(true);
								}
								contextStack.push(context);
								continue;
							}
							else {
								throw new UndefinedVariableException(identifier.getName());
							}
						}
						else {
							throw new UndeclaredVariableException(identifier.getName());
						}
					}
				}
				if (atom instanceof AtomicExpressionFunctionCall) {                    
					AtomicExpressionFunctionCall aefc = (AtomicExpressionFunctionCall) atom;

					// save the current context
					contextStack.push(context);

					Function callingFunction = context.getCallingFunction();
					Function calledFunction = callingFunction.getScope().getFunction(aefc.getName());
					if (calledFunction == null) {
						Parameter parameterFunction = 
								callingFunction.getScope().getParameter(aefc.getName());
						if (parameterFunction == null) {
							throw new UndeclaredVariableException(aefc.getName());
						}
						String functionName = parameterFunction.getValue();
						if (functionName == null) {
							throw new UndefinedVariableException(aefc.getName());
						}
						calledFunction = callingFunction.getScope().getFunction(functionName);
						if (calledFunction == null) {
							throw new UndefinedVariableException(functionName);
						}
					}

					contextStack.push(new ExecutionContext(callingFunction, calledFunction, aefc));
					continue;
				}
			}
		}
		
		// to placate compiler
		return null; 
	}
}