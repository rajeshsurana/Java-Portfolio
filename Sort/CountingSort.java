class CountingSort {
	
	/* 
	 * Counting sort works well for large number of values in
	 * a specific range. It works by counting the number of occurrences
	 * of each value as compared to comparison based sorts like Merge sort.
	 */
	public static void sort(int[] arr, int k) {
		// Here, range of values 0 to k
		// Values = n
		// Complexity of algorithm for large value of n
		// as compared to k is O(n)

		int n = arr.length;
		int[] count = new int[k+1];
		int[] output = new int[n];

		// Count occurance of each element
		for (int i=0; i < n; i++) {
			++count[arr[i]];
		}

		// Change count[i] so that count[i] now
		// contains position of characters in sorted array
		for (int i=1; i<=k; i++) {
			count[i] += count[i-1];
		}

		// Now generate output sorted array
		for (int i=0; i<n; i++) {
			output[--count[arr[i]]] = arr[i]; 
		}

		// Copy sorted output array in the arr
		for (int i=0; i<n; i++){
			arr[i] = output[i];
		}
	}

	public static void printArray(int[] arr) {
		for (int a: arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = {9, 4, 4, 3, 7, 5, 9, 1, 6, 2};
		sort(arr, 9);
		// Output -> 1 2 3 4 4 5 6 7 9 9
		printArray(arr);
	}
}

