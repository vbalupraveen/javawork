package org.ulab.mh3.model;

import javax.persistence.Entity;

@Entity
public class NonContagiousDisease extends Disease{
	String diseaseType;

	public String getDiseaseType() {
		return diseaseType;
	}

	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}
	
}
