package algos;

import algos.util.SortingUtils;

public class SelectionSort {
	
	/*
	 * O(N^2)
	 * Quadratic time even when input is sorted or partially sorted
	 */
	
	public static void sort(Comparable[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min  = i;
			for (int j = i+1; j < arr.length; j++) {
				if (SortingUtils.less(arr[j], arr[min]))
					min = j;
			}
			SortingUtils.exch(arr, i, min);
		}
	}

	public static void main(String[] args) {
		String[] arr = {"s", "o", "r", "t", "e", "x", "a", "m", "p", "l", "e"};

		sort(arr);
		//assert(SortingUtils.isSorted(arr));

		for (String item: arr)
			System.out.println(item);
	}
}