package com.up.agree.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.up.agree.dao.IAgreeEntityDao;
import com.up.agree.service.IAgreeService;
import com.up.model.AgreeEntity;
import java.sql.Timestamp;

@Service("agreeService")
public class AgreeService implements IAgreeService{
	
	@Autowired
	private IAgreeEntityDao agreeDao;

	@Override
	public boolean addAgree(int user_id, int weibo_id, Timestamp timestamp) {
		AgreeEntity agree = new AgreeEntity();	
		try{
			agreeDao.save(agree);
			agreeDao.increaseAgreenum(weibo_id);
			return true;
		}
		catch(Exception e){
		return false;
		}
	}
	
	public boolean cancelAgree(int weibo_id, int user_id) {
		AgreeEntity agree = new AgreeEntity();	
		try{
			agreeDao.cancel(weibo_id, user_id);
			agreeDao.decreaseAgreenum(weibo_id);
			return true;
		}
		catch(Exception e){
		return false;
		}
	}
	
	
	
	
}
