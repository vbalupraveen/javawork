package com.ulab.BankAOP;

import org.springframework.beans.factory.annotation.Autowired;

public class AccountService {
private Checkings checkings;
private Savings savings;
public Checkings getCheckings() {
	return checkings;
}
@Autowired
public void setCheckings(Checkings checkings) {
	this.checkings = checkings;
}
public Savings getSavings() {
	return savings;
}
@Autowired
public void setSavings(Savings savings) {
	this.savings = savings;
}

}
