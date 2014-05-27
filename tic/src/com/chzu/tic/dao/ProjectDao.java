package com.chzu.tic.dao;

import java.util.List;

import com.chzu.tic.model.Project;

public interface ProjectDao {

	/**
	 * 根据标识属性来加载Project实例
	 * 
	 * @param id
	 *            需要加载的Project实例的标识属性值
	 * @return 返回指定标识属性对应的Project实例
	 */
    Project get(Integer id);
	
	
	/**
	 * 持久化指定的Project实例
	 * 
	 * @param project
	 *            需要被持久化的Project实例
	 * @return 返回Project实例被持久化后的标识属性值
	 */
	Integer save(Project project);

	
	/**
	 * 修改指定的Project实例
	 * 
	 * @param news
	 *            需要被修改的Project实例
	 */
	void update(Project project);
	
	/**
	 * 根据标识属性删除Project实例
	 * 
	 * @param id
	 *            需要被删除的Project实例的标识属性值
	 */
	void delete(Integer id);

	
	/**
	 * 查询全部的Project实例
	 * 
	 * @return 返回数据库中全部的Project实例
	 */
	List<Project> findAll();
	
	/**
	 * 根据项目名查询比赛项目
	 * 以后供模糊查询
	 * @param name
	 *            文件名
	 * @return 返回符合条件的实例
	 */
	List<Project> findByName(String name);
	
	/**
	 * 
	 * 以下进行分页查询所需要的方法，通过继承UtilHibernateDaoSupport实现，
	 * 不进行重写
	 */
	public List<Project> findByPage(final String hql, final int offset,
			final int pageSize);
	public List<Project> findByPage(final String hql, final Object value,
			final int offset, final int pageSize);
	public List<Project> findByPage(final String hql, final Object[] values,
			final int offset, final int pageSize);
	public int getAllRowCount(String hql);
	public int getAllRowCount(String hql, Object value);
	public int getAllRowCount(String hql, Object[] values);
}
