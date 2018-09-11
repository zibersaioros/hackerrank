package com.rasin.hackerrank.easy;

import java.util.Scanner;

public class RecursionFibonacciNumbers {
    //https://www.hackerrank.com/challenges/ctci-fibonacci-numbers/problem

    public static int fibonacci(int n) {
        if (n < 2)
            return n;

        int prev = 0, temp = 0;
        int current = 1;
        for(int i = 1; i < n; i++) {
            temp = prev;
            prev = current;
            current += temp;
        }
        return current;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}
