package caremelle;

import java.util.HashMap;
import java.util.Map;

public class Scope {
	
	private Scope outerScope = null;
	private Map<String, Function> functionNamespace;
	private Map<String, AtomicParameter> atomicParameterNamespace;
	
	public Scope() {
		functionNamespace = new HashMap<String, Function>();
		atomicParameterNamespace = new HashMap<String, AtomicParameter>();
	}
	
	public Scope(Scope outerScope) {
		this();
		this.setOuterScope(outerScope);
	}

	public Scope getOuterScope() {
		return outerScope;
	}

	public void setOuterScope(Scope outerScope) {
		this.outerScope = outerScope;
	}
	
	public Function getFunction(String name) {
		Function function = functionNamespace.get(name);
		if (function == null && outerScope != null) {
			function = outerScope.getFunction(name);
		}
		return function;
	}
	
	/**
	 * 
	 * @param function
	 * @return True if the function replaced an existing one, false otherwise.
	 */
	public boolean addFunction(Function function) {
		return functionNamespace.put(function.getName(), function) != null;
	}
	
	public AtomicParameter getAtomicParameter(String name) {
		AtomicParameter atomicParameter = atomicParameterNamespace.get(name);
		if (atomicParameter == null && outerScope != null) {
			atomicParameter = outerScope.getAtomicParameter(name);
		}
		return atomicParameter;
	}
	
	/**
	 * 
	 * @param parameter
	 * @return True if the parameter replaced an existing one, false otherwise.
	 */
	public boolean addAtomicParameter(AtomicParameter parameter) {
		return atomicParameterNamespace.put(parameter.getName(), parameter) != null;
	}
	
	public void addParameters(Parameters parameters) {
		for (int i = 0; i < parameters.size(); i++) {
			Parameter parameter = parameters.get(i);
			for (int j = 0; j < parameter.size(); j++) {
				if (parameter.get(j).getName() != null) {
					this.addAtomicParameter(parameter.get(j));
				}
			}
		}
	}

}
