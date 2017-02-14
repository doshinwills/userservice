package com.doshin.service.user.bao;

import com.doshin.service.user.model.UserVO;

public interface UserBao {
	
	void save(UserVO user);
	void update(UserVO user);
	void delete(UserVO user);
	UserVO findByUserId(Integer userId);

}
