package com.neuedu.homework0220;

public class Paixu {
    public static void main(String[] args) {
        int a[] = {45,23234,234,456,678,23,42,12,2982};
        int temp = 0;
        for (int i=0;i<a.length;i++){
            for(int j=i;j<a.length-1-i;j++){
                    if(a[i]>=a[j+1]){
                        temp = a[i];
                        a[i]=a[j+1];
                        a[j+1] =temp;
                    }
            }
        }
       for(int i=0;i<a.length;i++){
           System.out.println(a[i]);
       }
    }
}
