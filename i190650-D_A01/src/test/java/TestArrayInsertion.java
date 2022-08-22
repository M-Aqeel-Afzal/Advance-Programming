import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class TestArrayInsertion {
	ArrayInsertion arr=new ArrayInsertion();
	
	
	
	
	@SuppressWarnings("static-access")
	@Test
	public void testInsertionValid() {                   //Deletion test for valid index
		int [] temp = new int[6];
		arr.insert(temp,1,1);
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  arr.display(temp);
		 assertEquals("0 1 0 0 0 0 \r\n",ConsoleOutput.toString());
		
	}
	
	
	
}
