package com.ulab.st.action;

import java.util.ArrayList;
import java.util.Collection;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@Results(value = { @Result(name = "index", location = "/ui.jsp"),
		@Result(name = "results", location = "/results.jsp") })
public class UITagAction extends ActionSupport {

	Collection<String> genderList;
	Collection<String> fieldsList;
	String gender;
	String field;

	public Collection<String> getFieldsList() {
		return fieldsList;
	}

	public void setFieldsList(Collection<String> fieldsList) {
		this.fieldsList = fieldsList;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Collection<String> getGenderList() {
		return genderList;
	}

	public void setGenderList(Collection<String> genderList) {
		this.genderList = genderList;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public UITagAction() {
		genderList = new ArrayList<String>();
		fieldsList = new ArrayList<String>();
		genderList.add("male");
		genderList.add("female");
		genderList.add("don't wish to disclose");
		fieldsList.add("Engineer");
		fieldsList.add("IT");
		fieldsList.add("Management");
		fieldsList.add("Sales");
		fieldsList.add("Adminstrator");
		fieldsList.add("Education");
		fieldsList.add("Other");
	}

	@Action(value = "/index")
	public String indexAction() {
		return "index";
	}

	@Action(value = "/results")
	public String resultsAction() {
		return "results";
	}
}
