package com.neuedu.homework0205;

public class SalesEmployee extends ColaEmployee {
    private int MonthSalas;
    private double RoyaltyRate;

    public SalesEmployee(int month,int MonthSalas,double Royaltyate) {
        super(month);
        this.MonthSalas=MonthSalas;
        this.RoyaltyRate=Royaltyate;
    }

    @Override
    public int getSalary(int month) {
        return (int) (MonthSalas*RoyaltyRate);
    }
}
