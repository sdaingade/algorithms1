package algos.iface;

public interface MinPQ<T extends Comparable<T>> {
	public void insert(T item);
	
	public T deleteMin();
	
	public boolean isEmpty();

}
