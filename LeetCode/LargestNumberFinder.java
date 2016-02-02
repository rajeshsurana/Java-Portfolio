/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
*/
public class LargestNumberFinder {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        String[] str = new String[len];
        for(int i=0; i<len; i++){
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, new Comparator<String>(){
            public int compare(String s1, String s2){
                String leftright = s1 + s2;
                String rightleft = s2 + s1;
                return rightleft.compareTo(leftright);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String s: str){
            sb.append(s);
        }
        while(sb.charAt(0) == '0' && sb.length()>1){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}