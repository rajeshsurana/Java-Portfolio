public class QuickSort
{
    private int [] arr;
    private int length;
    
    public static void main(String[] args){
        int[] a = {10, 6, 5, 13, 48};
        QuickSort qs = new QuickSort();
        qs.sort(a);
        for(int item: a){
            System.out.print(item + " ");
        }
    }
    
    public void sort(int[] a){
        if(a == null || a.length == 0){
            System.out.println("Invalid input.");
            return;
        }
        this.arr = a;
        this.length = this.arr.length;
        doQuickSort(0, length-1);
    }
    
    private void doQuickSort(int l, int h){
        int i = l;
        int j = h;
        int pivot = this.arr[l+(h-l)/2];
        while(i<=j){
            while(this.arr[i] < pivot){
                i++;
            }
            while(this.arr[j] > pivot){
                j--;
            }
            if(i<=j){
                swapNumbers(i,j);
                i++;
                j--;
            }
        }
        if(i<h){
            doQuickSort(i, h);
        }
        if(l<j){
            doQuickSort(l, j);
        }
    }
    
    private void swapNumbers(int i, int j){
        int tmp = this.arr[i];
        this.arr[i] = this.arr[j];
        this.arr[j] = tmp;
    }
}