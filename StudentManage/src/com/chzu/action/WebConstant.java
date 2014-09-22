package com.chzu.action;

public interface WebConstant {
	// HttpSession中用TYPE记录何种用户登录
	String LOGIN_TYPE = "type";
	// HttpSession里用LOGIN_ADMIN 标记是管理员登录
	public static final String LOGIN_ADMIN = "0";
	// HttpSession里用LOGIN_TEACHER标记是老师登录
	public static final String LOGIN_TEACHER = "1";
	// HttpSession里用LOGIN_STUDENT标记是学生登录
	public static final String LOGIN_STUDENT = "2";
	// HttpSession里用USERNAME记录用户的姓名
	String USERNAME = "username";
}
