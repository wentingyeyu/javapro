package com.neuedu.practice;

public class MyArray {
    private int [] array;
    private int size;
    public MyArray(){
        size=0;
        array = new int [10];
    }
    public void add(int i){
        int cont=0;
        if(size>=array.length){
            int[] newarray = new int [size+size/2];
            for (int j=0;j<array.length;j++){
                newarray[j]=array[j];
            }
            array=newarray;
        }
        array[size++] = i;
    }
    public int getSize(){
        return size;
    }
    public int get(int j){
        if (j<0||j>=size){
            System.out.println("索引错误");
            return-1;
        }else {
            return array[j];
        }
    }
}
