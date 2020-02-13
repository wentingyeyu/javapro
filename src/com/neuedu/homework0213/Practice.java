package com.neuedu.homework0213;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        /*
        斐波那契数列
        Integer x=1;
        Integer y=1;
        Integer sum=0;
        System.out.println(x);
        System.out.println(y);
        while (sum<200){
            System.out.println(sum=x+y);
            x=y;
            y=sum;
        }
         */
        /*
        小球反弹
        Double a=100.00;
        for (int i=0;i<10;i++){
            a=a/2;
        }
        System.out.println(a);
         */
        /*
        一个整数 加100后是一个完全平方数 再加168也是一个完全平方数
        Double a=0.0;
        while(true){
        if((Math.sqrt(a+100)==(int)Math.sqrt(a+100))&&(Math.sqrt(a+168)==(int)Math.sqrt(a+168))){
            System.out.println(a);
            return;
        }else {
            a++;
        }
        }
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入人数：");
        Integer n = scanner.nextInt();
        Integer m=1;
        List list = new ArrayList();
        for(Integer i=1;i<=n;i++){
            list.add(i);
        }
        while (list.size()!=1){
            if(m!=3){
                Integer x= (Integer) list.get(0);
                list.remove(0);
                list.add(x);
                m++;
            }else {
                list.remove(0);
                m=1;
            }
        }
        System.out.println(list.get(0));
    }
}
