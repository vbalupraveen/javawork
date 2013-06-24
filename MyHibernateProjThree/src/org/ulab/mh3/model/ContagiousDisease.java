package org.ulab.mh3.model;

import javax.persistence.Entity;

@Entity
public class ContagiousDisease extends Disease{
	String infectionType;

	public String getInfectionType() {
		return infectionType;
	}

	public void setInfectionType(String infectionType) {
		this.infectionType = infectionType;
	}
	
}
