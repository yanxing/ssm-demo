package com.chzu.tic.service.impl;

import java.util.List;

import com.chzu.tic.dao.FileDao;
import com.chzu.tic.dao.NewsDao;
import com.chzu.tic.dao.OnlineDao;
import com.chzu.tic.dao.ProjectDao;
import com.chzu.tic.dao.UserDao;
import com.chzu.tic.model.News;
import com.chzu.tic.model.User;
import com.chzu.tic.service.AdminService;
import com.chzu.tic.util.PageBean;

public class AdminServiceImpl implements AdminService {
	private FileDao fileDao;
	private NewsDao newsDao;
	private OnlineDao onlineDao;
	private ProjectDao projectDao;
	private UserDao userDao;

	public FileDao getFileDao() {
		return fileDao;
	}

	public void setFileDao(FileDao fileDao) {
		this.fileDao = fileDao;
	}

	public NewsDao getNewsDao() {
		return newsDao;
	}

	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}

	public OnlineDao getOnlineDao() {
		return onlineDao;
	}

	public void setOnlineDao(OnlineDao onlineDao) {
		this.onlineDao = onlineDao;
	}

	public ProjectDao getProjectDao() {
		return projectDao;
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 以管理员身份来验证登录
	 * @return -1为登录失败，0为管理员登录 1为老师登录 2为学生登录
	 */
	@Override
	public int validLogin(User user) {
		if (userDao.findByNameAndPass(user).size() >= 1) {
			int type = userDao.findByNameAndPass(user).get(0).getType();// 获取用户类型
			if (type == 0) {// 管理员登录，0代表管理员
				return LOGIN_ADMIN;
			} else if (type == 1) {// 老师登录，1代表老师
				return LOGIN_TEACHER;
			} else if (type == 2) {// 学生登录，2代表学生
				return LOGIN_STUDENT;
			}
			return LOGIN_FAIL;
		} else {
			return LOGIN_FAIL;
		}
	}

	//保存新闻
	@Override
	public boolean saveNotice(News news) {
		newsDao.save(news);
		return true;
	}
//添加用户
	@Override
	public boolean addUser(User user) {
		userDao.save(user);
		return true;
	}

	public User findByName(String name){
		return userDao.findByName(name);
	}
	
//获得学生，老师用户
	@Override
	public List<User> findAllUser() {
		List<User> userLists=userDao.findByAdmin();
		for(User user:userLists)
		{
			if(user.getType().equals(1))
			{
				user.setTypename("老师");
			}
			if(user.getType().equals(2))
			{
				user.setTypename("学生");
			}
		}
		return userLists;
	}

	//删除老师或者学生
	@Override
	public boolean delete(Integer id) {
		userDao.delete(id);
		return true;
	}

	@Override
	public News get(Integer id) {
		News news=newsDao.get(id);
		return news;
	}

	@Override
	public boolean deleteOneNews(Integer id) {
		newsDao.delete(id);
		return true;
	}

	@Override
	public boolean UpdateOneNews(News news) {
		newsDao.update(news);
		return true;
	}
	
	@Override
    public PageBean queryForPage(int pageSize,int page){

       final String hql = "from News";        //查询语句
       int allRow = newsDao.getAllRowCount(hql);    //总记录数
       int totalPage = PageBean.countTotalPage(pageSize, allRow);    //总页数
       final int offset = PageBean.countOffset(pageSize, page);    //当前页开始记录
       final int length = pageSize;    //每页记录数
       final int currentPage = PageBean.countCurrentPage(page);
       List<News> list = newsDao.findByPage(hql, offset, length);        //"一页"的记录
       
       //把分页信息保存到Bean中
       PageBean pageBean = new PageBean();
       pageBean.setPageSize(pageSize);    
       pageBean.setCurrentPage(currentPage);
       pageBean.setAllRow(allRow);
       pageBean.setTotalPage(totalPage);
       pageBean.setList(list);
       pageBean.init();
       return pageBean;
   }

}
