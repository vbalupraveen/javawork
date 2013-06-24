package org.ulab.mh3.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.ulab.mh3.model.ContagiousDisease;
import org.ulab.mh3.model.Disease;
import org.ulab.mh3.model.NonContagiousDisease;
import org.ulab.mh3.model.Patient;

public class Client {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Disease conDisease=new ContagiousDisease();
		Disease nconDisease=new NonContagiousDisease();
		Patient patient=new Patient();
		
		patient.setPatientName("Balu");
		nconDisease.setDiseaseName("Non Contagious");
		((NonContagiousDisease) nconDisease).setDiseaseType("Mental");
		conDisease.setDiseaseName("Contagious");
		((ContagiousDisease) conDisease).setInfectionType("Bite");
		patient.getListOfDiseases().add(nconDisease);
		patient.getListOfDiseases().add(conDisease);
		session.save(patient);
		session.getTransaction().commit();
		
		/*Getting Data using Criteria*/
		
		/*--------Basic Criteria
		Criteria criteria1=session.createCriteria(Patient.class);
		//defining desired criteria(OR) 
		criteria1.add(Restrictions.eq("patientId", 1)).add(Restrictions.or(Restrictions.eq("patientName", "Balu")));
		---------------------*/
		
		/*----------Projection---------------*/
		 //Grouping the "diseaseName" Property using Projections		 
		 Criteria criteria2=session.createCriteria(Disease.class).setProjection(Projections.property("diseaseName"));
		 List<String> diseases=criteria2.list();
		 for(String afflication:diseases)
		 System.out.println("---"+afflication);
		 		 
		/*----------Example Class------------*/
		Patient examplePatient=new Patient();//creating example object
		examplePatient.setPatientId(1);
		examplePatient.setPatientName("Balu");
		Example example=Example.create(examplePatient);//adding to example class
		Criteria criteria3=session.createCriteria(Patient.class).add(example);//ask hibernate to find it
		
		java.util.List<Patient> results=(List<Patient>)criteria3.list();
		for(Patient patron:results)
		System.out.println(patron.getPatientName());
		
		
		session.close();
		
	}

}
