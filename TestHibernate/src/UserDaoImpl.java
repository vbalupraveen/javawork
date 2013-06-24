import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserDaoImpl {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SessionFactory sessionFactory;
		Session session;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		/*User user=new User();
		user.setPassWord("1234");
		user.setUserName("ulab");
		session.save(user);
		session.getTransaction().commit();*/
		
		Query query = session
				.createQuery("from User u where u.userName=:username");
		query.setParameter("username", "bcvattem");
		List<User> users=query.list();
		System.out.println(users.get(0).getPassWord());
		}
}
