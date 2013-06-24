package edu.ulab.week2.test;
import static org.junit.Assert.*;

import org.junit.Test;
import edu.ulab.week2.StringLinkedQueue;
public class TestStringLinkedQueue {
	private StringLinkedQueue instance=new StringLinkedQueue(); 
	@Test
	public void testDequeue() throws Exception
	{
	  System.out.println( "Dequeue" );
	  instance.enQueue("praveen");
	  instance.enQueue("Balu");
	  assertEquals( "Balu", instance.deQueue() );
	}
	public static void main(String[] args) throws Exception {
	new TestStringLinkedQueue().testDequeue();
	}

}
