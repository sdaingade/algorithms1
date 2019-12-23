package algos.impl;

import algos.iface.ST;

public class SeparateChainingHashST<Key extends Comparable<Key>, Value> extends ST<Key, Value> {

	private static class Node{
		private Object _key;
		private Object _value;
		private Node _next;
		
		public Node (Object key, Object val, Node next) {
			_key = key;
			_val = val;
			_next = next;
		}
	}

	private int _M = 97; //prime, can be resized
	private Node[] _st = new Node[_M];
	
	private void resize(int newCapacity) {
		//This resize method is slightly different that the resize method for say a queue
		// here we have to copy all elements in the old st.
		// In the queue case you would only copy elements that are occupied and not ones that are empty 
		// (esp when resize is shrinking capacity)
		
		Node[] oldSt  = _st;
		Node[] _st = new Node[newCapacity];
		_M = newCapacity;

		for (int i=0; i < _M; i++) {
			for(Node x = oldSt[i]; x!=null; x=x._next)
				put(x._key, x._value);
		}
	}
	
	private int hash(Key key) {
		return key.hashCode() & 0x7fffffff % _M;
	}

	public static void main(String[] args) {
		SeparateChainingHashST<Integer, String> st = new SeparateChainingHashST<Integer, String>();
		System.out.println(st.get(new Integer("1")));
	}

	@Override	
	public Value get(Key key) {
		int i = hash(key);
		
		for(Node x = _st[i]; x!= null; x=x._next) {
			if(key.equals(x._key)) return (Value) x._value;
		}
		return null;
	}
	
	@Override
	public void put(Key key, Value value) throws Exception {
		int i = hash(key);
		for (Node x = _st[i]; x!=null; x=x._next) {
			if (key.equals(x._key)) {
				x._value = value;
				return;
			}
		}
		_st[i] = new Node(key, value, _st[i]);
	}

	@Override
	public void delete(Key key) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Key min() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key max() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key floor(Key key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key ceiling(Key key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int rank(Key key) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteMin() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMax() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size(Key lo, Key hi) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterable<Key> keys(Key lo, Key hi) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Key> keys() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}