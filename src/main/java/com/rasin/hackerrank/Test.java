package com.rasin.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println("Test");

        List<String> list = new ArrayList<String>();
        list.add("가나다라마바사아자차카타파" + 1);
        String obj = list.get(0);
        obj = null;
        System.out.println(list.get(0));
    }
}
