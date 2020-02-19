package com.neuedu.homework0218.model;

public class Student {
    @StuSql("Sno")
    private Integer no;
    @StuSql("Sname")
    private String name;
    @StuSql("Ssex")
    private String sex;
    @StuSql("Sage")
    private Integer age;
    @StuSql("Sdept")
    private String dept;

    public Student() {
    }

    public Integer getNo() {
        return no;
    }
    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", dept='" + dept + '\'' +
                '}';
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
