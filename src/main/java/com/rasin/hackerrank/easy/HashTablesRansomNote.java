package com.rasin.hackerrank.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashTablesRansomNote {

    //https://www.hackerrank.com/challenges/ctci-ransom-note/problem

    public static void main(String[] args) {
        Map<String, Integer> hash = new HashMap<String, Integer>();
        String result = "Yes";
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
            hash.put(magazine[magazine_i], hash.getOrDefault(magazine[magazine_i], 0)+1);
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
            if(hash.getOrDefault(ransom[ransom_i], 0) < 1) {
                result = "No";
                break;
            } else {
                hash.put(ransom[ransom_i], hash.get(ransom[ransom_i])-1);
            }
        }
        in.close();

        System.out.println(result);
    }
}
