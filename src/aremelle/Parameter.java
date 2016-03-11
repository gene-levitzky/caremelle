package aremelle;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import share.ListWrapper;

public class Parameter extends ListWrapper<AtomicParameter>{
	
	public Parameter(AtomicParameter ... atoms) {
		super(atoms);
	}

	public boolean fitArgument(Argument argument) {
		
		if (argument.isFunction()) {
			if (size() != 1) {
				return false;
			}
			if (get(0).isLiteral()) {
				return false;
			}
			return true;
		}
		
		StringBuffer regexpBuffer = new StringBuffer("^");
		int totalNumberOfCapturingGroups = 0;
		for (AtomicParameter atom : this) {
			regexpBuffer.append(atom.getRegexp());
			totalNumberOfCapturingGroups++;
			totalNumberOfCapturingGroups += atom.getNumberOfCaptureGroups();
		}
		regexpBuffer.append("$");
		
		Matcher matcher = Pattern.compile(regexpBuffer.toString()).matcher(argument.toString());
		if (!matcher.find() || matcher.groupCount() != totalNumberOfCapturingGroups) {
			for (AtomicParameter atom : this) {
				atom.setValue(null);
			}
			return false;
		}
		int group = 1;
		for (int i = 0; i < size(); i++) {
			String match = matcher.group(group);
			get(i).setValue(match);
			group++;
			group += get(i).getNumberOfCaptureGroups();
		}
		
		// check to make sure that back-references match
		for (AtomicParameter atom : this) {
			if (atom.getReference() != null 
					&& !atom.getReference().getValue().equals(atom.getValue())) {
				return false;
			}
		}
		
		return true;
	}

	public void resolve(Scope scope) {
		for (AtomicParameter ap : this) {
			ap.resolve(scope);
		}
	}
}