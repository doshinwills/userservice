package com.doshin.service.user.dao;

import com.doshin.service.user.dao.model.GroupDO;

public interface GroupDao {

	Integer save(GroupDO group);
	
	GroupDO findByGroupId(Integer groupId);

}
