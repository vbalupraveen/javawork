package net.ulab.mh2.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Award {
@Id @GeneratedValue(strategy=GenerationType.AUTO)
Integer aid;
String aname;
@ManyToMany(mappedBy="listOfAwards")
Collection<Movie> listOfMovies=new ArrayList<Movie>();
@ManyToOne
Sponsor sponsor;

public Sponsor getSponsor() {
	return sponsor;
}
public void setSponsor(Sponsor sponsor) {
	this.sponsor = sponsor;
}

public Collection<Movie> getListOfMovies() {
	return listOfMovies;
}
public void setListOfMovies(Collection<Movie> listOfMovies) {
	this.listOfMovies = listOfMovies;
}
public Integer getAid() {
	return aid;
}
public void setAid(Integer aid) {
	this.aid = aid;
}
public String getAname() {
	return aname;
}
public void setAname(String aname) {
	this.aname = aname;
}

}
