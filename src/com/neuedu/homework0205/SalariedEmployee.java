package com.neuedu.homework0205;

public class SalariedEmployee extends ColaEmployee
{
    public SalariedEmployee(int month, int salary){
    super(month);
    this.salary=salary;
}
    private int salary;
    @Override
    public int getSalary(int Month) {
        return salary;
    }
}
