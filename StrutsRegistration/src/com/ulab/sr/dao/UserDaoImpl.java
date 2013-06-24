package com.ulab.sr.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ulab.sr.model.User;

public class UserDaoImpl {
	SessionFactory sessionFactory;
	Session session;
	User user;

	@SuppressWarnings("deprecation")
	public UserDaoImpl() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public User getUser(String enteredUserName) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from User u where u.userName=:username");
		query.setParameter("username", enteredUserName);
		try {
			List<User> users = query.list();
			/*
			 * if enteredUserName not found, gives array index out of bound
			 * exception
			 */
			user = users.get(0);
		} catch (Exception e) {
			session.close();
			return null;
		}
		session.close();
		return user;
	}

	public void setUser(String userName, String passWord) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			user = new User();
			user.setPassWord(passWord);
			user.setUserName(userName);
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Excepting in creating user");
		}
	}
}
