import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class TestLinkedListSwap {

	LinkedListSwap list = new LinkedListSwap();
	
	
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
		 assertEquals("List : 20 10 30 20 15 \r\n",ConsoleOutput.toString());
		
	
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
		 assertEquals("List : 30 20 15 25 \r\n",ConsoleOutput.toString());
		 LinkedListSwap list1 = new LinkedListSwap();
		 list1.display();
		 list1.pushBack(25);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testSwap() {                        //Testing Dsiplay function
		list.display();
		
		
		list.swap();
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  list.display();
		 assertEquals("List : 15 20 30 \r\n",ConsoleOutput.toString());
		 LinkedListSwap list1 = new LinkedListSwap();
		 list1.swap();
		 list1.display();
		 list1.pushBack(25);
	}
	
	
	
	
	
	
}
