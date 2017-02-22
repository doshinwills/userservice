package com.doshin.service.user.bao.impl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doshin.service.user.bao.GroupBao;
import com.doshin.service.user.dao.GroupDao;
import com.doshin.service.user.dao.model.GroupDO;
import com.doshin.service.user.dao.model.RightDO;
import com.doshin.service.user.model.GroupVO;
import com.doshin.service.user.model.RightVO;

@Service("groupBao")
@Transactional
public class GroupBaoImpl implements GroupBao {

	@Autowired
	GroupDao groupDao;

	public void save(GroupVO group) {

		GroupDO groupDO = new GroupDO();

		BeanUtils.copyProperties(group, groupDO);
		groupDO.setRightList(new ArrayList<RightDO>());
		for (RightVO rightVO : group.getRightList()) {
			RightDO rightDO = new RightDO();
			BeanUtils.copyProperties(rightVO, rightDO);
			groupDO.getRightList().add(rightDO);
		}
		groupDao.save(groupDO);
	}

	public GroupVO findByGroupId(Integer groupId) {
		GroupDO groupDO = groupDao.findByGroupId(groupId);
		GroupVO groupVO = new GroupVO();
		BeanUtils.copyProperties(groupDO, groupVO);
		groupVO.setRightList(new ArrayList<RightVO>());
		for (RightDO rightDO : groupDO.getRightList()) {
			RightVO rightVO = new RightVO();
			BeanUtils.copyProperties(rightDO, rightVO);
			groupVO.getRightList().add(rightVO);
		}
		return groupVO;
	}

}
