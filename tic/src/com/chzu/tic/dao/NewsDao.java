package com.chzu.tic.dao;

import java.util.List;

import com.chzu.tic.model.User;
import com.chzu.tic.model.News;

public interface NewsDao {
	
	/**
	 * 根据标识属性来加载News实例
	 * 
	 * @param id
	 *            需要加载的News实例的标识属性值
	 * @return 返回指定标识属性对应的News实例
	 */
	News get(Integer id);

	
	/**
	 * 持久化指定的News实例
	 * 
	 * @param news
	 *            需要被持久化的News实例
	 * @return 返回News实例被持久化后的标识属性值
	 */
	Integer save(News news);

	
	/**
	 * 修改指定的News实例
	 * 
	 * @param news
	 *            需要被修改的News实例
	 */
	void update(News news);

	
	/**
	 * 删除指定的News实例
	 * 
	 * @param news
	 *            需要被删除的News实例
	 */
	void delete(News news);

	
	/**
	 * 根据标识属性删除News实例
	 * 
	 * @param id
	 *            需要被删除的News实例的标识属性值
	 */
	void delete(Integer id);

	
	/**
	 * 查询全部的News实例
	 * 
	 * @return 返回数据库中全部的News实例
	 */
	List<News> findAll();
	
	/**
	 * 
	 * 以下进行分页查询所需要的方法，通过继承UtilHibernateDaoSupport实现，
	 * 不进行重写
	 */
	public List<News> findByPage(final String hql, final int offset,
			final int pageSize);
	public List<User> findByPage(final String hql, final Object value,
			final int offset, final int pageSize);
	public List<User> findByPage(final String hql, final Object[] values,
			final int offset, final int pageSize);
	public int getAllRowCount(String hql);
	public int getAllRowCount(String hql, Object value);
	public int getAllRowCount(String hql, Object[] values);
	

}
