package com.ulab.SocialAppAnnotation;

public class FaceBook implements SocialHub{
	String status;
	User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void sendConformation() {
		// TODO Auto-generated method stub
		System.out.println(user.email+" successfully registered into Facebook");
	}
}
