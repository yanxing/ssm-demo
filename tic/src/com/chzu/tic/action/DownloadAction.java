package com.chzu.tic.action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.chzu.tic.model.File;

public class DownloadAction extends TeacherBaseAction {
	private static final long serialVersionUID = 1L;
	private String fileName;
	private String filePath;// 要下载的文件路径

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * 
	 * 定义一个返回InputStream的方法，该方法将作为被下载文件的入口
	 * 且需要配置stream类型结果时指定inputName参数(struts动作类属性的名字),
	 * inputName参数的值就是方法去掉get前缀、首字母小写的字符串
	 */
	public InputStream getTargetFile() throws Exception {
		String idString=ServletActionContext.getRequest().getParameter("file.id");
		Integer id = Integer.parseInt(idString);
		File file = teacherService.getFile(id);
		setFileName(file.getName());// 为下载的文件名命名
		setFilePath(file.getPath());// 下载文件路径指定数据库中文件的路径
		return new java.io.FileInputStream(getFilePath());
	}

	public String execute() throws Exception {
		return SUCCESS;

	}

}
