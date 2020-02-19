package com.neuedu.homework0218.util;

import com.neuedu.homework0218.model.StuSql;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtilAll {
    private static Connection conn = null;
    PreparedStatement pstmt = null;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public JdbcUtilAll(String url,String uname,String pwd){
        try {
            conn = DriverManager.getConnection(url,uname,pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int executeUpdate(String sql,Object...params){
        int result =0;
        try {
            pstmt = conn.prepareStatement(sql);
            if (params!=null){
                for(int i=0;i<params.length;i++){
                   pstmt.setObject(i+1,params[i]);
                }
            }
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return result;
    }
    public <T>List<T> executeQuery(String sql,Class<T> clz,Object...params){
        ResultSet rs = null;
        List<T> list = new ArrayList<T>();
        try {
            pstmt = conn.prepareStatement(sql);
            if (params!=null){
                for (int i=0;i<params.length;i++){
                    pstmt.setObject(i+1,params[i]);
                }
                rs = pstmt.executeQuery();
            }
            while (rs.next()){
                T t = clz.newInstance();
                Field []field = clz.getDeclaredFields();
                for (Field f:field){
                    f.setAccessible(true);
                    String value = f.getName();
                    if(f.isAnnotationPresent(StuSql.class)){
                        StuSql s = f.getAnnotation(StuSql.class);
                        value=s.value();
                    }
                    f.set(t,rs.getObject(value));
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
            close(rs);
        }
        return list;
    }
    private void close(){
        try {
            if (pstmt!=null)
                pstmt.close();
            if (conn!=null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void close(ResultSet rs){
        try {
            if (rs!=null)
                rs.close();
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
