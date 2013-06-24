package com.ulab.BankAOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("BankAOP.xml");
		AccountService accountService=(AccountService) context.getBean("accountService");
		System.out.println(accountService.getSavings().printAccoNo("Balu"));
		//accountService.getSavings().setAccno(996668961);
		//System.out.println(accountService.getCheckings().getAccno());
	}
}
