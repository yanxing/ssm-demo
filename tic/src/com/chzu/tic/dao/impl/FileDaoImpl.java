package com.chzu.tic.dao.impl;

import java.util.List;

import com.chzu.tic.dao.FileDao;
import com.chzu.tic.model.File;
import com.chzu.tic.util.UtilHibernateDaoSupport;

public class FileDaoImpl extends UtilHibernateDaoSupport implements FileDao {

	@Override
	public File get(Integer id) {
		return getHibernateTemplate().get(File.class, id);
	}

	/**
	 * 上传文件
	 */
	@Override
	public Integer save(File file) {
		return (Integer) getHibernateTemplate().save(file);
	}

	@Override
	public void update(File file) {
		getHibernateTemplate().update(file);
	}

	@Override
	public void delete(File file) {
		getHibernateTemplate().delete(file);
	}

	@Override
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	/**
	 * 查询所有的上传文件
	 * 
	 * @author 返回所有的上传文件
	 */
	@Override
	public List<File> findAll() {
		String queryString = "from File";
		return (List<File>) getHibernateTemplate().find(queryString);
	}
  
	/**
	 * 为老师提供根据文件名查询上传的文件 此处进行的是精准匹配
	 * 
	 * @author 返回符合条件的上传文件
	 */
	@Override
	public List<File> findByName(String name) {
		return (List<File>) getHibernateTemplate().find(
				"from File as f where f.name=?", name);
	}
}
