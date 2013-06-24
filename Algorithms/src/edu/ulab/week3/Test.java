package edu.ulab.week3;

public class Test {
	public static void call(int i){
		if(i<=5){
		//System.out.println(i);
		call(++i);
		//System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		call(0);
		System.out.println("b".compareTo("c"));
	}
}
