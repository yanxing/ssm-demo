package com.chzu.action.android;

import com.chzu.action.AdminBaseAction;
import com.chzu.model.Student;

/**
 * android登录验证
 * 
 * @author Administrator
 *
 */
public class LoginAction extends AdminBaseAction {

	private static final long serialVersionUID = 1L;
	private String loginResult;// 返回登录标志成功标志
	// 接收android客户端发来的用户名和密码student.username,student.password
	// 这里，是字符串，没有封装成json格式的数据
	private Student student;

	public String getLoginResult() {
		return loginResult;
	}

	public void setLoginResult(String loginResult) {
		this.loginResult = loginResult;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String execute() throws Exception {
		student = adminService.validLogin(student);
		if (student != null) {
			setLoginResult("success");
		}
		return SUCCESS;
	}
}
