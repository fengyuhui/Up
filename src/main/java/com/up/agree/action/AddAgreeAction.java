package com.up.agree.action;

import java.util.Date;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.ActionSupport;
import com.up.agree.service.IAgreeService;

@SuppressWarnings("serial")
public class AddAgreeAction extends ActionSupport {
	/**
	 * 新增点赞
	 */
	private int user_id;
	private String user_name;
	private int weibo_id;
	private Timestamp time;
	
	/**
	 * 获取agreeService对象
	 */
	@Autowired
	IAgreeService agreeService;
	
	public String getUserName() {
		return user_name;
	}
	
	public void setUserName(String name) {
		this.user_name = name;
	}
	
	public int getUserID() {
		return user_id;
	}

	public void setUserID(int id) {
		this.user_id = id;
	}
	
	public int getWeiboID() {
		return weibo_id;
	}

	public void setWeiboID(int id) {
		this.weibo_id = id;
	}
	
	public Timestamp getTime() {
		return time;
	}
	public void setTime(){
		Date date = new Date();      
		this.time = new Timestamp(date.getTime());
	}
	
	@Override
	public String execute() throws Exception{
		if(agreeService.addAgree(getUserID(), getWeiboID(),  getTime()))
			return SUCCESS;
		return INPUT;
	}
}
