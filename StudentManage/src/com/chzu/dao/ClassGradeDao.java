package com.chzu.dao;

import java.util.List;

import com.chzu.model.ClassGrade;

public interface ClassGradeDao {

	/**
	 * 根据标识属性来加载ClassGrade实例
	 */
	ClassGrade get(Integer id);

	
	/**
	 * 持久化指定的ClassGrade实例
	 */
	Integer save(ClassGrade ClassGrade);

	
	/**
	 * 修改指定的ClassGrade实例
	 */
	void update(ClassGrade ClassGrade);

	
	/**
	 * 删除指定的ClassGrade实例
	 */
	void delete(ClassGrade ClassGrade);

	
	/**
	 * 根据标识属性删除ClassGrade实例
	 */
	void delete(Integer id);

	
	/**
	 * 查询全部的ClassGrade实例
	 */
	List<ClassGrade> findAll();
	
	/**
	 * 根据班级名称查询
	 * @param name
	 * @return
	 */
	ClassGrade findByName(String name);

	
	

}
