package net.ulab.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import net.ulab.jdbc.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
@Component
public class JdbcDaoImpl {
DataSource dataSource;
JdbcTemplate jdbcTemplate;
NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//JdbcTemplate jdbcTemplate=new JdbcTemplate();removed because created a bean in spring.xml
public DataSource getDataSource() {
	System.out.println(dataSource.getClass().getName());
	return dataSource;
}
@Autowired
public void setDataSource(DataSource dataSource) {
	this.dataSource = dataSource;
}
public JdbcTemplate getJdbcTemplate() {
	return jdbcTemplate;
}
@Autowired
public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}
public Integer getProductCount(){
	/*to mention on which DataSouce we are working on
	jdbcTemplate.setDataSource(getDataSource());*/
	//above line is removed. created a JdbcTemplate bean and referenced DataSource for JdbcTemplate in spring.xml
	String sql="select count(*) from products";
	return jdbcTemplate.queryForInt(sql);
}
public Object getProductName(Integer productName){
	String sql="select PNAME from products where PID=?";
	return jdbcTemplate.queryForObject(sql, new Object[]{productName}, String.class);
	}

public Product getProductObject(Integer productId){
	String sql="select * from products where PID=?";
	return jdbcTemplate.queryForObject(sql, new Object[]{productId}, new ProductMapper());
	}

public Product getProductNamedparam(String productName,Integer productId){
	String sql="select * from products where pname=:name and pid=:id";   
	namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(this.dataSource);
	SqlParameterSource namedParameters=new MapSqlParameterSource("id",productId).addValue("name", productName);
	return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, new ProductMapper());
}

public List<Product> getAllProducts(){
	String sql="select * from products";
	return jdbcTemplate.query(sql,new ProductMapper());
}
public Object insertProduct(Product product){
	String sql="insert into products values(?,?)";
	return jdbcTemplate.update(sql, new Object[]{product.getProductId(),product.getProductName()}); 
}
//Prodcut Mapper Class
public static final class ProductMapper implements RowMapper<Product>{
	@Override
	public Product mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Product product=new Product();
		product.setProductId(resultSet.getInt(1));
		product.setProductName(resultSet.getString(2));
		return product;
	}
	
}
}
