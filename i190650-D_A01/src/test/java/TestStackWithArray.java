import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class TestStackWithArray {
	StackWIthArray myStack = new StackWIthArray();
	StackWIthArray Stack1 = new StackWIthArray();
	
	@SuppressWarnings("static-access")
	@Before
	public void Setup(){
		Stack1.display();
		Stack1.pop();
		myStack.push(20);
		myStack.push(15);
		myStack.push(30);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testPush(){                        //Testing Dsiplay function
		
		myStack.push(40);
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  myStack.display();
		 assertEquals("Stack : 20 15 30 40 \r\n",ConsoleOutput.toString());
		
	
	}
	@SuppressWarnings("static-access")
	@Test
	public void testPop(){                        //Testing Dsiplay function
		int tenp=myStack.pop();
		        
		assertEquals(30,tenp);
		
	
	}
	@SuppressWarnings("static-access")
	@Test
	public void testPushFront() {                        //Testing Dsiplay function
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  myStack.display();
		  assertEquals("Stack : 20 15 30 \r\n",ConsoleOutput.toString());
		  
	
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testDisplay() {                        //Testing Dsiplay function
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  Stack1.display();
		  assertEquals("Stack : 20 15 30 \r\n",ConsoleOutput.toString());
		  
	
	}
	/*
	@SuppressWarnings("static-access")
	@Test
	public void testSize() throws Exception {                        //Testing Dsiplay function
		int tenp=myStack.size();
		assertEquals(3,tenp);
		
	
	}
	*/
	/*
	@Test
	public void testPushException() throws Exception {                        //Testing Dsiplay function
		assertEquals(4,myStack1.top());
		
	
	}*/
}
