package com.doshin.service.user.dao;

import com.doshin.service.user.dao.model.UserDO;

public interface UserDao {

	void save(UserDO user);

	void update(UserDO user);

	void delete(UserDO user);

	UserDO findByUserId(Integer userId);
}
