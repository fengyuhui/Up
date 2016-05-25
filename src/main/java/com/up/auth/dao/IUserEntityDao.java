package com.up.auth.dao;

import com.up.model.UserEntity;

public interface IUserEntityDao {
	void save(UserEntity user);
	UserEntity findByUserName(String username);
	UserEntity findByName(String name);
}
