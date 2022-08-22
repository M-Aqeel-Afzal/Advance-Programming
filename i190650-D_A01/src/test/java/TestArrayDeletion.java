import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class TestArrayDeletion {
	ArrayDeletion arr=new ArrayDeletion();
	@SuppressWarnings("static-access")
	@Test
	public void testDeletionValid() {                   //Deletion test for valid index
		int [] temp= {3,1,7,5,7,8,9,0};
		arr.delete(temp,1);
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  arr.display(temp);
		 assertEquals("3 7 5 7 8 9 0 -1 \r\n",ConsoleOutput.toString());
		
	}
	@SuppressWarnings("static-access")
	@Test
	public void testDeletionInValid() {                   //Deletion test for valid index
		int [] temp= {3,1,7,5,7,8,9,0};
		arr.delete(temp,-1);
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  arr.display(temp);
			 assertEquals("3 1 7 5 7 8 9 0 \r\n",ConsoleOutput.toString());
		
	}
}
