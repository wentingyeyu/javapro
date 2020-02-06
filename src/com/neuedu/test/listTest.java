package com.neuedu.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class listTest {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();
        Date arrayStartWrite = new Date();
        for(int i=0;i<100000;i++){
            arrayList.add(i);
        }
        Date arrayEndWrite = new Date();
        System.out.println("arrayList直接写入时间为："+(arrayEndWrite.getTime()-arrayStartWrite.getTime()));
        Date linkedStartWrite = new Date();
        for(int i=0;i<100000;i++){
            linkedList.add(i);
        }
        Date linkedEndWrite = new Date();
        System.out.println("linkedList直接写入时间为："+(linkedEndWrite.getTime()-linkedStartWrite.getTime()));
        Date arrayStartInsert = new Date();
        for(int i=0;i<100000;i++){
            arrayList.add(i,i);
        }
        Date arrayEndInsert = new Date();
        System.out.println("arrayList写入时间为："+(arrayEndInsert.getTime()-arrayStartInsert.getTime()));
        Date linkedStartInsert = new Date();
        for(int i=0;i<100000;i++){
            linkedList.add(i);
        }
        Date linkedEndInsert = new Date();
        System.out.println("linkedList写入时间为："+(linkedEndInsert.getTime()-linkedStartInsert.getTime()));
        Date arrayStartRead = new Date();
        for(int i=0;i<arrayList.size();i++){
            Object o =arrayList.get(i);
        }
        Date arrayEndRead = new Date();
        System.out.println("arrayList读数据时间为："+(arrayEndRead.getTime()-arrayStartRead.getTime()));
        Date linkedStartRead = new Date();
        for(int i=0;i<linkedList.size();i++){
            Object o =linkedList.get(i);
        }
        Date linkedEndRead = new Date();
        System.out.println("linkedList读数据时间为："+(linkedEndRead.getTime()-linkedStartRead.getTime()));

    }
}
