package com.rasin.hackerrank.easy;

import java.util.HashSet;
import java.util.Set;

public class LinkedListsDetectACycle {
    // https://www.hackerrank.com/challenges/ctci-linked-list-cycle/problem

    class Node {
        int data;
        Node next;
    }

    boolean hasCycle(Node head) {
        if(head == null)
            return false;
        Set<Node> sets = new HashSet<Node>();

        Node current = head;
        while(current != null) {
            if(sets.contains(current))
                return true;

            sets.add(current);
            current = current.next;
        }
        return false;
    }

}
