package aremelle;

import share.NamedEntity;

public class AtomicParameter extends NamedEntity {
	
	private String regexp;
	private String value;
	
	private int numberOfCaptureGroups;
	
	private final static String varRegexp = ".+?";
	
	private AtomicParameter reference;

	public AtomicParameter(String name) {
		super(name);
		setRegexp(varRegexp);
	}
	
	public AtomicParameter(String name, String regexp) {
		super(name);
		setRegexp(regexp == null ? varRegexp : regexp);
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
		AtomicParameter referencedParameter = null;
		if (regexp.isEmpty() 
				&& getName() != null 
				&& (referencedParameter = scope.getAtomicParameter(getName())) != null) {
			setRegexp(referencedParameter.getRegexp());
		}
	}

	public boolean isLiteral() {
		return this.regexp.equals(varRegexp) && getName().isEmpty();
	}

	public void setReference(AtomicParameter reference) {
		this.reference = reference;		
	}

	public AtomicParameter getReference() {
		return this.reference;
	}

}
