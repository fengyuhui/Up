package com.up.weibo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.up.weibo.action.AllWeiboAction;
import com.up.weibo.action.MyWeiboAction;
import com.up.weibo.action.PublishAction;

@Configuration
public class WeiboBeanConfig {
	@Bean
	public PublishAction publishAction(){
		return new PublishAction();
	}
	
	@Bean
	public MyWeiboAction myWeiboAction(){
		return new MyWeiboAction();
	}
	
	@Bean
	public AllWeiboAction allWeiboAction(){
		return new AllWeiboAction();
	}
}
