package net.ulab.mh2.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.ulab.mh2.model.Award;
import net.ulab.mh2.model.Movie;
import net.ulab.mh2.model.Sponsor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientDaoImpl {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SessionFactory sessionFactory;
		Session session;
		sessionFactory=new Configuration().configure().buildSessionFactory();
		/*
		session=sessionFactory.openSession();
		session.beginTransaction();
		Movie argo=new Movie();
		Movie lopi=new Movie();
		Award oscar=new Award();
		Award gg=new Award(); 
		Sponsor hollywood=new Sponsor();
		
		argo.setMname("Argo");
		lopi.setMname("Life of Pi");
		argo.getListOfAwards().add(oscar);
		argo.getListOfAwards().add(gg);
		argo.getListOfAwards().add(gg);
		
		oscar.setAname("Oscar");
		gg.setAname("Golden Globe");
		oscar.setSponsor(hollywood);
		gg.setSponsor(hollywood);
		oscar.getListOfMovies().add(argo);
		gg.getListOfMovies().add(argo);
		oscar.getListOfMovies().add(lopi);
		
		hollywood.setSname("Hollywood Pictures");
		hollywood.getListOfAwards().add(oscar);
		hollywood.getListOfAwards().add(gg);
		
		session.save(argo);
		session.save(lopi);
		session.save(oscar);
		session.save(gg);	//cascaded in Movie
		session.save(hollywood);
		session.getTransaction().commit();
		session.close();
		*/
/*---------------New Session to get objects----------------*/
		session=sessionFactory.openSession();
		session.beginTransaction();
		String sqlOne="select award.aname,sponsor.sname from award,sponsor where award.sponsor_sid=sponsor.sid";
		String sqlTwo="select award.aname,movie.mname from Movie as movie,Movie_Award as movie_award,Award as award where movie.mid=movie_award.movieid and award.aid=movie_award.awardid";
		String sqlThree="select a.aname,s.sname from Sponsor s inner join s.listOfAwards a";
		org.hibernate.Query query=session.createQuery(sqlThree);
		//org.hibernate.Query query=session.createSQLQuery(sqlOne);
		Iterator iterator=query.list().iterator();
		while(iterator.hasNext()){
			Object[] pair = (Object[]) iterator.next();
			System.out.println(pair[0]+"    "+pair[1]);
		}
		session.close();
		
	}
}
