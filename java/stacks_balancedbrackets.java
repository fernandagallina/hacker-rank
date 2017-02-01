/* 
  Stacks: Balanced Brackets
  https://www.hackerrank.com/challenges/ctci-balanced-brackets

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static boolean isBalanced(String expression) {
        Stack<Character> expressionStack = new Stack<Character>();
        if(expression.length() == 0) return false;
        
        for(int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            switch(c) {
                case ')':
                    if(expressionStack.empty() || (Character)expressionStack.pop() != '(') 
                        return false; 
                    break;
                case '}':
                    if(expressionStack.empty() || (Character)expressionStack.pop() != '{') 
                        return false; 
                    break;
                case ']':
                    if(expressionStack.empty() || (Character)expressionStack.pop() != '[') 
                        return false; 
                    break;
                default:
                 expressionStack.push(c);
            }
        }
        if(!expressionStack.empty()) return false;
        return true;
     }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            boolean answer = isBalanced(expression);
            if(answer)
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}