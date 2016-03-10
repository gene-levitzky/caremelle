package share;

import java.util.ArrayList;
import java.util.List;

public class Utility {

	public static <T> List<T> arrayToList(T[] ts) {
		List<T> out = new ArrayList<T>(ts.length);
		for (T t : ts) {
			out.add(t);
		}
		return out;
	}
}
