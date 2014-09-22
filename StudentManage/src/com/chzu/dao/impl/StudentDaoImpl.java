package com.chzu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.chzu.dao.StudentDao;
import com.chzu.model.Student;
import com.chzu.util.UtilHibernateDaoSupport;

public class StudentDaoImpl extends UtilHibernateDaoSupport implements StudentDao {

	@Override
	public Student get(Integer id) {
		return getHibernateTemplate().get(Student.class, id);
	}

	@Override
	public Integer save(Student user) {
		return (Integer) getHibernateTemplate().save(user);
	}

	@Override
	public void update(Student user) {
		getHibernateTemplate().update(user);
	}

	/**
	 * 只更新部分字段
	 * @param sql
	 */
	public void update(String hql){
		Session session =getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery(hql);
		query.executeUpdate();
		session.getTransaction().commit();
	} 
	@Override
	public void delete(Student user) {
		getHibernateTemplate().delete(user);
	}

	@Override
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	@Override
	public List<Student> findAll() {
		String queryString = "from Student";
		return (List<Student>) getHibernateTemplate().find(queryString);
	}

	@Override
	public List<Student> findByNameAndPass(Student user) {
		String queryString = "from Student as u where u.username=? and u.password=?";
		return (List<Student>) getHibernateTemplate().find(queryString,
				user.getUsername(), user.getPassword());
	}

	@Override
	public Student findByName(String name) {
		List<Student> nameList = (List<Student>) getHibernateTemplate().find(
				"from Student as u where u.number=?", name);
		if (nameList != null && nameList.size() > 0) {
			return nameList.get(0);
		}
		return null;
	}

}
