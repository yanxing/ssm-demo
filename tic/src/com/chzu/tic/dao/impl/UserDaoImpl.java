package com.chzu.tic.dao.impl;

import java.util.List;

import com.chzu.tic.dao.UserDao;
import com.chzu.tic.model.User;
import com.chzu.tic.util.UtilHibernateDaoSupport;

public class UserDaoImpl extends UtilHibernateDaoSupport implements UserDao {

	@Override
	public User get(Integer id) {
		return getHibernateTemplate().get(User.class, id);
	}

	@Override
	public Integer save(User user) {
		return (Integer) getHibernateTemplate().save(user);
	}

	@Override
	public void update(User user) {
		getHibernateTemplate().update(user);
	}

	@Override
	public void delete(User user) {
		getHibernateTemplate().delete(user);
	}

	@Override
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	@Override
	public List<User> findAll() {
		String queryString = "from User";
		return (List<User>) getHibernateTemplate().find(queryString);
	}

	@Override
	public List<User> findByNameAndPass(User user) {
		String queryString = "from User as u where u.username=? and u.password=?";
		return (List<User>) getHibernateTemplate().find(queryString,
				user.getUsername(), user.getPassword());
	}

	@Override
	public User findByName(String name) {
		List<User> nameList = (List<User>) getHibernateTemplate().find(
				"from User as u where u.username=?", name);
		if (nameList != null && nameList.size() > 0) {
			return nameList.get(0);
		}
		return null;
	}

	@Override
	public List<User> findByAdmin() {
		return (List<User>) getHibernateTemplate().find(
				"from User as u where " + "u.type in(1,2)");
	}

}
