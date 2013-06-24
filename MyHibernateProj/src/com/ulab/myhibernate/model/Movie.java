package com.ulab.myhibernate.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "Movie")
public class Movie {
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	Integer mid;
	@Column(name = "name")
	String mname;
	String genre;
	@Temporal(TemporalType.DATE)//type of date to be displayed
	Date dateAdded;
	Integer year; 
	@ElementCollection //connect with Review class, add mid in reviews table
	@JoinTable(name="REVIEWS",joinColumns=@JoinColumn(name="MOVIE_ID")) //change join column name and table name
	@GenericGenerator(name="hi-lo",strategy="hilo")//generator
	@CollectionId(columns=@Column(name="REVIEW_ID"),generator="hi-lo",type=@Type(type="long"))//generate auto ID
	Collection<Review> listOfReviews=new ArrayList<Review>();
	
	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date date) {
		this.dateAdded = date;
	}

	public Collection<Review> getListOfReviews() {
		return listOfReviews;
	}

	public void setListOfReviews(Collection<Review> listOfReviews) {
		this.listOfReviews = listOfReviews;
	}

	
}
