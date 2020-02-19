package com.neuedu.homework0218.wed;

import com.neuedu.homework0218.model.Student;
import com.neuedu.homework0218.service.IStudentService;
import com.neuedu.homework0218.service.StudentService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentWeb {
    IStudentService studentService = new StudentService();
    public void menu(){
        System.out.println("请输入对应数字！");
        System.out.println("1——所有学生");
        System.out.println("2——添加学生");
        System.out.println("3——查询学生");
        System.out.println("4——删除学生");
        System.out.println("5——修改学生");
        System.out.println("0——退出系统");
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        if(n<0||n>5){
            System.out.println("输入错误请重新输入");
            return;
        }
        switch (n)
            {
                case 0:
                    System.exit(0);
                case 1:
                    queryAll();
                    break;
                case 2:
                    add(scanner);
                    break;
                case 3:
                    query(scanner);
                    break;
                case 4:
                    delete(scanner);
                    break;
                case 5:
                    update(scanner);
            }
    }
    public void queryAll(){
        List<Student> list = studentService.queryAll();
        for(Student student:list){
            System.out.println(student);
        }
    }
    public void add(Scanner scanner){
        List<Student> list = new ArrayList<Student>();
        System.out.println("请输入要添加学生的数量");
        int n = scanner.nextInt();
        for(int i=0;i<n;i++){
            Student student = new Student();
            System.out.println("第"+(i+1)+"名学生！！");
            System.out.print("请输入学号：");
            student.setNo(scanner.nextInt());
            System.out.print("请输入姓名：");
            student.setName(scanner.next());
            System.out.print("请输入性别：");
            student.setSex(scanner.next());
            System.out.print("请输入年龄：");
            student.setAge(scanner.nextInt());
            System.out.print("请输入系别：");
            student.setDept(scanner.next());
            list.add(student);
        }
        studentService.add(list);
    }
    public void query(Scanner scanner){
        System.out.print("请输入要查询学生的学号：");
        int no = scanner.nextInt();
        List<Student> list = studentService.query(no);
        for (Student student:list){
            System.out.println(student);
        }
    }
    public void delete(Scanner scanner){
        System.out.print("请输入要删除的学生的学号：");
        int no = scanner.nextInt();
        if(studentService.delte(no)==0){
            System.out.println("删除失败，没有该学生！");
        }else{
            System.out.println("删除成功！");
        }
    }
    public void update(Scanner scanner){
        System.out.print("请输入要修改的学生的学号：");
        int no = scanner.nextInt();
        Student student = new Student();
        System.out.print("请输入修改后的学号：");
        student.setNo(scanner.nextInt());
        System.out.print("请输入修改后的姓名：");
        student.setName(scanner.next());
        System.out.print("请输入修改后的性别：");
        student.setSex(scanner.next());
        System.out.print("请输入修改后的年龄：");
        student.setAge(scanner.nextInt());
        System.out.print("请输入修改后的系别：");
        student.setDept(scanner.next());
        studentService.upDate(student,no);
    }
}
