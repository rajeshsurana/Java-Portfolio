public class GCD{
    public int findGCD(int a, int b){
        // Last non-zero remainder is the gcd of a and b
        if(b == 0) return a;
        // Call for smaller of two and remainder after dividing by smaller number
        return findGCD(b, a%b);
    }
    
    public static void main(String[] args){
        GCD gcd = new GCD();
        System.out.println(gcd.findGCD(400, 1000));
    }
}