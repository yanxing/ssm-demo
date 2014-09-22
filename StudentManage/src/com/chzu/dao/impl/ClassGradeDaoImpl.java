package com.chzu.dao.impl;

import java.util.List;

import com.chzu.dao.ClassGradeDao;
import com.chzu.model.ClassGrade;
import com.chzu.util.UtilHibernateDaoSupport;

public class ClassGradeDaoImpl extends UtilHibernateDaoSupport implements
		ClassGradeDao {

	@Override
	public ClassGrade get(Integer id) {
		return getHibernateTemplate().get(ClassGrade.class, id);
	}

	@Override
	public Integer save(ClassGrade ClassGrade) {
		return null;
	}

	@Override
	public void update(ClassGrade ClassGrade) {

	}

	@Override
	public void delete(ClassGrade ClassGrade) {

	}

	@Override
	public void delete(Integer id) {

	}

	@Override
	public List<ClassGrade> findAll() {
		String queryString = "from ClassGrade";
		return (List<ClassGrade>) getHibernateTemplate().find(queryString);
	}

	@Override
	public ClassGrade findByName(String name) {
		List<ClassGrade> classGrades=(List<ClassGrade>) getHibernateTemplate().find("from ClassGrade as c where c.name=?",name);
		return classGrades.get(0);
		
	}

}
