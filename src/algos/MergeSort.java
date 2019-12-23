package algos;

import algos.util.SortingUtils;

/*
 * Just as sorted on reversed array as on arbitrary array.
 * 
 * Needs O(N) space for the auxillary array
 */
public class MergeSort {
	
	public static boolean isSorted(Comparable[] arr, int lo, int hi) {
		if (lo >= hi) return true;

		for (int i = lo+1; i <= hi; i++)
			if (SortingUtils.less(arr[i], arr[i-1])) return false;

		return true;
	}

	public static void merge(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi) throws Exception{
		if(!isSorted(arr, lo, mid) || !isSorted(arr, mid+1, hi))
			throw new Exception("Input arrays are not sorted");

		// copy to auxiliary array
		for (int k = lo; k <= hi; k++)
			aux[k] = arr[k];

		// merge
		int i = lo; 
		int j = mid + 1;
		
		for (int k = lo; k <= hi; k++) {
			if (i > mid) arr[k] = aux[j++];
			else if (j > hi) arr[k] = aux[i++];
			//For Merge sort to be stable, if elements in left and right sub array are equal, then the one in left sub array should be copied to main array
			// See lecture 6.5 Stability
			else if (SortingUtils.less(aux[j], aux[i])) arr[k] = aux[j++];
			else arr[k] = aux[i++];
		}
		
		if(!isSorted(arr, lo, hi))
			throw new Exception("Resultant array is not sorted");
	}

	public static void sort(Comparable[] arr, Comparable[] aux, int lo, int hi) throws Exception {
		if (lo >= hi) return;
		
		int mid = (lo + hi)/2;
		
		sort(arr, aux, lo, mid);
		sort(arr, aux, mid+1, hi);
		if (SortingUtils.less(arr[mid], arr[mid + 1])) return;
		merge(arr, aux, lo, mid, hi);
	}
	
	public static void sort(Comparable[] arr) throws Exception {
		Comparable[] aux = new Comparable[arr.length];
		sort(arr, aux, 0, arr.length - 1);
	}

	public static void main(String[] args) throws Exception{
		String[] arr = {"a", "s", "o", "m", "e", "w", "h", "a", "t", "l", "o", "n", "g", "e", "r", "i", "n", "s", "e", "r", "t", "i", "o", "n", "s", "o", "r", "t", "e", "x", "a", "m", "p", "l", "e"};
		
		sort(arr);
		
		System.out.println(String.format("isSorted: %s", SortingUtils.isSorted(arr)));
		for (String item: arr)
			System.out.println(item);

	}
}