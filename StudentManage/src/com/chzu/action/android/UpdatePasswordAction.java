package com.chzu.action.android;

import com.chzu.action.AdminBaseAction;
import com.chzu.model.Student;

/**
 * 
 * 更新学生密码，接收android客户端传来的学号和密码字符串
 */
public class UpdatePasswordAction extends AdminBaseAction {

	private static final long serialVersionUID = 1L;
	// 和客户端对应相应的属性，struts会自动接收赋值
	private Student student;// 获取客户端提交的student.number，student.password
	private String updateResult;

	public String getUpdateResult() {
		return updateResult;
	}

	public void setUpdateResult(String updateResult) {
		this.updateResult = updateResult;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String execute() throws Exception {
		Student student1 = adminService.findByName(student.getNumber());
		if (student1 != null) {
			student1.setPassword(student.getPassword());
			adminService.updateStudent(student1);
			setUpdateResult("修改成功!");// 返回给android客户端
		}
		return SUCCESS;
	}

}
