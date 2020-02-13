package com.neuedu.homework0212;

public interface MyInterface {
    public int method(int a,int b);
}
class Jian implements MyInterface{

    @Override
    public int method(int a, int b) {
        return a-b;
    }
}
class Add implements MyInterface{

    @Override
    public int method(int a, int b) {
        return a+b;
    }
}
class Cheng implements MyInterface{

    @Override
    public int method(int a, int b) {
        return a*b;
    }
}
class Chu implements MyInterface{

    @Override
    public int method(int a, int b) {
        return a/b;
    }
}
class Test {
    MyInterface add = new MyInterface() {
        @Override
        public int method(int a, int b) {
            return a+b;
        }
    };
}
