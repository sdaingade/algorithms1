package algos.iface;

public interface IntervalST<Key extends Comparable<Key>, Value> {

	// Get value paired with given interval
	public Value get(Key lo, Key hi);

	// Put interval-value pair in ST
	public void put(Key lo, Key hi, Value val);
	
	// Delete the given interval
	public void delete(Key lo, Key hi);
	
	// All intervals that intersect the given interval
	Iterable<Value> intersects(Key lo, Key hi);
}

// No two intervals have the same end point
// Use left endpoint as BST key