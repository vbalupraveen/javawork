package com.ulab.SpringIoc_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("shapeApplicationContext_1.xml");
		Shape shape=(Shape) context.getBean("typeBean"); 
		shape.draw();
		System.out.println("The area of "+shape.getClass().getName()+" "+shape.area());
	}

}
