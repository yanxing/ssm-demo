package com.chzu.tic.action;

import com.chzu.tic.util.PageBean;

//报名管理中，审核通过和未通过功能处理类
public class CompetitionListAction extends TeacherBaseAction {

	private static final long serialVersionUID = 1L;
	private int page; // 第几页
	private PageBean pageBean; // 包含分页信息的bean

	public int getPage() {
		return page;
	}

	public void setPage(int page) { // 若URL中无此参数,会默认为第1页
		this.page = page;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	
	/**
	 * 载入审核已通过名单
	 * @return
	 * @throws Exception
	 */
	public String pass()throws Exception{
		// 分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
		this.pageBean = teacherService.queryPassOrNoPassForPage(5, page,true);
		return SUCCESS;
	}
	
	/**
	 * 载入审核未通过名单
	 * @return
	 * @throws Exception
	 */
	public String nopass()throws Exception{
		// 分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
		this.pageBean = teacherService.queryPassOrNoPassForPage(5, page,false);
		return SUCCESS;
	}

}
