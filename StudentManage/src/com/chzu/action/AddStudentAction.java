package com.chzu.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.chzu.model.ClassGrade;
import com.chzu.model.Student;

/**
 * 添加学生
 */
public class AddStudentAction extends AdminBaseAction {

	private static final long serialVersionUID = 1L;
	private Student student;// 封装add.jsp页面提交的数据

	private String tip;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String execute() throws Exception {
		String name = ServletActionContext.getRequest().getParameter("name");
		ClassGrade classGrade = adminService.findClassGradeByName(name);
		student.setClassGrade(classGrade);
		student.setPassword("000000");

		String birthday = ServletActionContext.getRequest().getParameter(
				"birthday");
		if (adminService.exit(student.getNumber().trim())) {
			setTip("该学号的学生已经存在！");
			return "input";
		}
		if (birthday.contains("/")) {
			StringBuffer sb = new StringBuffer();
			String s[] = birthday.split("/");
			sb.append(s[2] + "-");
			sb.append(s[0] + "-");
			sb.append(s[1]);
			birthday = sb.toString();
		}
		if (!birthday.equals("")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = birthday;
			Date date = sdf.parse(strDate);
			student.setBirthday(date);
		}
		student.setNumber(student.getNumber().trim());// 去掉空格
		adminService.addStudent(student);
		return SUCCESS;
	}
}
