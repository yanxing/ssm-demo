package com.chzu.action;

import org.apache.struts2.ServletActionContext;

import com.chzu.model.Student;

public class SearchStudentAction extends AdminBaseAction {

	private static final long serialVersionUID = 1L;
	private String tip;// 搜索失败提示
	private Student user;// 接收JSP页面传过来的project.number值(struts封装)

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public Student getUser() {
		return user;
	}

	public void setUser(Student user) {
		this.user = user;
	}

	public String execute() throws Exception {
		String number = ServletActionContext.getRequest()
				.getParameter("number");
		// 对中文字符进行串码
		String title = new String(number.getBytes("iso8859-1"), "utf-8");
		user = adminService.findByName(title);
		if (user == null) {
			setTip("您搜索的学生不存在，请核对再试！");
			return INPUT;
		}
		return SUCCESS;
	}

}
