package com.chzu.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.chzu.model.ClassGrade;
import com.chzu.model.Student;

/**
 * 
 * 更新学生信息
 */
public class UpdateStudentAction extends AdminBaseAction {

	private static final long serialVersionUID = 1L;
	private Student student;// 封装update.jsp页面提交的数据

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
		String birthday = ServletActionContext.getRequest().getParameter(
				"birthday");
		String number = ServletActionContext.getRequest()
				.getParameter("number");
		// 对中文字符进行串码
		String title = new String(number.getBytes("iso8859-1"), "utf-8");
		System.out.println(title + "\\" + student.getNumber() + "\\");
		if ((!title.trim().equals(student.getNumber().trim()))
				&& adminService.exit(student.getNumber())) {
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
		Student student1 = adminService.findStudent(student.getId());
		if (!birthday.equals("")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = birthday;
			Date date = sdf.parse(strDate);
			student.setBirthday(date);
		}
		student.setNumber(student.getNumber().trim());// 去掉空格
		student.setPassword(student1.getPassword());
		student.setClassGrade(student1.getClassGrade());
		student.setClassGrade(classGrade);
		adminService.updateStudent(student);
		return SUCCESS;
	}

}
