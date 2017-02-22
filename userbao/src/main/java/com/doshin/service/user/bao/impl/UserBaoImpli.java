package com.doshin.service.user.bao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doshin.service.user.bao.UserBao;
import com.doshin.service.user.dao.UserDao;
import com.doshin.service.user.dao.model.GroupDO;
import com.doshin.service.user.dao.model.RightDO;
import com.doshin.service.user.dao.model.UserDO;
import com.doshin.service.user.dao.model.UserPasswordDO;
import com.doshin.service.user.model.GroupVO;
import com.doshin.service.user.model.RightVO;
import com.doshin.service.user.model.UserVO;

@Service("userBao")
@Transactional
public class UserBaoImpli implements UserBao {

	@Autowired
	UserDao userDao;

	public UserVO save(UserVO user) {
		UserDO userDo = getUserDoFromVo(user);
		return getUserVoFromDo(userDao.save(userDo));
	}

	public void update(UserVO user) {
		UserDO userDo = new UserDO();
		BeanUtils.copyProperties(user, userDo);
		userDao.update(userDo);

	}

	public void delete(UserVO user) {
		UserDO userDo = getUserDoFromVo(user);
		userDao.delete(userDo);

	}

	public UserVO findByUserId(Integer userId) {
		UserDO userDo = userDao.findByUserId(userId);
		UserVO userVo = getUserVoFromDo(userDo);
		return userVo;
	}

	private UserVO getUserVoFromDo(UserDO userDo) {
		UserVO userVo = new UserVO();
		BeanUtils.copyProperties(userDo, userVo);
		BeanUtils.copyProperties(userDo.getUserPassword(), userVo.getUserPassword());
		List<GroupVO> groupList = new ArrayList<GroupVO>();
		if (userDo.getGroupList() != null)
			for (GroupDO source : userDo.getGroupList()) {
				GroupVO target = new GroupVO();
				BeanUtils.copyProperties(source, target);

				if (source.getRightList() != null) {
					List<RightVO> rightList = new ArrayList<RightVO>();
					for (RightDO sourceR : source.getRightList()) {
						RightVO targetR = new RightVO();
						BeanUtils.copyProperties(sourceR, targetR);
						rightList.add(targetR);
					}
					target.setRightList(rightList);
				}
				groupList.add(target);
			}
		userVo.setGroupList(groupList);
		return userVo;
	}

	private UserDO getUserDoFromVo(UserVO user) {
		UserDO userDo = new UserDO();
		UserPasswordDO userPasswordDO = new UserPasswordDO();
		BeanUtils.copyProperties(user.getUserPassword(), userPasswordDO);
		BeanUtils.copyProperties(user, userDo);
		userDo.setUserPassword(userPasswordDO);
		List<GroupDO> groupList = new ArrayList<GroupDO>();
		if (user.getGroupList() != null)
			for (GroupVO source : user.getGroupList()) {
				GroupDO target = new GroupDO();
				BeanUtils.copyProperties(source, target);
				if (source.getRightList() != null) {
					List<RightDO> rightList = new ArrayList<RightDO>();
					for (RightVO sourceR : source.getRightList()) {
						RightDO targetR = new RightDO();
						BeanUtils.copyProperties(sourceR, targetR);
						rightList.add(targetR);
					}
					target.setRightList(rightList);
				}
				groupList.add(target);
			}
		userDo.setGroupList(groupList);
		return userDo;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
