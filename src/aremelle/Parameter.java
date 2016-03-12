package aremelle;

import share.NamedEntity;

public class Parameter extends NamedEntity {
	
	private String regexp;
	private String value;
	
	private int numberOfCaptureGroups;
	
	private final static String nonEmptyRegexp = ".+?";
	private final static String anyRegexp = ".*?";
	
	private Parameter reference;

	public Parameter(String name) {
		super(name);
		setRegexp(name != null && name.charAt(0) == '$' ? anyRegexp : nonEmptyRegexp);
	}
	
	public Parameter(String name, String regexp) {
		super(name);
		setRegexp(regexp == null ? 
				(name != null && name.charAt(0) == '$' ? anyRegexp : nonEmptyRegexp) : regexp);
	}
	
	public String getRegexp() {
		return regexp;
	}
	
	public void setRegexp(String regexp) {
		boolean inQuotes = false;
		int numberOfCaptureGroups = 0;
		for (int i = 0; i < regexp.length(); i++) {
			char c = regexp.charAt(i);
			if (c == '\'') {
				inQuotes = !inQuotes;
				continue;
			}
			if (!inQuotes && c == '(') {
				numberOfCaptureGroups++;
			}
		}
		this.numberOfCaptureGroups = numberOfCaptureGroups;
		this.regexp = '(' + regexp + ')';
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getNumberOfCaptureGroups() {
		return numberOfCaptureGroups;
	}

	public void resolve(Scope scope) {
		Parameter referencedParameter = null;
		if (regexp.isEmpty() 
				&& getName() != null 
				&& (referencedParameter = scope.getAtomicParameter(getName())) != null) {
			setRegexp(referencedParameter.getRegexp());
		}
	}

	public boolean isLiteral() {
		return this.regexp.equals(nonEmptyRegexp) && getName().isEmpty();
	}

	public void setReference(Parameter reference) {
		this.reference = reference;		
	}

	public Parameter getReference() {
		return this.reference;
	}

}
