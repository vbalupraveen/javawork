package com.ulab.BankAOP;

public class Savings{
private Integer accno;
public Integer getAccno() {
	return accno;
}
public void setAccno(Integer accno) {
	this.accno = accno;
}

public String printAccoNo(String name) {
	Integer exception=Integer.parseInt(name);
	System.out.println("executing target or printAccoNo()...");
	return "Dear "+name+" your Savings Account Number is:"+accno;
}
}
