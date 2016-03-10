package caremelle;

public class Parameters extends ListWrapper<Parameter> {

	public Parameters(Parameter ... parameters) {
		super(parameters);
		for (int i = 0; i < size(); i++) {
			Parameter currentParam = get(i);
			for (int j = 0; j < currentParam.size(); j++) {
				AtomicParameter currentAtomicParam = currentParam.get(j);
				for (int k = i; k < size(); k++) {
					Parameter siblingParam = get(k);
					for (int l = 0 + (siblingParam == currentParam ? j + 1 : 0); l < siblingParam.size(); l++) {
						AtomicParameter siblingAtomicParam = siblingParam.get(l);
						if (currentAtomicParam.getName() != null 
								&& siblingAtomicParam.getName() != null 
								&& currentAtomicParam.getName().equals(siblingAtomicParam.getName())) {
							siblingAtomicParam.setReference(currentAtomicParam);
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
		for (Parameter p : this) {
			p.resolve(scope);
		}
	}

}
