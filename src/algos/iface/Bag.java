package algos.iface;

import java.util.Iterator;

public interface Bag<T> extends Iterable<T> {

	public void add(T item);

	public int size();
	
	public Iterator<T> iterator();
}