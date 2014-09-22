package com.chzu.action.android;

import java.util.ArrayList;
import java.util.List;

import com.chzu.action.AdminBaseAction;
import com.chzu.model.Student;

/**
 * 
 * 获取指定学生的同班同学列表
 * 
 */
public class StudentListAction extends AdminBaseAction {

	private static final long serialVersionUID = 1L;
	private Student student;// 接收android客户端传来的student.number字符串
	private List<Student> students = new ArrayList<Student>();

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String execute() throws Exception {
		Student student1 = adminService.findByName(student.getNumber());
		Integer id = student1.getClassGrade().getId();// 获取班级id
		students = adminService.getStudentList(id);
		return SUCCESS;
	}

}
