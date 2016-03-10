package caremelle;

import java.util.Arrays;
import java.util.Iterator;

public abstract class ListWrapper<T> implements Iterable<T> {
	
	private T[] list;
	
	@SafeVarargs
	protected ListWrapper(T ... ts) {
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
