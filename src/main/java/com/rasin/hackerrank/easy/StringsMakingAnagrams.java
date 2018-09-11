package com.rasin.hackerrank.easy;

import java.util.Scanner;

public class StringsMakingAnagrams {

    // https://www.hackerrank.com/challenges/ctci-making-anagrams/problem

    public static int numberNeeded(String first, String second) {
        int count = 0;
        for(int i = 0; i < first.length(); i++) {
            String s = Character.toString(first.charAt(i));
            if(second.indexOf(s) >= 0) {
                count++;
                second = second.replaceFirst(s, "");
            }
        }

        return second.length() + first.length() - count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
