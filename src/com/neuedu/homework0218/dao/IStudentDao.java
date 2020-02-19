package com.neuedu.homework0218.dao;

import com.neuedu.homework0218.model.Student;

import java.util.List;

public interface IStudentDao {
    public List<Student> selectAll();
    public int daoAdd(List<Student> list);
    public List<Student> selectOne(int no);
    public int delteOne(int no);
    public int upDate(Student student,int no);
}
