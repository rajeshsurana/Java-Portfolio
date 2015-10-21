public class BinarySearchImpl{
    public static boolean binarySearch(int target, int[] seq){
        int l = 0;
        int hi = seq.length - 1;
        int mid = 0;
        while(l <= hi){
            mid = l + (hi-l)/2;
            if(seq[mid] == target){
                return true;
            }else if(seq[mid]< target){
                l = mid+1;
            }else if(seq[mid]> target){
                hi = mid-1;
            }
        }
        return false;
    }
    
    public static void main(String[] args){
        int[] seq = {27, 45, 49, 57};
        if(BinarySearchImpl.binarySearch(27, seq)){
            System.out.println("Number found!");
        }else{
            System.out.println("Number not found!");
        }
    }
}