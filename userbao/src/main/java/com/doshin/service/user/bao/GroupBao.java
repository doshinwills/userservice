package com.doshin.service.user.bao;

import com.doshin.service.user.model.GroupVO;

public interface GroupBao {
	void save(GroupVO group);
	GroupVO findByGroupId(Integer groupId);

}
