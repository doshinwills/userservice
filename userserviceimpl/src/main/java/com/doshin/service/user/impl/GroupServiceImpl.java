package com.doshin.service.user.impl;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import com.doshin.service.user.api.GroupService;
import com.doshin.service.user.bao.GroupBao;
import com.doshin.service.user.model.GroupVO;

@Path("/group")
public class GroupServiceImpl implements GroupService {

	@Autowired
	GroupBao groupBao;

	@Override
	public void save(GroupVO group) {
		groupBao.save(group);
	}
	
	@Override
	public GroupVO findByGroupId(Integer groupId) {
		return groupBao.findByGroupId(groupId);
	}
}