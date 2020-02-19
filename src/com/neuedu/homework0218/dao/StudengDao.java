package com.neuedu.homework0218.dao;

import com.neuedu.homework0218.model.Student;
import com.neuedu.homework0218.util.DaoUtils;
import com.neuedu.homework0218.util.JdbcUtil;
import com.neuedu.homework0218.util.JdbcUtilAll;

import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudengDao implements IStudentDao {
    private static final String URL = "jdbc:mysql://192.168.199.199:3306/School?useUnicode=true&characterEncoding=utf8";
    private static final String UNAME = "root";
    private static final String PWD = "123123";
    @Override
    public List<Student> selectAll() {
        JdbcUtilAll jdbcUtilAll = new JdbcUtilAll(URL,UNAME,PWD);
        return jdbcUtilAll.executeQuery("select Sno,Sname,Ssex,Sage,Sdept from Student",Student.class);
    }

    @Override
    public int daoAdd(List<Student> list) {
        JdbcUtilAll jdbcUtilAll = new JdbcUtilAll(URL,UNAME,PWD);
        for(Student student:list){
            jdbcUtilAll.executeUpdate("insert into Student VALUES(?,?,?,?,?)", student.getNo(), student.getName(), student.getSex(), student.getAge(), student.getDept());
        }
        return 0;
    }

    @Override
    public List<Student> selectOne(int no) {
        JdbcUtilAll jdbcUtilAll = new JdbcUtilAll(URL,UNAME,PWD);
        return jdbcUtilAll.executeQuery("SELECT Sno,Sname,Ssex,Sage,Sdept from Student where Sno=?",Student.class,no);
    }

    @Override
    public int delteOne(int no) {
        JdbcUtilAll jdbcUtilAll = new JdbcUtilAll(URL,UNAME,PWD);
        return jdbcUtilAll.executeUpdate("DELETE from Student where Sno = ?",no);
    }

    @Override
    public int upDate(Student student, int no) {
        JdbcUtilAll jdbcUtilAll = new JdbcUtilAll(URL,UNAME,PWD);
        return jdbcUtilAll.executeUpdate("UPDATE Student set sno = ?,Sname =?,Ssex = ?,Sage = ?,Sdept=? WHERE Sno = ?", student.getNo(), student.getName(), student.getSex(), student.getAge(), student.getDept(),no);
    }
   /*
   JdbcUtils ---数据库等信息不变
   @Override
public List<Student> selectAll() {
    return JdbcUtil.executeQuery("select Sno,Sname,Ssex,Sage,Sdept from Student",Student.class);
}

    @Override
    public int daoAdd(List<Student> list) {
        for(Student student:list) {
            JdbcUtil.executeUpdate("insert into Student VALUES(?,?,?,?,?)", student.getNo(), student.getName(), student.getSex(), student.getAge(), student.getDept());
        }
        return 0;
    }

    @Override
    public List<Student> selectOne(int no) {
        return JdbcUtil.executeQuery("SELECT * from Student where Sno=?",Student.class,no);
    }

    @Override
    public int delteOne(int no) {
        return JdbcUtil.executeUpdate("DELETE from Student where Sno = ?",no);
    }

    @Override
    public int upDate(Student student,int no) {
        return JdbcUtil.executeUpdate("UPDATE Student set sno = ?,Sname =?,Ssex = ?,Sage = ?,Sdept=? WHERE Sno = ?", student.getNo(), student.getName(), student.getSex(), student.getAge(), student.getDept(),no);
    }*/

}
