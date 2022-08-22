import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class TestLinkedList {
	LinkedList list = new LinkedList();
	
	@SuppressWarnings("static-access")
	@Before
public void setup()
{
		
		list.pushFront(10);
		list.pushBack(12);
		list.pushFront(8);
		list.pushFront(6);
		list.pushBack(20);
		
}
	@SuppressWarnings("static-access")
	@Test
	public void testPushValid() {                   //insertion test for valid index
		
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		  list.display();
		 assertEquals("6 8 10 12 20 \r\n",ConsoleOutput.toString());
	}
	
	
	@SuppressWarnings("static-access")
	@Test
	public void testPushFrontValid() {                   //insertion test for valid index
		list.pushFront(3);
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		  list.display();
		 assertEquals("3 6 8 10 12 20 \r\n",ConsoleOutput.toString());
	}
	
	
	@SuppressWarnings("static-access")
	@Test
	public void testPushBackValid() {                   //insertion test for valid index
		list.pushBack(2);
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		  list.display();
		 assertEquals("6 8 10 12 20 2 \r\n",ConsoleOutput.toString());
	}
	
	
	@SuppressWarnings("static-access")
	@Test
	public void testPopFrontValid() {                   //insertion test for valid index
		list.popFront();
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		  list.display();
		 assertEquals("8 10 12 20 \r\n",ConsoleOutput.toString());
	}
	
	
	
	@SuppressWarnings("static-access")
	@Test
	public void testPopBackValid() {                   //insertion test for valid index
		list.popBack();
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		  list.display();
		 assertEquals("6 8 10 12 \r\n",ConsoleOutput.toString());
	}
	
	
	
	@SuppressWarnings("static-access")
	@Test
	public void testPopAtPosition_Valid() {                   //insertion test for valid index
		list.pop(2);
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		  list.display();
		  assertEquals("6 8 12 20 \r\n",ConsoleOutput.toString());
	}
	
	
	@SuppressWarnings("static-access")
	@Test
	public void testPopAtPosition_InValid() {                   //insertion test for valid index
		
		
		  assertEquals(list.pop(-1),false);
	}
	
	
	@SuppressWarnings("static-access")
	@Test
	public void testSwap() {                   //insertion test for valid index
		list.swap();
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		  list.display();
		  assertEquals("20 8 10 12 6 \r\n",ConsoleOutput.toString());
	}
	
	
}








