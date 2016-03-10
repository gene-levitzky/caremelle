package executor;

import caremelle.Argument;
import caremelle.AtomicExpressionFunctionCall;
import caremelle.Expression;
import caremelle.Function;

public class ExecutionContext {
    
    private final Function callingFunction;
    private final Argument[] callingFunctionArguments;
    // index of AtomicExpression in expression
    private int atomIndex;
    private final Expression expression;
    
    private final Function calledFunction;
    private final AtomicExpressionFunctionCall aefc;
    // arguments from evaluated expressions passed to function call
    private final Argument[] calledFunctionArguments;
    // index to current Argument in callArgs
    private int calledFunctionArgumentIndex;
    
    // mode of this context (ExpressionMode or FunctionCallMode)
    private final ExecutionMode mode;
    
    // set to true when this context is done
    private boolean done;
    // the fully evaluated result of expression
    private Argument result;
    
    // for ExpressionMode
    public ExecutionContext(Function callingFunction, Expression expression, Argument[] callingFunctionArguments) {
        this.callingFunction = callingFunction;
        this.expression = expression;
        this.callingFunctionArguments = callingFunctionArguments;
        this.calledFunction = null;
        this.aefc = null;
        this.calledFunctionArguments = null;
        this.mode = ExecutionMode.ExpressionMode;
        this.setCalledFunctionArgumentIndex(-1);
        this.setAtomIndex(0);
        this.setDone(false);
    }
    
    // for FunctionCallMode
    public ExecutionContext(Function function, Function calledFunction, AtomicExpressionFunctionCall aefc) {
        this.callingFunction = function;
        this.expression = null;
        this.callingFunctionArguments = null;
        this.calledFunction = calledFunction;
        this.aefc = aefc;
        this.calledFunctionArguments = new Argument[aefc.getRawArguments().length];
        this.mode = ExecutionMode.FunctionCallMode;
        this.setCalledFunctionArgumentIndex(0);
        this.setAtomIndex(-1);
        this.setDone(false);
    }

	public Function getCallingFunction() {
		return callingFunction;
	}

	public Argument[] getCallingFunctionArguments() {
		return callingFunctionArguments;
	}

	public int getAtomIndex() {
		return atomIndex;
	}

	public void setAtomIndex(int atomIndex) {
		this.atomIndex = atomIndex;
	}

	public Expression getExpression() {
		return expression;
	}

	public Function getCalledFunction() {
		return calledFunction;
	}

	public Argument[] getCalledFunctionArguments() {
		return calledFunctionArguments;
	}

	public AtomicExpressionFunctionCall getAtomicExpressionFunctionCall() {
		return aefc;
	}

	public int getCalledFunctionArgumentIndex() {
		return calledFunctionArgumentIndex;
	}

	public void setCalledFunctionArgumentIndex(int calledFunctionArgumentIndex) {
		this.calledFunctionArgumentIndex = calledFunctionArgumentIndex;
	}

	public ExecutionMode getMode() {
		return mode;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public Argument getResult() {
		return result;
	}

	public void setResult(Argument result) {
		this.result = result;
	}

	public void setCalledFunctionArgument(int index, Argument argument) {
		if (this.calledFunctionArguments[index] != null) {
			assert false;
		}
		this.calledFunctionArguments[index] = argument;
	}

	public void appendResult(Argument argument) {
		if (result == null) {
			result = argument;
		}
		else {
			if (result.isFunction() || argument.isFunction()) {
				assert false;
			}
			result = new Argument(result.toString() + argument.toString());
		}
	}
}
