package com.ulab.SpringIoc_1;

public class Triangle implements Shape{
	Double area;
	Double hight;
	Triangle(Double hight){
		this.hight=hight;
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("This is Triangle");
	}
	@Override
	public Double area() {
		// TODO Auto-generated method stub
		area=(Math.sqrt(3)/4)*hight*hight;
		return area;
	}

}
