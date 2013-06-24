package com.ulab.BankAOP;

public class Checkings{
	private Integer accno;
public Integer getAccno() {
	return accno;
}
public void setAccno(Integer accno) {
	this.accno = accno;
}

public String printAccoNo(String name) {
return "Dear "+name+" your Checkings Account Number is:"+accno;
}
}
