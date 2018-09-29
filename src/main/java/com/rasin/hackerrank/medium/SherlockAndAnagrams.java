package com.rasin.hackerrank.medium;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndAnagrams {
    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int count = 0;
        for(int i = 0; i < s.length() - 1; i++){
            for(int j = 1; j <= s.length() - i; j++){
                String first = s.substring(i, i+j);
                for(int k = i+1; k+j <= s.length(); k++){
                    String second = s.substring(k, k+j);

                    System.out.println(first + " " + second);

                    count += checkAnagram(first, second);
                    System.out.println(count);
                }
            }
        }


        return count;
    }

    static int checkAnagram(String first, String second){
        Map<Character, Integer> table = new HashMap<Character, Integer>();

        for(int i = 0; i < first.length(); i++){
            char c = first.charAt(i);
            table.put(c, table.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < second.length(); i++){
            char c = second.charAt(i);
            int count = table.getOrDefault(c, 0) - 1;
            if(count < 0)
                return 0;
            else
                table.put(c, count);
        }


        return 1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int i = sherlockAndAnagrams("abba");
        System.out.println(i);
    }
}
