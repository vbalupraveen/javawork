package net.ulab.strutsadv.dao;

import net.ulab.strutsadv.model.User;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserDaoImpl {
	SessionFactory sessionFactory;
	Session session;

	@SuppressWarnings("deprecation")
	public UserDaoImpl() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public User getUser(String userName) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from User u where u.userName=:username");
		query.setParameter("username", "bcvattem");
		List<User> users = query.list();
		User user = users.get(0);
		session.close();
		return user;
	}
}
