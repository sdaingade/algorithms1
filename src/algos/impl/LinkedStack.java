package algos.impl;

import java.util.Iterator;
import algos.iface.Stack;

public class LinkedStack<T> implements Stack<T> {
	
	private class Node {
		T item;
		Node next;
		
		public Node (T item, Node next) {
			this.item = item;
			this.next = next;
		}
	}
	
	private Node _first = null;

	private class LinkedStackIterator implements Iterator<T> {
		public Node _current = _first;

		public boolean hasNext() {
			return _current != null;
		}
		
		public T next() {
			T item = _current.item;
			_current = _current.next;
			return item;
		}
	}

	/*
	 * O(1)
	 */
	public void push(T item) {
		Node newFirst = new Node(item, _first);
		_first = newFirst;
	}
	
	/*
	 * O(1)
	 */
	public T pop() throws Exception {
		if (_first == null)
			throw new Exception("Stack is empty");

		T item = _first.item;
		_first = _first.next;
		return item;
	}
	
	/*
	 * O(1)
	 */
	public boolean isEmpty() {
		return _first == null;
	}
	
	public Iterator<T> iterator() {
		return new LinkedStackIterator();
	}
}
