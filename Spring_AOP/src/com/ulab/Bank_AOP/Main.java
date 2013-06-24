package com.ulab.Bank_AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("Bank_AOP.xml");
		AccountService accountService=(AccountService) context.getBean("accountService");
		//System.out.println(accountService.getSavings().printAccoNo("1234"));
		System.out.println("---"+accountService.getCheckings().printAccoNo("1234")+"---");	
	}
}
