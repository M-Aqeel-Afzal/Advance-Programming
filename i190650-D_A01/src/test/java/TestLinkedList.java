import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class TestLinkedList {

		LinkedList list = new LinkedList();
		
		@SuppressWarnings("static-access")
		@Before
		public void Setup(){
			
			list.pushFront(20);
			list.pushBack(15);
			list.pushFront(30);
		}

	@SuppressWarnings("static-access")
	@Test
	public void testPushFront() {                        //Testing Dsiplay function
		list.display();
		list.pushFront(10);
		list.pushFront(20);
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  list.display();
		 assertEquals("LinkedList : 20 10 30 20 15 \r\n",ConsoleOutput.toString());
		
	
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testPushBack() {                        //Testing Dsiplay function
		list.display();
		
		
		list.pushBack(25);
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  list.display();
		 assertEquals("LinkedList : 30 20 15 25 \r\n",ConsoleOutput.toString());
		
	
	}
	
	
	
	@SuppressWarnings("static-access")
	@Test
	public void testPopBack() {                        //Testing Dsiplay function
		list.popBack();
		
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  list.display();
		 assertEquals("LinkedList : 30 20 \r\n",ConsoleOutput.toString());
		
	
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testPopfront() {                        //Testing Dsiplay function
		list.popFront();
		
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  list.display();
		 assertEquals("LinkedList : 20 15 \r\n",ConsoleOutput.toString());
		 LinkedList list1 = new LinkedList();
		 list1.pushBack(15);
		 list1.popBack();
		 list1.popBack();
		 list1.popFront();
	}
	
	
	@SuppressWarnings("static-access")
	@Test
	public void testPop() {                        //Testing Dsiplay function
		list.pop(2);
	
		
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  list.display();
		 assertEquals("LinkedList : 30 20 \r\n",ConsoleOutput.toString());
		 list.pop(0);
		 list.pop(0);
		 list.pop(0);
		 list.popFront();
		 list.display();
	
	}
}
