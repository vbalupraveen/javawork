package com.ulab.SpringIoc_1;

public class Circle implements Shape{
	Double area;
	Double radius;
	Circle(Double radius){
		this.radius=radius;
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("This is Circle");
	}

	@Override
	public Double area() {
		// TODO Auto-generated method stub
		area=(Math.PI)*radius*radius;
		return area;
	}

}
