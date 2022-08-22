import static org.junit.Assert.assertEquals;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class TestDequeue {
	Dequeue myqueue = new Dequeue(5);
	Dequeue queue = new Dequeue(5);
	
	
	@SuppressWarnings("static-access")
	@Before
	public void Setup() throws Exception{
		queue.display();
		myqueue.addLeft(20);
		myqueue.addLeft(15);
		myqueue.addLeft(30);
		
		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testAddLeft() throws Exception{                        //Testing Dsiplay function
		
		
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  myqueue.display();
		  assertEquals("DeQueue : 20 15 30 0 0 \r\n",ConsoleOutput.toString());
		
	
	}
	
	
	@Test
	public void testAddRight() throws Exception{                        //Testing Dsiplay function
		
		myqueue.addRight(40);
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  myqueue.display();
		  assertEquals("DeQueue : 20 15 30 0 40 \r\n",ConsoleOutput.toString());
		
	
	}
	
	/*
	@SuppressWarnings("static-access")
	@Test
	public void testDequeue() throws Exception{                        //Testing Dsiplay function
		
		myqueue.dequeue();
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  myqueue.display();
		  assertEquals("Queue : 15 30 \r\n",ConsoleOutput.toString());
		
	
	}
	*/
	
	
	
	
	
	
	
	
	
}
