package com.ulab.SpringIoc_2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("shapeApplicationContext_2.xml");
		//ServiceProvider context=new ServiceProvider();
		Draw drawBean=(Draw) context.getBean("drawBean"); 
		Shape shape=drawBean.getType();
		System.out.println("The is "+shape.getClass().getName());
	}

}
