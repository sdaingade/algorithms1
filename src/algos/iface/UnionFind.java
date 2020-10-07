package algos.iface;

public interface UnionFind {
	
	/*
	 * Initialize union find data structure with N objects (0 to N-1)

	public UnionFind(int N) {
		
	}
	 */

	/*
	 * Add connection between p and q
	 */
	void union(int p, int q);
	
	/*
	 * Are p and q in the same component
	 */
	boolean connected(int p, int q);
	
	/*
	 * Component identifier for p
	 */
	int find(int p);
	
	/*
	 * Number of components
	 */
	int count();
}