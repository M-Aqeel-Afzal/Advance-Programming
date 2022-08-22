import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class TestArray {
	Array arr=new Array();
	
	@SuppressWarnings("static-access")
	@Before
public void setup()
{
		
		arr.insert(3,0);
		arr.insert(1,1);
		arr.insert(7,2);
		arr.insert(5,3);
		arr.insert(7,4);
		arr.insert(8,5);
		arr.insert(9,6);
		arr.insert(0,7);
		
}
	
	@SuppressWarnings("static-access")
	@Test
	public void testInsertionValid() {                   //insertion test for valid index
		int [] temp= {3,1,7,5,7,8,9,0};
		arr.insert(10,0);
		assertEquals(arr.binarySearch(10,0,1),true);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testInsertionInvalid() {                   //insertion with index is invalid
		
		assertNotEquals(arr.binarySearch(2,0,1),true);
	}
	
	

	@SuppressWarnings("static-access")
	@Test
	public void testDeletionValid() {        //Deleteion when index is valid
		int [] temp= {1,5,7,8,9,0};
		arr.delete(3);
		for(int i=0;i<6;i++)
			assertNotEquals(arr.binarySearch(3,0,7),true);
	}
	
	
	@SuppressWarnings("static-access")
	@Test
	public void testDisplay() {                        //Testing Dsiplay function
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  arr.display();
		 assertEquals("3 1 7 5 7 8 9 0 \r\n",ConsoleOutput.toString());
		
	
	}
	
	
	@SuppressWarnings("static-access")
	@Test
	public void testLinearSearchValid() {                       //Linear Search when index is valid(7 is in the array)
		
		assertEquals(arr.linearSearch(7),true);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testLinearSearchInvalid() {                       //Linear Search when index is valid(2 is not in the array)
		
		assertEquals(arr.linearSearch(2),false);
	}

	/*
	@SuppressWarnings("static-access")
	@Test
	public void testBubbleSort() {                              //bubble sorting test
		int [] temp= {0,1,3,5,7,7,8,9};
		arr.bubbleSort();
		for(int i=0;i<7;i++)
		assertEquals(arr.getvalueAt(i),temp[i]);
	}
	*/
	
	
	@SuppressWarnings("static-access")
	@Test
	public void testBinarySearchvalid() {                       //Valid Linear Search (searching 8 in the array)
		
		assertEquals(arr.binarySearch(8,0,7),true);
	}
	
	
	
	@SuppressWarnings("static-access")
	@Test
	public void testBinarySearchInvalid() {                       //Valid Linear Search (searching 10 in the array)
		
		assertEquals(arr.binarySearch(4,0,7),false);
	}
	
	
	
	@SuppressWarnings("static-access")
	@Test
	public void testBubbleSort() {  
									//Testing Dsiplay function
		 arr.bubbleSort();
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  arr.display();
		 assertEquals("0 1 3 5 7 7 8 9 \r\n",ConsoleOutput.toString());
		
	
	}
	/*
	@SuppressWarnings("static-access")
	@Test
	public void testgetvalue() {  
									//Testing Dsiplay function
		 arr.getValues();
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  arr.display();
		 assertEquals("0 1 3 5 7 7 8 9 \r\n",ConsoleOutput.toString());
		
	
	}*/
	
}








