package TimeoutTest;
import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
 
import org.junit.BeforeClass;
import org.junit.Test;

import Examples.Bank;
 
public class TestTimeout {
 
    private static Bank bank;
 
    @BeforeClass
    public static void init() {
        bank = new Bank(500000, 100);
    }
 
    @Test(timeout = 1000)
    public void totalCashTest() throws InterruptedException {
        assertThat(10.0, is(bank.getTotalCash()));
        
    }
     
    @Test(timeout = 1000)
    public void totalAccountsTest() throws InterruptedException {
        assertThat(100, is(bank.getTotalAccounts()));
        /* Simulate a task that takes 3 secs.
         * 1 (timeout) > 0.5 so this method should be marked as
         * a pass */
    }
}
