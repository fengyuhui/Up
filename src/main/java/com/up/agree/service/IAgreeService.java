package com.up.agree.service;

import java.sql.Timestamp;

public interface IAgreeService {
	
	boolean addAgree(int weibo_id, int user_id, Timestamp timestamp); //点赞
	boolean cancelAgree(int weibo_id, int user_id); //取消点赞
}


