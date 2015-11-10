/*
Mark and Jane are very happy after having their first kid. 
Their son is very fond of toys, so Mark wants to buy some. 
There are N different toys lying in front of him, tagged with their prices, but he has only $K. 
He wants to maximize the number of toys he buys with this money.

Now, you are Mark's best friend and have to help him buy as many toys as possible.

Input Format 
 The first line contains two integers, N and K, followed by a line containing N space separated integers indicating the products' prices.

Output Format 
 An integer that denotes maximum number of toys Mark can buy for his son.

Constraints 
1<=N<=10^5 
1<=K<=10^9 
1<=price of any toy<=10^9 
 A toy can't be bought multiple times.

Sample Input
7 50
1 12 5 111 200 1000 10


Sample Output
4


Explanation

He can buy only 4 toys at most. These toys have the following prices: 1,12,5,10.
*/
import java.io.*;
import java.util.*;

public class ToyShopping {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        String[] sArr = s.split(" ");
        int[] iArr = new int[n];
        for(int i=0; i< n; i++){
            iArr[i] = Integer.parseInt(sArr[i]);
        }
        Arrays.sort(iArr);
        int sum = 0;
        int j=0;
        for(; j<n; j++){
            sum += iArr[j];
            if(sum>= k)
                break;
        }
        if(sum<k){
            j++;
        }
        System.out.println(j);
    }
}