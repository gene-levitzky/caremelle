package caremelle;

import java.util.Stack;

import aremelle.Argument;
import aremelle.AtomicExpression;
import aremelle.AtomicExpressionFunctionCall;
import aremelle.AtomicExpressionIdentifier;
import aremelle.AtomicExpressionLiteral;
import aremelle.Expression;
import aremelle.Function;
import aremelle.Program;
import aremelle.Statement;
import exceptions.NoMatchingSignatureException;
import exceptions.NotANumberException;
import exceptions.UndefinedVariableException;

public class AremelleProgramExecutor {

	public String evaluateProgram(Program program) 
			throws UndefinedVariableException, NoMatchingSignatureException, NotANumberException {

		ExecutionContext programContext = 
				new ExecutionContext(program.getBaseFunction(), program.getFunction(), program.getFunctionCall());
		Stack<ExecutionContext> contextStack = new Stack<ExecutionContext>();
		contextStack.push(programContext);

		main: while (!contextStack.isEmpty()) {

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
					// this result is an argument to a function call
					previousContext.setCalledFunctionArgument(previousContext.getCalledFunctionArgumentIndex(), result);
					previousContext.setCalledFunctionArgumentIndex(previousContext.getCalledFunctionArgumentIndex() + 1);
					break;
				case ExpressionMode:
					// this result is an evaluated atomic expression\
					previousContext.appendResult(result);
					previousContext.setAtomIndex(previousContext.getAtomIndex() + 1);
					if (previousContext.getAtomIndex() == previousContext.getExpression().size()) {
						previousContext.setDone(true);
						contextStack.push(previousContext);
						continue main;
					}
					break;
				}
				// hand control back to calling function argument, and possibly move on to next
				// argument, or finish this context
				context = previousContext;
			}

			switch(context.getMode()) {
			case FunctionCallMode:
				if (context.getCalledFunctionArgumentIndex() == context.getCalledFunctionArguments().length) {
					// we've evaluated all of this function's arguments, so now we need 
					// to evaluate the function; we do this by creating a new context
					Function newFunction = context.getCalledFunction();
					Expression expression = newFunction.getExpression();
					if (expression == null) {
						Statement statement = newFunction.getStatementWithMatchingParameters(context.getCalledFunctionArguments());
						if (statement == null) {
							throw new NoMatchingSignatureException(context.getCalledFunction().getName(), 
									context.getCalledFunctionArguments());
						}
						expression = statement.getExpression();
					}
					ExecutionContext newContext = new ExecutionContext(newFunction, expression, context.getCalledFunctionArguments());
					contextStack.push(newContext);
					continue main;
				}
				else {
					// we have a few more arguments to process
					Expression expression = context.getAtomicExpressionFunctionCall()
							.getRawArguments()[context.getCalledFunctionArgumentIndex()];
					ExecutionContext newContext = 
							new ExecutionContext(context.getCallingFunction(), expression, context.getCalledFunctionArguments());
					contextStack.push(context);
					contextStack.push(newContext);
					continue main;
				}
			case ExpressionMode:

				int atomIndex = context.getAtomIndex();

				AtomicExpression atom = context.getExpression().get(atomIndex);

				if (atom instanceof AtomicExpressionLiteral) {
					context.appendResult(new Argument(((AtomicExpressionLiteral) atom).getValue()));
					context.setAtomIndex(atomIndex + 1);
					if (context.getAtomIndex() == context.getExpression().size()) {
						context.setDone(true);
					}
					contextStack.push(context);
					continue main;
				}
				else {
					if (atom instanceof AtomicExpressionIdentifier) {
						AtomicExpressionIdentifier identifier = (AtomicExpressionIdentifier) atom;
						String value = context.getCallingFunction().getScope().getAtomicParameter(identifier.getName()).getValue();
						if (value != null) {
							context.appendResult(new Argument(value));
							context.setAtomIndex(atomIndex + 1);
							if (context.getAtomIndex() == context.getExpression().size()) {
								context.setDone(true);
							}
							contextStack.push(context);
							continue main;
						}
						else {
							throw new UndefinedVariableException(identifier.getName());
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
						String functionName = callingFunction.getScope().getAtomicParameter(aefc.getName()).getValue();
						if (functionName == null) {
							throw new UndefinedVariableException(aefc.getName());
						}
						calledFunction = callingFunction.getScope().getFunction(functionName);
						if (calledFunction == null) {
							throw new UndefinedVariableException(functionName);
						}
					}

					contextStack.push(new ExecutionContext(callingFunction, calledFunction, aefc));
					continue main;
				}
				break;
			default:
				assert false;
			}

			assert false; // should never be here
		}
		return null; // to placate compiler
	}
}