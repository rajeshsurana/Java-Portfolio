/*
You and your K−1 friends want to buy N flowers. 
Flower number i has cost ci. 
Unfortunately the seller does not want just one customer to buy a lot of flowers, 
so he tries to change the price of flowers for customers who have already bought some flowers. 
More precisely, if a customer has already bought x flowers, he should pay (x+1)*ci dollars to buy flower number i. 
You and your K−1 friends want to buy all N flowers in such a way that you spend the least amount of money. 
You can buy the flowers in any order. 

Input:

The first line of input contains two integers N and K(K<=N). The next line contains N space separated positive integers c1,c2,...,cN.

Output:

Print the minimum amount of money you (and your friends) have to pay in order to buy all N flowers.

Constraints

1≤N,K≤100 
 Any ci is not more than 106 
 Result is guaranteed to be less than 231 

Sample input #00
3 3
2 5 6


Sample output #00
13


Sample input #01 
3 2
2 5 6


Sample output #01
15


Explanation : 
Sample Case #00: In this example, all of you should buy one flower each. Hence, you'll have to pay 13 dollars. 
Sample Case #01: Here one of the friend buys first two flowers in decreasing order of their price. 
So he will pay (0+1)*5 + (1+1)*2 = 9. And other friend will buy the costliest flower of cost 6. 
So total money need is 9+6=15.

*/

import java.io.*;
import java.util.*;

public class FlowerShopping {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        int[] fc = new int[n];
        for(int i=0; i<n; i++){
            fc[i] = sc.nextInt();
        }
        Arrays.sort(fc);
        int[] kArr = new int[k];
        int tot = 0;
        for(int i=n-1, j=0; i>=0; i--,j++){
            tot += fc[i] * (kArr[j%k]+1);
            kArr[j%k]++; 
        }
        System.out.println(tot);
    }
}