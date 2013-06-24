package net.ulab.jdbc.model;

public class Product {
	Integer productId;
	String productName;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Product(Integer pid, String pname){
		setProductId(pid);
		setProductName(pname);
	}
}
