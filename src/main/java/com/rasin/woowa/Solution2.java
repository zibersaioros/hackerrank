package com.rasin.woowa;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public static int solution(int[] A, int[] B, int M, int X, int Y) {
        // write your code in Java SE 8
        int stop = 0;
        int start = 0;
        //

        Set<Integer> targets = new HashSet<Integer>(M);

        while(start < A.length){
            int end = getLimitPerson(A, X, Y, start);
            targets.clear();

            for(int i = start; i <= end; i++){
                targets.add(B[i]);
            }
            stop += targets.size() + 1;
            start = end+1;
        }

        return stop;
    }

    public static int getLimitPerson(int[] A, int X, int Y, int start){
        int sumX = 0;
        int sumY = 0;
        int i = 0;
        while(A.length > start + i){
            sumY += A[start + i++];
            sumX++;

            if(sumX == X)
                return start + sumX - 1;
            else if(sumY > Y)
                return start + i - 2;
        }
        return A.length - 1;
    }

    public static void main(String[] args) {
        int[] A = {40, 40, 100, 80, 20};
        int[] B = {3, 3, 2, 2, 3};
        int M = 3;
        int X = 5;
        int Y = 200;
        System.out.println(solution(A, B, M, X, Y));
    }
}
