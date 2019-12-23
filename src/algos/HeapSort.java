package algos;

import algos.util.SortingUtils;

public class HeapSort<T extends Comparable<T>> {
	
	private T[] _arr = null;
	private int _index = 0;

	public HeapSort(T[] arr) {

		_arr = (T[])new Comparable[arr.length + 1];

		for (int i=0; i < arr.length; i++)
			_arr[i+1] = arr[i];
		_index = _arr.length;

		heapify();
	}

	private void sink(int k) {
		while(2*k < _index) {
			int j = 2*k;
			
			if (j < _index - 1 && SortingUtils.less(_arr[j], _arr[j+1])) j++;
			
			if(!SortingUtils.less(_arr[k], _arr[j])) break;
			
			SortingUtils.exch(_arr, k, j);
			
			k = j;
		}
	}
		
	private void heapify() {
		for (int i = _arr.length/2; i >= 1 ;i--) {
			sink(i);
		}
	}

	private T deleteMax() {
		_index--;
		T item = _arr[1];
		SortingUtils.exch(_arr, 1, _index);
		sink(1);
		_arr[_index] = null;
		return item;
	}
	
	public static void sort(String[] arr) {
		HeapSort<String> heapSort = new HeapSort<String>(arr);
		
		for (int i = arr.length - 1; i>= 0; i--)
			arr[i] = heapSort.deleteMax();
	}
	
	public static void main(String[] args) {
		String[] arr = {"a", "s", "o", "m", "e", "w", "h", "a", "t", "l", "o", "n", "g", "e", "r", "i", "n", "s", "e", "r", "t", "i", "o", "n", "s", "o", "r", "t", "e", "x", "a", "m", "p", "l", "e"};
		sort(arr);
		
		System.out.println(String.format("isSorted: %s", SortingUtils.isSorted(arr)));

		for (String item: arr)
			System.out.println(item);
	}

}