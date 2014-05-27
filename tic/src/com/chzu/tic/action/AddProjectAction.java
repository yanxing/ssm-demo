package com.chzu.tic.action;

import com.chzu.tic.model.Project;
/**
 * 
 * 添加比赛项目
 */
public class AddProjectAction extends TeacherBaseAction {

	private static final long serialVersionUID = 1L;//
	private Project project;//封装add.jsp页面提交的数据
	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}


	public String execute()throws Exception{
		project.setName(project.getName());
		project.setLevel(project.getLevel());
		project.setPeriod(project.getPeriod());
		teacherService.addProject(project);
		return SUCCESS;
	}
}
