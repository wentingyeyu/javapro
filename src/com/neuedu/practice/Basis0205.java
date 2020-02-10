package com.neuedu.practice;

public class Basis0205 {
    public static void main(String[] args) {
        /*
        0205 上午练习1 冒泡排序

        int array[] = {45,67,23,78,28,39,19,100,12,76,92};
        int temp = 0;
        for (int i=1;i<array.length;i++){
            int flag=0;
            for (int j=0;j<array.length-1;j++){
                if(array[j]>array[j+1]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    flag++;
                }
            }
            if(flag==0){
                break;
            }
        }
        for(int a:array){
            System.out.println(a);
        }
         */
        /*
        0205 上午 练习2 选择排序

        int array[] = {45,67,23,78,28,39,19,100,12,76,92};
        int temp = 0;
        for(int i=0;i<array.length-1;i++){
            for(int j=i;j<array.length-1;j++){
                if(array[i]>array[j+1]){
                    temp=array[i];
                    array[i]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        for(int a:array){
            System.out.println(a);
        }*/
        /*
        0205 上午 练习3 二分搜索 （循环，递归两版）

        int a[] =new int [100000];
        int b=82222;
        for(int i=0;i<a.length-1;i++){
            a[i]=i+1;
        }
        //循环版调用
        int s = find(a,b);
        System.out.println(s);
        //递归版调用
        try {
            find(a,b,0,a.length-1,0);
        }catch (Exception e){

        }
         */
        /*
        0205 下午 练习1 继承 重写（override）
        用到的类 Dog Animal Person

        Animal animal = new Animal();
        Person person = new Person();
        Dog dog = new Dog();
        person.setName("王三");
        dog.setName("小D");
        System.out.println(person.getName());
        System.out.println(dog.getName());
        animal.sound();
        person.sound();
        dog.sound();
         */
        /*
        0205下午 练习2 创建动态数组
        用到的类 MyArray

         */MyArray myArray = new MyArray();
        for (int i = 1;i<=100;i++){
            myArray.add(i);
        }
        System.out.println(myArray.get(99));
    }
    /*[]
    二分搜索 循环版
    public static int find(int []a,int value){
        int max=a.length-1;
        int min=0;
        int count=0;
        while (min<=max){
            count++;
            int mid=(min+max)/2;
            if(a[mid]==value){
                System.out.println("查找了"+count+"次");
                return mid;
            }else if(a[mid]>value){
                max=mid-1;
            }else{
                min=mid+1;
            }
        }
        return -1;
    }
     */
    /*
    二分搜索 递归版
    public static void find(int []a,int value,int min,int max,int count){
        int mid = (min+max)/2;
        count++;
        if(min<=max) {
            if (a[mid] == value) {
                System.out.println("查找了" + count + "次");
                System.out.println("索引为" + mid);
            } else if (a[mid] > value) {
                find(a, value, min, mid - 1, count);
            } else {
                find(a, value, mid + 1, max, count);
            }
        }
        else{
            System.out.println("未找到");
        }
    }
     */
}
