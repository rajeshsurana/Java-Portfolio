/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.Scanner;

/**
 *
 * @author Rajesh
 */
/*You are given a square matrix of size . Calculate the absolute difference of the sums across the two main diagonals.
Link: https://www.hackerrank.com/challenges/diagonal-difference */

public class DiagonalDiff {
        public static int diagonalDifference(){
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int sumDia1 = 0;
        int sumDia2 = 0;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                int num = in.nextInt();
                /* If i == j then element is on diagonal with left-top to right-bottom corner
                   else if i + j is one less than length of matrix then element is on another diagonal*/
                if (i == j){
                    sumDia1 += num;
                }
                if(i + j == len-1){
                    sumDia2 += num;
                }
            }// End of inner for loop
        }// End of outer for loop
        return Math.abs(sumDia1 - sumDia2);
    }
}
