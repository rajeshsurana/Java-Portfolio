/*
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
*/
public class AddDigitsSolution {
    /*public int addDigits(int num) {
        int sum;
        while(num>9){
            sum = 0;
            while(num>0){
                sum += num%10;
                num /=10;
            }
            num = sum;
        }
        return num;
    }*/
    public int addDigits(int num) {
        return 1 + (num-1)%9;
    }
}