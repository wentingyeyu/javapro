package com.neuedu.homework0205;

public class HourlyEmployee extends ColaEmployee {
    private int salary;
    private int hour;
    public HourlyEmployee(int month,int hour,int salary) {
        super(month);
        this.hour=hour;
        this.salary=salary;
    }
    @Override
    public int getSalary(int Month) {
        if(hour<0){
            System.out.println("旷工");
            return -1;
        }else if(hour<=160){
            return hour*salary;
        }else {
            return 160*salary+((hour-160)*salary+(hour-160)*salary/2);
        }
    }
}
