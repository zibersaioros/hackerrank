package com.rasin.hackerrank.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SortingComparator {
    //  https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }

    public static class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static class Checker implements Comparator<Player> {
        public int compare(Player p1, Player p2) {
            int result = 0;
            if ( (result = Integer.compare(p2.score, p1.score)) == 0)
                result = p1.name.compareTo(p2.name);
            return result;
        }
    }
}
