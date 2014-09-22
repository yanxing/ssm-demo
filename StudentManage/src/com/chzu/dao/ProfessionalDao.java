package com.chzu.dao;

import java.util.List;

import com.chzu.model.Professional;

public interface ProfessionalDao {

	/**
	 * 根据标识属性来加载Professional实例
	 */
	Professional get(Integer id);

	
	/**
	 * 持久化指定的Professional实例
	 */
	Integer save(Professional Professional);

	
	/**
	 * 修改指定的Professional实例
	 */
	void update(Professional Professional);

	
	/**
	 * 删除指定的Professional实例
	 */
	void delete(Professional Professional);

	
	/**
	 * 根据标识属性删除Professional实例
	 */
	void delete(Integer id);

	
	/**
	 * 查询全部的Professional实例
	 */
	List<Professional> findAll();

	
	

}
