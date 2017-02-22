package com.doshin.service.user.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doshin.service.user.dao.GroupDao;
import com.doshin.service.user.dao.model.GroupDO;
import com.doshin.service.user.dao.model.RightDO;

@Repository("groupDao")
public class GroupDaoImpli implements GroupDao {

	@Autowired
	SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public Integer save(GroupDO group) {
		return (Integer) getSession().save(group);
	}
	
	public GroupDO findByGroupId(Integer groupId) {
		Criteria criteria = getSession().createCriteria(GroupDO.class);
		criteria.add(Restrictions.eq("groupId", groupId));
		GroupDO groupDO = (GroupDO) criteria.uniqueResult();
		
		return groupDO;
	}

}
