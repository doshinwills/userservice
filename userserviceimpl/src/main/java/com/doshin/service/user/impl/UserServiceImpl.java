package com.doshin.service.user.impl;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import com.doshin.service.user.api.UserService;
import com.doshin.service.user.bao.UserBao;
import com.doshin.service.user.model.UserVO;

@Path("/user")
public class UserServiceImpl implements UserService{

	@Autowired
	UserBao userBao;

	@Override
	public UserVO save(UserVO user) {
		return userBao.save(user);
		
	}

	@Override
	public void update(UserVO user) {
		userBao.update(user);

		
	}

	@Override
	public void delete(UserVO user) {
		userBao.delete(user);
	}

	@Override
	public UserVO findByUserId(Integer userId) {
		return userBao.findByUserId(userId);
	}



}