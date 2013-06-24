package com.ulab.SocialAppAnnotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
@Component
public class GooglePlus implements SocialHub{
	String status;
	User user;
	@Override
	public void sendConformation() {
		// TODO Auto-generated method stub
		System.out.println(user.email+" successfully registered into Google Plus");
	}
	public User getUser() {
		return user;
	}
	@Resource(name="user")
	public void setUser(User user) {
		this.user = user;
		}
}
