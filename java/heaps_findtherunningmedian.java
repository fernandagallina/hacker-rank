/*
  Heaps: Find the Running Median

  https://www.hackerrank.com/challenges/ctci-find-the-running-median

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static void printMeds(int[] arr){
        PriorityQueue<Integer> left = new PriorityQueue<Integer>(10, Collections.reverseOrder()); //max heap on left
        PriorityQueue<Integer> right = new PriorityQueue<Integer>(10); //min heap on right
        
        for (int val : arr){
            
            //add to one of the heaps
            if (left.size() == 0 || val <= left.peek()) 
                left.add(val);
            else
                right.add(val);
            
            //ensure balance
            if (left.size() - right.size() == 2)
                right.add(left.poll()); // l is too large
            if (right.size() - left.size() == 2)
                left.add(right.poll()); //r is too large
            
            double m = 0;
            
            //calculate median
            if (left.size() == right.size())
                m = ((double) left.peek() + (double) right.peek())/2;
            else if (left.size() > right.size())
                m = (double) left.peek();
            else
                m = right.peek();
            System.out.println(m);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        printMeds(a);       
    }
}