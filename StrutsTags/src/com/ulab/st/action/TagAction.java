package com.ulab.st.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.util.SubsetIteratorFilter.Decider;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.location.Location;
import com.ulab.st.model.Book;

@Results(value = { @Result(name = "success", location = "/test.jsp"),
		@Result(name = "bookSuccess", location = "/book.jsp"),
		@Result(name = "index", location = "/ui.jsp"),
		@Result(name = "results", location = "/results.jsp") })
public class TagAction extends ActionSupport {
	private List<String> numbers = new ArrayList<String>();
	private List<String> values = new ArrayList<String>();

	public void setValues(List<String> values) {
		this.values = values;
	}

	public List<String> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<String> numbers) {
		this.numbers = numbers;
	}

	@Action(value = "/tagTest")
	public String execute() {
		numbers.add("Number 2");
		numbers.add("Number 1");
		numbers.add("Number 5");
		numbers.add("Number 8");
		numbers.add("Number 4");
		numbers.add("Number 3");
		values.add("Value 7");
		values.add("Value 6");
		values.add("Value 9");
		return SUCCESS;
	}

	public Decider getNumberDecider() {
		return new Decider() {
			@Override
			public boolean decide(Object element) throws Exception {
				String number = element.toString();
				if (("Number 5").equals(number))
					return true;
				else
					return false;
			}
		};
	}

	@Action(value = "/book")
	public String bookAction() {
		return "bookSuccess";
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
