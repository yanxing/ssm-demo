package com.chzu.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生实体
 * @author yanxing on 2015/1/28.
 */
public class Student implements Serializable{

    private Integer id;
    private String number;//学号
    private String name;//姓名
    private String sex;//性别
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;//生日
    private Grade grade;//所属的年级

    public Student() {
    }

    public Student(Integer id, String number, String name, String sex, Date birthday, Grade grade) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday+
                '}';
    }
}
