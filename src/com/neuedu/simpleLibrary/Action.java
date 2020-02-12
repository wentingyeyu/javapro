package com.neuedu.simpleLibrary;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Action {
    Scanner scanner = new Scanner(System.in);
    test test = new test();
    Dao dao = new Dao();
    /*
    添加书籍
     */
    public void inputDate(List<MyBook> books, File file){
        System.out.print("请输入要添加书籍的数量：");
        int n = scanner.nextInt();
        for(int i=0;i<n;i++){
            MyBook book = new MyBook();
            System.out.println("请输入第"+(books.size()+1)+"本书的信息");
            System.out.print("请输入书名：");
            String name = scanner.next();
            System.out.print("请输入书价：");
            Double price = scanner.nextDouble();
            System.out.print("请输入出版社：");
            String press = scanner.next();
            System.out.print("请输入作者：");
            String author = scanner.next();
            System.out.print("请输入书的ISBN：");
            String bookISBN = scanner.next();
            book.setName(name);
            book.setPrice(price);
            book.setPress(press);
            book.setAuthor(author);
            book.setBookISBN(bookISBN);
            books.add(book);
        }
        dao.save(file,books);
        test.menu(books);

    }
    /*
    显示全部书籍
     */
    public void print(List<MyBook> books){
        if(books.size()==0){
            System.out.println("书籍数量为零，请添加书籍！");
        }else{
            for(MyBook book:books){
                System.out.println("第"+(books.indexOf(book)+1)+"本书的全部信息");
                System.out.println(book);
            }
        }
        test.menu(books);
    }
    /*
    查找书籍
     */
    public void search(List<MyBook> books,String name) {
        if (books.size() == 0) {
            System.out.println("书籍数量为零，请添加书籍！");
        } else {
            for (MyBook book : books) {
                if (book.getName().equals(name)) {
                    System.out.println(book);
                    break;
                } else if (books.indexOf(book) == books.size() - 1) {
                    System.out.println("此书不存在！");
                }
            }
        }
        test.menu(books);
    }
    /*
    删除指定书籍
     */
    public void deleteName(List<MyBook> books,String name, File file) {
        if (books.size() == 0) {
            System.out.println("书籍数量为零，请添加书籍！");
        } else {
            for (MyBook book : books) {
                if (book.getName().equals(name)) {
                    books.remove(book);
                    System.out.println("删除成功！");
                    dao.save(file,books);
                    break;
                } else if (books.indexOf(book) == books.size() - 1) {
                    System.out.println("没有此书，删除失败！");
                }
            }
        }
        test.menu(books);
    }
}
