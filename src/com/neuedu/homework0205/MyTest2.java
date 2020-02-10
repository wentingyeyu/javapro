package com.neuedu.homework0205;

public class MyTest2 {
    public static void main(String[] args) {
        ColaEmployee salariedEmployee = new SalariedEmployee(2,3434);
        ColaEmployee hourlyEmployee = new HourlyEmployee(2,200,1);
        ColaEmployee salesEmployee = new SalesEmployee(2,10000000,0.2);
        ColaEmployee colaEmployee[] = new ColaEmployee[3];
        colaEmployee[0]=salariedEmployee;
        colaEmployee[1]=hourlyEmployee;
        colaEmployee[2]=salesEmployee;
        for (int i=0;i<3;i++){
            payWage(colaEmployee[i],2);
        }

    }
    public static int payWage(ColaEmployee emp,int month){
        System.out.println(month+"月的工资为："+emp.getSalary(month));
        return 0;
    }
}
