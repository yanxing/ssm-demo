package com.chzu.tic.action;

import com.chzu.tic.model.User;
import com.opensymphony.xwork2.ActionContext;
import static com.chzu.tic.service.AdminService.*;

public class LoginAction extends AdminBaseAction {

	private static final long serialVersionUID = 1L;
	public static String ADMIN_RESULT = "admin_result";// 作为管理员登录成功的返回结果名
	public static String TEACHER_RESULT = "teacher_result";// 作为老师登录成功的返回结果名
	public static String STUDENT_RESULT = "student_result";// 作为学生登录成功的返回结果名
	private String verifycode;// 验证码
	private User user;
	// 处理登录后的提示信息
	private String tip;

	public String getVerifycode() {
		return verifycode;
	}

	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getTip() {
		return this.tip;
	}

	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		// 获取HttpSession中的rand属性
		String ver2 = (String) ctx.getSession().get("rand");
		if (verifycode.equalsIgnoreCase(ver2)) {
			// 调用业务逻辑方法来处理登录请求
			int result = adminService.validLogin(getUser());
			// 登录结果为管理员
			if (result == LOGIN_ADMIN) {
				ctx.getSession().put(WebConstant.USERNAME, user.getUsername());
				ctx.getSession().put(WebConstant.LOGIN_TYPE, WebConstant.LOGIN_ADMIN);
				setTip("您已经成功登录系统");
				return ADMIN_RESULT;
			}
			// 登录结果为老师
			else if (result == LOGIN_TEACHER) {
				ctx.getSession().put(WebConstant.USERNAME, user.getUsername());
				ctx.getSession()
						.put(WebConstant.LOGIN_TYPE, WebConstant.LOGIN_TEACHER);
				setTip("您已经成功登录系统");
				return TEACHER_RESULT;
			}
			// 登录结果为学生
			else if (result == LOGIN_STUDENT) {
				ctx.getSession().put(WebConstant.USERNAME, user.getUsername());
				ctx.getSession()
						.put(WebConstant.LOGIN_TYPE, WebConstant.LOGIN_STUDENT);
				setTip("您已经成功登录系统");
				return STUDENT_RESULT;
			}
			// 用户名和密码不匹配
			else {
				setTip("用户名/密码不匹配");
				return ERROR;
			}
		}
		// 验证码不匹配
		else {
			setTip("验证码不匹配,请重新输入");
			return ERROR;
		}
	}
}
