package com.chzu.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ClassGrade implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;// 标识属性
	private String name;// 班级名称
	private String counselor;// 辅导员
	private Professional pro;// 班级所属专业
	private Set<Student> students = new HashSet<Student>();

	public ClassGrade() {
	}

	public ClassGrade(Integer id, String name, String counselor,
			Professional pro, Set<Student> course) {
		this.id = id;
		this.name = name;
		this.counselor = counselor;
		this.pro = pro;
		this.students = course;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCounselor() {
		return counselor;
	}

	public void setCounselor(String counselor) {
		this.counselor = counselor;
	}

	public Professional getPro() {
		return pro;
	}

	public void setPro(Professional pro) {
		this.pro = pro;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	

}