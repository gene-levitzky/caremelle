package caremelle2.execution;

import aremelle2.AtomicExpression;
import aremelle2.Expression;
import aremelle2.Function;
import caremelle2.exceptions.CaremelleBaseException;
import caremelle2.exceptions.NoMatchingSignatureException;

public class ExecutionContextExpression extends ExecutionContext {
	
	private final Expression expression;
	private final Function parentFunction;
	
	private int atomicExpressionIndex;
	
	private final StringBuilder resultBuilder;

	public ExecutionContextExpression(Expression expression, Function parentFunction) {
		this.expression = expression;
		this.parentFunction = parentFunction;
		this.atomicExpressionIndex = 0;
		this.resultBuilder = new StringBuilder();
	}

	@Override
	public void executeStepDelegate(ExecutionContextResult previousResult)
			throws NoMatchingSignatureException, CaremelleBaseException {
		if (atomicExpressionIndex == expression.size()) {
			String expressionAsString = resultBuilder.toString();
			ExecutionContextResult result = 
					ExecutionContextFactory.createExecutionFunctionContextResult(expressionAsString);
			setResult(result);
		}
		else {
			if (previousResult != null) {
				resultBuilder.append(previousResult.getStringValue());
				atomicExpressionIndex++;
			}
			else {
				AtomicExpression atom = expression.get(atomicExpressionIndex);
				if (atom.isLiteral()) {
					resultBuilder.append(atom.getLiteralValue());
				}
				else if (atom.isIdentifier()) {
					getResources().getIdentifierValue(atom.getIdentifier(), parentFunction);
				}
			}
		}
	}
	
	@Override
	public String stringify() {
		return "ExecutionContext[" + expression.toString() + "]";
	}

}
