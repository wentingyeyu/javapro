package com.neuedu.homework0218.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
    public static void main(String[] args) {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://192.168.199.199:3306/School?useUnicode=true&characterEncoding=utf8";
        String user = "root";
        String password = "123123";
        Connection conn = null;
        Statement sta = null;
        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(url,user,password);
            System.out.println("连接成功");
            sta = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
                try {
                    if (sta!=null)
                        sta.close();
                    if(conn!=null)
                        conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

        }
    }
}
