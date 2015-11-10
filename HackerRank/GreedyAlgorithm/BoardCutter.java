/*
Alice gives a wooden board composed of M X N wooden square pieces to Bob and asks him to find the minimal cost of breaking 
the board into square wooden pieces. 
Bob can cut the board along horizontal and vertical lines, and each cut divides the board in smaller parts. 
Each cut has a cost depending on whether the cut is made along a horizontal or a vertical line. 

Let us denote the costs of cutting it along consecutive vertical lines by x1, x2, ..., xn-1, 
and the cost of cutting it along horizontal lines by y1, y2, ..., ym-1. 
If a cut (of cost c) is made and it passes through n segments, then total cost of this cut will be n*c. 

The cost of cutting the whole board into single squares is the sum of the cost of successive cuts 
used to cut the whole board into square wooden pieces of size 1x1. 
Bob should compute the minimal cost of breaking the whole wooden board into squares of size 1x1. 

Bob needs your help to find the minimal cost. Can you help Bob with this challenge?

Input Format 
 A single integer in the first line T, stating the number of test cases. T testcases follow. 
 For each test case, the first line contains two positive integers M and N separated by a single space. 
 In the next line, there are integers y1, y2, ..., ym-1, separated by spaces. 
 Following them are integers x1, x2, ..., xn-1, separated by spaces.

Output Format 
 For each test-case, write an integer in separate line which denotes the minimal cost of cutting 
 the whole wooden board into single wooden squares. 
 Since the answer can be very large, output the answer modulo 109+7.

Constraints 
 1 <= T <= 20 
 2 <= M,N <= 1000000 
 0 <= xi <= 10^9 
 0 <= yi <= 10^9

Sample Input #00
1
2 2
2
1


Sample Output #00
4


Sample Input #01
1
6 4
2 1 3 1 4
4 1 2


Sample Output #01 
42


Explanation 
Sample Case #00: At first, board should be cut horizontally, where y1 = 2, then it should be cut vertically. 
So total cost will be 2*1 + 1*2 = 4. 

Sample Case #01: We should start cutting using y5, x1, y3, y1, x3, y2, y4 and x2, in order. 
First cut will be a horizontal one where cost = y5 = 4. Next we will do a vertical cut with x1. 
Since this cut passes through two segments (created by previous horizontal cut), it's total cost will be 2*x1 = 2*4. 
Similarly next horizontal cut (y3) will pass through two segments and will cost 2*y3 = 2*3. 
We can proceed in similar way and get overall cost as 4 + 4*2 + 3*2 + 2*2 + 2*4 + 1*3 + 1*3 + 1*6 = 42.
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void BoardCutter(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for(int i=0; i< t; i++){
            int m = sc.nextInt();
            int n = sc.nextInt();
            m--;
            n--;
            sc.nextLine();
            long[] M = new long[m];
            for(int j=0; j<m; j++){
                M[j] = sc.nextInt();
            }
            sc.nextLine();
            long[] N = new long[n];
            for(int j=0; j<n; j++){
                N[j] = sc.nextInt();
            }
            if(sc.hasNext()) sc.nextLine();
            long h = 1L;
            long v = 1L;
            long cost = 0L;
            Arrays.sort(M);
            Arrays.sort(N);
            int x, y;
            for(x=n-1, y=m-1; x>=0 && y>=0;){
                if(M[y] > N[x]){
                    h++;
                    cost = (cost + v*M[y])%1000000007L;
                    y--;
                }else if(M[y] < N[x]){
                    v++;
                    cost = (cost + h*N[x])%1000000007L;
                    x--;
                }else{
                    if(h<v){
                        h++;
                        cost = (cost + v*M[y])%1000000007L;
                        y--;
                    }else{
                      v++;
                      cost = (cost + h*N[x])%1000000007L;
                      x--;  
                    }
                }
            }
            while(x>=0){
                 v++;
                 cost = (cost + h*N[x]) %1000000007L;
                 x--; 
            }
            while(y>=0){
                h++;
                cost = (cost + v*M[y])%1000000007L;
                y--;
            }
            System.out.println(cost%1000000007L);
        }
    }
}