package algos;

import java.util.Random;
import algos.util.SortingUtils;

public class Shuffle {

	public static void shuffle(Object[] arr) {
		Random random = new Random();
		for (int i=0; i < arr.length; i++) {
			int r = random.nextInt(i + 1);
			SortingUtils.exch(arr, r, i);
		}
	}

	public static void main(String[] args) {
		Integer[] arr = {0,1,2,3,4,5,6,7,8,9};
		
		shuffle(arr);
		
		for (Integer i : arr)
			System.out.println(i);
	}
}