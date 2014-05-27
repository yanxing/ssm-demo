package com.chzu.tic.dao;

import java.util.List;

import com.chzu.tic.model.File;

public interface FileDao {
	/**
	 * 根据标识属性来加载File实例
	 * 
	 * @param id
	 *            需要加载的File实例的标识属性值
	 * @return 返回指定标识属性对应的File实例
	 */
	File get(Integer id);

	/**
	 * 持久化指定的File实例
	 * 
	 * @param file
	 *            需要被持久化的File实例
	 * @return 返回File实例被持久化后的标识属性值
	 */
	Integer save(File file);

	
	/**
	 * 修改指定的File实例
	 * 
	 * @param file
	 *            需要被修改的File实例
	 */
	void update(File file);

	
	/**
	 * 删除指定的File实例
	 * 
	 * @param file
	 *            需要被删除的File实例
	 */
	void delete(File file);

	
	/**
	 * 根据标识属性删除file实例
	 * 
	 * @param id
	 *            需要被删除的file实例的标识属性值
	 */
	void delete(Integer id);

	
	/**
	 * 查询全部的File实例
	 * 
	 * @return 返回数据库中全部的File实例
	 */
	List<File> findAll();
	
	/**
	 * 
	 * 以下进行分页查询所需要的方法，通过继承UtilHibernateDaoSupport实现，
	 * 不进行重写
	 */
	public List<File> findByPage(final String hql, final int offset,
			final int pageSize);
	public List<File> findByPage(final String hql, final Object value,
			final int offset, final int pageSize);
	public List<File> findByPage(final String hql, final Object[] values,
			final int offset, final int pageSize);
	public int getAllRowCount(String hql);
	public int getAllRowCount(String hql, Object value);
	public int getAllRowCount(String hql, Object[] values);
	
	/**
	 * 根据文件名查询文件
	 * 
	 * @param name
	 *            文件名
	 * @return 返回符合条件的File实例
	 */
	List<File> findByName(String name);


}
