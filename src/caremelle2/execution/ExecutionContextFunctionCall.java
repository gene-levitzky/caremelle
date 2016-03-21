package caremelle2.execution;

import caremelle2.exceptions.ResultAccessedBeforeResolvedException;
import aremelle2.Argument;
import aremelle2.Expression;
import aremelle2.Function;
import aremelle2.Atom;
import aremelle2.Pattern;
import aremelle2.RewriteRule;
import aremelle2.Signature;

public class ExecutionContextFunctionCall extends ExecutionContext {
	
	private ExecutionContextResult result;
	
	private final Function callingFunction;
	private final Function calledFunction;
	private final Argument[] arguments;
	private final Expression expression;
	
	private int argumentIndex;
	private int rewriteRuleIndex;
	private int signatureIndex;
	private int patternIndex;
	private int atomIndex;
	
	private StringBuilder currentRegexp;
	
	public ExecutionContextFunctionCall(
			Function callingFunction, 
			Function calledFunction, 
			Argument[] arguments, 
			Expression expression
			) {
		this.callingFunction = callingFunction;
		this.calledFunction = calledFunction;
		this.arguments = arguments;
		this.expression = expression;
		
		argumentIndex = 0;
		rewriteRuleIndex = 0;
		signatureIndex = 0;
		patternIndex = 0;
		atomIndex = 0;
	}

	public boolean isDone() {
		return false;
	}
	
	public ExecutionContextResult getResult() throws ResultAccessedBeforeResolvedException {
		if (isDone()) {
			return result;
		}
		
		String problem = null;
		if (argumentIndex < arguments.length) {
			problem = String.format("%d of %d arguments processed", argumentIndex, arguments.length);
		}
		else if (rewriteRuleIndex < calledFunction.size()) {
			problem = String.format("%d of %d rewrite rules considered", rewriteRuleIndex, calledFunction.size());
		}
		else {
			problem = "All arguments processed and all rewrite rules considered. This should never happen";
		}
		String msg = String.format(
				"Result of function %s, called by %s, has not yet been resolved; %d.", 
				calledFunction.getIdentifier(),
				callingFunction.getIdentifier(),
				problem);
		throw new ResultAccessedBeforeResolvedException(msg);
	}
	
	public ExecutionContext execute(ExecutionContextResult previousResult) throws Exception {
		if (argumentIndex < arguments.length) {
			// TODO return new ExecutionContextArgument();
		}
		else if (rewriteRuleIndex < calledFunction.size()) {
			RewriteRule rewriteRule = calledFunction.get(rewriteRuleIndex);
			if (signatureIndex < rewriteRule.size()) {
				Signature signature = rewriteRule.get(signatureIndex);
				if (patternIndex == signature.size()) {
					
				}
				else {
					Pattern pattern = signature.get(patternIndex);
					if (atomIndex == pattern.size()) {
						// The pattern is complete, it is stored in currentRegexp
						
					}
					else {
						Atom atom = pattern.get(atomIndex);
						if (atomIndex < pattern.size() &&
								(atom.isLiteral() || atom.isFunction())) {
							currentRegexp.append(atom.getRegexp());
							atomIndex++;
						}
						else if (atom.isExpression()) {
							if (previousResult != null) {
								currentRegexp.append(previousResult.getStringValue());
								atomIndex++;
							}
							else {
								// TODO return new ExecutionContextExpression
							}
						}
						else {
							// for test purposes only
							throw new Exception("Should never be here");
						}
					}
				}
			}
			// TODO return new ExecutionContextArgument();
		}
		return null;
	}

	@Override
	public ExecutionContextFunctionCall toFunctionCall() {
		return this;
	}
	
	
}
