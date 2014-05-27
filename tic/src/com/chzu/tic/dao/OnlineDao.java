package com.chzu.tic.dao;

import java.util.List;

import com.chzu.tic.model.Online;

public interface OnlineDao {
	/**
	 * 根据标识属性来加载Online实例
	 * 
	 * @param id
	 *            需要加载的Online实例的标识属性值
	 * @return 返回指定标识属性对应的Online实例
	 */
	Online get(Integer id);

	
	/**
	 * 持久化指定的Online实例
	 * 
	 * @param online
	 *            需要被持久化的Online实例
	 * @return 返回Online实例被持久化后的标识属性值
	 */
	Integer save(Online online);

	
	/**
	 * 修改指定的Online实例
	 * 
	 * @param news
	 *            需要被修改的Online实例
	 */
	void update(Online online);

	
	/**
	 * 删除指定的Online实例
	 * 
	 * @param online
	 *            需要被删除的Online实例
	 */
	void delete(Online online);

	
	/**
	 * 根据标识属性删除Online实例
	 * 
	 * @param id
	 *            需要被删除的Online实例的标识属性值
	 */
	void delete(Integer id);

	
	/**
	 * 查询全部的Online实例
	 * 
	 * @return 返回数据库中全部的Online实例
	 */
	List<Online> findAll();
}
