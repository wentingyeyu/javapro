package com.neuedu.homework0218.util;

import java.sql.*;

public class DaoUtils {
    String drive = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://192.168.199.199:3306/School?useUnicode=true&characterEncoding=utf8";
    String uname = "root";
    String pwd = "123123";
    Connection conn = null;
    PreparedStatement state = null;
    public DaoUtils(String sql){
        try {
            Class.forName(drive);
            conn = DriverManager.getConnection(url,uname,pwd);
            state = conn.prepareStatement(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement getState() {
        return state;
    }
    public void close(){
        try {
            if(state!=null)
                state.close();
            if(conn!=null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
