package com.chzu.tic.service.impl;

import java.util.List;

import com.chzu.tic.dao.FileDao;
import com.chzu.tic.dao.NewsDao;
import com.chzu.tic.dao.OnlineDao;
import com.chzu.tic.dao.ProjectDao;
import com.chzu.tic.dao.UserDao;
import com.chzu.tic.model.File;
import com.chzu.tic.model.Project;
import com.chzu.tic.model.User;
import com.chzu.tic.service.TeacherService;
import com.chzu.tic.util.PageBean;

public class TeacherServiceImpl implements TeacherService {

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
    
	@Override
     public PageBean queryForPage(int pageSize,int page){

        final String hql = "from File";        //查询语句
        int allRow = fileDao.getAllRowCount(hql);    //总记录数
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //总页数
        final int offset = PageBean.countOffset(pageSize, page);    //当前页开始记录
        final int length = pageSize;    //每页记录数
        final int currentPage = PageBean.countCurrentPage(page);
        List<File> list = fileDao.findByPage(hql, offset, length);        //"一页"的记录
        
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

	@Override
	public PageBean queryProjectForPage(int pageSize, int page) {
		final String hql = "from Project";        //查询语句
        int allRow = projectDao.getAllRowCount(hql);    //总记录数
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //总页数
        final int offset = PageBean.countOffset(pageSize, page);    //当前页开始记录
        final int length = pageSize;    //每页记录数
        final int currentPage = PageBean.countCurrentPage(page);
        List<Project> list =projectDao.findByPage(hql, offset, length);        //"一页"的记录
        
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
	
	@Override
	public PageBean queryPassOrNoPassForPage(int pageSize, int page,boolean isPass) {
		String state = "";
		if (isPass) {//查找已经通过审核的比赛项目
			state = "已通过";
		} else {//查找为通过审核的比赛项目
			state = "未通过";
		}
		// 进行多对一查询，查询的结果为User对象的list集合，其中每一个User对象
		// 封装了相对应的Project对象
		final String hql = "from User as u where u.project is not null and u.state=? "; // 多对一查询
		int allRow = getUserDao().getAllRowCount(hql, state); // 总记录数
		int totalPage = PageBean.countTotalPage(pageSize, allRow); // 总页数
		final int offset = PageBean.countOffset(pageSize, page); // 当前页开始记录
		final int length = pageSize; // 每页记录数
		final int currentPage = PageBean.countCurrentPage(page);
		List<User> list = getUserDao().findByPage(hql, state, offset, length); // "一页"的记录
		
		// 把分页信息保存到Bean中
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}
	
	@Override
	public Boolean exit(String name) {
		List<File> listFile=fileDao.findByName(name);
		if(listFile.size()>0){//相同文件名已存在
			return true;
		}
		return false;
	}

	@Override
	public void upload(File file) {
            fileDao.save(file);
	}
	
	@Override
	public List<File> fileFindAll(){
		return fileDao.findAll();
	}
	
	@Override
	public File getFile(Integer id){
		return fileDao.get(id);
	}

	@Override
	public void deleteFile(Integer id) {
		fileDao.delete(id);
	}

	@Override
	public List<Project> findProjectByName(String ProjectName) {
		return projectDao.findByName(ProjectName);
	}

	@Override
	public void deleteProject(Integer id) {
		projectDao.delete(id);
		
	}

	@Override
	public void updateProject(Project project) {
		projectDao.update(project);
		
	}

	@Override
	public void addProject(Project project) {
		projectDao.save(project);
		
	}

	@Override
	public void updateApprove(User user) {
		userDao.update(user);
		
	}

	@Override
	public void updateCancel(User user) {
		userDao.update(user);
	}

	@Override
	public User getUser(Integer id) {
		return userDao.get(id);
	}

}
