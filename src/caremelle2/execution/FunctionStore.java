package caremelle2.execution;

import java.util.HashMap;
import java.util.Map;

import aremelle2.Function;

public class FunctionStore {
	
	private final Map<String, Function> store;
	
	private static final FunctionStore instance = new FunctionStore();
	
	private FunctionStore() {
		store = new HashMap<String, Function>();
	}

	public static FunctionStore getInstance() {
		return instance;
	}
	
	public Function getFunction(String id) {
		return store.get(id);
	}
	
	public void putFunction(String id, Function f) {
		store.put(id, f);
	}

}
