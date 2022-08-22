import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.*;
import org.junit.Test;
public class AccountsTest {
	Accounts Acc= new Accounts(System.in);
@Before
public void setup()
{
	
	DateTimeFormatter d= DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a z");
	ZonedDateTime dat = ZonedDateTime.now();
	String date = d.format(dat);
	 String t="Deposited " + 500;
	Acc.create_account("Aqeel", "Islambad","03016666660",101,"saving",500, date, date, t, 0.0, 0.0);
	
	Acc.create_account("Afzal", "Islambad","03016666661",103,"checking",500, date, date, t, 0.0, 0.0);
	
	Acc.create_account("Asad", "Islambad","03016666663",104,"checking",500, date, date, t, 0.0, 0.0);
	
	Acc.create_account("dawood", "Islambad","03016666600",105,"saving",21000, date, date, t, 0.0, 0.0);
	
	
}
	@Test
	public void test_login_account_exist() {                      //when account exist
		
		 boolean b= Acc.LoginAccount(101);
		 
		 assertEquals(b,true);
		 
		
	}
	@Test
	public void test_login_account_Not_exist() {                      //when account  not exist
		
		 
		boolean b= Acc.LoginAccount(102);
		  assertEquals(b,false);
		
		
	}
	
	@Test
	public void test_Delete_account_exist()  {                      //when account exist
		
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  try {
			Acc.close_account(103);
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		 assertEquals("Account founded and deleted\r\n",ConsoleOutput.toString());
		 Acc.menuAdmin();
		 Acc.menu1();
		 Acc.menu2();
		
	}
	@Test
	public void test_CheckBalance_account_exist() {                      //when account exist
		
		 double temp= Acc.balance(101);
		  assertEquals(500.0,temp,0);
		 	
	}
	@Test
	public void test_CheckBalance_account_Not_exist() {                      //when account  not exist
		
		 
		
		  ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  Acc.balance(102);
		  assertEquals("Account not found\r\n",ConsoleOutput.toString());
		
	}
	
	
	@Test
	public void test_Delete_account_Not_exist() {                      //when account  not exist
		
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  try {
			Acc.close_account(102);
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		 assertEquals("Account not found\r\n",ConsoleOutput.toString());
		Acc.menuCustomerSaving();
		
	}
	
	@Test
	public void test_Deposit_account_exist() {                      //when account exist
		
		
		  Acc.deposit(500.0,103);
		  Acc.deposit(500.0,101);
		  assertEquals(1000.0,Acc.balance(103),0);
		 Acc.menuCustomerChecking();
		
	}
	@Test
	public void test_deposit_account_Not_exist() {                      //when account  not exist
		
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  Acc.deposit(500.0,102);
		 assertEquals("Account not found\r\n",ConsoleOutput.toString());
		 
		
	}
	
	@Test
	public void test_Withdraw_account_exist() {                      //when account exist
		
		
		  Acc.withdraw(500.0,103);
		  Acc.withdraw(500.0,101);
		  assertEquals(0.0,Acc.balance(103),0);
		//Acc.addmin();
		  Acc.DisplayAll();
		
	}
	@Test
	public void test_Withdraw_account_Not_exist() {                      //when account  not exist
		
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  Acc.withdraw(500.0,102);
		 assertEquals("Account not found\r\n",ConsoleOutput.toString());
		 
		
	}
	
	@Test
	public void test_transferAmount_account_exist() {                      //when account exist
		
		  boolean flag=Acc.transferAmount(500.0,103,101);
		  assertEquals(flag,true);
		
		
	}
	@Test
	public void test_transferAmount_account_Not_exist() {                      //when account  not exist
		
		boolean flag=Acc.transferAmount(500.0,102,101);
		  assertEquals(flag,false);
		 
		
	}
	
	
	@Test
	public void test_Deduction_checking_account_exist() {                      //when account exist
		
		  double temp=Acc.DisplayAllDeductions(101);
		  temp=Acc.DisplayAllDeductions(103);
		  assertEquals(12.5,temp,0.5);
		
		
	}
	@Test
	public void test_Deduction_saving_account_exist() {                      //when account exist
		
		  double temp=Acc.DisplayAllDeductions(103);
		  assertEquals(12.5,temp,0.5);
		
		
	}
	@Test
	public void test_Deduction_account_Not_exist() {                      //when account  not exist
		
		 double temp=Acc.DisplayAllDeductions(102);
		  assertEquals(0,temp,0);
		 
		
	}
	
	@Test
	public void test_zakatcalculation_account_exist() {                      //when account exist
		
		  double temp=Acc.ZakatFun(105);
		  assertEquals(525.0,temp,0.5);
		
		
	}
	@Test
	public void test_zakatcalculation_account_Not_exist() {                      //when account  not exist
		
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  Acc.ZakatFun(102);
		 assertEquals("Account not found\r\n",ConsoleOutput.toString());
		 
		 
		
	}
	
	@Test
	public void test_interestRate_account_exist() {                      //when account exist
		     Acc.InterestRate(5);
		  double temp=Acc.calculatelnterest(101);
		  temp=Acc.calculatelnterest(105);
		  assertEquals(1050.0,temp,0.5);
		
		
	}
	@Test
	public void test_interestRate_account_Not_exist() {                      //when account  not exist
		
		 ByteArrayOutputStream ConsoleOutput= new ByteArrayOutputStream();

		  System.setOut(new PrintStream(ConsoleOutput));
		//  System.getProperty("line.separator");
		  Acc.calculatelnterest(102);
		 assertEquals("Account not found\r\n",ConsoleOutput.toString());
		 
		 
		
	}

}
