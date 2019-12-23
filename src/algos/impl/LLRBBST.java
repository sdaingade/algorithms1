package algos.impl;

import java.util.LinkedList;
import java.util.Queue;

import algos.iface.ST;

public class LLRBBST<K extends Comparable<K>, V> extends ST<K, V> {

	private static boolean RED = true;
	private static boolean BLACK = false;

	private class Node {
		public K _key;
		public V _value;
		public Node _left, _right;
		public int _count;
		public boolean _color;
		
		public Node(K key, V value) {
			_key = key;
			_value = value;
			_count = 1;
			_color = RED;
		}
	}

	private Node _root = null;

	private boolean isRed(Node x) {
		if (x == null) return false;
		return x._color == RED;
	}

	private Node rotateLeft(Node h) throws Exception {
		if (h == null || h._right._color != RED)
			throw new Exception(String.format("rotateLeft - Input is null or right child is not red in color."));
		
		Node x = h._right;
		h._right = x._right;
		x._left = h;
		x._color = h._color;
		h._color = RED;
		return x;

	}

	private Node rotateRight(Node h) throws Exception {
		if (h == null || h._left._color != RED)
			throw new Exception(String.format("rotateRight - Input is null or left child is not red in color."));

		Node x = h._left;
		h._left = x._right;
		x._right = h;
		x._color = h._color;
		h._color = RED;
		return x;
	}

	private void flipColors(Node h) throws Exception {
		if (h == null || h._left._color != RED || h._right._color != RED)
			throw new Exception(String.format("flipColors - Input is null or either of left or right child is not red in color."));
		
		h._color = RED;
		h._left._color = BLACK;
		h._right._color = BLACK;
	}

	@Override
	public void put(K key, V value) throws Exception {
		_root = put(_root, key, value);
	}

	private Node put(Node x, K key, V value) throws Exception{
		if (x == null)
			return new Node(key, value);

		int cmp = key.compareTo(x._key);

		if (cmp < 0)
			x._left = put(x._left, key, value);
		else if (cmp > 0)
			x._right = put(x._right, key, value);
		else x._value = value;

		if (isRed(x._right) && !isRed(x._left)) x = rotateLeft(x); 
		if (isRed(x._left) && isRed(x._left._left)) x = rotateRight(x);
		if(isRed(x._left) && isRed(x._right)) flipColors(x);

		x._count = 1 + size(x._left) + size(x._right);
		return x;
	}

	@Override
	public V get(K key) throws Exception {
		return get(_root, key);
	}

	private V get(Node x, K key) {
		if (x == null) return null;
		
		int cmp = key.compareTo(x._key);
		if (cmp < 0)
			return get(x._left, key);
		else if (cmp > 0)
			return get(x._right, key);
		else return x._value;
	}
	
	@Override
	public void delete(K key) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() throws Exception {
		return _root == null;
	}

	@Override
	public int size() throws Exception {
		return size(_root);
	}
	
	private int size(Node x) {
		if (x == null) return 0;
		else return x._count;		
	}

	@Override
	public K min() throws Exception {
		if (isEmpty()) return null;
		return min(_root);
	}

	private K min(Node x) {
		if (x._left == null) return x._key;
		else return min(x._left);
	}
	
	@Override
	public K max() throws Exception {
		if (isEmpty())
			return null;
		return max(_root);
	}
	
	 private K max(Node x) {
		 if (x._right == null) return x._key;
		 else return max(x._right);
	 }

	/*
	 * Largest key <= input key
	 */
	@Override
	public K floor(K key) throws Exception {
		return floor(_root, key);
	}

	private K floor(Node x, K key) {
		if (x==null) return null;
		
		int cmp = key.compareTo(x._key);
		
		if (cmp < 0)
			return floor(x._right, key);
		else if (cmp > 0) {
			K rightKey = floor(x._right, key);
			if (rightKey == null) return x._key;
			else return rightKey;
		} else return x._key; 
	}
	
	/*
	 * Smallest key >= input key
	 */
	@Override
	public K ceiling(K key) throws Exception {
		return ceiling(_root, key);
	}

	private K ceiling(Node x, K key) {
		if (x == null) return null;
		
		int cmp = key.compareTo(x._key);
		
		if (cmp < 0) {
			K leftkey = ceiling(x._left, key);
			if (leftkey == null) return x._key;
			else return leftkey;
		} else if (cmp > 0)
			return ceiling(x._right, key);
		else return x._key;
	}

	/*
	 * Number of keys less than input key
	 */
	@Override
	public int rank(K key) throws Exception {
		return rank(_root, key);
	}
	
	private int rank(Node x, K key) {
		if (x == null) return 0;
		
		int cmp = key.compareTo(x._key);

		if (cmp < 0)
			return rank(x._right, key);
		else if (cmp > 0)
			return 1 + size(x._left) + rank(x._right, key);
		else return size(x._left);
	}

	@Override
	public void deleteMin() throws Exception {
		if (isEmpty())
			throw new Exception("LLRBBST is empty");
		_root = deleteMin(_root);
	}
	
	private Node deleteMin(Node x) {
		if (x._left == null) return x._right;

		x._left = deleteMin(x._left);
		x._count = 1 + size(x._left) + size(x._right);
		// We do not have to do the three tests for RBTree here
		// as the _right link returned during deletion should always be a black link.
		return x;
	}

	@Override
	public void deleteMax() throws Exception {
		
		
	}

	@Override
	public int size(K lo, K hi) throws Exception {
		if (contains(hi)) return rank(hi) - rank(lo) + 1;
		else return rank(hi) - rank(lo);
	}

	@Override
	public Iterable<K> keys(K lo, K hi) throws Exception {
		Queue<K> q = new LinkedList<K>();
		keys(_root, q, lo, hi);
		return q;
	}

	private void keys(Node x, Queue<K> q, K lo, K hi) {
		if (x == null) return;

		if(lo.compareTo(x._key) < 0)
			keys(x._left, q, lo, hi);
		
		if (lo.compareTo(x._key) <= 0 && hi.compareTo(x._key) >= 0)
			q.add(x._key);
		
		if(hi.compareTo(x._key) > 0)
			keys(x._right, q, hi, lo);

	}

	@Override
	public Iterable<K> keys() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}