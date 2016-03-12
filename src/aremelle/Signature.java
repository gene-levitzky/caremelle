package aremelle;

import share.ListWrapper;

public class Signature extends ListWrapper<Pattern> {

	public Signature(Pattern ... patterns) {
		super(patterns);
		for (int i = 0; i < size(); i++) {
			Pattern currentPattern = get(i);
			for (int j = 0; j < currentPattern.size(); j++) {
				Parameter currentParam = currentPattern.get(j);
				for (int k = i; k < size(); k++) {
					Pattern siblingPattern = get(k);
					for (int l = 0 + (siblingPattern == currentPattern ? j + 1 : 0); l < siblingPattern.size(); l++) {
						Parameter siblingParam = siblingPattern.get(l);
						if (currentParam.getName() != null 
								&& siblingParam.getName() != null 
								&& currentParam.getName().equals(siblingParam.getName())) {
							siblingParam.setReference(currentParam);
						}
					}
				}
			}
		}
	}

	public boolean fitArguments(Argument[] args) {
		if (size() != args.length) {
			return false;
		}

		for (int i = 0; i < args.length; i++) {
			if (!get(i).fitArgument(args[i])) {
				return false;
			}
		}
		return true;
	}

	public void resolve(Scope scope) {
		for (Pattern p : this) {
			p.resolve(scope);
		}
	}

}
