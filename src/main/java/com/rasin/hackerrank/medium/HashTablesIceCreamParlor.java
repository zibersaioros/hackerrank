package com.rasin.hackerrank.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashTablesIceCreamParlor {
    // https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem

    static void solve(int[] arr, int money) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < arr.length-1; i++) {
            if(arr[i] >= money)
                continue;
            map.put(arr[i], i);
        }

        for(int i = 0; i < arr.length-1; i++) {
            if(arr[i] >= money)
                continue;
            if(map.get(money - arr[i]) != null) {
                System.out.println((i+1) + " " + (map.get(money - arr[i]) + 1));
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int money = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            solve(arr, money);
        }
        in.close();
    }
}
