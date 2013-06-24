package net.ulab.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.ulab.jdbc.model.Product;
@Component
public class JdbcDaoImpl_1 {
DataSource dataSource;
public Product getProduct(Integer productId){
	Connection con=null;
	try{
		con=dataSource.getConnection();	
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
public DataSource getDataSource() {
		return dataSource;
}
@Autowired
public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
