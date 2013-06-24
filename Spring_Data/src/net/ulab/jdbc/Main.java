package net.ulab.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.ulab.jdbc.dao.JdbcDaoImpl;
import net.ulab.jdbc.model.Product;
public class Main {
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl jdao=context.getBean("jdbcDaoImpl",JdbcDaoImpl.class);
		//System.out.println("Number of products in database:"+jdao.getProductObject(2).getProductName());
		//System.out.println("Inserting records..."+jdao.insertProduct(new Product(5,"lumina920 ")));
		//System.out.println("Total number of Products:"+jdao.getAllProducts().size());
		Product product=jdao.getProductNamedparam("oneX",4);
		System.out.println("Product ID from DB:"+product.getProductId());
		}
}
