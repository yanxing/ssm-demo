package com.chzu.tic.dao;

import java.util.List;

import com.chzu.tic.model.User;

public interface UserDao {

	/**
	 * 根据标识属性来加载User实例
	 * 
	 * @param id
	 *            需要加载的User实例的标识属性值
	 * @return 返回指定标识属性对应的User实例
	 */
	User get(Integer id);

	
	/**
	 * 持久化指定的User实例
	 * 
	 * @param user
	 *            需要被持久化的User实例
	 * @return 返回User实例被持久化后的标识属性值
	 */
	Integer save(User user);

	
	/**
	 * 修改指定的User实例
	 * 
	 * @param user
	 *            需要被修改的User实例
	 */
	void update(User user);

	
	/**
	 * 删除指定的User实例
	 * 
	 * @param user
	 *            需要被删除的User实例
	 */
	void delete(User user);

	
	/**
	 * 根据标识属性删除User实例
	 * 
	 * @param id
	 *            需要被删除的User实例的标识属性值
	 */
	void delete(Integer id);

	
	/**
	 * 查询全部的User实例
	 * 
	 * @return 返回数据库中全部的User实例
	 */
	List<User> findAll();

	
	/**
	 * 根据用户名和密码查询用户
	 * 
	 * @param user
	 *            包含指定用户名、密码的用户
	 * @return 返回符合指定用户名和密码的用户集合
	 */
	List<User> findByNameAndPass(User user);

	
	/**
	 * 根据用户名查询学生或老师
	 * 
	 * @param name
	 *            学生或老师的用户名
	 * @return 返回符合用户名的学生或老师
	 */
	User findByName(String name);

	
	/**
	 * 根据管理员查询学生和老师，传入数值1，2（1代表老师，2代表学生）
	 * @return 返回该管理员对应的所有学生和老师
	 */
	List<User> findByAdmin();
	
	/**
	 * 
	 * 以下进行分页查询所需要的方法，通过继承UtilHibernateDaoSupport实现，
	 * 不进行重写
	 */
	public List<User> findByPage(final String hql, final int offset,
			final int pageSize);
	public List<User> findByPage(final String hql, final Object value,
			final int offset, final int pageSize);
	public List<User> findByPage(final String hql, final Object[] values,
			final int offset, final int pageSize);
	public int getAllRowCount(String hql);
	public int getAllRowCount(String hql, Object value);
	public int getAllRowCount(String hql, Object[] values);
}
