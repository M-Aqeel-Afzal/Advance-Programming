import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class TestQueueWithLinkedList {
	QueueWIthLinkedList myqueue = new QueueWIthLinkedList();
	QueueWIthLinkedList queue = new QueueWIthLinkedList();
	
	
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
		
		QueueWIthLinkedList queue1 = new QueueWIthLinkedList();
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  queue1.display();
		  assertEquals("Empty queue.\r\n",ConsoleOutput.toString());
		
	
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
	public void testDequeue() throws Exception{                        //Testing Dsiplay function
		
		myqueue.dequeue();
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  myqueue.display();
		  assertEquals("Queue : 15 30 \r\n",ConsoleOutput.toString());
		
	
	}
	
	
	
	
	
	
	
	
	
	
}
