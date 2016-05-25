package com.up.auth.service;

import com.up.model.UserEntity;

public interface IUserService {
	UserEntity loadUserByUsername(String username);
	boolean register(String username, String password); 
}
