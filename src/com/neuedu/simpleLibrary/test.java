package com.neuedu.simpleLibrary;

import java.util.ArrayList;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        ArrayList<MyBook> books = new ArrayList<MyBook>(200);
        while(menu(books)==0){
            menu(books);
        }
    }
    public static int menu(ArrayList<MyBook> books){
        System.out.println("请输入1~5来进行操作");
        System.out.println("1.添加书籍");
        System.out.println("2.查找书籍");
        System.out.println("3.删除书籍");
        System.out.println("4.所有书籍");
        System.out.println("5.退出系统");
        Action action = new Action();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        switch (n){
            case 1:
                System.out.print("请输入要添加书籍的数量：");
                int i = scanner.nextInt();
                action.inputDate(books,i);
                System.out.println("输入0，退出系统！输入其他值，返回主界面");
                if(scanner.nextInt()==0){
                    System.exit(0);
                }
                break;
            case 2:
                System.out.print("请输入要查询书籍的名称：");
                String sName = scanner.next();
                action.search(books,sName);
                System.out.println("输入0，退出系统！输入其他值，返回主界面");
                if(scanner.nextInt()==0){
                    System.exit(0);
                }
                break;
            case 3:
                System.out.print("请输入要删除书籍的名称：");
                String dName = scanner.next();
                action.deleteName(books,dName);
                System.out.println("输入0，退出系统！输入其他值，返回主界面");
                if(scanner.nextInt()==0){
                    System.exit(0);
                }
                break;
            case 4:
                action.print(books);
                System.out.println("输入0，退出系统！输入其他值，返回主界面");
                if(scanner.nextInt()==0){
                    System.exit(0);
                }
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("输入0，退出系统！输入其他值，返回主界面");
                if(scanner.nextInt()==0){
                    System.exit(0);
                }
        }

        return 0;
    }
}
