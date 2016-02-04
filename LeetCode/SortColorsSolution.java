/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
*/
public class SortColorsSolution {
    public void sortColors(int[] nums) {
        int[] arr = new int[3];
        int i=0;
        for(int x : nums){
            if(x==0){
                nums[i] = 0;
                i++;
            }else
                arr[x]++;
            
        }
        int j;
        for(j=i; j<arr[1]+i;j++){
            nums[j] = 1;
        }
        for(;j<nums.length;j++){
            nums[j] = 2;
        }
    }
}