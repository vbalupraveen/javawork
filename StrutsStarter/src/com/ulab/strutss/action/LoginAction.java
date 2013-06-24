package com.ulab.strutss.action;

import org.apache.commons.lang.StringUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ulab.strutss.model.User;
import com.ulab.strutss.service.LoginService;

public class LoginAction extends ActionSupport implements ModelDriven<User>{
	
	private static final long serialVersionUID = 1L;
	User user=new User();
	LoginService loginService=new LoginService();
	@Override
	public void validate() {
		
		if(StringUtils.isEmpty(user.getUserName()))
			addFieldError("userName", "User Name must not be empty.");
		if(StringUtils.isEmpty(user.getPassWord()))
			addFieldError("passWord", "Password must not be empty.");
		System.out.println("Validated in Login action class");
	}
	/*method to be executed instead "execute()"*/
	public String getResult(){
		System.out.println("LoginAction-->getResult()");
		if (loginService.authenticateUser(user)) {
			return SUCCESS;
		} else
			return LOGIN;
	}
	public String execute() {
		System.out.println("LoginAction-->execute()");
		String forward=getResult();
		return forward;
	}
	@Override
	public User getModel() {
		System.out.println("LoginAction-->getModel() of ModelDriven");
		return user;
	}
}
