package com.neuedu.simpleLibrary;

import java.io.Serializable;

public class MyBook implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;    //书名
    private Double price;   //价格
    private String press;   //出版社
    private String author;  //作者
    private String bookISBN;//书的ISBN

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    @Override
    public String toString() {
        return  "书名：'" + name + '\'' +
                ", 价格：" + price +
                ", 出版社：'" + press + '\'' +
                ", 作者：'" + author + '\'' +
                ", bookISBN：'" + bookISBN + '\'';
    }
}
