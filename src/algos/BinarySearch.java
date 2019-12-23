package algos;

public class BinarySearch {

	/**
	 * @param arr array
	 * @param low lower bound of array
	 * @param hi upper limit of array
	 * @param search element to search
	 * @return index of the element being searched
	 */
	//See Video 9.2 elementary implementation for 'rank' similar to binary search 
	public static int search(int[] arr, int low, int hi, int search) {
		System.out.println("arr: " + arr + ", low: " + low + ", hi: "+ hi);
		if (low > hi) return -1;

		int mid = (low + hi)/2;
		if (search == arr[mid]) return mid;
		else if (search < arr[mid]) return search(arr, low, mid - 1, search);
		else return search(arr, mid + 1 , hi, search);

	}
	
	public static int search(int [] arr, int search) {
		return search(arr, 0, arr.length -1, search);
	}

	public static void main(String[] args) {
		int[] arr = {6,13,14,25,33,43,52,53,64,72,84,93,95,96,97};
		int search = 34;
		
		System.out.println(BinarySearch.search(arr, search));
	}
}
