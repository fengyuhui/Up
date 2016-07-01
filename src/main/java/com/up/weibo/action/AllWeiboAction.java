package com.up.weibo.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.up.model.WeiboEntity;
import com.up.weibo.service.IWeiboService;

public class AllWeiboAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IWeiboService weiboService;
	
	private List<WeiboEntity> weiboList;


	public List<WeiboEntity> getWeiboList() {
		return weiboList;
	}

	public void setWeiboList(List<WeiboEntity> weiboList) {
		this.weiboList = weiboList;
	}

	@Override
	public String execute() throws Exception {
		weiboList = weiboService.getAllWeibo();
		return SUCCESS;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}
	
	
}
