package com.neuedu.homework0218.dao;

import com.neuedu.homework0218.model.Student;
import com.neuedu.homework0218.util.DaoUtils;

import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudengDao implements IStudentDao {
    @Override
    public List<Student> selectAll() {
        List<Student> list = new ArrayList<Student>();
        String sql = "select * from Student";
        DaoUtils utils = new DaoUtils(sql);
        PreparedStatement state = utils.getState();
        ResultSet rs = null;
        try {
            rs = state.executeQuery();
            while (rs.next()){
                Student student = new Student();
                student.setNo(rs.getInt("Sno"));
                student.setName(rs.getString("Sname"));
                student.setSex(rs.getString("Ssex"));
                student.setAge(rs.getInt("Sage"));
                student.setDept(rs.getString("Sdept"));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null)
                    rs.close();
                utils.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public int daoAdd(List<Student> list) {
        String sql = "insert into Student VALUES(?,?,?,?,?)";
        DaoUtils utils = new DaoUtils(sql);
        PreparedStatement state = utils.getState();
            try {
                for(Student student:list){
                    state.setInt(1,student.getNo());
                    state.setString(2,student.getName());
                    state.setString(3,student.getSex());
                    state.setInt(4,student.getAge());
                    state.setString(5,student.getDept());
                    state.executeUpdate();
                 }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                utils.close();
            }
        return 0;
    }

    @Override
    public Student selectOne(int no) {
        Student student = new Student();
        String sql = "SELECT * from Student where Sno=?";
        DaoUtils utils = new DaoUtils(sql);
        PreparedStatement state = utils.getState();
        ResultSet rs = null;
        try {
            state.setInt(1,no);
            rs = state.executeQuery();
            if(rs.next()){
                student.setNo(rs.getInt("Sno"));
                student.setName(rs.getString("Sname"));
                student.setSex(rs.getString("Ssex"));
                student.setAge(rs.getInt("Sage"));
                student.setDept(rs.getString("Sdept"));
            }else{
                System.out.println("没有这名学生！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null)
                    rs.close();
                utils.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }

    @Override
    public int delteOne(int no) {
        String sql = "DELETE from Student where Sno = ?";
        DaoUtils utils = new DaoUtils(sql);
        PreparedStatement state = utils.getState();
        Integer i = 0;
        try {
            state.setInt(1,no);
            i=state.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            utils.close();
        }
        return i;
    }

    @Override
    public int upDate(Student student,int no) {
        String sql = "UPDATE Student set sno = ?,Sname =?,Ssex = ?,Sage = ?,Sdept=? WHERE Sno = ?";
        DaoUtils utils = new DaoUtils(sql);
        PreparedStatement state = utils.getState();
        Integer i = 0;
        try {
            state.setInt(1,student.getNo());
            state.setString(2,student.getName());
            state.setString(3,student.getSex());
            state.setInt(4,student.getAge());
            state.setString(5,student.getDept());
            state.setInt(6,no);
            i=state.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            utils.close();
        }
        return i;
    }
}
