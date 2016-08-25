// Generic class InsertionSort
public class InsertionSort <T extends Comparable<? super T>> {
	private T[] arr;
	private int length;

	// Generic method printArray
	public static <E> void printArray(E[] inputArray) {
		// Display array elements  
		for (E element: inputArray) {
			System.out.printf("%s ", element);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Test 1: Integers
		Integer[] intArr = {10, 55, 2, 30};
		InsertionSort<Integer> insInt = new InsertionSort<Integer>();
		insInt.sort(intArr);
		// Result should be intArr = {2, 10, 30, 55}
		InsertionSort.printArray(intArr);

		// Test 2: Strings
		String[] strArr = {"one", "two", "three", "four"};
		InsertionSort<String> insStr = new InsertionSort<String>();
		insStr.sort(strArr);
		// Result should be strArr = {"four", "one", "three", "two"}
		InsertionSort.printArray(strArr);
	}

	public void sort(T[] arr) {
		this.arr = arr;
		this.length = this.arr.length;
		this.doSort();
	}

	private void doSort() {
		int i, holePosition;
		T valueToInsert;
		for (i = 1; i < this.length; i++) {
			holePosition = i;
			valueToInsert = this.arr[i];
			while(holePosition > 0 && this.arr[holePosition-1].compareTo(valueToInsert) > 0) {
				this.arr[holePosition] = this.arr[holePosition-1];
				holePosition--;
			}
			this.arr[holePosition] = valueToInsert;
		}
	}
}