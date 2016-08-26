// Generic class HeapSort
public class HeapSort <T extends Comparable<? super T>> {
  private T[] arr;
  private int length;

  // Generic Method printArray
  public static <E> void printArray(E[] inputArray) {
    for (E element: inputArray) {
      System.out.printf("%s ", element);
    }
    System.out.println();
  }

  public static void main(String[] args) {
    // Test 1: Integers
    Integer[] intArr = {10, 55, 2, 30};
    HeapSort<Integer> hInt = new HeapSort<Integer>();
    hInt.sort(intArr);

    // Result should be intArr = {2, 10, 30, 55}
    HeapSort.printArray(intArr);

    // Test 2: Strings
    String[] strArr = {"one", "two", "three", "four"};
    HeapSort<String> hStr = new HeapSort<String>();
    hStr.sort(strArr);

    // Result should be strArr = {"four", "one", "three", "two"}
    HeapSort.printArray(strArr);
  }

  public void sort(T[] arr) {
    this.arr = arr;
    this.length = this.arr.length;
    this.doSort();
  }

  private void doSort() {

    // Build heap array
    for (int i = (this.length / 2) - 1; i >= 0; i--) {
      this.heapify(this.length, i);
    }

    // Extract element from heap one by one
    for (int i = this.length - 1; i >= 0; i--) {

      // Move current root to end
      T temp = this.arr[0];
      this.arr[0] = this.arr[i];
      this.arr[i] = temp;

      // call max heapify on the reduced heap
      this.heapify(i, 0);
    }
  }

  private void heapify(int size, int root) {
    int largest = root;
    int lChild = (root * 2) + 1;
    int rChild = (root * 2) + 2;
    T temp;

    // If left child is larger than root
    if (lChild < size && this.arr[lChild].compareTo(this.arr[largest]) > 0) {
      largest = lChild;
    }

    // If right child is larger than root
    if (rChild < size && this.arr[rChild].compareTo(this.arr[largest]) > 0) {
      largest = rChild;
    }

    // If root is not the largest
    if (largest != root) {
      temp = this.arr[root];
      this.arr[root] = this.arr[largest];
      this.arr[largest] = temp;

      // Recursively heapify the affected sub-tree
      this.heapify(size, largest);
    }
  }
}