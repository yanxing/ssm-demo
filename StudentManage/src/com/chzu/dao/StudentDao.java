package com.chzu.dao;

import java.util.List;

import com.chzu.model.Student;

public interface StudentDao {

	/**
	 * 根据标识属性来加载student实例
	 */
	Student get(Integer id);

	
	/**
	 * 持久化指定的student实例
	 */
	Integer save(Student student);

	
	/**
	 * 修改指定的student实例
	 */
	void update(Student student);
	
	/**
	 * 修改学生部分信息
	 */
	void update(String hql);
	
	/**
	 * 删除指定的student实例
	 */
	void delete(Student student);

	
	/**
	 * 根据标识属性删除student实例
	 */
	void delete(Integer id);

	
	/**
	 * 查询全部的student实例
	 */
	List<Student> findAll();

	
	/**
	 * 根据用户名和密码查询用户
	 * 
	 */
	List<Student> findByNameAndPass(Student student);

	
	/**
	 * 根据用户名查询
	 * 
	 */
	Student findByName(String name);

	
	/**
	 * 
	 * 以下进行分页查询所需要的方法，通过继承UtilHibernateDaoSupport实现，
	 * 不进行重写
	 */
	public List<Student> findByPage(final String hql, final int offset,
			final int pageSize);
	public List<Student> findByPage(final String hql, final Object value,
			final int offset, final int pageSize);
	public List<Student> findByPage(final String hql, final Object[] values,
			final int offset, final int pageSize);
	public int getAllRowCount(String hql);
	public int getAllRowCount(String hql, Object value);
	public int getAllRowCount(String hql, Object[] values);

}
