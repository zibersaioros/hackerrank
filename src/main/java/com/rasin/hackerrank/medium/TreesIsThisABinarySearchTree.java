package com.rasin.hackerrank.medium;

public class TreesIsThisABinarySearchTree {
    // https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem

    class Node {
        int data;
        Node left;
        Node right;
    }

    boolean checkBST(Node root) {

        if(!checkTraverse(root.left, 0, root.data))
            return false;
        if(!checkTraverse(root.right, root.data, Integer.MAX_VALUE))
            return false;

        return true;
    }

    boolean checkTraverse(Node root, int minValue, int maxValue) {
        if (root == null)
            return true;

        if(root.data >= maxValue )
            return false;
        if(root.data <= minValue)
            return false;
        if(root.left != null && root.data <= root.left.data)
            return false;
        if(root.right != null && root.data >= root.right.data)
            return false;

        return checkTraverse(root.left, minValue, root.data) && checkTraverse(root.right, root.data, maxValue);
    }
}
