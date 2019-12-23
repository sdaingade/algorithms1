package algos.impl;

import java.util.Iterator;
import algos.iface.Stack;

public class ResizingArrayStack<T> implements Stack<T> {
	private T[] _array = (T[]) new Object[1]; // Java does not allow generic array creation
	private int _index = 0; // This is where the latest element will be added
	
	private class ResizingArrayStackIterator implements Iterator<T> {
		private int _current = _index - 1;
		public boolean hasNext() {
			return _current >= 0;
		}
		
		public T next() {
			return _array[_current--];
		}
	}
	
	public void push(T item) {
		if (_index >= _array.length)
			resize(_array.length * 2);

		_array[_index] = item;
		_index++;
	}
	
	public T pop() throws Exception {
		if (isEmpty())
			throw new Exception("Stack is empty");

		_index--;
		T item = _array[_index];
		_array[_index] = null;
		if (_index <= _array.length/4)
			resize(_array.length/2);
		return item;
	}
	
	public boolean isEmpty() {
		return _index == 0;
	}
	
	public Iterator<T> iterator() {
		return new ResizingArrayStackIterator();
	}

	private void resize(int size) {
		T[] newArray = (T[]) new Object[size];

		for (int i = 0; i < _index; i++)
			newArray[i] = _array[i];

		_array = newArray;
	}
}