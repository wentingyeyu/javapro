package com.neuedu.homework0205;

import static java.lang.StrictMath.PI;

public class Circle extends Shape {
    private int radius;
    public Circle(){

    }
    public Circle(int radius,String color){
        super(color);
        this.radius = radius;
    }
    @Override
    public int getArea() {
        return (int) (PI*radius*radius);
    }

    @Override
    public int getPer() {
        return (int)(2*PI*radius);
    }
    @Override
    public void showAll() {
        System.out.println("矩形的周长为："+getPer());
        System.out.println("矩形的面积为："+getArea());
        System.out.println("矩形的颜色为"+super.getColor());
    }
}
