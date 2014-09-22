package com.chzu.action.android;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

import com.chzu.action.AdminBaseAction;
import com.chzu.model.Student;

/**
 * 
 * 更新学生信息，接收android客户端传来的json格式的数据 只修改用户名，性别，出生日期，手机号
 */
public class UpdateStudentAction extends AdminBaseAction {

	private static final long serialVersionUID = 1L;
	// 和客户端对应相应的属性，struts会自动接收赋值
	private String number;// 学号
	private String username;
	private String sex;
	private Date birthday;
	private String phone;
	private String updateResult;

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	// 对接收到的时间格式化
	@JSON(format = "yyyy-MM-dd")
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

	public String getUpdateResult() {
		return updateResult;
	}

	public void setUpdateResult(String updateResult) {
		this.updateResult = updateResult;
	}

	/**
	 * 接收android客户端发来的json数据 姓名，性别，出生日期，手机号
	 */
	public String execute() throws Exception {
		Student student = adminService.findByName(getNumber());
		if (student != null) {
			student.setUsername(getUsername());
			student.setSex(getSex());
			student.setBirthday(getBirthday());
			student.setPhone(getPhone());
			adminService.updateStudent(student);
			setUpdateResult("success");// 返回给android客户端
		}
		return SUCCESS;
	}

}
