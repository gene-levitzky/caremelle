package caremelle2.resources;

import java.util.Map;

import aremelle2.Function;
import caremelle2.execution.ExecutionContext;

public class Representation {
	
	private final ExecutionContext initialContext;
	private final Map<String, Function> functionStore;
	private final Map<String, Scope> scopeStore;
	
	public Representation(ExecutionContext initialContext, Map<String, Function> functionStore, Map<String, Scope> scopeStore) {
		this.initialContext = initialContext;
		this.functionStore = functionStore;
		this.scopeStore = scopeStore;
	}

	public ExecutionContext getInitialContext() {
		return initialContext;
	}

	public Map<String, Function> getFunctionStore() {
		return functionStore;
	}

	public Map<String, Scope> getScopeStore() {
		return scopeStore;
	}

}
