package com.chzu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = 1L;
	// 定义一个HttpServletRequest对象
	private HttpServletRequest request;

	// 实现ServletRequestAware接口必须重写的方法
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String execute() throws Exception {
		// 获取HttpSession
		HttpSession session = request.getSession();
		// 使Session失效
		session.invalidate();
		return SUCCESS;
	}
}
