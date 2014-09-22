package com.chzu.action;

import com.chzu.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminBaseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	// 依赖的业务逻辑组件
	protected AdminService adminService;

	// 进行依赖注入的set方法，采用自动装配策略，set方法名中AdminService匹配spring中bean的id值
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

}
