package caremelle2.execution;

import caremelle2.exceptions.CaremelleBaseException;
import caremelle2.exceptions.NextExecutionContextAccessedBeforeResolvedException;
import caremelle2.exceptions.NoMatchingSignatureException;
import caremelle2.exceptions.ResultAccessedBeforeResolvedException;

public class ExecutionContextArgument extends ExecutionContext {

	@Override
	public ExecutionContextFunctionCall toFunctionCall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void executeStep(ExecutionContextResult previousResult)
			throws NoMatchingSignatureException, CaremelleBaseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ExecutionContextResult getResult()
			throws ResultAccessedBeforeResolvedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExecutionContext getNextExecutionContext()
			throws NextExecutionContextAccessedBeforeResolvedException {
		// TODO Auto-generated method stub
		return null;
	}

}
