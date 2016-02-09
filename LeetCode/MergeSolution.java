/*
Merge Sorted Array
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
*/
public class MergeSolution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // If second array is null return or 
        // last element of nums1 < first element of nums2 then append nums2 into nums1
        if(m>0 && (n==0 || nums1[m-1] < nums2[0])){
            for(int i=m;i<m+n;i++){
                nums1[i] = nums2[i-m];
            }
            return;
        }
        // Slide elements of nums1 by n to make place for merging
        for(int i=m+n-1; i>=n; i--){
            nums1[i] = nums1[i-n];
        }
        // Logic of merge sort
        int j=0, i=0;
        for(int k=0; j<n && k<m; i++){
            if(nums2[j] < nums1[n+k]){
                nums1[i] = nums2[j];
                j++;
            }else{
                nums1[i] = nums1[n+k];
                k++;
            }
        }
        // If anything left in nums2 append to nums1
        for(;j<n;j++,i++){
            nums1[i]=nums2[j];
        }
        // Don't worry if something left in nums1 as it is already in place
        // due to our sliding operation
        return;
    }
}