import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class TestMyStack {
	MyStack myStack = new MyStack(5);
	MyStack myStack1 = new MyStack(5);
	
	
	@Before
	public void Setup() throws Exception{
		
		myStack.push(20);
		myStack.push(15);
		myStack.push(30);
	}
	
	
	@Test
	public void testPush() throws Exception {                        //Testing Dsiplay function
		myStack.push(40);
		assertEquals(40,myStack.top());
		
	
	}
	
	@Test
	public void testPop() throws Exception {                        //Testing Dsiplay function
		int tenp=myStack.pop();
		assertEquals(30,tenp);
		
	
	}
	
	@Test
	public void testPushFront() {                        //Testing Dsiplay function
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  myStack.displayStack();
		 assertEquals("Stack : [ 20 15 30 ]\r\n",ConsoleOutput.toString());
		
	
	}
	
	
	@Test
	public void testSize() throws Exception {                        //Testing Dsiplay function
		int tenp=myStack.size();
		assertEquals(3,tenp);
		
	
	}
	
	/*
	@Test
	public void testPushException() throws Exception {                        //Testing Dsiplay function
		assertEquals(4,myStack1.top());
		
	
	}*/
}
