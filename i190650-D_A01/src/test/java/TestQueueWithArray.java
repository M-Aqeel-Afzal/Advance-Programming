import static org.junit.Assert.assertEquals;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class TestQueueWithArray {
	QueueWithArray myqueue = new QueueWithArray(5);
	QueueWithArray queue = new QueueWithArray(5);
	
	
	@SuppressWarnings("static-access")
	@Before
	public void Setup() throws Exception{
		queue.display();
		myqueue.enqueue(20);
		myqueue.enqueue(15);
		myqueue.enqueue(30);
		
		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testDequeueEmpty() throws Exception{                        //Testing Dsiplay function
		
		QueueWithArray queue = new QueueWithArray(5);
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  queue.display();
		  assertEquals("Empty Queue.\r\n",ConsoleOutput.toString());
		
	
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testEnqueue() throws Exception{                        //Testing Dsiplay function
		
		myqueue.enqueue(40);
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  myqueue.display();
		  assertEquals("Queue : 20 15 30 40 \r\n",ConsoleOutput.toString());
		
	
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testEnqueueFull() throws Exception{                        //Testing Dsiplay function
		 queue.enqueue(60);
		  queue.enqueue(40);
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  queue.enqueue(60);
		 
		  assertEquals("Queue is Full.\r\n",ConsoleOutput.toString());
		
	
	}
	
	
	
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
	
	
	
	
	
	
	
	
}
