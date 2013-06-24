package com.ulab.myhibernate.dao;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ulab.myhibernate.model.Movie;
import com.ulab.myhibernate.model.Review;

public class MovieDaoImpl {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration .buildSessionFactory();
		Session hsession = sessionFactory.openSession();
		hsession.beginTransaction();
		
		Movie movie = new Movie();
		Review imdb=new Review();
		imdb.setWesSite("imdb");
		imdb.setRating(7.0);
		Review rot=new Review();
		rot.setRating(6.5);
		rot.setWesSite("Rotten Tomatos");
		
		movie.setMname("Inland Empire");
		movie.setYear(2006);
		movie.setGenre("Thriller");
		movie.setDateAdded(new Date(0));
		movie.getListOfReviews().add(rot);
		movie.getListOfReviews().add(imdb);
		
		hsession.save(movie);
		hsession.getTransaction().commit();
		hsession.close();
		//get data
		hsession=sessionFactory.openSession();
		hsession.beginTransaction();
		movie=(Movie) hsession.get(Movie.class, 10);
		System.out.println(movie.getMname()+"("+movie.getYear()+")");
		System.out.println(movie.getListOfReviews().size());
		hsession.close();
	}
}
