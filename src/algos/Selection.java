package algos;

import java.util.Random;
import algos.util.SortingUtils;

/*
 * Given an array of N sorted elements, find the kth largest.
 * O(N logN) upper bound. Can we do better?
 * Is there a linear time algorithm for every k ?
 * 
 * Selection takes linear time in the AVERAGE
 */
public class Selection {
	
	public static int partition(Comparable[] arr, int lo, int hi) {
		System.out.println(String.format("partition - lo: %s, hi: %s", lo, hi));

		int i = lo + 1;
		int j = hi;
		
		while(true) {
			while(SortingUtils.lessOrEqual(arr[i], arr[lo])) {
				if (i >=hi) break;
				i++;
			}
			
			while(SortingUtils.less(arr[lo], arr[j])) {
				if (j <= lo) break;
				j--;
			}
			
			if (i >= j) break;
			else SortingUtils.exch(arr, i, j);
		}
		SortingUtils.exch(arr, lo, j);
		return j;
	}

	public static void sort(Comparable[] arr, int lo, int hi) {
		if (lo >= hi) return;
		
		int j = partition(arr, lo, hi);
		sort(arr, lo, j-1);
		sort(arr, j+1, hi);
	}

	public static Comparable selection(Comparable[] arr, int k) {
		System.out.println(String.format("selection - k:%s", k));

		int lo = 0;
		int hi = arr.length - 1;

		while(lo < hi) {
			int j = partition(arr, lo, hi);
			if (j < k) lo = j+1;
			else if (j > k) hi = j - 1;
			else return arr[k];
		}
		return arr[k];
	}

	public static boolean areEqual(Comparable[] arr1, Comparable[] arr2) {
		if (arr1.length != arr2.length) return false;
		
		for (int i=0; i < arr1.length;i++) {
			if (arr1[i] != arr2[i]) return false;
		}

		return true;
	}

	public static void shuffle(Comparable[] arr) {
		Random r = new Random();

		for (int i=0; i<arr.length;i++) {
			int k = r.nextInt(i+1);
			SortingUtils.exch(arr, i, k);
		}
	}

	public static void main(String[] args) {
		String[] arr = {"a", "s", "o", "m", "e", "w", "h", "a", "t", "l", "o", "n", "g", "e", "r", "i", "n", "s", "e", "r", "t", "i", "o", "n", "s", "o", "r", "t", "e", "x", "a", "m", "p", "l", "e"};
		String[] result = new String[arr.length];

		for (int i=0; i < arr.length; i++) {
			shuffle(arr);
			result[i] = (String) selection(arr, i);
		}

		shuffle(arr);
		sort(arr, 0, arr.length -1);

		System.out.println(String.format("areEqual: %s", areEqual(arr, result)));
	}
}