package com.chzu.action;

import org.apache.struts2.ServletActionContext;

/**
 * 此Action用来删除学生
 */
public class DeleteStudentAction extends AdminBaseAction {
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception {
		String idString = ServletActionContext.getRequest().getParameter(
				"user.id");
		Integer id = Integer.parseInt(idString);
		adminService.deleteStudent(id);
		return "success";
	}

}
