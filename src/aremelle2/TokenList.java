package aremelle2;

import java.util.Arrays;
import java.util.Iterator;

public abstract class TokenList<T extends Token> extends Token implements Iterable<T> {
	
	private T[] list;
	
	@SafeVarargs
	protected TokenList(int line, int col, T ... ts) {
		super(line, col);
		list = ts;
	}
	
	public T get(int i) {
		return list[i];
	}
	
	public int size() {
		return list.length;
	}

	@Override
	public Iterator<T> iterator() {
		return Arrays.asList(list).iterator();
	}

}
