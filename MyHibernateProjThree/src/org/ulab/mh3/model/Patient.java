package org.ulab.mh3.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Patient {
	@Id @GeneratedValue
	Integer patientId;
	String patientName;
	@OneToMany(cascade=CascadeType.ALL)
	Collection<Disease> listOfDiseases=new ArrayList<Disease>();
	
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public Collection<Disease> getListOfDiseases() {
		return listOfDiseases;
	}
	public void setListOfDiseases(Collection<Disease> listOfDiseases) {
		this.listOfDiseases = listOfDiseases;
	}

}
