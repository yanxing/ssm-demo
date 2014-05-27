package com.chzu.tic.action;

import org.apache.struts2.ServletActionContext;

import com.chzu.tic.model.User;

//此Action批准或取消学生参加比赛
public class CompetitionCheckAction extends TeacherBaseAction {

	private static final long serialVersionUID = 1L;

	public String execute() throws Exception {
		String idString = ServletActionContext.getRequest().getParameter(
				"user.id");
		String check = ServletActionContext.getRequest().getParameter("check");
		Integer id = Integer.parseInt(idString);
		User user = new User();
		user=teacherService.getUser(id);
		user.setId(id);
		user.setUsername(user.getUsername());
		user.setPassword(user.getPassword());
		user.setEmail(user.getEmail());
		user.setType(user.getType());
		user.setTeam(user.getTeam());
		System.out.println("checkd==============================================================="+check);
		if (check.equals("0")) {// 批准学生参赛资格，把数据库中字段未通过改为已通过
			user.setState("已通过");
			teacherService.updateApprove(user);
		} else if (check.equals("1")) {// 取消学生参赛资格，把数据库中字段已通过改为未通过
			user.setState("未通过");
			teacherService.updateApprove(user);
		}
		return SUCCESS;
	}

}
