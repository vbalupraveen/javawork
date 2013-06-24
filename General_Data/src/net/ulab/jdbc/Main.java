package net.ulab.jdbc;

import net.ulab.jdbc.dao.JdbcDaoImpl;
import net.ulab.jdbc.model.Product;

public class Main {
	public static void main(String[] args) {
		Product product=(Product)new JdbcDaoImpl().getProduct(356);
		System.out.println("Product ID:"+product.getProductId());
		System.out.println("Product Name:"+product.getProductName());
	}
}
