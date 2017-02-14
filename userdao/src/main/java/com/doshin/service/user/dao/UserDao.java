package com.doshin.service.user.dao;

import com.doshin.service.user.dao.model.UserDO;

public interface UserDao {

	Integer save(UserDO user);

	void update(UserDO user);

	void delete(UserDO user);

	UserDO findByUserId(Integer userId);
}
