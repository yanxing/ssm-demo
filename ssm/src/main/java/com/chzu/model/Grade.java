package com.chzu.model;

import java.io.Serializable;
import java.util.Set;

/**
 * 年级实体
 * @author yanxing on 2015/1/28.
 */
public class Grade implements Serializable{

    private Integer id;
    private String name;//班级名称
    private Set<Student> students;//班级包含的学生

    public Grade() {
    }

    public Grade(Integer id, String name, Set<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
