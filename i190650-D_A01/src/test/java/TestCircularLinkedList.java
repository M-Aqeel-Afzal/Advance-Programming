import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class TestCircularLinkedList {

	CircularLinkedList list = new CircularLinkedList();
		
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
		 assertEquals("List : 20 10 30 20 15\r\n",ConsoleOutput.toString());
		
	
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
		 assertEquals("List : 30 20 15 25\r\n",ConsoleOutput.toString());
		
	
	}
	
	
	
	@SuppressWarnings("static-access")
	@Test
	public void testPopBack() {                        //Testing Dsiplay function
		list.popBack();
		
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  list.display();
		 assertEquals("List : 30 20\r\n",ConsoleOutput.toString());
		
	
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testPopfront() {                        //Testing Dsiplay function
		list.popFront();
		
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  list.display();
		 assertEquals("List : 20 15\r\n",ConsoleOutput.toString());
		 CircularLinkedList list1 = new CircularLinkedList();
		 list1.pushBack(15);
		 list1.popBack();
		 list1.popBack();
		 list1.popFront();
		 list1.display();
		 list1.pushFront(1);
		 list1.pushFront(2);
	}
	
	
}
