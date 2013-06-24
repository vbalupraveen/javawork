package com.ulab.sr.service;

import com.ulab.sr.dao.UserDaoImpl;

public class RegisterService {
	UserDaoImpl daoImpl;

	public RegisterService() {
		daoImpl = new UserDaoImpl();
	}

	public void createUser(String userName, String passWord) {
		daoImpl = new UserDaoImpl();
		daoImpl.setUser(userName, passWord);
	}

	public Boolean checkUser(String userName){
		if (daoImpl.getUser(userName) == null){
			return false;
		}
		else
			return true;
	}
}
