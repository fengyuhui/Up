package com.up.agree.dao;

import java.util.List;
import com.up.model.AgreeEntity;

public interface IAgreeEntityDao {
	public void save(AgreeEntity agree);
	public void cancel(int weibo_id, int user_id);
	public void increaseAgreenum(int weibo_id);
	public void decreaseAgreenum(int weibo_id);
	List<AgreeEntity> findByWeiboID(int weibo_id);	
}
