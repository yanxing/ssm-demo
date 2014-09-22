package com.chzu.action;

import com.chzu.util.PageBean;

public class StudentListAction extends AdminBaseAction {

	private static final long serialVersionUID = 1L;

	private int page; // 第几页
	private PageBean pageBean; // 包含分布信息的bean

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

	@Override
	public String execute() throws Exception {
		// 分页的pageBean,参数pageSize表示每页显示记录数,page为当前页
		this.pageBean = adminService.queryUserForPage(5, page);
		return SUCCESS;
	}
}
