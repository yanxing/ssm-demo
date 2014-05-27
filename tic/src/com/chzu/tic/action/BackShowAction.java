package com.chzu.tic.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

/**
 * 此action，作为登录界面验证码jsp的显示，管理员和老师
 * 登陆成功后界面的显示
 * @author Administrator
 *
 */
public class BackShowAction extends TeacherBaseAction{

	private static final long serialVersionUID = 1L;
	private List<String> list=new ArrayList<String>();
	
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
     * 加载框架布局底部的buttom.jsp页面
     */
	public String buttom() throws Exception {
		return "buttom";
	}
    
	/**
	 * 加载登录界面的验证码verifycode.jsp页面
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
	 *跳转到上传文件界面 
	 */
	public String upload() throws Exception {
		return "upload";
	}
	
	/**
	 * 加载搜索比赛项目search.jsp页面
	 */
	public String search() throws Exception{
		return "search";
	}
	
	/**
	 * 加载修改比赛项目update.jsp页面,
	 * 并回显要修改项目信息到update.jsp页面
	 */
	public String update() throws Exception{
		String id=ServletActionContext.getRequest().getParameter("project.id");
		//获取页面传过来的值
		String nameString=ServletActionContext.getRequest().getParameter("project.name");
		String levelString=ServletActionContext.getRequest().getParameter("project.level");
		String periodString=ServletActionContext.getRequest().getParameter("project.period");
		//对中文字符进行串码
		String  name=new  String(nameString.getBytes("iso8859-1"),"utf-8");
		String level=new String(levelString.getBytes("iso8859-1"),"utf-8");
		String period=new String(periodString.getBytes("iso8859-1"),"utf-8");
		list.add(id);
		list.add(name);
		list.add(level);
		list.add(period);
		return "update";
	}
	
	/**
	 * 加载添加比赛项目add.jsp页面
	 */
	public String add()throws Exception{
		return "add";
	}
	
	/**
	 * 添加用户跳到addUser.jsp页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addUser() throws Exception {
		return "addUser";
	}
}
