package com.neuedu.homework0205;

public class Rectangle extends Shape{
    private int width;
    private int height;
    public Rectangle(){
    }
    public Rectangle(int width,int height,String color){
        super(color);
        this.width=width;
        this.height=height;
    }
    @Override
    public int getPer() {
        return 2*(width+height);
    }

    @Override
    public int getArea() {
        return width*height;
    }

    @Override
    public void showAll() {
        System.out.println("矩形的周长为："+getPer());
        System.out.println("矩形的面积为："+getArea());
        System.out.println("矩形的颜色为"+super.getColor());
    }
}
