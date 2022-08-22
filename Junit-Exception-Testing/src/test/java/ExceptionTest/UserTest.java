package ExceptionTest;
import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;

import org.junit.FixMethodOrder;
import org.junit.Test;

import Examples.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserTest {

	@Test(expected = IllegalArgumentException.class)
	public void testUsernameIsNull() {
	    System.out.println("second testUsernameIsNull executed!");
	    User user = new User();
	    user.setName(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testUsernameIsShort() {
        System.out.println("third testUsernameIsShort executed!");
		User user = new User();
        user.setName("Jo");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testUsernameIsLong() {
        System.out.println("first testUsernameIsLong executed!");
	    User user = new User();
        user.setName("Pablo Diego Jose Franciso Picasso");
	}
	
	
}


