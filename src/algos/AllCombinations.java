package algos;

public class AllCombinations {
	public static int combinations(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++)
			for(int j = i+1; j < arr.length; j++)
				for(int k = j+1;k < arr.length; k++)
					count++;

		return count;
	}
	public static void main(String[] args) {
		int[] arr = {6,13,14,25,33,43,52,53,64,72,84,93,95,96,97};
		System.out.println(AllCombinations.combinations(arr));
	}
}