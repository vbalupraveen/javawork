package com.ulab.SocialAppAnnotation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("SocialAppAnnotation.xml");
		//SocialHub social=(SocialHub) context.getBean("gBean");
		SocialHub social=(SocialHub) context.getBean("googlePlus");
		social.sendConformation();
		context.registerShutdownHook();
	}
}
