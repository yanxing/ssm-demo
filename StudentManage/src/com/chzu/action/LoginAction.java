package com.chzu.action;

import com.chzu.model.Admin;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends AdminBaseAction {

	private static final long serialVersionUID = 1L;
	public static String ADMIN_RESULT = "admin_result";// 作为管理员登录成功的返回结果名
	private String verifycode;// 验证码
	private Admin admin;
	// 处理登录后的提示信息
	private String tip;

	public String getVerifycode() {
		return verifycode;
	}

	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
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
			int result = adminService.validLogin(getAdmin());
			// 登录结果为管理员
			if (result == 0) {
				ctx.getSession().put(WebConstant.USERNAME, admin.getUsername());
				ctx.getSession().put(WebConstant.LOGIN_TYPE,
						WebConstant.LOGIN_ADMIN);
				setTip("您已经成功登录系统");
				return ADMIN_RESULT;
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
