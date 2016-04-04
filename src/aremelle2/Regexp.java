package aremelle2;

import java.util.ArrayList;
import java.util.List;

public class Regexp {
	
	private final StringBuilder regexpBuilder;
	private final List<Integer> numberOfCaptureGroupsList;
	
	public Regexp() {
		regexpBuilder = new StringBuilder();
		numberOfCaptureGroupsList = new ArrayList<Integer>();
	}
	
	public void append(String fragment) {
		boolean inQuotes = false;
		int numberOfCaptureGroups = 0;
		for (int i = 0; i < fragment.length(); i++) {
			char c = fragment.charAt(i);
			if (c == '\'') {
				inQuotes = !inQuotes;
				continue;
			}
			if (!inQuotes && c == '(') {
				numberOfCaptureGroups++;
			}
		}
		numberOfCaptureGroupsList.add(numberOfCaptureGroups);
		regexpBuilder.append('(' + fragment + ')');
	}
	
	@Override
	public String toString() {
		return '^' + regexpBuilder.toString() + '$';
	}

	public int getNumberOfCaptureGroups(int i) {
		return numberOfCaptureGroupsList.get(i);
	}

}
