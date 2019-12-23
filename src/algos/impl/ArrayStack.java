package algos.impl;

import java.util.Iterator;
import algos.iface.Stack;

public class ArrayStack<T> implements Stack<T> {
	private T[] arr = null;
	private int index = 0; // This is where the latest element will be added
	
	private class ArrayStackIterator implements Iterator<T> {
		private int current = index - 1;

		public boolean hasNext() {
			return current >=0;
		}
		
		public T next() {
			return arr[current--];
		}
	}

	public ArrayStack(int size) {
		//this.size = size;
		this.arr = (T[]) new Object[size];  // Java does not allow generic array creation
	}

	public void push(T item) throws Exception{
		if (index >= arr.length)
			throw new Exception("Stack is full");

		arr[index] = item;
		index++;
	}

	public T pop() throws Exception {
		if (index <= 0)
			throw new Exception("Stack is empty");
		index--;
		T item = arr[index];
		arr[index] = null; // Avoid loitering. Keep reference when object is no longer needed
		return item;
	}
	
	public boolean isEmpty() {
		return index == 0;
	}
	
	public Iterator<T> iterator() {
		return new ArrayStackIterator(); 
	}
	
}