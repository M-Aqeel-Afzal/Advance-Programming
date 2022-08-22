package Examples;
import java.util.concurrent.TimeUnit;

public class Bank {
 
    private double totalCash;
    private int totalAccounts;
 
    public Bank(double cash, int accounts) {
        this.totalCash = cash;
        this.totalAccounts = accounts;
    }
 
    public double getTotalCash() throws InterruptedException {
        double cash = 0.0;
        for (int index = 0; index < 5; index++) {
            cash += index;
            }
        return cash;
    }
 
    public int getTotalAccounts() throws InterruptedException {
    	TimeUnit.MILLISECONDS.sleep(990);
    	return totalAccounts;
    }
 
    @Override
    public String toString() {
        return "Bank [cash=" + totalCash + ", accounts=" + totalAccounts + "]";
    }
}