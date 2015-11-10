/*
A series is defined in the following manner:

Given the nth and (n+1)th terms, the (n+2)th can be computed by the following relation 
T(n+2) = (T(n+1))^2 + Tn 

So, if the first two terms of the series are 0 and 1: 
 the third term = 1^2 + 0 = 1 
 fourth term = 1^2 + 1 = 2 
 fifth term = 2^2 + 1 = 5 
 ... And so on. 

Given three integers A, B and N, such that the first two terms of the series (1st and 2nd terms) are A and B respectively, 
compute the Nth term of the series. 

Input Format 

You are given three space separated integers A, B and N on one line. 

Input Constraints 
 0 <= A,B <= 2 
 3 <= N <= 20 

Output Format 

One integer. 
 This integer is the Nth term of the given series when the first two terms are A and B respectively. 

Note 
•Some output may even exceed the range of 64 bit integer. 

Sample Input 
0 1 5  


Sample Output 
5


Explanation 

The first two terms of the series are 0 and 1. The fifth term is 5. 
How we arrive at the fifth term, is explained step by step in the introductory sections. 

*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ModifiedFibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aTemp = sc.nextInt();
        int bTemp = sc.nextInt();
        int n = sc.nextInt();
        BigInteger a = new BigInteger(aTemp+"");
        BigInteger b = new BigInteger(bTemp+"");
        BigInteger temp = new BigInteger(bTemp+"");
        
        for(int i=2; i<n; i++){
            temp = b;
            b = b.multiply(b).add(a); 
            a = temp;
        }
        System.out.println(b);
    }
}