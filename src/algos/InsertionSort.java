package algos;

import algos.util.SortingUtils;

public class InsertionSort {
	/*
	 * O(N^2)
	 * Best case: O(N) if array id already sorted
	 * Worst case: If array is in descending order
	 */
	public static void sort(Comparable[] arr) {
		for (int i = 0; i < arr.length;i++) {
			for (int j = i; j > 0 && SortingUtils.less(arr[j], arr[j-1]); j--) {
					SortingUtils.exch(arr, j, j-1);
			}
		}
	}
	
	public static void main(String[] main) {
		//String[] arr = {"s", "o", "r", "t", "i", "n", "g", "e", "x", "a", "m", "p", "l", "e"};
		String[] arr = {"a", "s", "o", "m", "e", "w", "h", "a", "t", "l", "o", "n", "g", "e", "r", "i", "n", "s", "e", "r", "t", "i", "o", "n", "s", "o", "r", "t", "e", "x", "a", "m", "p", "l", "e"};
		sort(arr);
		
		System.out.println(String.format("Array is sorted: %s", SortingUtils.isSorted(arr)));
		
		for (String item: arr)
			System.out.println(item);
	}
}