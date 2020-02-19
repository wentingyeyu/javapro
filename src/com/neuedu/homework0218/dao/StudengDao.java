package com.neuedu.homework0218.dao;

import com.neuedu.homework0218.model.Student;
import com.neuedu.homework0218.util.DaoUtils;
import com.neuedu.homework0218.util.JdbcUtil;

import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudengDao implements IStudentDao {
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
    }
}
