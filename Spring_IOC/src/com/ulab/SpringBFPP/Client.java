package com.ulab.SpringBFPP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//AbstractApplicationContext context=new ClassPathXmlApplicationContext("MyBeanFactoryPostProcessor.xml");
		ApplicationContext context=new ClassPathXmlApplicationContext("MyBeanFactoryPostProcessor.xml");
		Computer computer=(Computer) context.getBean("computerBean");
		computer.printProperties();
		//context.registerShutdownHook();
	}

}
