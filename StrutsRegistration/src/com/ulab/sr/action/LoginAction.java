package com.ulab.sr.action;

/*
 Required files for annotations
 struts2-convention-plugin-x.y.z.jar
 asm-x.y.jar
 asm-commons-x.y.jar
 */
import org.apache.commons.lang.StringUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ulab.sr.model.User;
import com.ulab.sr.service.LoginService;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Results(value = { @Result(name = "success", location = "/views/success.jsp"),
		@Result(name = "login", location = "/views/login.jsp"),
		@Result(name = "input", location = "/views/login.jsp") })
public class LoginAction extends ActionSupport implements ModelDriven<User> {
	User user = new User();

	@Override
	public void validate() {
		
		if (StringUtils.isEmpty(user.getUserName())
				|| user.getUserName().trim() == null)
			addFieldError("userName", "User Name must not be empty.");
		if (StringUtils.isEmpty(user.getPassWord())
				|| user.getPassWord().trim() == null)
			addFieldError("passWord", "Password must not be empty.");
	}

	@Action(value = "/login")
	public String execute() {
		LoginService loginService = new LoginService();
		if (loginService.authenticateUser(user))
			return SUCCESS;
		else
			return LOGIN;
	}

	@Override
	public User getModel() {
		return user;
	}
}
