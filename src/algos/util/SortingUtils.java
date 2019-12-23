package algos.util;

import java.util.Random;

public class SortingUtils {

	public static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	public static boolean greater(Comparable a, Comparable b) {
		return a.compareTo(b) > 0;
	}

	public static boolean lessOrEqual(Comparable a, Comparable b) {
		return a.compareTo(b) <= 0;
	}

	public static void exch(Object[] arr, int i, int j) {
		Object tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static boolean isSorted(Comparable[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (less(arr[i], arr[i-1])) return false;
		}
		return true;
	}

	public static void shuffle(Comparable[] arr) {
		Random random = new Random();

		for (int i=0; i< arr.length;i++) {
			int r = random.nextInt(i+1);
			exch(arr, i, r);
		}
	}

}