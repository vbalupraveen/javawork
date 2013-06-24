package com.ulab.sr.action;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.ulab.sr.service.RegisterService;

@Results(value = {
		@Result(name = "success", location = "/views/regSuccess.jsp"),
		@Result(name = "regError", location = "/views/regError.jsp"),
		@Result(name = "input", location = "/views/register.jsp") })
@ExceptionMappings({ @ExceptionMapping(exception = "java.lang.NullPointerException", result = "/views/regError.jsp", params = {
		"param", "valueIfMappingNotPossible" }) })
public class RegisterAction extends ActionSupport {
	String userName;
	String passWord;
	String rePassWord;

	/*
	 * validator annotation not working
	 * 
	 * @RequiredFieldValidator(message = "User Name must not be empty.",
	 * fieldName = "userName", type = ValidatorType.FIELD)
	 */
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getRePassWord() {
		return rePassWord;
	}

	public void setRePassWord(String rePassWord) {
		this.rePassWord = rePassWord;
	}

	@Override
	public void validate() {
		if (StringUtils.isEmpty(getUserName()) || getUserName().trim() == null)
			addFieldError("userName", "User Name must not be empty.");
		if (StringUtils.isEmpty(getPassWord()) || getPassWord().trim() == null)
			addFieldError("passWord", "Password must not be empty.");
		if (!(getPassWord().equals(getRePassWord())))
			addFieldError("rePassWord",
					"Password and Re-enter Password must be same");
	}

	@Action(value = "/register")
	public String execute() {
		RegisterService registerService = new RegisterService();
		if (registerService.checkUser(getUserName())) {
			return "regError";
		} else {
			registerService.createUser(getUserName(), getPassWord());
			return SUCCESS;
		}
	}
}
