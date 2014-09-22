package com.chzu.dao.impl;

import java.util.List;

import com.chzu.dao.DepartmentDao;
import com.chzu.model.Department;
import com.chzu.util.UtilHibernateDaoSupport;

public class DepartmentDaoImpl extends UtilHibernateDaoSupport implements
		DepartmentDao {

	@Override
	public Department get(Integer id) {
		return null;
	}

	@Override
	public Integer save(Department Department) {
		return null;
	}

	@Override
	public void update(Department Department) {

	}

	@Override
	public void delete(Department Department) {

	}

	@Override
	public void delete(Integer id) {

	}

	@Override
	public List<Department> findAll() {
		return null;
	}

}
