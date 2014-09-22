package com.chzu.dao.impl;

import java.util.List;

import com.chzu.dao.AdminDao;
import com.chzu.model.Admin;
import com.chzu.model.Student;
import com.chzu.util.UtilHibernateDaoSupport;

public class AdminDaoImpl extends UtilHibernateDaoSupport implements AdminDao {

	@Override
	public Admin get(Integer id) {
		return null;
	}

	@Override
	public Integer save(Admin admin) {
		return null;
	}

	@Override
	public void update(Admin admin) {

	}

	@Override
	public void delete(Admin admin) {

	}

	@Override
	public void delete(Integer id) {

	}

	@Override
	public List<Admin> findAll() {
		return null;
	}

	@Override
	public List<Admin> findByNameAndPass(Admin admin) {
		String queryString = "from Admin as a where a.username=? and a.password=?";
		return (List<Admin>) getHibernateTemplate().find(queryString,
				admin.getUsername(), admin.getPassword());
	}

	@Override
	public Admin findByName(String name) {
		return null;
	}

}
