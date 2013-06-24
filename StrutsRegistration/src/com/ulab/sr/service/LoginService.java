package com.ulab.sr.service;

import com.ulab.sr.dao.UserDaoImpl;
import com.ulab.sr.model.User;

public class LoginService {
	public boolean authenticateUser(User user) {
		UserDaoImpl userDao = new UserDaoImpl();
		try {
			User myUser = userDao.getUser(user.getUserName());
			if (user.getPassWord().equals(myUser.getPassWord()))
				return true;
			else {
				return false;
			}
		} catch (java.lang.NullPointerException e) {
			System.out.println("Exception is getting User");
			return false;
		}
	}
}
