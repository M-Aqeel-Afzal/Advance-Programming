import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class TestArrayList {
	ArrayList arr=new ArrayList();
	
	
	
	@Test
	public void testSetGetvalueValid() {                   //Deletion test for valid index
		
		arr.setValue(1,0);
		arr.setValue(2,1);
		 assertEquals(1,arr.getElement(0));
		
	}
	
	
	@Test
	public void TestaddElementValid() {                   //Deletion test for valid index
		
		arr.addElement(1);
		arr.addElement(2);
		arr.addElement(3);
		arr.addElement(4);
		arr.addElement(5);
		 assertEquals(5,arr.getElement(4));
		
	}
	
	
	@Test
	public void TestremoveElementValid() {                   //Deletion test for valid index
		arr.numofElements=2;
		arr.addElement(1);
		arr.addElement(2);
		arr.removeElement(1);
		arr.removeElement(0);
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();
		
		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  arr.removeElement(0);
		 assertEquals("Empty Array\r\n",ConsoleOutput.toString());
		
		
	}
	
	@Test
	public void TestsizeValid() {                   //Deletion test for valid index
		
		ArrayList arr1=new ArrayList();
		arr1.numofElements=2;
		 assertEquals(2,arr1.size());
		
		
	}
	
	
}
