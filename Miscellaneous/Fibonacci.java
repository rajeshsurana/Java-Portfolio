// Recursive with Memoization 
// Memoization required if more than one recursive call in a function

import java.util.*;
public class Fibonacci{
    public int fib(int n){
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        
        // Set base condition in memo
        memo[0] = 0;
        memo[1] = 1;
        
        // Call to recursive function 
        return calcFibonacci(memo, n);
    }
    
    private int calcFibonacci(int[] memo, int n){
        // Compute memo[n] if not computed already
        if(memo[n] == -1) {
            memo[n] = calcFibonacci(memo, n-1)+ calcFibonacci(memo, n-2);
        }
        
        // Return the result of memo[n]
        return memo[n];
    }
}
