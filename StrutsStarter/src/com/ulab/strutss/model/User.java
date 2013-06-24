package com.ulab.strutss.model;

public class User {
	String userName;
	String passWord;
	public String getUserName() {
		System.out.println("Getting User Name");
		return userName;
	}
	public void setUserName(String userName) {
		System.out.println("Setting User Name");
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
}
