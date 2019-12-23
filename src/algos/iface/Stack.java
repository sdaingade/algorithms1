package algos.iface;

public interface Stack<T> extends Iterable<T>{
	
	public void push(T item) throws Exception;

	public T pop() throws Exception;

	public boolean isEmpty();

}
