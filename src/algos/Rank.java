package algos;

import algos.util.SortingUtils;

public class Rank {

	public static int rank(Comparable[] arr, int lo, int hi, Comparable search) {
		if(lo > hi) return lo;
		
		int mid = (lo + hi)/2;
		
		if (SortingUtils.less(search, arr[mid])) return rank(arr, lo, mid-1, search);
		else if (SortingUtils.greater(search, arr[mid])) return rank(arr, mid+1, hi, search);
		else return mid;

	}

	public static int rank(Comparable[] arr, Comparable search) {
		return rank(arr, 0, arr.length -1, search);
	}

	public static void main(String[] args) {
		Integer[] arr = {6,13,14,25,33,43,52,53,64,72,84,93,95,96,97};
		int search = 72;

		System.out.println(Rank.rank(arr, search));
	}
}
