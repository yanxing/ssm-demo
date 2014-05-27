package com.chzu.tic.service;

import java.util.List;

import com.chzu.tic.model.News;
import com.chzu.tic.model.User;
import com.chzu.tic.util.PageBean;

public interface AdminService {
	// 登录失败
	public static final int LOGIN_FAIL = -1;
	// 以管理员身份登录
	public static final int LOGIN_ADMIN = 0;
	// 以老师身份登录
	public static final int LOGIN_TEACHER = 1;
	// 以学生身份登录
	public static final int LOGIN_STUDENT = 2;

	int validLogin(User admin);//以管理员身份来验证登录
	
	boolean saveNotice(News news);//添加新闻告示
	
	boolean addUser(User user);//添加用户
	
	List<User> findAllUser();
	
	User findByName(String name);
	
	boolean delete(Integer id);
	
	News get(Integer id);
	
	/**
	 * 删除新闻
	 * @param id
	 * @return
	 */
	boolean deleteOneNews(Integer id);
	
	/**
	 * 编辑新闻
	 * @param news
	 * @return
	 */
	boolean UpdateOneNews(News news);
	
	/**
     * 新闻分页查询
     * @param pageSize 每页大小
     * @param page 当前第几页
     * @return 封装了分页信息(包括记录集list)的Bean
     */
    public PageBean queryForPage(int pageSize,int currentPage);

}
