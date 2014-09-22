package com.chzu.model;

import java.io.Serializable;
import java.util.Date;


public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;// 标识属性
	private String number;//学号
	private String username;// 用户名
	private String password;// 密码
	private String sex;//性别
	private Date birthday;//出生日期
	private String phone;//联系电话
	private ClassGrade classGrade;//学生所属班级
	
	public Student() {
	}

	public Student(Integer id, String number, String username, String password,
			String sex, Date birthday, String phone, ClassGrade classGrade) {
		this.id = id;
		this.number = number;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
		this.phone = phone;
		this.classGrade = classGrade;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}


	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ClassGrade getClassGrade() {
		return classGrade;
	}

	public void setClassGrade(ClassGrade classGrade) {
		this.classGrade = classGrade;
	}
	
	
	
	
	
}