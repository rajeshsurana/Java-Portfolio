/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/
public class PlusOneSolution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int len = digits.length;
        int i = len -1;
        for(; i>=0; i--){
            digits[i] = digits[i] + carry;
            carry = digits[i]/10;
            digits[i] %= 10;
            if(carry == 0)
                return digits;
        }
        int[] res = new int[len+1];
        res[0] = 1;
        return res;
    }
}