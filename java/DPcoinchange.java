/*
  https://www.hackerrank.com/challenges/ctci-coin-change
  DP: Coin Change
  
  
  Given a number of dollars and a list of dollar values for distinct coins, find
  and print the number of different ways you can make change for  dollars if each 
  coin is available in an infinite quantity.

  

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static long dynamic(int[] v, int amount) {
        long[][] solution = new long[v.length + 1][amount + 1];
        
        // if amount=0 then just return empty set to make the change
        for (int i = 0; i <= v.length; i++) {
            solution[i][0] = 1;
        }

        // if no coins given, 0 ways to change the amount
        for (int i = 1; i <= amount; i++) {
            solution[0][i] = 0;
        }
        
        // now fill rest of the matrix.
        for (int i = 1; i <= v.length; i++) {
            for (int j = 1; j <= amount; j++) {
                // check if the coin value is less than the amount needed
                if (v[i - 1] <= j) {
                    // reduce the amount by coin value and
                    // use the subproblem solution (amount-v[i]) and
                    // add the solution from the top to it
                    solution[i][j] = solution[i - 1][j] + solution[i][j - v[i - 1]];
                } else {
                    // just copy the value from the top
                    solution[i][j] = solution[i - 1][j];
                }
            }
        }
        
        return solution[v.length][amount];
        
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        
        System.out.println(dynamic(coins, n));
    }
}