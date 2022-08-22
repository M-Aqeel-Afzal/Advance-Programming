import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ExceptionTest.UserTest;
import TimeoutTest.TestTimeout;




@RunWith(Suite.class)
@SuiteClasses({ UserTest.class, TestTimeout.class })
public class TestSuite {
	// This class remains empty, it is used only as a holder for the above annotations	
}
