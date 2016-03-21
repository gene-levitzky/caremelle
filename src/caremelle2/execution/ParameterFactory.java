package caremelle2.execution;

import static java.util.regex.Pattern.compile;

import java.util.regex.Matcher;

import aremelle2.Argument;
import aremelle2.Parameter;
import aremelle2.Pattern;

public class ParameterFactory {

	public static Parameter[] buildParameters(Argument arg, String regexp, Pattern pattern) {
		
		Parameter[] parameters = new Parameter[pattern.size()];
		
		Matcher matcher = compile(regexp).matcher(arg.toString());
		if (!matcher.find()) {
			return null;
		}
		int group = 1;
		for (int i = 0; i < pattern.size(); i++) {
			String match = matcher.group(group);
			if (arg.getFunction() == null) {
				parameters[i] = new Parameter(pattern.get(i).getIdentifier(), match, null);
			}
			else {
				if (i > 0) {
					// TODO testing only
					System.err.println("Should never happen.");
				}
			}
			group++;
			group += pattern.get(i).getNumberOfCaptureGroups();
		}
		
		// check to make sure that back-references match
		for (Parameter p : parameters) {
			// TODO 
		}
		
		return parameters;
	}
}
