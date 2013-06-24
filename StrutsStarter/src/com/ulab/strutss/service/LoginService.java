package com.ulab.strutss.service;

import com.ulab.strutss.model.User;

public class LoginService {
	public boolean authenticateUser(User user) {
		System.out.println("Evaluating user in LoginService");
		if (user.getUserName().equals("balu")
				&& user.getPassWord().equals("1234"))
			return true;
		else
			return false;
	}
}
