package com.neuedu.homework0212;

public class InterfaceTest {
    public static void main(String[] args) {
        MyInterface add=(a,b)->{
            return a+b;
        };
        System.out.println(add.method(2,5));
        MyInterface jian = (a,b)->{
            return a-b;
        };
        System.out.println(jian.method(5,2));
        MyInterface cheng = (a,b) ->{
            return a*b;
        };
        System.out.println(cheng.method(2,3));
        MyInterface chu = (a,b)->{
            return a/b;
        };
        System.out.println(chu.method(4,2));
        MyInterface add2 = (a,b) -> add.method(a,b);
        System.out.println(add2.method(2,5));
    }
}
