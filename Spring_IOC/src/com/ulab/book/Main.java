package com.ulab.book;

import java.util.List;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//POJO no new ...() and no implements
public class Main {
	public static void main(String[] args) {
	//ServiceProviderFrameWork beanFactory=new ServiceProviderFrameWork();
	BeanFactory beanFactory=new ClassPathXmlApplicationContext("BookApplicationContext.xml");
	//BookReader client = beanFactory.getServiceProviderFrameWork();
	BookReader client = (BookReader) beanFactory.getBean("bookReaderBean");
	

	
	
	List<Book> books = client.read();
	System.out.printf("Client read: %s books%n",books.size());
	}
	}