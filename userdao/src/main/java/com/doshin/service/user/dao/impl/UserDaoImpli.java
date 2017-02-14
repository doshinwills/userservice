package com.doshin.service.user.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doshin.service.user.dao.UserDao;
import com.doshin.service.user.dao.model.UserDO;

@Repository("userDao")
public class UserDaoImpli implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public Integer save(UserDO user) {
		return (Integer) getSession().save(user);
	}

	public void update(UserDO ptsUser) {
		getSession().update(ptsUser);
	}

	public void delete(UserDO ptsUser) {
		getSession().delete(ptsUser);
	}

	public UserDO findByUserId(Integer userId) {
		Criteria criteria = getSession().createCriteria(UserDO.class);
		criteria.add(Restrictions.eq("id", userId));
		return (UserDO) criteria.uniqueResult();
	}

}
