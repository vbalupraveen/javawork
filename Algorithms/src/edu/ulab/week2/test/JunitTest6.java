package edu.ulab.week2.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class JunitTest6 {
 
	 private int number;
 
	 public JunitTest6(int number) {
	    this.number = number;
	 }
 
	 @Parameters
	 public static Collection<Object[]> data() {
		   Object[][] data = new Object[][] { { 1 }, { 5 }, { 121 } };
		   return Arrays.asList(data);
		 }
 
	 @Test
	 public void pushTest() {
	   System.out.println("Parameterized Number is : " + number);
	 }
	 @Test
	  public void testMultiplyException() {
	    MyClass tester = new MyClass();
	    assertEquals("Result", number * number,
	        tester.multiply(number, number));
	  }
}

class MyClass {
	  public int multiply(int x, int y) {
	    // the following is just an example
	    if (x > 999) {
	      throw new IllegalArgumentException("X should be less than 1000");
	    }
	    return x * y;
	  }
	} 