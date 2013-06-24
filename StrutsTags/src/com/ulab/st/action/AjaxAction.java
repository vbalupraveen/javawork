package com.ulab.st.action;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@Results(value = {
		@Result(name = "search", location = "/ajaxresults/search.jsp"),
		@Result(name = "ajaxResult", location = "/ajaxresults/success.jsp") })
public class AjaxAction extends ActionSupport{
	String yourFavWebFramework;
	Collection<String> webframeworks;
	
	public AjaxAction() {
		webframeworks=new ArrayList<String>();
		webframeworks.add("Spring MVC");
		webframeworks.add("Struts 1.x");
		webframeworks.add("Struts 2.x");
		webframeworks.add("JavaServer Faces (JSF)");
		webframeworks.add("Google Web Toolkit (GWT)");
		webframeworks.add("Apache Wicket");
		webframeworks.add("Apache Click");
		webframeworks.add("Apache Hadoop");
		webframeworks.add("Apache Cocoon");
		webframeworks.add("JBoss Seam");
		webframeworks.add("Stripes");
		webframeworks.add("Apache Tapestry");
		webframeworks.add("Others");
	}
	
	public String getYourFavWebFramework() {
		return yourFavWebFramework;
	}
	public void setYourFavWebFramework(String yourFavWebFramework) {
		this.yourFavWebFramework = yourFavWebFramework;
	}
	public Collection<String> getWebframeworks() {
		return webframeworks;
	}
	public void setWebframeworks(Collection<String> webframeworks) {
		this.webframeworks = webframeworks;
	}
	@Action(value="/search")
	public String execute(){
		return "search";
	}
}
