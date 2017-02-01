/*
  Hash Tables: Ransom Note
  https://www.hackerrank.com/challenges/ctci-ransom-note
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        Map<String, Integer> magazine = new HashMap<String, Integer>(m);
        //String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            String word = in.next();
            int value = 0;
            if(magazine.containsKey(word)) {
                value = magazine.get(word);
            }
            
            magazine.put(word, value + 1);
            //magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            String word = in.next();
            int value = 0;
            if(magazine.containsKey(word)) {
                if(magazine.get(word) == 0) {
                    System.out.println("No");
                    return;                    
                }
                value = magazine.get(word).intValue();
                magazine.put(word, value - 1);               
            } else {
                System.out.println("No");
                return;
            }          
            //ransom[ransom_i] = in.next();
        }
        
        System.out.println("Yes");
        
    }
}