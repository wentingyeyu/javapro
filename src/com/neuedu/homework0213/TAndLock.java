package com.neuedu.homework0213;

import java.util.concurrent.CountDownLatch;

public class TAndLock {
    public static int a=0;
    public static Object obj = new Object();
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5000);
        for(int i=0;i<5000;i++){
            Thread t = new Thread(()->{
                synchronized(obj){
                    a++;
                    countDownLatch.countDown();
                }
            });
            t.start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a);
    }
}
