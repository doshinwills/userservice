package com.doshin.service.user.bao.impl;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doshin.service.user.bao.UserBao;
import com.doshin.service.user.dao.UserDao;
import com.doshin.service.user.dao.model.UserDO;
import com.doshin.service.user.model.UserVO;

@Service("userBao")
@Transactional
public class UserBaoImpli implements UserBao {

	@Autowired
	UserDao userDao;

	public void save(UserVO user) {
		UserDO userDo = new UserDO();
		BeanUtils.copyProperties(user, userDo);
		userDao.save(userDo);

	}

	public void update(UserVO user) {
		UserDO userDo = new UserDO();
		BeanUtils.copyProperties(user, userDo);
		userDao.update(userDo);

	}

	public void delete(UserVO user) {
		UserDO userDo = new UserDO();
		BeanUtils.copyProperties(user, userDo);
		userDao.delete(userDo);

	}

	public UserVO findByUserId(Integer userId) {
		UserDO userDo = userDao.findByUserId(userId);
		UserVO userVo = new UserVO();
		BeanUtils.copyProperties(userDo, userVo);
		return userVo;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
