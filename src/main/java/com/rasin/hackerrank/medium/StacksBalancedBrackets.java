package com.rasin.hackerrank.medium;

import java.util.Scanner;
import java.util.Stack;

public class StacksBalancedBrackets {
    //  https://www.hackerrank.com/challenges/ctci-balanced-brackets/problem

    public static boolean isBalanced(String expression) {
        String open = "({[";
        String close = ")}]";
        int openCount = 0;
        int closeCount = 0;

        Stack<String> stack = new Stack<String>();

        for(int i = 0; i < expression.length(); i++) {
            String item = Character.toString(expression.charAt(i));
            if(open.contains(item)) {
                stack.push(item);
                openCount++;
            } else {
                closeCount++;
                if(closeCount > openCount || open.indexOf(stack.pop()) != close.indexOf(item))
                    return false;
            }
        }
        if(openCount == closeCount)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
        in.close();
    }
}
