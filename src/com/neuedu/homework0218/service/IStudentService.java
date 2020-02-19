package com.neuedu.homework0218.service;

import com.neuedu.homework0218.model.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> queryAll();
    public Student query(int no);
    public int delte(int no);
    public int add(List<Student> list);
    public int upDate(Student student,int no);
}
