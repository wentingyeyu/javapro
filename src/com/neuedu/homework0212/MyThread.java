package com.neuedu.homework0212;

public class MyThread extends Thread {
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"线程输出:"+i);
        }
    }
}
