/*
Implement pow(x, n).
*/
public class MyPowSolution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }
        
        if(n == -1){
            return 1/x;
        }
        
        double num = myPow(x, n/2);
        return num * num * myPow(x, n%2);
    }
}