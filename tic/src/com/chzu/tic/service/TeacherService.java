package com.chzu.tic.service;

import java.util.List;

import com.chzu.tic.util.*;
import com.chzu.tic.model.File;
import com.chzu.tic.model.Project;
import com.chzu.tic.model.User;

public interface TeacherService {
	
	 /**
 	 * 验证用户上传的文件是否已经存在
 	 */
	public Boolean exit(String name);

	/**
	 * 把上传的文件的名称和路径写入数据库
	 */
	public void upload(File file);
	
	/**
	 * 
	 *查询所有的文件
	 */
	public List<File> fileFindAll();
	
	/**
     * 文件分页查询
     * @param pageSize 每页大小
     * @param page 当前第几页
     * @return 封装了分页信息(包括记录集list)的Bean
     */
    public PageBean queryForPage(int pageSize,int currentPage);
    
    /**
     * 比赛项目分页查询
     * @param pageSize 每页大小
     * @param page 当前第几页
     * @return 封装了分页信息(包括记录集list)的Bean
     */
    public PageBean queryProjectForPage(int pageSize,int currentPage);
    
    /**
     *参赛项目是否通过分页查询
     *得到的数据包含通过和未通过
     * @param pageSize 每页大小
     * @param page 当前第几页
     * @param isPass 筛选通过或未通过，isPass只能为true或false,通过true,未通过false
     * @return 封装了分页信息(包括记录集list)的Bean
     */
    public PageBean queryPassOrNoPassForPage(int pageSize,int page,boolean isPass);
    
    /**
	 * 根据id删除文件
	 */
    public File getFile(Integer id);
    
    /**
	 * 根据id删除文件
	 */
    public void deleteFile(Integer id);
    
    /**
	 * 根据名称查询比赛项目
	 */
    public List<Project> findProjectByName(String ProjectName);
    
    /**
     * 根据项目id删除项目
     * @param id 项目id
     */
    public void deleteProject( Integer id);
    
    /**
     * 更新项目
     * @param project Project类对象
     */
    public void updateProject(Project project);
    
    /**
     * 添加比赛项目
     * 
     */
    public void addProject(Project project);
    
    /**
     * 批准学生参赛
     */
    public void updateApprove(User user);
    
    /**
     * 取消学生参赛
     */
    public void updateCancel(User user);
    
    /**
     * 获得学生信息
     */
    public User getUser(Integer id);
    
    	
}
