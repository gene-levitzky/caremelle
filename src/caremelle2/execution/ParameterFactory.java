package caremelle2.execution;

import static java.util.regex.Pattern.compile;

import java.util.HashMap;
import java.util.Map;
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
		
		Map<String, Parameter> paramMap = new HashMap<String, Parameter>();
		
		// check to make sure that back-references match
		for (Parameter p : parameters) {
			Parameter put = paramMap.putIfAbsent(p.getIdentifier(), p);
			if (put != null) {
				if (put.getFunction() != null && p.getFunction() != null
						&& !put.getFunction().getIdentifier().equals(p.getFunction().getIdentifier())) {
					return null;
				}
				if (put.getValue() != null && p.getValue() != null && !put.getValue().equals(p.getValue())) {
					return null;
				}
			}
		}
		
		return parameters;
	}
}
