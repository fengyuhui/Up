package com.up.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.up.auth.dao.IUserEntityDao;
import com.up.auth.service.IUserService;
import com.up.model.UserEntity;

@Service("userService")
public class UserService implements IUserService {

	@Autowired
	private IUserEntityDao userDao;
	
	@Override
	public UserEntity loadUserByUsername(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public boolean register(String username, String password) {
		UserEntity user=new UserEntity();
		user.setUsername(username);
		user.setPasswordHash(password);
		if(userDao.findByUserName(username) == null){
			try{
				userDao.save(user);
				return true;
			}
			catch(Exception e){
				return false;
			}
		}
		else return false;
	}

}