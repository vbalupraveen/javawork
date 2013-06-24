package net.ulab.strutsadv.service;

import net.ulab.strutsadv.dao.UserDaoImpl;
import net.ulab.strutsadv.model.User;

public class LoginService {
	public boolean authenticateUser(User user) {
		UserDaoImpl userDao = new UserDaoImpl();

		try {
			User myUser = userDao.getUser(user.getUserName());
			if (user.getPassWord().equals(myUser.getPassWord()))
				return true;
			else
				return false;
		} catch (Exception e) {
			System.out.println("Exception is getting User");
			return false;
		}
	}
}
