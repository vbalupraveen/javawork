package com.ulab.SpringBFPP;

public class Laptop implements Computer{
	Double screen;
	public Double getScreen() {
		return screen;
	}
	public void setScreen(Double screen) {
		this.screen = screen;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	String os;
	@Override
	public void printProperties() {
		// TODO Auto-generated method stub
		System.out.println("OS is: "+os+"\t Screen is: "+screen);
	}

}
