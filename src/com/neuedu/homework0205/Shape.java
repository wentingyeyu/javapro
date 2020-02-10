package com.neuedu.homework0205;

public abstract class Shape {
    private int per;
    private int area;
    private String color;
    public Shape(){
    }

    public String getColor() {
        return color;
    }

    public Shape(String color){
        this.color=color;
    }
    public abstract int getArea();
    public abstract int getPer();
    public abstract void showAll();

}
