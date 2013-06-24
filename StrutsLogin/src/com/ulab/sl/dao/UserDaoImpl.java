package com.ulab.sl.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ulab.sl.model.User;

public class UserDaoImpl {
	SessionFactory sessionFactory;
	Session session;

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
		List<User> users = query.list();
		/*
		 * if enteredUserName not found, gives array index out of bound
		 * exception
		 */
		User user = users.get(0);
		session.close();
		return user;
	}
}
