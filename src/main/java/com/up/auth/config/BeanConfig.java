package com.up.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.up.auth.action.HelloAction;
import com.up.auth.action.RegisterAction;

/**
 * 这个文件用于配置auth功能模块当中的bean，相当于{@link http://www.tutorialspoint.com/spring/spring_bean_definition.htm}当中的xml文件的作用
 * @author tyche
 *
 */
@Configuration
public class BeanConfig {
	@Bean
	public HelloAction helloAction(){
		return new HelloAction();
	}
	
	@Bean
	public RegisterAction registerAction(){
		return new RegisterAction();
	}
	
	
}
