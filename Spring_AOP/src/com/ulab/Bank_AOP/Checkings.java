package com.ulab.Bank_AOP;

public class Checkings{
	private Integer accno;
public Integer getAccno() {
	return accno;
}
public void setAccno(Integer accno) {
	System.out.println("----------------------------------");
	this.accno = accno;
}
@Loggable
public String printAccoNo(String name) {
	System.out.println("executing target or printAccoNo(..) in Checking");
return "Dear "+name+" your Checkings Account Number is:"+accno;
}
}
