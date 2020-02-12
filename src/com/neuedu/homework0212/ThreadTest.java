package com.neuedu.homework0212;

public class ThreadTest {
    public static void main(String[] args) {
//        MyThread t1 = new MyThread();
//        t1.start();
//        MyThread t2 = new MyThread();
//        t2.start();
        MyThread2 t3 = new MyThread2();
        Thread t= new Thread(t3);
        t.start();
    }
}
