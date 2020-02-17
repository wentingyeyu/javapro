package com.neuedu;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hundred {
    public static void main(String[] args) {
        /*
        9 9 乘法表
        for(int i=1;i<=9;i++){
            for(int j=1;j<=i;j++){
                if(i==j){
                    System.out.println(j+"*"+i+"="+i*j);
                }else{
                    System.out.print(j+"*"+i+"="+i*j+" ");
                }
            }
        }
         */
        /*
        输出错误信息
         System.err.println 可用于调试
        System.out.println("main()方法开始运行了");
        System.err.println("在运行期间手动输出一个错误信息");
        System.err.println("\t 这是一个不安全的程序");
        System.out.println("main()方法运行结束");
        */
        /*
        * 改变输出流
        PrintStream out = System.out;
        try {
            PrintStream ps = new PrintStream("./../../../javase/log.txt");
            System.setOut(ps);
            int age = 18;
            System.out.println("年龄变量重新定义，初始值为18！");
            String sex = "女";
            System.out.println("性别变量重新定义，初始值为女！");
            String info = "这是一个"+sex+"孩子，应该"+age+"岁了";
            System.out.println("整合两个变量为Info字符串变量，其结果是："+info);
            System.setOut(out);
            System.out.println("程序运行完毕，请查看日志文件。");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
         */
        /*
        * 加密解密
        System.out.println("请输入要加密或解密的英文");
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        char []pass = a.toCharArray();
        for(int i=0;i<a.length();i++){
            pass[i]=(char)(pass[i]^20000);
        }
        System.out.println(pass);

         */
    }
}
