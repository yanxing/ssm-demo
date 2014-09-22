package com.chzu.dao;

import java.util.List;

import com.chzu.model.Department;

public interface DepartmentDao {

	/**
	 * 根据标识属性来加载Department实例
	 */
	Department get(Integer id);

	
	/**
	 * 持久化指定的Department实例
	 */
	Integer save(Department Department);

	
	/**
	 * 修改指定的Department实例
	 */
	void update(Department Department);

	
	/**
	 * 删除指定的Department实例
	 */
	void delete(Department Department);

	
	/**
	 * 根据标识属性删除Department实例
	 */
	void delete(Integer id);

	
	/**
	 * 查询全部的Department实例
	 */
	List<Department> findAll();

	
	

}
