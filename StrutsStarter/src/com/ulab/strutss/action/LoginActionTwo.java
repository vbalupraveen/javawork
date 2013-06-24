package com.ulab.strutss.action;

import org.apache.commons.lang.StringUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.ulab.strutss.model.User;
import com.ulab.strutss.service.LoginService;

public class LoginActionTwo extends ActionSupport {

	private static final long serialVersionUID = 1L;
	User user;
	LoginService loginService = new LoginService();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		System.out.println("Setting User");
		this.user = user;
	}

/*	@Override
	public void validate() {

		if (StringUtils.isEmpty(user.getUserName()))
			addFieldError("userName", "User Name must not be empty.");
		if (StringUtils.isEmpty(user.getPassWord()))
			addFieldError("passWord", "Password must not be empty.");
		System.out.println("Validated in Login action class");
	}
*/
	/* method to be executed instead "execute()" */
	public String getResult() {
		System.out.println("LoginAction-->getResult()");
		if (loginService.authenticateUser(user)) {
			return SUCCESS;
		} else
			return LOGIN;
	}

	public String execute() {
		System.out.println("LoginAction-->execute()");
		String forward = getResult();
		return forward;
	}
}
