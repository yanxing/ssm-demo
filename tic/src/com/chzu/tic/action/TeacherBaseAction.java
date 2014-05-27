package com.chzu.tic.action;

import com.chzu.tic.service.TeacherService;
import com.opensymphony.xwork2.ActionSupport;

public class TeacherBaseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	// 依赖的业务逻辑组件
	protected TeacherService teacherService;

	// 进行依赖注入的set方法，采用自动装配策略，set方法名中AdminService匹配spring中bean的id值
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

}
