package com.neuedu.practice;

public class Basis {
    public static void main(String[] args) {
        /*
        0203 上午
        int a = 10;
        byte c = 100;
        short b = 100;
        int i = 0;
        if(i++>4&i++>6) {
            System.out.println(a + c + b);
        }
        System.out.println(i);
        public static String getType(Object o){
        return o.getClass().toString();
         }
         */
        /*
//        0203 下午 练习1 封装类
        Dog dog = new Dog();
        dog.setType("阿拉斯加");
        dog.setSex('公');
        dog.setAge(1200);
        dog.setName("小小");
        int age = dog.getAge();
        if(dog.isTrue(age)){
            System.out.println(age);
        }
        System.out.println(dog.getType());
        System.out.println(dog.getSex());
        System.out.println(dog.getName());
         */
        /*
        0203 下午 练习2 判断闰年（判断）

        int year = 1996;
        if(year%4 == 0 && year%100 !=0){
            System.out.println(year+":是普通闰年");
        }else if(year%400 == 0){
            System.out.println(year+":是世纪闰年");
        }else{
            System.out.println(year+":不是闰年");
        }
         */
        /*
        0203 下午 练习3 1——100 累加 （循环）
        int a=0;
        for(int i = 1;i<=100;i++){
            a+=i;
        }
        System.out.println(a);
         */
        /*
        0203 作业 1~100质数和

        int sum = 0;
        for(int i = 2;i<=100;i++) {
            boolean flag = true;
            for (int j = 2; j < Math.sqrt(i); j++) {
                if (i % j == 0 && i != j) {
                    flag = false;
                }
            }
            if (flag) {
                sum += i;
            }
        }
        System.out.println(sum);

         */
        /*
        0204 上午 练习1 静态方法
         int sum = Dog.add(3,5);
        System.out.println(sum);
         */
       /*
       0204 下午 数组定义方式
        int [] arry = new int[];
        int []arry ={1,2,3};
        增强for 专门循环数组
        for(int a:arry){ //每次的a 相当于当前arry
        }
        */
       /*
       0204 下午 练习1 数字组合
       int [] number={1,2,3,4};//123 124 134 234
       for(int a:number){
           for(int b:number){
               for(int c:number){
                   if(a==b||a==c||b==c){
                       continue;
                   }else{
                       System.out.println(a*100+b*10+c);
                   }
               }
           }
       }
        */
        /*
       0204 下午 练习2 1~100 偶数和
       int sum= 0;
        for(int i =1;i<=100;i++){
            if(i%2==0){
                sum+=i;
            }
        }
        System.out.println(sum);
         */
        /*
       0204 下午 练习3 求 m的n次方
        int m=8;
        int n=4;
        int num=1;
        for(int i=0;i<n;i++){
            num*=num;
        }
        System.out.println(num);
         */
          /*
       0204 下午 练习4 求111~999 之间的水仙花数 每位的3次方 相加还是本身
         int [] number = {0,1,2,3,4,5,6,7,8,9};
         int m=0,x=0,y=0,z=0,sum=0;
         for(int a:number){
             x=a;
             a = a*100;
             for(int b:number){
                 y=b;
                 b=b*10;
                 for(int c:number){
                     z=c;
                     m=a+b+c;
                     if(999>m&&m>100){
                     sum = x*x*x+y*y*y+z*z*z;
                     if(m==sum){
                         System.out.println(m);
                     }
                     }
                 }
             }
         }
           */
          /*
       0204 下午 练习5 两个正整数 计算最大公约数和最小公倍数
       三目运算符
       （条件)?成立返回：不成立返回
          int m=15;
          int n=10;
          int max=1;
          int min=0;
          for(int i=1;i<=n&&i<=m;i++){
              if(m%i==0&&n%i==0) {
                  max = i;
              }
          }
        for(int i=1;i<=n&&i<=m;i++){
            if((m*i)%n==0){
                min=m*i;
                break;
            }else if((n*i)%m==0){
                min=n*i;
                break;
            }
        }
        System.out.println("最大公约数："+max+"最小公倍数："+min);
           */
    }
}

