package com.up.auth.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.opensymphony.xwork2.ActionSupport;
import com.up.auth.service.IUserService;
import com.up.model.UserEntity;


@SuppressWarnings("serial")
public class RegisterAction extends ActionSupport{
	/**
	 * 
	 */
	private String username;
	private String password;
	private String confirmPassword;
	
	/**
	 * 获取userService对象
	 */
	@Autowired
	IUserService userService;
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}
	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception{
		if(getUsername()==null&&getPassword()==null)return INPUT;
		if(userService.register(getUsername(), getPassword()))return SUCCESS;
		return INPUT;
	}
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#validate()
	 */
	@Override
	public void validate(){
		if(getUsername()==null||getPassword()==null||getConfirmPassword()==null)return;
		if(getUsername().length()==0){
			addFieldError("username", "Username is required.");
		}
		if(getPassword().length()==0){
			addFieldError("password", "Password is required.");
		}
		if(getConfirmPassword().length()==0){
			addFieldError("confirmPassword", "Confirmed password is required.");
		}
		if(!(getPassword().equals(getConfirmPassword()))){
			addFieldError("confirmPassword", "Confirmed password is not the same as password.");
		}
		super.validate();
	}
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#input()
	 */
	@Override
	public String input() throws Exception {
		return super.input();
	}
}
	