package com.ulab.sl.action;

import com.opensymphony.xwork2.ActionSupport;
import com.ulab.sl.model.User;
import com.ulab.sl.service.LoginService;

public class LoginAction extends ActionSupport {

	User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public String execute() {
		LoginService loginService = new LoginService();
		if (loginService.authenticateUser(user))
			return SUCCESS;
		else
			return LOGIN;
	}
}
