package algos.impl;

import algos.util.SortingUtils;
import algos.iface.MaxPQ;

public class MaxHeap<T extends Comparable<T>> implements MaxPQ<T> {
	private T[] _arr = null;
	private int _index = 1; // This is where the latest element will be added
	
	public MaxHeap(int size) {
		// index 0 is not used, indices 1 to size are used
		_arr = (T[]) new Comparable[size + 1];
	}

	public boolean isEmpty() {
		return _index == 1;
	}

	// Item at index = k becomes greater than its parents
	// O(Log N)
	private void swim(int k) {
		while (k > 1 && SortingUtils.less(_arr[k/2], _arr[k])) {
			SortingUtils.exch(_arr, k, k/2);
			k = k/2;
		}
	}
	
	// Item at index k becomes smaller than its children
	// O(Log N)
	private void sink(int k) {
		while(2*k < _index) {
			int j = 2*k;
			
			if (j < _index - 1 && SortingUtils.less(_arr[j], _arr[j+1])) j++;

			if(!SortingUtils.less(_arr[k], _arr[j])) break;
			
			SortingUtils.exch(_arr, k, j);
			k = j;
		}
	}
	
	public void insert(T item) throws Exception {
		if (_index >= _arr.length)
			throw new Exception("Max Heap is full");

		_arr[_index] = item;
		swim(_index);
		_index++;
	}
	
	public T deleteMax() throws Exception {
		if (isEmpty())
			throw new Exception("Max Heap is empty");

		T item = _arr[1];
		_index--;
		SortingUtils.exch(_arr, 1, _index);
		sink(1);
		_arr[_index] = null;
		return item;
	}
	
	public String toString() {
		String str = "{";
		for (int i=1; i<_arr.length; i++)
			str = str.concat(String.format("%s, ", _arr[i]));

		return str.concat("}");
	}
	
	public static void main(String[] args) throws Exception{
		MaxHeap<Integer> maxHeap = new MaxHeap<Integer> (10);

		maxHeap.insert(10);
		maxHeap.insert(20);
		System.out.println(maxHeap);
		System.out.println(String.format("deleteMax: %s", maxHeap.deleteMax()));
		System.out.println(maxHeap);
		System.out.println(String.format("deleteMax: %s", maxHeap.deleteMax()));
		System.out.println(maxHeap);
		maxHeap.insert(10);
		maxHeap.insert(20);
		System.out.println(maxHeap);
	}
	
}