public class MergeSort{
    private int[] arr;
    private int[] tmpArr;
    private int length;
    
    
    public static void main(String[] args){
        int[] a = {10, 10, 3, 2};
        MergeSort ms = new MergeSort();
        ms.sort(a);
        for(int item: a){
            System.out.print(item + " ");
        }
    }
    
    public void sort(int[] a){
        this.arr = a;
        this.length = this.arr.length;
        this.tmpArr = new int[length];
        doMergeSort(0, length-1);
    }
    
    private void doMergeSort(int l, int h){
        if(l<h){
            int middle = (h-l)/2 + l;
            doMergeSort(l, middle);
            doMergeSort(middle+1, h);
            mergeParts(l, middle, h);
        }
    }
    
    private void mergeParts(int l, int middle, int h){
        for(int i=l; i<=h; i++ ){
            this.tmpArr[i] = this.arr[i];
        }
        int i= l;
        int j = middle+1;
        int k = l;
        while(i<= middle && j<=h){
            if(this.tmpArr[i]<= this.tmpArr[j]){
                this.arr[k] = this.tmpArr[i];
                i++;
            }else{
                this.arr[k] = this.tmpArr[j];
                j++;
            }
            k++;
        }

        while(i<=middle){
            this.arr[k] = this.tmpArr[i];
            i++;
            k++;
        }                
    }
}