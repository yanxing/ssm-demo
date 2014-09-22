package com.chzu.dao;

import java.util.List;

import com.chzu.model.Admin;

public interface AdminDao {

	/**
	 * 根据标识属性来加载admin实例
	 */
	Admin get(Integer id);

	
	/**
	 * 持久化指定的admin实例
	 */
	Integer save(Admin admin);

	
	/**
	 * 修改指定的admin实例
	 */
	void update(Admin admin);

	
	/**
	 * 删除指定的admin实例
	 */
	void delete(Admin admin);

	
	/**
	 * 根据标识属性删除admin实例
	 */
	void delete(Integer id);

	
	/**
	 * 查询全部的admin实例
	 */
	List<Admin> findAll();

	
	/**
	 * 根据用户名和密码查询用户
	 */
	List<Admin> findByNameAndPass(Admin admin);

	
	/**
	 * 根据用户名查询
	 * 
	 */
	Admin findByName(String name);

}
