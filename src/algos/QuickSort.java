package algos;

import algos.util.SortingUtils;

public class QuickSort {

	private static int partition(Comparable[] arr, int lo, int hi) throws Exception {
		//System.out.println(String.format("lo: %s, hi: %s", lo, hi));
		if (lo >= hi)
			throw new Exception(String.format("Invalid input. lo greater than or equal to hi. lo: %s, hi: %s", lo, hi));

		int i = lo + 1;
		int j = hi;
		
		while(true) {
			//System.out.println(String.format("lo:%s, arr[lo]:%s",lo, arr[lo]));
			while(SortingUtils.lessOrEqual(arr[i], arr[lo])) { //Stops at equal or greater than arr[lo]
				if (i >= hi) break;
				i++;
			}

			//System.out.println(String.format("i:%s, arr[i]:%s",i, arr[i]));
			while(SortingUtils.less(arr[lo], arr[j])) { //Stops at less than arr[lo]
				if (j <= lo) break;
				j--;
			}
			//System.out.println(String.format("j:%s, arr[j]: %s",j, arr[j]));

			if (i >= j) break;
			
			SortingUtils.exch(arr, i, j);
			
		}
		SortingUtils.exch(arr, lo, j);
		return j;
	}

	private static void sort(Comparable[] arr, int lo, int hi) throws Exception {
		if (lo >= hi) return;

		int j = partition(arr, lo, hi);
		
		sort(arr, lo, j-1);
		sort(arr, j+1, hi);
	}
	
	public static void sort(Comparable[] arr) throws Exception {
		SortingUtils.shuffle(arr);
		System.out.println("After shuffle:");
		for(Comparable item:arr)
			System.out.println(item);

		sort(arr, 0, arr.length-1);
	}

	public static void main(String[] args) throws Exception {
		String[] arr = {"a", "s", "o", "m", "e", "w", "h", "a", "t", "l", "o", "n", "g", "e", "r", "i", "n", "s", "e", "r", "t", "i", "o", "n", "s", "o", "r", "t", "e", "x", "a", "m", "p", "l", "e"};
		
		sort(arr);
		System.out.println(String.format("isSorted: %s",SortingUtils.isSorted(arr)));

		for(String item: arr)
			System.out.println(item);
	}
}