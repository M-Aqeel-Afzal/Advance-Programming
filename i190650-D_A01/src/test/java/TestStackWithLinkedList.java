import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class TestStackWithLinkedList {
	StackWithLinkedList myStack = new StackWithLinkedList();
	StackWithLinkedList Stack1 = new StackWithLinkedList();
	
	@SuppressWarnings("static-access")
	@Before
	public void Setup(){
		Stack1.display();
		Stack1.pop();
		Stack1.top();
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
		 assertEquals("Stack \r\n"
		 		+ "----------\r\n"
		 		+ "|   40   |\r\n"
		 		+ "----------\r\n"
		 		+ "|   30   |\r\n"
		 		+ "----------\r\n"
		 		+ "|   15   |\r\n"
		 		+ "----------\r\n"
		 		+ "|   20   |\r\n"
		 		+ "----------",ConsoleOutput.toString().trim());
		
	
	}
	@SuppressWarnings("static-access")
	@Test
	public void testPop(){                        //Testing Dsiplay function
		int tenp=myStack.pop();
		        
		assertEquals(30,tenp);
		
	
	}
	
	
	@SuppressWarnings("static-access")
	@Test
	public void testDisplay() {                        //Testing Dsiplay function
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  Stack1.display();
		  assertEquals("Stack \r\n"
		  		+ "----------\r\n"
		  		+ "|   30   |\r\n"
		  		+ "----------\r\n"
		  		+ "|   15   |\r\n"
		  		+ "----------\r\n"
		  		+ "|   20   |\r\n"
		  		+ "----------",ConsoleOutput.toString().trim());
		  
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testSize() throws Exception {                        //Testing Dsiplay function
		int tenp=myStack.getSize();
		assertEquals(3,tenp);
		
	
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testTop() throws Exception {                        //Testing Dsiplay function
	
		int tenp=myStack.top();
		assertEquals(30,tenp);
		
	
	}
	
	
	
}
