package com.ulab.strutss.action;

import org.apache.commons.lang.StringUtils;

import com.opensymphony.xwork2.ActionSupport;

public class LoginActionOne extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	String userName;
	String passWord;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	@Override
	public void validate() {
		System.out.println("Hello this is validate Login action class");
		if(StringUtils.isEmpty(getUserName()))
			addFieldError("userName", "User Name must not be empty.");
		if(StringUtils.isEmpty(getPassWord()))
			addFieldError("passWord", "Password must not be empty.");
	}
	/*method to be executed instead "execute()"*/
	public String getResult(){
		System.out.println("Hello this is Login action class getResult()");
		System.out.println(getUserName());
		if (getUserName().equals("balu") && getPassWord().equals("1234")) {
			return SUCCESS;
		} else
			return LOGIN;
	}
	public String execute() {
		System.out.println("Hello this is Login action class execute()");
		String forward=getResult();
		return forward;
	}
}
