package algos;

import algos.util.SortingUtils;

public class ShellSort {

	public static void sort(Comparable[] arr) {
		int N = arr.length;
		int h = 1;

		while(h < N/3) h = h*3 + 1;

		while( h >= 1) {
		
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && SortingUtils.less(arr[j], arr[j-h]); j = j - h)
					SortingUtils.exch(arr, j, j-h);
			}
			h = h/3;
		}
	}

	public static void main(String[] args) {
		String[] arr = {"s", "o", "r", "t", "e", "x", "a", "m", "p", "l", "e"};

		sort(arr);
		System.out.println(String.format("isSorted: %s", SortingUtils.isSorted(arr)));

		for (String item: arr)
			System.out.println(item);

	}
}