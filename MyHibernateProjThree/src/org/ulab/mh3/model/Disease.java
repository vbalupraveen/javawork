package org.ulab.mh3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)//normalized join
public class Disease {
@Id @GeneratedValue
Integer diseaseId;
String diseaseName;
public Integer getDiseaseId() {
	return diseaseId;
}
public void setDiseaseId(Integer diseaseId) {
	this.diseaseId = diseaseId;
}
public String getDiseaseName() {
	return diseaseName;
}
public void setDiseaseName(String diseaseName) {
	this.diseaseName = diseaseName;
}

}
