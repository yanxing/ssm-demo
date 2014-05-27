package com.chzu.tic.action;

import java.util.List;

import com.chzu.tic.model.Project;

public class SearchProjectAction extends TeacherBaseAction {

	private static final long serialVersionUID = 1L;
	private String tip;//搜索失败提示
	private Project project;//接收JSP页面传过来的project.name值(struts封装)
	private List<Project> listProject;//get.set方法，供JSP页面接收listProject
	
	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Project> getListProject() {
		return listProject;
	}

	public void setListProject(List<Project> listProject) {
		this.listProject = listProject;
	}

	public String execute()throws Exception{
		this.listProject=teacherService.findProjectByName(project.getName());
		if (listProject.size()<=0) {
			setTip("您搜索的比赛项目不存在，请核对好比赛项目名称再试！");
            return INPUT;
		}
		return SUCCESS;
	}

}
