package net.ulab.mh2.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Movie {
@Id @GeneratedValue(strategy=GenerationType.AUTO)
private Integer mid;
private String mname;
@ManyToMany(cascade=CascadeType.ALL)//creates Movie_Award table to join Movie and Awards
@JoinTable(name="Movie_Award",joinColumns=@JoinColumn(name="movieid"),inverseJoinColumns=@JoinColumn(name="awardid"))
private Collection<Award> listOfAwards=new ArrayList<Award>();
public Collection<Award> getListOfAwards() {
	return listOfAwards;
} 
public void setListOfAwards(Collection<Award> listOfAwards) {
	this.listOfAwards = listOfAwards;
}
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

}
