package com.chzu.tic.dao.impl;

import java.util.List;

import com.chzu.tic.dao.ProjectDao;
import com.chzu.tic.model.Project;
import com.chzu.tic.util.UtilHibernateDaoSupport;

public class ProjectDaoImpl extends UtilHibernateDaoSupport implements
		ProjectDao {

	@Override
	public Project get(Integer id) {
		return getHibernateTemplate().get(Project.class, id);
	}

	@Override
	public Integer save(Project project) {
		return (Integer) getHibernateTemplate().save(project);
	}

	@Override
	public void update(Project project) {
		getHibernateTemplate().update(project);
	}

	@Override
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));

	}

	@Override
	public List<Project> findAll() {
		String queryString = "from Project";
		return (List<Project>) getHibernateTemplate().find(queryString);
	}

	@Override
	public List<Project> findByName(String name) {
		return (List<Project>) getHibernateTemplate().find(
				"from Project as p where p.name=?", name);
	}

}
