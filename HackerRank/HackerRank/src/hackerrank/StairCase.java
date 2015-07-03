/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;
import java.util.*;
/**
 *
 * @author Rajesh
 */

/* Your teacher has given you the task to draw the structure of a staircase. 
Being an expert programmer, you decided to make a program for the same. 
You are given the height of the staircase. You need to print a staircase as shown in the example.*/

public class StairCase {

        public static void stairCase() {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int height = in.nextInt();
        for(int i = 0; i < height; i++){
            for(int j = 0; j < height; j++){
                if(i + j >= height - 1){
                    System.out.print("#");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
