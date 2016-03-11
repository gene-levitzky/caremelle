package aremelle;

public class Argument {
	
	private final String value;

	public Argument(String value) {
		this.value = value;
	}

	public boolean isFunction() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String toString() {
		return this.value;
	}

}
