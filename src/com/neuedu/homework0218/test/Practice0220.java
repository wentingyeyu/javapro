package com.neuedu.homework0218.test;

import com.neuedu.homework0218.model.Student;
import com.neuedu.homework0218.util.JdbcUtil;
import com.neuedu.homework0218.util.RowMap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.neuedu.homework0218.util.JdbcUtil.*;

public class Practice0220 {
    public static void main(String[] args) {
        /*
        匿名内部类封装 查询 的测试
        List<Student> list = new ArrayList<Student>();
        list=JdbcUtil.excuteQuery("select Sno,Sname,Ssex,Sage,Sdept from Student", new RowMap<Student>() {
            @Override
            public Student rowMaping(ResultSet rs) {
                Student student = new Student();
                try {
                    student.setNo(rs.getInt("Sno"));
                    student.setName(rs.getString("Sname"));
                    student.setSex(rs.getString("Ssex"));
                    student.setAge(rs.getInt("Sage"));
                    student.setDept(rs.getString("Sdept"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return student;
            }
        });
        for(Student s:list){
            System.out.println(s);
        }*/
        /*Mysql 事务  引入
   Connection conn = JdbcUtil.getconnection();
    PreparedStatement pstmt = null;
    PreparedStatement pstmt2 = null;
        try {
            conn.setAutoCommit(false);
            pstmt=conn.prepareStatement("INSERT INTO Student (Sno,Sname,Ssex,Sage,Sdept) VALUES (?,?,?,?,?)");
            pstmt.setInt(1,60);
            pstmt.setString(2,"猫有时");
            pstmt.setString(3,"男");
            pstmt.setInt(4,60);
            pstmt.setString(5,"猫有时");
            pstmt2=conn.prepareStatement("INSERT INTO Student (Sno,Sname,Ssex,Sage,Sdept) VALUES (?,?,?,?,?)");
            pstmt2.setInt(1,70);
            pstmt2.setString(2,"狗狗哦");
            pstmt2.setString(3,"女");
            pstmt2.setInt(4,60);
            pstmt2.setString(5,"猫有时");
            int i = pstmt.executeUpdate();
            System.out.println(i);

            int k=1/0;
            int j = pstmt2.executeUpdate();
            System.out.println(j);
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
                try {
                    if(pstmt2!=null)
                        pstmt2.close();
                    if(pstmt!=null)
                        pstmt.close();
                    if (conn!=null)
                        conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }*/
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()->{
            set();
        });
        service.execute(()->{
            read();
        });
    }
    public static void set(){
        Connection conn = JdbcUtil.getconnection();
        PreparedStatement pstmt = null;
        try {
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(4);
            pstmt=conn.prepareStatement("INSERT INTO Student (Sno,Sname,Ssex,Sage,Sdept) VALUES (?,?,?,?,?)");
            pstmt.setInt(1,60);
            pstmt.setString(2,"猫有时");
            pstmt.setString(3,"男");
            pstmt.setInt(4,60);
            pstmt.setString(5,"猫有时");
            Thread.sleep(1000);
            int i = pstmt.executeUpdate();
            System.out.println(i);
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if(pstmt!=null)
                    pstmt.close();
                if (conn!=null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void read(){
        Connection conn = JdbcUtil.getconnection();
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        ResultSet rs = null;
        try {
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(8);
            pstmt=conn.prepareStatement("select Sno,Sname,Ssex,Sage,Sdept from Student where  Sno = 60");
            rs = pstmt.executeQuery();
            if(rs.next()){
                System.out.println("不可以写");
            }else {
                System.out.println("keyikeyi");
                Thread.sleep(3000);
                pstmt2=conn.prepareStatement("INSERT INTO Student (Sno,Sname,Ssex,Sage,Sdept) VALUES (?,?,?,?,?)");
                pstmt2.setInt(1,60);
                pstmt2.setString(2,"猫有时");
                pstmt2.setString(3,"男");
                pstmt2.setInt(4,60);
                pstmt2.setString(5,"猫有时");
                int i = pstmt2.executeUpdate();
                System.out.println("asdasd");
            }
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs!=null)
                    rs.close();
                if(pstmt!=null)
                    pstmt.close();
                if (conn!=null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
