package com.neuedu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class practice0206 {
    public static void main(String[] args) {
        List arraylist = new ArrayList();
        List linkedlist = new LinkedList();
        arraylist.add(213);
        arraylist.add(2123123);
        arraylist.add("asdasda");
        arraylist.add(2,"aaaaa");
        linkedlist.add(12);
        linkedlist.add(23);
        linkedlist.add("12312312");
        linkedlist.add(1,"asdasdas");
        for (Object i:arraylist){
            System.out.println(i);
        }
        for (Object i:linkedlist){
            System.out.println(i);
        }
        System.out.println(arraylist.size());
        System.out.println(arraylist.contains("aaaaa"));
        System.out.println(arraylist.indexOf(2123123));
        System.out.println(linkedlist.size());
        System.out.println(linkedlist.contains("aaaaa"));
        System.out.println(linkedlist.indexOf(2123123));
        System.out.println(arraylist.get(-1));
    }
}
