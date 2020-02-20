package com.neuedu.homework0218.test;

import com.neuedu.homework0218.model.Student;
import com.neuedu.homework0218.util.JdbcUtil;
import com.neuedu.homework0218.util.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.neuedu.homework0218.util.JdbcUtil.*;

public class Practice0220 {
    public static void main(String[] args) {
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
        }
    }
}
