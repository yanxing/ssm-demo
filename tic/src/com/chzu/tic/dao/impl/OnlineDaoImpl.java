package com.chzu.tic.dao.impl;

import java.util.List;

import com.chzu.tic.dao.OnlineDao;
import com.chzu.tic.model.Online;
import com.chzu.tic.util.UtilHibernateDaoSupport;

public class OnlineDaoImpl extends UtilHibernateDaoSupport implements OnlineDao {

	@Override
	public Online get(Integer id) {
		return getHibernateTemplate().get(Online.class, id);
	}

	@Override
	public Integer save(Online online) {
		return (Integer) getHibernateTemplate().save(online);
	}

	@Override
	public void update(Online online) {
		getHibernateTemplate().update(online);

	}

	@Override
	public void delete(Online online) {
		getHibernateTemplate().delete(online);
	}

	@Override
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));

	}

	@Override
	public List<Online> findAll() {
		String queryString = "from Online";
		return (List<Online>) getHibernateTemplate().find(queryString);
	}

}
