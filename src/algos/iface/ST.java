package algos.iface;

// See 3.1 Symbol tables slide 26 for the complete interface

public abstract class ST<Key extends Comparable<Key>, Value> {

	// Values cannot be null. Overwrites old value with new one.
	public abstract void put(Key key, Value val) throws Exception;
	
	// returns null if key is not present in the table
	public abstract Value get(Key key) throws Exception;
	
	public abstract void delete(Key key) throws Exception;
	
	public boolean contains(Key key) throws Exception{
		return get(key) != null;
	}
	
	public abstract boolean isEmpty() throws Exception;
	
	public abstract int size() throws Exception;
	
	public abstract Key min() throws Exception;
	
	public abstract Key max() throws Exception;
	
	public abstract Key floor(Key key) throws Exception;
	
	public abstract Key ceiling(Key key) throws Exception;
	
	public abstract int rank(Key key) throws Exception;
	
	public abstract void deleteMin() throws Exception;
	
	public abstract void deleteMax() throws Exception;
	
	public abstract int size(Key lo, Key hi) throws Exception;
	
	public abstract Iterable<Key> keys(Key lo, Key hi) throws Exception;
	
	public abstract Iterable<Key> keys() throws Exception;

}