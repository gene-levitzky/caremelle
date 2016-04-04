package caremelle2.resources;

import java.util.HashMap;
import java.util.Map;

import aremelle2.Function;
import aremelle2.Parameter;

public class Scope {
	
	private final Scope parentScope;
	
	private final Map<String, Function> functions;
	private final Map<String, Parameter> parameters;
	
	public Scope(final Scope parentScope) {
		this.parentScope = parentScope;
		functions = new HashMap<String, Function>();
		parameters = new HashMap<String, Parameter>();
	}
	
	public Scope getParentScope() {
		return parentScope;
	}
	
	public boolean addFunction(Function f) {
		return null != functions.put(f.getIdentifier(), f);
	}
	
	public boolean addParameter(Parameter p) {
		return null != parameters.put(p.getIdentifier(), p);
	}
	
	public Function getFunction(String identifier) {
		Function f = null;
		Scope current = this;
		while (f == null && current != null) {
			f = current.getFunctions().get(identifier);
			current = current.getParentScope();
		}
		return f;
	}
	
	public Map<String, Function> getFunctions() {
		return functions;
	}
	
	public Parameter getParameter(String identifier) {
		Parameter p = null;
		Scope current = this;
		while (p == null && current != null) {
			p = current.getParameters().get(identifier);
			current = current.getParentScope();
		}
		return p;
	}
	
	public Map<String, Parameter> getParameters() {
		return parameters;
	}

}
