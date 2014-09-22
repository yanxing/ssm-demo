package com.chzu.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.chzu.model.ClassGrade;
import com.chzu.model.Student;

/**
 * 此action，作为登录界面验证码jsp的显示，管理员 登陆成功后界面的显示
 * 
 * @author Administrator
 *
 */
public class BackShowAction extends AdminBaseAction {

	private static final long serialVersionUID = 1L;
	private List<String> list = new ArrayList<String>();
	private List<ClassGrade> list1 = new ArrayList<ClassGrade>();

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	/**
	 * 加载框架布局top.jsp页面
	 */
	public String top() throws Exception {
		return "top";
	}

	/**
	 * 加载框架布局左边的left.jsp页面
	 */
	public String left() throws Exception {
		return "left";
	}

	/**
	 */
	public String verifycode() throws Exception {
		return "verifycode";
	}

	/**
	 * 加载框架布局右边的main.jsp页面
	 */
	public String main() throws Exception {
		return "main";
	}

	/**
	 * 加载搜索学生search.jsp页面
	 */
	public String search() throws Exception {
		return "search";
	}

	/**
	 * 加载修改学生update.jsp页面, 并回显修改学生到update.jsp页面
	 */
	public String update() throws Exception {
		String id = ServletActionContext.getRequest().getParameter("user.id");
		list.add(id);
		Student user = new Student();
		user = adminService.findStudent(Integer.valueOf(id));
		list.add(user.getNumber());
		list.add(user.getUsername());
		list.add(user.getSex());
		if (user.getBirthday() != null) {
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
			String birthday = fm.format(user.getBirthday());
			list.add(birthday);
		} else {
			list.add("");
		}
		list.add(user.getPhone());
		list.add(user.getClassGrade().getName());// 班级
		list.add(user.getClassGrade().getPro().getName());// 专业
		list.add(user.getClassGrade().getPro().getDep().getName());// 院系
		list1 = adminService.findAllClassGrade();
		return "update";
	}

	/**
	 * 加载添加学生add.jsp页面
	 */
	public String add() throws Exception {
		list1 = adminService.findAllClassGrade();
		for (ClassGrade string : list1) {
			System.out.println(string.getName());
		}
		return "add";
	}

	public List<ClassGrade> getList1() {
		return list1;
	}

	public void setList1(List<ClassGrade> list1) {
		this.list1 = list1;
	}

}
