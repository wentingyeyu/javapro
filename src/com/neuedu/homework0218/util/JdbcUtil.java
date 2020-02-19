package com.neuedu.homework0218.util;

import com.neuedu.homework0218.model.StuSql;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtil {
    private static final String URl = "jdbc:mysql://192.168.199.199:3306/School?useUnicode = true&characterEncoding=utf8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123123";
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    static Connection getconnection(){
        Connection conn = null;
        try {
            conn= DriverManager.getConnection(URl,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static int executeUpdate(String sql,Object...params){
        int result = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getconnection();
            pstmt = conn.prepareStatement(sql);
            if(params!=null){
                for(int i=0;i<params.length;i++){
                    pstmt.setObject(i+1,params[i]);
                }
            }
            result=pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(conn,pstmt);
        }
        return result;
    }
    public static <T> List<T> executeQuery(String sql,Class<T> clz,Object...params){
        List<T> list = new ArrayList<T>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn=getconnection();
            pstmt=conn.prepareStatement(sql);
            if(params != null){
                for(int i=0;i<params.length;i++){
                    pstmt.setObject(i+1,params[i]);
                }
                rs = pstmt.executeQuery();
            }
            while (rs.next()){
                T t = clz.newInstance();
                Field []fields = clz.getDeclaredFields();
                for (Field f:fields){
                    f.setAccessible(true);
                    String stusql = f.getName();
                    if(f.isAnnotationPresent(StuSql.class)){
                        StuSql s=f.getAnnotation(StuSql.class);
                        stusql=s.value();
                    }
                    f.set(t,rs.getObject(stusql));
                }
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }finally {
            close(conn,pstmt,rs);
        }
        return list;
    }
    static void close(Connection conn,PreparedStatement pstmt){
        try {
            if (conn!=null)
                conn.close();
            if (pstmt!=null)
                pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    static void close(Connection conn, PreparedStatement pstmt, ResultSet rs){
        try {
            if(rs!=null)
                rs.close();
            close(conn,pstmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
