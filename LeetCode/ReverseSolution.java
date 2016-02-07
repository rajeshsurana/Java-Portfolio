/*
Reverse digits of an integer.
*/
public class ReverseSolution {
    public int reverse(int x) {
        int num = x > 0 ? x : -x;
        long rev = 0;
        while(num!=0){
            rev = rev*10 + num%10;
            num /=10;
        }
        if(rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE){
            return 0;
        }
        return x > 0 ? (int)rev : -(int)rev;
    }
}