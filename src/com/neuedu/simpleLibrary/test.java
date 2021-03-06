package com.neuedu.simpleLibrary;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        List<MyBook> books = new ArrayList<MyBook>();
        menu(books);
    }
    public static void menu(List<MyBook> books){
        File file = new File("D:/books");
        Dao dao = new Dao();
        Action action = new Action();
        if(dao.isSave(file)){
            action.inputDate(books,file);
        }else {
            books = dao.read(file);
        }
        System.out.println("请输入1~5来进行操作");
        System.out.println("1.添加书籍");
        System.out.println("2.查找书籍");
        System.out.println("3.删除书籍");
        System.out.println("4.所有书籍");
        System.out.println("5.退出系统");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        switch (n){
            case 1:

                action.inputDate(books,file);
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
                action.deleteName(books,dName,file);
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
    }
}
