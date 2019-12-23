package algos.impl;

import algos.iface.Queue;

public class LinkedQueue<T> implements Queue<T> {
	
	private class Node {
		T item;
		Node next;
		
		public Node(T item, Node next) {
			this.item = item;
			this.next = next;
		}
	}
	
	private Node _first = null;
	private Node _last = null;
	
	public void enqueue(T item) {
		if (_first == null && _last == null) {
			_first = new Node(item, null);
			_last = _first;
			return;
		}
		
		Node newLast = new Node(item, null);
		_last.next = newLast;
		_last = newLast;
	}
	
	public T dequeue() throws Exception {
		if (_first == null)
			throw new Exception("Queue is empty");

		T item = _first.item;
		_first = _first.next;

		if (_first == null)
			_last = null;
		
		return item;
	}
	
	public boolean isEmpty() {
		return _first == null;
	}
}