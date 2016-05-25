package com.up.auth.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.up.auth.dao.IUserEntityDao;
import com.up.model.UserEntity;

/**
 * IUserDao接口的实现
 * 实际上这两个文件也可以命名为IUserRepository和UserRepository，因为都是用了Repository的Annotation
 * @author tyche
 *
 */
@Repository
@Transactional
public class UserEntityDao implements IUserEntityDao {
	
	/**
	 * 获取在Application.java文件当中的Bean，调用UserDao中的函数时该对象会自动的生成
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 相当于insert语句，在数据库中创建一个新的User
	 */
	@Override
	public void save(UserEntity user) {
		sessionFactory.getCurrentSession().save(user);
	}

	/**
	 * select * from User where username=?，返回结果中的第一个对象
	 */
	@SuppressWarnings("unchecked")
	@Override
	public UserEntity findByUserName(String username) {
		List<UserEntity> users = new ArrayList<UserEntity>();

		users = sessionFactory.getCurrentSession()
			.createQuery("from User where username=?")
			.setParameter(0, username)
			.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserEntity findByName(String name) {
		List<UserEntity> users = new ArrayList<UserEntity>();

		users = sessionFactory.getCurrentSession()
			.createQuery("from User where name=?")
			.setParameter(0, name)
			.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}
}
