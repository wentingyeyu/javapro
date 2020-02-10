package com.neuedu.homework0205;

public abstract class ColaEmployee {
    private String name;
    private int birthday;
    private int month;
    public ColaEmployee(int month){
        this.month=month;
    }
    public abstract int getSalary(int month);
}
