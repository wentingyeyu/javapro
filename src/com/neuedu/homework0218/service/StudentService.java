package com.neuedu.homework0218.service;

import com.neuedu.homework0218.dao.IStudentDao;
import com.neuedu.homework0218.dao.StudengDao;
import com.neuedu.homework0218.model.Student;

import java.util.List;

public class StudentService implements IStudentService {
    IStudentDao studentDao = new StudengDao();
    @Override
    public List<Student> queryAll() {
        return studentDao.selectAll();
    }
    @Override
    public Student query(int no) {
        return studentDao.selectOne(no);
    }

    @Override
    public int delte(int no) {
        return studentDao.delteOne(no);
    }

    @Override
    public int add(List<Student> list) {
        studentDao.daoAdd(list);
        return 0;
    }

    @Override
    public int upDate(Student student, int no) {
        int i = studentDao.upDate(student,no);
        if(i!=0)
            System.out.println("修改成功");
        else
            System.out.println("没有学号为:"+no+"的学生，修改失败");
        return i;
    }
}
