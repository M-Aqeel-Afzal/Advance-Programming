import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class TestQueue {
	Queue myqueue = new Queue(5);
	Queue queue = new Queue(5);
	
	
	@Before
	public void Setup() throws Exception{
		queue.display();
		myqueue.enqueue(20);
		myqueue.enqueue(15);
		myqueue.enqueue(30);
	}
	
	
	@Test
	public void testEnqueue() throws Exception{                        //Testing Dsiplay function
		
		myqueue.enqueue(40);
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  myqueue.display();
		  assertEquals("Queue : 20 15 30 40 \r\n",ConsoleOutput.toString());
		
	
	}
	
	@Test
	public void testDequeue() throws Exception{                        //Testing Dsiplay function
		
		myqueue.dequeue();
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  myqueue.display();
		  assertEquals("Queue : 15 30 \r\n",ConsoleOutput.toString());
		
	
	}
	
	
	
	@Test
	public void testemptyValid(){                        //Testing Dsiplay function
   
		assertTrue(queue.empty());
		
	
	}
	
	@Test
	public void testemptyInValid(){                        //Testing Dsiplay function
   
		assertFalse(myqueue.empty());
		
	
	}
	
	@Test
	public void testSize(){                        //Testing Dsiplay function
   
		assertEquals(3,myqueue.size());
		
	
	}
	/*
	
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
	*/
	
	
}
