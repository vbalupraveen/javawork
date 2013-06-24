package net.ulab.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.ulab.jdbc.model.Product;

public class JdbcDaoImpl {
	public Product getProduct(Integer productId){
	try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ulabdb","root");
	PreparedStatement pstmt=con.prepareStatement("select * from products where pid=?");
	pstmt.setInt(1, productId);
	ResultSet rs=pstmt.executeQuery();
	Product product=null;
	while (rs.next()) {
		product=new Product(rs.getInt(1),rs.getString(2));
	}
	con.close();
	pstmt.close();
	return product;
	}catch(Exception e){throw new RuntimeException(e);}
	}
}
