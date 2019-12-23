package algos.iface;

public interface MaxPQ<T extends Comparable<T>> {

	public void insert(T v) throws Exception;
	
	public T deleteMax() throws Exception;
	
	public boolean isEmpty();
	
}
