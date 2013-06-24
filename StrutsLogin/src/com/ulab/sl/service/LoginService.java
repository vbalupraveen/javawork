package com.ulab.sl.service;

import com.ulab.sl.dao.UserDaoImpl;
import com.ulab.sl.model.User;

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
