// Generic class Selection Sort
public class SelectionSort<T extends Comparable<? super T>> {
	private T[] arr;
	private int length;

	// Generic method printArray                         
	public static <E> void printArray( E[] inputArray )
	{
		// Display array elements          
		for (E element : inputArray){ 
			System.out.printf("%s ", element);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Test 1: Integers
		Integer[] a = {10, 4, 6, 20};
		SelectionSort<Integer> ssInt = new SelectionSort<Integer>();
		ssInt.sort(a);
		// Result should be a = {4, 6, 10, 20}
		SelectionSort.printArray(a);

		// Test 2: String
		String[] b = {"Sam", "Alex", "Rony", "Sandra"};
		SelectionSort<String> ssString = new SelectionSort<String>();
		ssString.sort(b);
		// Result should be b = {'Alex', 'Rony', 'Sam', 'Sandra'}
		SelectionSort.printArray(b);
	}

	public void sort(T[] a) {
		this.arr = a;
		this.length = this.arr.length;
		this.doSort();
	}

	private void doSort() {
		int i, j, p;
		T t;
		for (i = 0; i < this.length-1; i++) {
			p = i;
			for (j = i+1; j < this.length-1; j++) {
				if ((this.arr[p]).compareTo(this.arr[j]) > 0) {
					p = j;
				}
			}
			t = this.arr[i];
			this.arr[i] = this.arr[p];
			this.arr[p] = t;
		}
	}
}