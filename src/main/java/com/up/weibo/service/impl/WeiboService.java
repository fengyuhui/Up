package com.up.weibo.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.up.dao.IBaseDao;
import com.up.model.UserEntity;
import com.up.model.WeiboEntity;
import com.up.weibo.service.IWeiboService;

@Service("weiboService")
public class WeiboService implements IWeiboService {
	
	@Autowired
	private IBaseDao<WeiboEntity> weiboDao;
	
	@Autowired
	private IBaseDao<UserEntity> userDao;

	@Override
	public void publish(String username, String content) {
		List<Object> param = new ArrayList<Object>();
		param.add(username);
		UserEntity user = userDao.get("from UserEntity where username=?", param);
		WeiboEntity weibo = new WeiboEntity();
		weibo.setUserEntity(user);
		weibo.setTime(new Timestamp(new Date().getTime()));
		weibo.setContent(content);
		weiboDao.save(weibo);
	}

	@Override
	public List<WeiboEntity> getWeiboByUsername(String username) {
		List<Object> param = new ArrayList<Object>();
		param.add(username);
		return weiboDao.find("select w from WeiboEntity w join w.userEntity u where u.username=? order by w.time", param);
	}

	@Override
	public Long getWeiboAmount(String username) {
		List<Object> param = new ArrayList<Object>();
		param.add(username);
		return weiboDao.count("select count(w) from WeiboEntity w join w.userEntity u where u.username=?", param);
	}

	@Override
	public List<WeiboEntity> getAllWeibo() {
		return weiboDao.find("from WeiboEntity");
	}

}
