package aremelle;

import java.util.regex.Matcher;
import static java.util.regex.Pattern.compile;

import share.ListWrapper;

public class Pattern extends ListWrapper<Parameter>{
	
	public Pattern(Parameter ... params) {
		super(params);
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
		for (Parameter param : this) {
			regexpBuffer.append(param.getRegexp());
			totalNumberOfCapturingGroups++;
			totalNumberOfCapturingGroups += param.getNumberOfCaptureGroups();
		}
		regexpBuffer.append("$");
		
		Matcher matcher = compile(regexpBuffer.toString()).matcher(argument.toString());
		if (!matcher.find() || matcher.groupCount() != totalNumberOfCapturingGroups) {
			/*for (Parameter param : this) {
				param.setValue(null);
			}*/
			return false;
		}
		int group = 1;
		for (int i = 0; i < size(); i++) {
			String match = matcher.group(group);
			if (get(i).getValue() != null) {
				System.err.println("Something went wrong.");
				//System.exit(-1);
			}
			get(i).setValue(match);
			group++;
			group += get(i).getNumberOfCaptureGroups();
		}
		
		// check to make sure that back-references match
		for (Parameter param : this) {
			if (param.getReference() != null 
					&& !param.getReference().getValue().equals(param.getValue())) {
				return false;
			}
		}
		
		return true;
	}

	public void resolve(Scope scope) {
		for (Parameter ap : this) {
			ap.resolve(scope);
		}
	}
}