package com.up.weibo.service;

import java.util.List;

import com.up.model.WeiboEntity;

public interface IWeiboService {
	public void publish(String username, String content);
	public List<WeiboEntity> getWeiboByUsername(String username);
	public Long getWeiboAmount(String username);
	public List<WeiboEntity> getAllWeibo();
}
