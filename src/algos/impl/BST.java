package algos.impl;

import java.util.LinkedList;
import java.util.Queue;

import algos.iface.ST;

public class BST<Key extends Comparable<Key>, Value> extends ST<Key, Value>{

	private class Node {
		private Key _key;
		private Value _value;
		private Node _left, _right;
		private int _count;
		
		public Node (Key key, Value value) {
			_key = key;
			_value = value;
			_count = 1;
		}
	}

	private Node _root = null;

/*	
 	// Iterative implementation of get
	public Value get(Key key) {
		Node x = root;

		while (x != null) {
			int cmp = key.compareTo(x._key);
			if (cmp < 0) x = x._left;
			else if (cmp > 0) x = x._right;
			else return x._value;
		}

		return null; // Not found
	}
*/	
	public Value get(Key key) {
		return get(_root, key);
	}
	
	private Value get(Node x, Key key) {
		if (x== null) return null;
		
		int cmp = key.compareTo(x._key);
		if (cmp < 0) 
			return get(x._left, key);
		else if(cmp > 0)
			return get(x._right, key);
		else return x._value;
	}

	public void put(Key key, Value value) {
		_root = put(_root, key, value);
	}

	private Node put(Node x, Key key, Value value) {
		if (x == null) new Node (key, value);

		int cmp = key.compareTo(x._key);
		if (cmp < 0) 
			x._left =  put(x._left, key, value);
		else if (cmp > 0) 
			x._right = put (x._right, key, value);
		else x._value = value;

		x._count = 1 + size(x._left) + size(x._right);
		return x;
	}

	public void delete(Key key) throws Exception {
		if (isEmpty()) throw new Exception("BST is empty");
		_root = delete(_root, key);
	}

	private Node delete(Node x, Key key) {
		if (x == null) return null;
		
		int cmp = key.compareTo(x._key);
		
		if(cmp < 0)
			x._left = delete(x._left, key);
		else if (cmp > 0)
			x._right = delete(x._right, key);
		else {
			if (x._left == null) return x._right;
			else if (x._right == null) return x._left;
			else {
				Key rightMin = min(x._right);
				Value rightMinValue = get(rightMin);
				x._key = rightMin;
				x._value = rightMinValue;
				x._right = deleteMin(x._right);
			}
		}
		
		x._count = 1 + size(x._left) + size(x._right);
		return x;
	}
	
	public Iterable<Key> keys() throws Exception {
		Queue<Key> q = new LinkedList<Key>();
		inorder(_root, q);
		return q;
	}

	private void inorder(Node x, Queue<Key> q) {
		if(x == null) return;
		
		inorder(x._left, q);
		q.add(x._key);
		inorder(x._right, q);
	}

	public boolean isEmpty() {
		return _root == null;
	}

	public int size() throws Exception {
		return size(_root);
	}
	
	private int size(Node x) {
		if (x == null) return 0;
		else return x._count;
	}

	public Key min() throws Exception {
		if (isEmpty())
			throw new Exception("BST is empty");
		
		return min(_root);
	}

	private Key min(Node x) {
		if (x._left == null) return x._key;
		else return min(x._left);
	}

	public Key max() throws Exception {
		if (isEmpty())
			throw new Exception("BST is empty");
		return max(_root);
	}

	private Key max(Node x) {
		if (x._right == null) return x._key;
		else return max(x._right);
	}

	/*
	 * Largest key <= input key
	 */
	public Key floor(Key key) throws Exception {
		return floor(_root, key);
	}
	
	private Key floor(Node x, Key key) {
		if (x == null) return null;
		
		int cmp = key.compareTo(x._key);
		
		if(cmp < 0)
			return floor(x._left, key);
		else if (cmp > 0) {
			Key rightKey = floor(x._right, key);
			if (rightKey== null) return x._key;
			else return rightKey;

		} else return x._key;
	}

	/*
	 * Smallest key >= input key
	 */
	public Key ceiling(Key key) throws Exception {
		return ceiling(_root, key);
	}
	
	private Key ceiling(Node x, Key key) {
		if (x == null) return null;
		
		int cmp = key.compareTo(x._key);
		
		if (cmp < 0) {
			Key leftKey = ceiling(x._left, key);
			if (leftKey == null) return x._key;
			else return leftKey;
		}
		else if (cmp > 0)
			return ceiling(x._right, key);
		else return x._key;
	}

	public int rank(Key key) throws Exception {
		return rank(_root, key);
	}

	/*
	 * Number of keys less than input key
	 */
	private int rank(Node x, Key key) {
		if (x == null) return 0;

		int cmp = key.compareTo(x._key);
		if (cmp < 0)
			return rank(x._left, key);
		else if (cmp > 0)
			return 1 + size(x._left) + rank(x._right, key);
		else return size(x._left);
	}

	public void deleteMin() throws Exception {
		if (isEmpty()) throw new Exception("BST is empty");
		_root = deleteMin(_root);
	}

	private Node deleteMin(Node x) {
		if (x._left == null) return x._right;
		else {
			x._left = deleteMin(x._left);
			x._count = 1 + size(x._left) + size(x._right);
			return x;
		}
	}

	public void deleteMax() throws Exception {
		if (isEmpty()) throw new Exception("BST is empty");
		_root = deleteMax(_root);
	}

	private Node deleteMax(Node x) {
		if (x._right == null) return x._left;
		else {
			x._right = deleteMax(x._right);
			x._count = 1 + size(x._left) + size(x._right);
			return x;
		}
	}

	public int size(Key lo, Key hi) throws Exception { //Range count
		if (contains(hi)) return rank(hi) - rank(lo) + 1;
		else return rank(hi) - rank(lo);
	}

	public Iterable<Key> keys(Key lo, Key hi) throws Exception { //Range search
		Queue<Key> q = new LinkedList<Key>();
		keys(_root, q, lo, hi);
		return q;
	}
	
	private void keys(Node x, Queue<Key> q, Key lo, Key hi) {
		if (x == null) return;

		if (lo.compareTo(x._key) < 0)
			keys(x._left, q, lo, hi);
		
		if(lo.compareTo(x._key) <=0 && hi.compareTo(x._key) >=0)
			q.add(x._key);
		
		if(hi.compareTo(x._key) > 0)
			keys(x._right, q, hi, lo);
	}

	public static void main(String[] args) {
		BST bst = new BST();
	}

}