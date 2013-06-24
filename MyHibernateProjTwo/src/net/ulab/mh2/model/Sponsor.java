package net.ulab.mh2.model;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Sponsor {
	@Id @GeneratedValue
	Integer sid;
	String sname;
	
	@OneToMany//creates a new table Sponsor_Award to join both tables
	@JoinTable(name="sponsor_award",joinColumns=@JoinColumn(name="sponsor_id"),
	inverseJoinColumns=@JoinColumn(name="award_id"))
	private Collection<Award> listOfAwards=new ArrayList<Award>();
	public Collection<Award> getListOfAwards() {
		return listOfAwards;
	} 
	public void setListOfAwards(Collection<Award> listOfAwards) {
		this.listOfAwards = listOfAwards;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
}
