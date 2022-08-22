import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;



public class Accounts extends Admin {
	
	
	public static class ConnectionBuilderOracle {
	    static String user_name="system";
	    static String Password="aq4427";

	    public static  Connection buildConnection () {
	        try{
	           Class.forName("oracle.jdbc.driver.OracleDriver");
	           try {
	               return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",user_name,Password);
	           } catch (SQLException e) {
	               System.err.println("connection not established");
	               e.printStackTrace();
	                return null; 
	           }
	        } catch(ClassNotFoundException ex) {
	            System.err.println("Driver is not loaded");
	            return null; 
	        }
	    }
	}
	
	public static class ConnectionBuilderMysql {
	    static String user_name="root";
	    static String Password="aq4427";

	    public static  Connection buildConnection () {
	        try{
	           Class.forName("com.mysql.jdbc.Driver");
	           try {
	               return DriverManager.getConnection("jdbc:mysql://localhost:3306/Account_Management_System",user_name,Password);
	           } catch (SQLException e) {
	               System.err.println("connection not established");
	               e.printStackTrace();
	                return null; 
	           }
	        } catch(ClassNotFoundException ex) {
	            System.err.println("Driver is not loaded");
	            return null; 
	        }
	    }
	}
	
	public Accounts(InputStream in) {
		// TODO Auto-generated constructor stub
	}
	
	public void addmin(int temp9)
	{
		 int  temp1=0;
		 Scanner obj2= new Scanner(System.in);
		 while(true)
		 {  menuAdmin(); 
		 
		

		 if(obj2.hasNextInt())
		 {
		   temp1= obj2.nextInt();
		 
		    	 switch(temp1)
		     {
		    
		     case 1:
		    	 System.out.println("Enter Name of Customer");
		    		
		    		Scanner obj= new Scanner(System.in);
		    		String name="";
		    		 
		    			 name= obj.nextLine();
		    		 
		    		
		    		
		    		System.out.println("Enter Address");
		    		String addr= obj.nextLine();
		    		
		    		System.out.println("Enter Phone number");
		    		String cont= obj.nextLine();
		    		
		    		System.out.println("Enter Account Type");
		    		String type= obj.nextLine();
		    		
		    		
		    		System.out.println("Enter Account ID");
		    		int id= obj.nextInt();
		    		
		    		System.out.println("Enter Intial Balance");
		    		double bal= obj.nextDouble();
		    		while(bal<0)
		    		{
		    			System.out.println("Amount cannot be negative:");
		    			System.out.println("Enter Intial Balance Again");
		    			bal= obj.nextDouble();
		    		}
		    		
		    		DateTimeFormatter d= DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a z");
		    		ZonedDateTime dat = ZonedDateTime.now();
		    		String date = d.format(dat);
		    		 String t="Deposited " + bal;
		    		 if(temp9==1)
		    	 create_account(name,addr,cont,id,type,bal,date,date,t,0.0,0.0);
		    		 else if(temp9==2)
		    		 {
		    			 String str1 ="INSERT INTO accounts ( Acc_id,name,cont,addr,acc_type,balance,creatation_date,LastTansection,deposited,trans_fee,interest) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		    			 try {
							PreparedStatement state=ConnectionBuilderOracle.buildConnection().prepareStatement(str1);
							state.setInt(1, id);
							state.setString(2, name);
							state.setString(3, cont);
							state.setString(4, addr);
							state.setString(5, type);
							state.setDouble(6, bal);
							state.setString(7, date);
							state.setString(8, date);
							state.setString(9, t);
							state.setDouble(10, 0.0);
							state.setDouble(11, 0.0);
							int inserted=state.executeUpdate();
							if(inserted>0)
							{
								System.out.println("Account added successfuliy");
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    		 }
		    		 else if(temp9==3)
		    		 {
		    			 String str1 ="INSERT INTO accounts ( Acc_id,name,cont,addr,acc_type,balance,creatation_date,LastTansection,deposited,trans_fee,interest) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		    			 try {
							PreparedStatement state=ConnectionBuilderMysql.buildConnection().prepareStatement(str1);
							state.setInt(1, id);
							state.setString(2, name);
							state.setString(3, cont);
							state.setString(4, addr);
							state.setString(5, type);
							state.setDouble(6, bal);
							state.setString(7, date);
							state.setString(8, date);
							state.setString(9, t);
							state.setDouble(10, 0.0);
							state.setDouble(11, 0.0);
							int inserted=state.executeUpdate();
							if(inserted>0)
							{
								System.out.println("Account added successfuliy");
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
		    		 }
		    	 
		    	 break;
		     case 2:
		    	 System.out.println("Enter Account ID");
		    		 obj= new Scanner(System.in);
		    		 id= obj.nextInt();
					
					if(temp9==1)
					{
						try {
							close_account(id);
						} catch (IOException e) {
							 System.out.println("Error!");
							e.printStackTrace();
						}
						
					}
				    		 else if(temp9==2)
				    		 {
				    			 String str1 ="DELETE FROM accounts where Acc_id=?";
				    			 try {
									PreparedStatement state=ConnectionBuilderOracle.buildConnection().prepareStatement(str1);
									state.setInt(1, id);
	
									int inserted=state.executeUpdate();
									if(inserted>0)
									{
										System.out.println("Account Deleted successfuliy");
									}
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				    		 }
				    		 else if(temp9==3)
				    		 {
				    			 String str1 ="DELETE FROM accounts where Acc_id=?";
				    			 try {
									PreparedStatement state=ConnectionBuilderMysql.buildConnection().prepareStatement(str1);
									state.setInt(1, id);
			
									int inserted=state.executeUpdate();
									if(inserted>0)
									{
										System.out.println("Account Deleted successfuliy");
									}
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} 
				    		 }
		    	 break;
		     case 3:
		    	 System.out.println("Enter Account ID:");
		    		Scanner obj4= new Scanner(System.in);
		    		int id1= obj4.nextInt();
		    		if(temp9==1)
					{
						LoginAccount(id1);
						
					}
				    		 else if(temp9==2)
				    		 {
				    			 java.sql.Statement s1 = null;
									try {
										s1 = ConnectionBuilderOracle.buildConnection().createStatement();
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
					    			 try {
										ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id1);
										while(str1.next()) {
										int id2=str1.getInt(1);
										//if(id2==id1)
											System.out.println("Account Login Successfully!");	
										}
										
									} catch (SQLException e) {
										// TODO Auto-generated catch block1
									
										e.printStackTrace();
									}
					    			 
				    		 }
				    		 else if(temp9==3)
				    		 {
				    			 java.sql.Statement s1 = null;
								try {
									s1 = ConnectionBuilderMysql.buildConnection().createStatement();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
				    			 try {
									ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id1);
									while(str1.next()) {
									int id2=str1.getInt(1);
									if(id2==id1)
										System.out.println("Account Login Successfully!");	
									}
								} catch (SQLException e) {
									// TODO Auto-generated catch block1
								
									e.printStackTrace();
								}
				    			 
			
													    		 }
		    	 
		    	 break;
		     case 4:
		    	
		    		System.out.println("\nEnter new value of Interest Rate:");
		    		 obj= new Scanner(System.in);
		    		double temp5= obj.nextInt();
		    		while(temp5<0)
		    		{
		    			System.out.println("Amount cannot be negative:");
		    			System.out.println("Enter Again");
		    			temp5= obj.nextInt();
		    		}
		    		
		    		if(temp9==1)

		    		{
		    			InterestRate(temp5);
			    		System.out.println("\nInterest Rate Updated\n");
		    		}
				    		 else if(temp9==2)
				    		 {
				    			 String str1 ="UPDATE accounts SET interest=?";
				    			 try {
									PreparedStatement state=ConnectionBuilderOracle.buildConnection().prepareStatement(str1);
									state.setString(1,""+temp5);
									
									int inserted=state.executeUpdate();
									if(inserted>0)
									{
										System.out.println("Account Interest rate Updated successfuliy");
									}
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				    		 }
				    		 else if(temp9==3)
				    		 {
				    			 String str1 ="UPDATE accounts SET interest=?";
				    			 try {
									PreparedStatement state=ConnectionBuilderMysql.buildConnection().prepareStatement(str1);
									
									state.setString(1,""+temp5);
									
									int inserted=state.executeUpdate();
									if(inserted>0)
									{
										System.out.println("Account Interest rate Updated successfuliy");
									}
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} 
				    		 }
		    		
		    	 
		    	 break;
		     case 5:
		    	
		    	if(temp9==1)
				{
		    		DisplayAll();
					
				}
			    		 else if(temp9==2)
			    		 {
			    			 java.sql.Statement s1 = null;
								try {
									s1 = ConnectionBuilderOracle.buildConnection().createStatement();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
				    			 try {
									ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts");
									while(str1.next()) {
										int id2=str1.getInt(1);
										name=str1.getString("name");
										addr=str1.getString("addr");
										cont=str1.getString("cont");
										String balan=str1.getString("balance");
										type=str1.getString("acc_type");
										date=str1.getString("creatation_date");
									String	tran=str1.getString("LastTansection");
										String deposite=str1.getString("deposited");
										String fee=str1.getString("trans_fee");
										String interest=str1.getString("interest");
									System.out.println("====================================");
										System.out.println("Account ID: "+id2+"\nName: "+name+"\nAddress: "+addr+"\nContact: "+cont+"\nBalance: "+balan+"\nCreatation Date: "+date+"\nLast Transection: "+tran+"\nDeposite: "+deposite+"\nTransection fee: "+fee+"\n3Interest: "+interest);	
									}
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block1
								
									e.printStackTrace();
								}
				    			 
			    		 }
			    		 else if(temp9==3)
			    		 {
			    			 java.sql.Statement s1 = null;
								try {
									s1 = ConnectionBuilderMysql.buildConnection().createStatement();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
				    			 try {
									ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts");
									while(str1.next()) {
										int id2=str1.getInt(1);
										name=str1.getString("name");
										addr=str1.getString("addr");
										cont=str1.getString("cont");
										String balan=str1.getString("balance");
										type=str1.getString("acc_type");
										date=str1.getString("creatation_date");
									String	tran=str1.getString("LastTansection");
										String deposite=str1.getString("deposited");
										String fee=str1.getString("trans_fee");
										String interest=str1.getString("interest");
									System.out.println("====================================");
										System.out.println("Account ID: "+id2+"\nName: "+name+"\nAddress: "+addr+"\nContact: "+cont+"\nBalance: "+balan+"\nCreatation Date: "+date+"\nLast Transection: "+tran+"\nDeposite: "+deposite+"\nTransection fee: "+fee+"\nInterest: "+interest);	
									}
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block1
								
									e.printStackTrace();
								}
				    			 
		
												    		 }
		    	break;
		     case 6:
		    	 System.out.println("Enter Account ID");
		    		 obj= new Scanner(System.in);
		    		 id= obj.nextInt();
		    		
		    		
		    		if(temp9==1)

		    		{
		    			double temp=calculatelnterest(id);
			    		System.out.println( "total interest is: " + temp);
		    		}
				    		 else if(temp9==2)
				    		 {
				    			 
				    			 java.sql.Statement s1 = null;
									try {
										s1 = ConnectionBuilderOracle.buildConnection().createStatement();
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
					    			 try {
										ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id);
										while(str1.next()) {
											int id2=str1.getInt(1);
											String interest=str1.getString("interest");
											String balan=str1.getString("balance");
											
											double inter=Double.parseDouble(interest); 
											int b=Integer.parseInt(balan); 
											Customer c1=new Customer();
										
										System.out.println("Interest is: "+	(b*inter)/100);
												}
										
									} catch (SQLException e) {
										// TODO Auto-generated catch block1
									
										e.printStackTrace();
									}
								
				    		 }
				    		 else if(temp9==3)
				    		 {
				    			 java.sql.Statement s1 = null;
									try {
										s1 = ConnectionBuilderMysql.buildConnection().createStatement();
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
					    			 try {
					    				 ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id);
											while(str1.next()) {
												int id2=str1.getInt(1);
												String interest=str1.getString("interest");
												String balan=str1.getString("balance");
												
												double inter=Double.parseDouble(interest); 
												int b=Integer.parseInt(balan); 
												Customer c1=new Customer();
											
											System.out.println("Interest is: "+	(b*inter)/100);
													}
										
									} catch (SQLException e) {
										// TODO Auto-generated catch block1
									
										e.printStackTrace();
									}
				    		 }
		    	
		    	break;
		     case 7: 
		    	
		    	 System.out.println("Enter Account ID");
	    		 obj= new Scanner(System.in);
	    		 id= obj.nextInt();
    	    	
    	    	if(temp9==1)

	    		{
    	    		double temp2=DisplayAllDeductions(id);
        	    	System.out.println( "Deduction on this account is: " + temp2);
	    		}
			    		 else if(temp9==2)
			    		 {
			    			 
			    			 java.sql.Statement s1 = null;
								try {
									s1 = ConnectionBuilderOracle.buildConnection().createStatement();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
				    			 try {
									ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id);
									while(str1.next()) {
										int id2=str1.getInt(1);
			
										String balan=str1.getString("balance");
										int b=Integer.parseInt(balan); 
										Customer c1=new Customer();
										
									System.out.println("Deduction is is: "+	(b*2.5)/100);
											}
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block1
								
									e.printStackTrace();
								}
							
			    		 }
			    		 else if(temp9==3)
			    		 {
			    			 java.sql.Statement s1 = null;
								try {
									s1 = ConnectionBuilderMysql.buildConnection().createStatement();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
				    			 try {
				    				 ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id);
										while(str1.next()) {
											int id2=str1.getInt(1);
				
											String balan=str1.getString("balance");
											int b=Integer.parseInt(balan); 
											Customer c1=new Customer();
											
										System.out.println("Deduction is is: "+	(b*2.5)/100);
												}
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block1
								
									e.printStackTrace();
								}
			    		 }
    	    	
		    	 break;
		     case 9:
		    	System.exit(0);
		     case 0:
		    	return;
		    	default:
		    		System.out.println("Wrong input! Try Again");
		    		
		     }
		 }
		    	 //obj2.close();	
		   // obj2.nextLine();
		 }
		// obj2.close();
		 
	}
	
	public void Custom(int temp9)
	{ 
		int  temp=0;
		 Scanner obj1= new Scanner(System.in);
		menu2(); 
		 temp= obj1.nextInt();
			 switch(temp)
		     {
			     case 1:
			    	 int  temp1=0;
			    	 Scanner obj2= new Scanner(System.in);
			    	 while(true)
			    	 { menuCustomerSaving(); 
			    	

			    	 if(obj2.hasNextInt())
			    	 {
			    	   temp1= obj2.nextInt();
			    	 
			    	    	 switch(temp1)
			    	     {
			    	     
			    	     case 1:
			    	    	 System.out.println("Enter Account ID");
			    	    		Scanner obj= new Scanner(System.in);
			    	    		int id= obj.nextInt();
			    	    		System.out.println("\nEnter Amount: \n");
			    	    		int b= obj.nextInt();
			    	    		while(b<0)
			    	    		{
			    	    			System.out.println("Amount cannot be negative:");
			    	    			System.out.println("Enter Again");
			    	    			b= obj.nextInt();
			    	    		}
			    	    	
			    	    	if(temp9==1)

				    		{
			    	    		deposit(b,id);
				    		}
						    		 else if(temp9==2)
						    		 {
						    			 int b1=0;
						    			 java.sql.Statement s1 = null;
											try {
												s1 = ConnectionBuilderOracle.buildConnection().createStatement();
											} catch (SQLException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
							    			 try {
												ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id);
												while(str1.next()) {
													int id2=str1.getInt(1);
			
													String balan=str1.getString("balance");
										 
													 b1=Integer.parseInt(balan); 
			                                           b1=b1+b;
														}
												
												
												
												String str2 ="UPDATE accounts SET balance=? where acc_id="+id;
								    			 try {
													PreparedStatement state=ConnectionBuilderOracle.buildConnection().prepareStatement(str2);
													state.setString(1,""+b1);
													
													int inserted=state.executeUpdate();
													if(inserted>0)
													{
														System.out.println("Account Deposite successfuliy");
													}
												} catch (Exception e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
								    			 
								    			 
												
											} catch (SQLException e) {
												// TODO Auto-generated catch block1
											
												e.printStackTrace();
											}
										
						    		 }
						    		 else if(temp9==3)
						    		 {
						    			 int b1=0;
						    			 java.sql.Statement s1 = null;
											try {
												s1 = ConnectionBuilderMysql.buildConnection().createStatement();
											} catch (SQLException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
							    			 try {
												ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id);
												while(str1.next()) {
													int id2=str1.getInt(1);
			
													String balan=str1.getString("balance");
										 
													 b1=Integer.parseInt(balan); 
			                                           b1=b1+b;
														}
												
												
												
												String str2 ="UPDATE accounts SET balance=? where acc_id="+id;
								    			 try {
													PreparedStatement state=ConnectionBuilderMysql.buildConnection().prepareStatement(str2);
													state.setString(1,""+b1);
													
													int inserted=state.executeUpdate();
													if(inserted>0)
													{
														System.out.println("Account Deposite successfuliy");
													}
												} catch (Exception e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
								    			 
								    			 
												
											} catch (SQLException e) {
												// TODO Auto-generated catch block1
											
												e.printStackTrace();
											}
						    		 }
			    	    	 break;
			    	     case 2:
			    	    	 System.out.println("Enter Account ID");
			    	    		 obj= new Scanner(System.in);
			    	    		 id= obj.nextInt();
			    	    		System.out.println("\nEnter Amount: \n");
			    	    		b= obj.nextInt();
			    	    		while(b<0)
			    	    		{
			    	    			System.out.println("Amount cannot be negative:");
			    	    			System.out.println("Enter Again");
			    	    			b= obj.nextInt();
			    	    		}
			    	    	
			    	    	 if(temp9==1)

					    		{
			    	    		 withdraw(b,id);
					    		}
							    		 else if(temp9==2)
							    		 {
							    			 int b1=0;
							    			 java.sql.Statement s1 = null;
												try {
													s1 = ConnectionBuilderOracle.buildConnection().createStatement();
												} catch (SQLException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
								    			 try {
													ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id);
													while(str1.next()) {
														int id2=str1.getInt(1);
				
														String balan=str1.getString("balance");
											 
														 b1=Integer.parseInt(balan); 
				                                           b1=b1-b;
															}
													
													
													
													String str2 ="UPDATE accounts SET balance=? where acc_id="+id;
									    			 try {
														PreparedStatement state=ConnectionBuilderOracle.buildConnection().prepareStatement(str2);
														state.setString(1,""+b1);
														
														int inserted=state.executeUpdate();
														if(inserted>0)
														{
															System.out.println("Account withdraw successfuliy");
														}
													} catch (Exception e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
									    			 
									    			 
													
												} catch (SQLException e) {
													// TODO Auto-generated catch block1
												
													e.printStackTrace();
												}
											
							    		 }
							    		 else if(temp9==3)
							    		 {
							    			 int b1=0;
							    			 java.sql.Statement s1 = null;
												try {
													s1 = ConnectionBuilderMysql.buildConnection().createStatement();
												} catch (SQLException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
								    			 try {
													ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id);
													while(str1.next()) {
														int id2=str1.getInt(1);
				
														String balan=str1.getString("balance");
											 
														 b1=Integer.parseInt(balan); 
				                                           b1=b1-b;
															}
													
													
													
													String str2 ="UPDATE accounts SET balance=? where acc_id="+id;
									    			 try {
														PreparedStatement state=ConnectionBuilderMysql.buildConnection().prepareStatement(str2);
														state.setString(1,""+b1);
														
														int inserted=state.executeUpdate();
														if(inserted>0)
														{
															System.out.println("Account withdraw successfuliy");
														}
													} catch (Exception e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
									    			 
									    			 
													
												} catch (SQLException e) {
													// TODO Auto-generated catch block1
												
													e.printStackTrace();
												}
							    		 }
			    	    	 break;
			    	     case 3:
			    	    	 System.out.println("Enter Account ID");
		    	    		 obj= new Scanner(System.in);
		    	    		 id= obj.nextInt();
		    	    	
		    	    	 if(temp9==1)

				    		{
		    	    		 System.out.println(balance(id));
				    		}
						    		 else if(temp9==2)
						    		 {
						    			 
						    			 java.sql.Statement s1 = null;
											try {
												s1 = ConnectionBuilderOracle.buildConnection().createStatement();
											} catch (SQLException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
							    			 try {
												ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id);
												while(str1.next()) {
													int id2=str1.getInt(1);
													String balan=str1.getString("balance");
													System.out.println("Balance: "+balan);
														}
												
											} catch (SQLException e) {
												// TODO Auto-generated catch block1
											
												e.printStackTrace();
											}
										
						    		 }
						    		 else if(temp9==3)
						    		 {
						    			 java.sql.Statement s1 = null;
											try {
												s1 = ConnectionBuilderMysql.buildConnection().createStatement();
											} catch (SQLException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
							    			 try {
							    				 ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id);
													while(str1.next()) {
														int id2=str1.getInt(1);
														String balan=str1.getString("balance");
														System.out.println("Balance: "+balan);
															}
												
											} catch (SQLException e) {
												// TODO Auto-generated catch block1
											
												e.printStackTrace();
											}
						    		 }
			    	    	 break;
			    	     case 4:
			    	    	
			    	    	 if(temp9==1)
			 				{
			    	    		 pstatement();
			 					
			 				}
			 			    		 else if(temp9==2)
			 			    		 {System.out.println("Enter Account ID");
			 			    		Scanner obj3= new Scanner(System.in);
			 			    		int id3= obj3.nextInt();
			 			    			 java.sql.Statement s1 = null;
			 								try {
			 									s1 = ConnectionBuilderOracle.buildConnection().createStatement();
			 								} catch (SQLException e1) {
			 									// TODO Auto-generated catch block
			 									e1.printStackTrace();
			 								}
			 				    			 try {
			 									ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where acc_id+"+id3);
			 									while(str1.next()) {
			 										int id2=str1.getInt(1);
			 										String		name=str1.getString("name");
			 										String		addr=str1.getString("addr");
			 										String		cont=str1.getString("cont");
			 										String balan=str1.getString("balance");
			 										String		type=str1.getString("acc_type");
			 										String		date=str1.getString("creatation_date");
			 									String	tran=str1.getString("LastTansection");
			 										String deposite=str1.getString("deposited");
			 										String fee=str1.getString("trans_fee");
			 										String interest=str1.getString("interest");
			 									System.out.println("====================================");
			 										System.out.println("Account ID: "+id2+"\nName: "+name+"\nAddress: "+addr+"\nContact: "+cont+"\nBalance: "+balan+"\nCreatation Date: "+date+"\nLast Transection: "+tran+"\nDeposite: "+deposite+"\nTransection fee: "+fee+"\n3Interest: "+interest);	
			 									}
			 									
			 								} catch (SQLException e) {
			 									// TODO Auto-generated catch block1
			 								
			 									e.printStackTrace();
			 								}
			 				    			 
			 			    		 }
			 			    		 else if(temp9==3)
			 			    		 {System.out.println("Enter Account ID");
			 			    		Scanner obj3= new Scanner(System.in);
			 			    		int id3= obj3.nextInt();
			 			    			 java.sql.Statement s1 = null;
			 								try {
			 									s1 = ConnectionBuilderMysql.buildConnection().createStatement();
			 								} catch (SQLException e1) {
			 									// TODO Auto-generated catch block
			 									e1.printStackTrace();
			 								}
			 				    			 try {
			 									ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where acc_id="+id3);
			 									while(str1.next()) {
			 										int id2=str1.getInt(1);
			 									String	name=str1.getString("name");
			 									String	addr=str1.getString("addr");
			 									String	cont=str1.getString("cont");
			 										String balan=str1.getString("balance");
			 										String	type=str1.getString("acc_type");
			 										String	date=str1.getString("creatation_date");
			 									String	tran=str1.getString("LastTansection");
			 										String deposite=str1.getString("deposited");
			 										String fee=str1.getString("trans_fee");
			 										String interest=str1.getString("interest");
			 									System.out.println("====================================");
			 										System.out.println("Account ID: "+id2+"\nName: "+name+"\nAddress: "+addr+"\nContact: "+cont+"\nBalance: "+balan+"\nCreatation Date: "+date+"\nLast Transection: "+tran+"\nDeposite: "+deposite+"\nTransection fee: "+fee+"\nInterest: "+interest);	
			 									}
			 									
			 								} catch (SQLException e) {
			 									// TODO Auto-generated catch block1
			 								
			 									e.printStackTrace();
			 								}
			 				    			 
			 		
			 												    		 }
			    	    	 break;
			    	     case 5:
			    	    	 System.out.println("\nEnter Sender Account ID:\n");
			    	    		 obj= new Scanner(System.in);
			    	    		int id1= obj.nextInt();
			    	    		System.out.println("\nEnter Reciver Account ID:\n");
			    	    		int id2= obj.nextInt();
			    	    		System.out.println("\nEnter Amount: \n");
			    	    		 b= obj.nextInt();
			    	    		while(b<0)
			    	    		{
			    	    			System.out.println("Amount cannot be negative:");
			    	    			System.out.println("Enter Again");
			    	    			b= obj.nextInt();
			    	    		}
			    	    
			    	    	if(temp9==1)

				    		{
			    	    		transferAmount(b,id1,id2);
				    		}
			    	    	 else if(temp9==2)
				    		 {
				    			 int b1=0,b2=0;
				    			 java.sql.Statement s1 = null;
									try {
										s1 = ConnectionBuilderOracle.buildConnection().createStatement();
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
					    			 try {
										ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id1);
										ResultSet str2 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id2);
										while(str1.next()) {
											int id3=str1.getInt(1);
	
											String balan=str1.getString("balance");
								 
											 b1=Integer.parseInt(balan); 
	                                           b1=b1-b;
												}
										while(str2.next()) {
											int id3=str2.getInt(1);
	
											String balan=str2.getString("balance");
								 
											 b2=Integer.parseInt(balan); 
	                                           b2=b2+b;
												}
										
										
										
										String str3 ="UPDATE accounts SET balance=? where acc_id="+id1;
										String str4 ="UPDATE accounts SET balance=? where acc_id="+id2;
						    			 try {
											PreparedStatement state=ConnectionBuilderOracle.buildConnection().prepareStatement(str3);
											PreparedStatement state1=ConnectionBuilderOracle.buildConnection().prepareStatement(str4);
											state.setString(1,""+b1);
											state1.setString(1,""+b2);
											
											int inserted=state.executeUpdate();
											if(inserted>0)
											{
												System.out.println("Transfer successfull");
											}
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
						    			 
						    			 
										
									} catch (SQLException e) {
										// TODO Auto-generated catch block1
									
										e.printStackTrace();
									}
								
				    		 }
				    		 else if(temp9==3)
				    		 {
				    			 int b1=0,b2=0;
				    			 java.sql.Statement s1 = null;
				    			 java.sql.Statement s2 = null;
									try {
										s1 = ConnectionBuilderMysql.buildConnection().createStatement();
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
					    			 try {
										ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id1);
										
										while(str1.next()) {
											int id3=str1.getInt(1);
	
											String balan=str1.getString("balance");
								 
											 b1=Integer.parseInt(balan); 
	                                           b1=b1-b;
												}
										s2 = ConnectionBuilderMysql.buildConnection().createStatement();
										ResultSet str2 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id2);
										while(str2.next()) {
											int id3=str2.getInt(1);
	
											String balan=str2.getString("balance");
								 
											 b2=Integer.parseInt(balan); 
	                                           b2=b2+b;
												}
										
										
										System.out.println("Transfer successfull"+b1+"   "+b2);
										String str3 ="UPDATE accounts SET balance=? where acc_id="+id1;
										String str4 ="UPDATE accounts SET balance=? where acc_id="+id2;
						    			 try {
											PreparedStatement state=ConnectionBuilderMysql.buildConnection().prepareStatement(str3);
											
											state.setString(1,""+b1);
											PreparedStatement state1=ConnectionBuilderMysql.buildConnection().prepareStatement(str4);
											state1.setString(1,""+b2);
											
											int inserted=state.executeUpdate();
											int inserted1=state1.executeUpdate();
											if(inserted>0)
											{
												System.out.println("Transfer successfull");
											}
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
						    			 
						    			 
										
									} catch (SQLException e) {
										// TODO Auto-generated catch block1
									
										e.printStackTrace();
									}
				    		 }
			    	    	break;
			    	     case 6:
			    	    	 System.out.println("Enter Account ID");
			    	    		obj= new Scanner(System.in);
			    	    		 id= obj.nextInt();
			    	    		
			    	    		if(temp9==1)
			    	    		{
			    	    			double zak=ZakatFun(id);
				    	    		System.out.println( "Zakat on your Account Balance is: " + zak);
			    	    		}
			    	    		 else if(temp9==2)
					    		 {
					    			 
					    			 java.sql.Statement s1 = null;
										try {
											s1 = ConnectionBuilderOracle.buildConnection().createStatement();
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
						    			 try {
											ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id);
											while(str1.next()) {
												
					
												String balan=str1.getString("balance");
												int bal=Integer.parseInt(balan); 
												Customer c1=new Customer();
												
											System.out.println("Zakat is: "+	(bal*2.5)/100);
													}
											
										} catch (SQLException e) {
											// TODO Auto-generated catch block1
										
											e.printStackTrace();
										}
									
					    		 }
					    		 else if(temp9==3)
					    		 {
					    			 java.sql.Statement s1 = null;
										try {
											s1 = ConnectionBuilderMysql.buildConnection().createStatement();
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
						    			 try {
						    				 ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id);
												while(str1.next()) {
													
						
													String balan=str1.getString("balance");
													int bal=Integer.parseInt(balan); 
													Customer c1=new Customer();
													
												System.out.println("Zakat is: "+	(bal*2.5)/100);
														}
											
										} catch (SQLException e) {
											// TODO Auto-generated catch block1
										
											e.printStackTrace();
										}
					    		 }
			    	    	
			    	    	break;
			    	     case 7:
			    	    	 System.out.println("Enter Account ID");
			    	    		 obj= new Scanner(System.in);
			    	    		 id= obj.nextInt();
				    	    	if(temp9==1)

					    		{
				    	    		double temp2=DisplayAllDeductions(id);
				        	    	System.out.println( "Deduction on this account is: " + temp2);
					    		}
							    		 else if(temp9==2)
							    		 {
							    			 
							    			 java.sql.Statement s1 = null;
												try {
													s1 = ConnectionBuilderOracle.buildConnection().createStatement();
												} catch (SQLException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
								    			 try {
													ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id);
													while(str1.next()) {
													
							
														String balan=str1.getString("balance");
														int bal=Integer.parseInt(balan); 
														Customer c1=new Customer();
														
													System.out.println("Deduction is is: "+	(bal*2.5)/100);
															}
													
												} catch (SQLException e) {
													// TODO Auto-generated catch block1
												
													e.printStackTrace();
												}
											
							    		 }
							    		 else if(temp9==3)
							    		 {
							    			 java.sql.Statement s1 = null;
												try {
													s1 = ConnectionBuilderMysql.buildConnection().createStatement();
												} catch (SQLException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
								    			 try {
								    				 ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id);
														while(str1.next()) {
															
								
															String balan=str1.getString("balance");
															int bal=Integer.parseInt(balan); 
															Customer c1=new Customer();
															
														System.out.println("Deduction is is: "+	(bal*2.5)/100);
																}
													
												} catch (SQLException e) {
													// TODO Auto-generated catch block1
												
													e.printStackTrace();
												}
							    		 }
				    	    	
				    	    	break;
			    	     case 8:
			    	    	 System.out.println("Enter Account ID");
				    		 obj= new Scanner(System.in);
				    		 id= obj.nextInt();
				    		if(temp9==1)

				    		{
				    			double temp4=calculatelnterest(id);
					    		System.out.println( "total interest is: " + temp4);
				    		}
						    		 else if(temp9==2)
						    		 {
						    			 
						    			 java.sql.Statement s1 = null;
											try {
												s1 = ConnectionBuilderOracle.buildConnection().createStatement();
											} catch (SQLException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
							    			 try {
												ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id);
												while(str1.next()) {
													
													String interest=str1.getString("interest");
													String balan=str1.getString("balance");
													
													double inter=Double.parseDouble(interest); 
													int bal=Integer.parseInt(balan); 
													Customer c1=new Customer();
												
												System.out.println("Interest is: "+	(bal*inter)/100);
														}
												
											} catch (SQLException e) {
												// TODO Auto-generated catch block1
											
												e.printStackTrace();
											}
										
						    		 }
						    		 else if(temp9==3)
						    		 {
						    			 java.sql.Statement s1 = null;
											try {
												s1 = ConnectionBuilderMysql.buildConnection().createStatement();
											} catch (SQLException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
							    			 try {
							    				 ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id);
													while(str1.next()) {
														
														String interest=str1.getString("interest");
														String balan=str1.getString("balance");
														
														double inter=Double.parseDouble(interest); 
														int bal=Integer.parseInt(balan); 
														Customer c1=new Customer();
													
													System.out.println("Interest is: "+	(bal*inter)/100);
															}
												
											} catch (SQLException e) {
												// TODO Auto-generated catch block1
											
												e.printStackTrace();
											}
						    		 }
				    	
				    	    	break;
			    	     case 9:
			    		    	System.exit(0);
			    	     case 0:
			    	    	return;
			    	    	default:
			    	    		System.out.println("Wrong input! Try Again");
			    	    		
			    	     }
			    	 }
			    	    	 //obj2.close();	
			    	   // obj2.nextLine();	 
			    	 }
			    	 
			    	 
			    	 
			    	 
			    	 
			    	 
			    	 
			    	 
			     case 2:
			    	 
			    	 int  temp2=0;
			    	 Scanner obj3= new Scanner(System.in);
			    	 while(true)
			    	 { menuCustomerChecking(); 
			    	

			    	 if(obj3.hasNextInt())
			    	 {
			    	   temp2= obj3.nextInt();
			    	 
			    	    	 switch(temp2)
			    	     {
			    	     
			    	     case 1:
			    	    	 System.out.println("Enter Account ID");
			    	    		Scanner obj= new Scanner(System.in);
			    	    		int id= obj.nextInt();
			    	    		System.out.println("\nEnter Amount: \n");
			    	    		int b= obj.nextInt();
			    	    		while(b<0)
			    	    		{
			    	    			System.out.println("Amount cannot be negative:");
			    	    			System.out.println("Enter Again");
			    	    			b= obj.nextInt();
			    	    		}
			    	    		if(temp9==1)

					    		{
				    	    		deposit(b,id);
					    		}
							    		 else if(temp9==2)
							    		 {
							    			 int b1=0;
							    			 java.sql.Statement s1 = null;
												try {
													s1 = ConnectionBuilderOracle.buildConnection().createStatement();
												} catch (SQLException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
								    			 try {
													ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id);
													while(str1.next()) {
														int id2=str1.getInt(1);
				
														String balan=str1.getString("balance");
											 
														 b1=Integer.parseInt(balan); 
				                                           b1=b1+b;
															}
													
													
													
													String str2 ="UPDATE accounts SET balance=? where acc_id="+id;
									    			 try {
														PreparedStatement state=ConnectionBuilderOracle.buildConnection().prepareStatement(str2);
														state.setString(1,""+b1);
														
														int inserted=state.executeUpdate();
														if(inserted>0)
														{
															System.out.println("Account Deposite successfuliy");
														}
													} catch (Exception e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
									    			 
									    			 
													
												} catch (SQLException e) {
													// TODO Auto-generated catch block1
												
													e.printStackTrace();
												}
											
							    		 }
							    		 else if(temp9==3)
							    		 {
							    			 int b1=0;
							    			 java.sql.Statement s1 = null;
												try {
													s1 = ConnectionBuilderMysql.buildConnection().createStatement();
												} catch (SQLException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
								    			 try {
													ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id);
													while(str1.next()) {
														int id2=str1.getInt(1);
				
														String balan=str1.getString("balance");
											 
														 b1=Integer.parseInt(balan); 
				                                           b1=b1+b;
															}
													
													
													
													String str2 ="UPDATE accounts SET balance=? where acc_id="+id;
									    			 try {
														PreparedStatement state=ConnectionBuilderMysql.buildConnection().prepareStatement(str2);
														state.setString(1,""+b1);
														
														int inserted=state.executeUpdate();
														if(inserted>0)
														{
															System.out.println("Account Deposite successfuliy");
														}
													} catch (Exception e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
									    			 
									    			 
													
												} catch (SQLException e) {
													// TODO Auto-generated catch block1
												
													e.printStackTrace();
												}
							    		 }
			    	    	 break;
			    	     case 2:
			    	    	 System.out.println("Enter Account ID");
			    	    		 obj= new Scanner(System.in);
			    	    		 id= obj.nextInt();
			    	    		System.out.println("\nEnter Amount: \n");
			    	    		 b= obj.nextInt();
			    	    		while(b<0)
			    	    		{
			    	    			System.out.println("Amount cannot be negative:");
			    	    			System.out.println("Enter Again");
			    	    			b= obj.nextInt();
			    	    		}
			    	    		 if(temp9==1)

						    		{
				    	    		 withdraw(b,id);
						    		}
								    		 else if(temp9==2)
								    		 {
								    			 int b1=0;
								    			 java.sql.Statement s1 = null;
													try {
														s1 = ConnectionBuilderOracle.buildConnection().createStatement();
													} catch (SQLException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													}
									    			 try {
														ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id);
														while(str1.next()) {
															int id2=str1.getInt(1);
					
															String balan=str1.getString("balance");
												 
															 b1=Integer.parseInt(balan); 
					                                           b1=b1-b;
																}
														
														
														
														String str2 ="UPDATE accounts SET balance=? where acc_id="+id;
										    			 try {
															PreparedStatement state=ConnectionBuilderOracle.buildConnection().prepareStatement(str2);
															state.setString(1,""+b1);
															
															int inserted=state.executeUpdate();
															if(inserted>0)
															{
																System.out.println("Account withdraw successfuliy");
															}
														} catch (Exception e) {
															// TODO Auto-generated catch block
															e.printStackTrace();
														}
										    			 
										    			 
														
													} catch (SQLException e) {
														// TODO Auto-generated catch block1
													
														e.printStackTrace();
													}
												
								    		 }
								    		 else if(temp9==3)
								    		 {
								    			 int b1=0;
								    			 java.sql.Statement s1 = null;
													try {
														s1 = ConnectionBuilderMysql.buildConnection().createStatement();
													} catch (SQLException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													}
									    			 try {
														ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id);
														while(str1.next()) {
															int id2=str1.getInt(1);
					
															String balan=str1.getString("balance");
												 
															 b1=Integer.parseInt(balan); 
					                                           b1=b1-b;
																}
														
														
														
														String str2 ="UPDATE accounts SET balance=? where acc_id="+id;
										    			 try {
															PreparedStatement state=ConnectionBuilderMysql.buildConnection().prepareStatement(str2);
															state.setString(1,""+b1);
															
															int inserted=state.executeUpdate();
															if(inserted>0)
															{
																System.out.println("Account withdraw successfuliy");
															}
														} catch (Exception e) {
															// TODO Auto-generated catch block
															e.printStackTrace();
														}
										    			 
										    			 
														
													} catch (SQLException e) {
														// TODO Auto-generated catch block1
													
														e.printStackTrace();
													}
								    		 }
			    	    	 break;
			    	     case 3:
			    	    	 System.out.println("Enter Account ID");
			    	    		 obj= new Scanner(System.in);
			    	    		 id= obj.nextInt();
			    	    	
			    	    	 if(temp9==1)

					    		{
			    	    		 System.out.println(balance(id));
					    		}
							    		 else if(temp9==2)
							    		 {
							    			 
							    			 java.sql.Statement s1 = null;
												try {
													s1 = ConnectionBuilderOracle.buildConnection().createStatement();
												} catch (SQLException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
								    			 try {
													ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id);
													while(str1.next()) {
														int id2=str1.getInt(1);
														String balan=str1.getString("balance");
														System.out.println("Balance: "+balan);
															}
													
												} catch (SQLException e) {
													// TODO Auto-generated catch block1
												
													e.printStackTrace();
												}
											
							    		 }
							    		 else if(temp9==3)
							    		 {
							    			 java.sql.Statement s1 = null;
												try {
													s1 = ConnectionBuilderMysql.buildConnection().createStatement();
												} catch (SQLException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
								    			 try {
								    				 ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id);
														while(str1.next()) {
															int id2=str1.getInt(1);
															String balan=str1.getString("balance");
															System.out.println("Balance: "+balan);
																}
													
												} catch (SQLException e) {
													// TODO Auto-generated catch block1
												
													e.printStackTrace();
												}
							    		 }
			    	    	 break;
			    	     case 4:
			    	    	 if(temp9==1)
				 				{
				    	    		 pstatement();
				 					
				 				}
				 			    		 else if(temp9==2)
				 			    		 {System.out.println("Enter Account ID");
				 			    		Scanner obj5= new Scanner(System.in);
				 			    		int id3= obj5.nextInt();
				 			    			 java.sql.Statement s1 = null;
				 								try {
				 									s1 = ConnectionBuilderOracle.buildConnection().createStatement();
				 								} catch (SQLException e1) {
				 									// TODO Auto-generated catch block
				 									e1.printStackTrace();
				 								}
				 				    			 try {
				 									ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where acc_id+"+id3);
				 									while(str1.next()) {
				 										int id2=str1.getInt(1);
				 										String		name=str1.getString("name");
				 										String		addr=str1.getString("addr");
				 										String		cont=str1.getString("cont");
				 										String balan=str1.getString("balance");
				 										String		type=str1.getString("acc_type");
				 										String		date=str1.getString("creatation_date");
				 									String	tran=str1.getString("LastTansection");
				 										String deposite=str1.getString("deposited");
				 										String fee=str1.getString("trans_fee");
				 										String interest=str1.getString("interest");
				 									System.out.println("====================================");
				 										System.out.println("Account ID: "+id2+"\nName: "+name+"\nAddress: "+addr+"\nContact: "+cont+"\nBalance: "+balan+"\nCreatation Date: "+date+"\nLast Transection: "+tran+"\nDeposite: "+deposite+"\nTransection fee: "+fee+"\n3Interest: "+interest);	
				 									}
				 									
				 								} catch (SQLException e) {
				 									// TODO Auto-generated catch block1
				 								
				 									e.printStackTrace();
				 								}
				 				    			 
				 			    		 }
				 			    		 else if(temp9==3)
				 			    		 {System.out.println("Enter Account ID");
				 			    		Scanner obj4= new Scanner(System.in);
				 			    		int id3= obj4.nextInt();
				 			    			 java.sql.Statement s1 = null;
				 								try {
				 									s1 = ConnectionBuilderMysql.buildConnection().createStatement();
				 								} catch (SQLException e1) {
				 									// TODO Auto-generated catch block
				 									e1.printStackTrace();
				 								}
				 				    			 try {
				 									ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where acc_id="+id3);
				 									while(str1.next()) {
				 										int id2=str1.getInt(1);
				 									String	name=str1.getString("name");
				 									String	addr=str1.getString("addr");
				 									String	cont=str1.getString("cont");
				 										String balan=str1.getString("balance");
				 										String	type=str1.getString("acc_type");
				 										String	date=str1.getString("creatation_date");
				 									String	tran=str1.getString("LastTansection");
				 										String deposite=str1.getString("deposited");
				 										String fee=str1.getString("trans_fee");
				 										String interest=str1.getString("interest");
				 									System.out.println("====================================");
				 										System.out.println("Account ID: "+id2+"\nName: "+name+"\nAddress: "+addr+"\nContact: "+cont+"\nBalance: "+balan+"\nCreatation Date: "+date+"\nLast Transection: "+tran+"\nDeposite: "+deposite+"\nTransection fee: "+fee+"\nInterest: "+interest);	
				 									}
				 									
				 								} catch (SQLException e) {
				 									// TODO Auto-generated catch block1
				 								
				 									e.printStackTrace();
				 								}
				 				    			 
				 		
				 												    		 }
			    	    	 break;
			    	     case 5:
			    	    	 System.out.println("\nEnter Sender Account ID:\n");
		    	    		 obj= new Scanner(System.in);
		    	    		int id1= obj.nextInt();
		    	    		System.out.println("\nEnter Reciver Account ID:\n");
		    	    		int id2= obj.nextInt();
		    	    		System.out.println("\nEnter Amount: \n");
		    	    		 b= obj.nextInt();
		    	    		while(b<0)
		    	    		{
		    	    			System.out.println("Amount cannot be negative:");
		    	    			System.out.println("Enter Again");
		    	    			b= obj.nextInt();
		    	    		}
		    	    		if(temp9==1)

				    		{
			    	    		transferAmount(b,id1,id2);
				    		}
			    	    	 else if(temp9==2)
				    		 {
				    			 int b1=0,b2=0;
				    			 java.sql.Statement s1 = null;
									try {
										s1 = ConnectionBuilderOracle.buildConnection().createStatement();
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
					    			 try {
										ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id1);
										ResultSet str2 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id2);
										while(str1.next()) {
											int id3=str1.getInt(1);
	
											String balan=str1.getString("balance");
								 
											 b1=Integer.parseInt(balan); 
	                                           b1=b1-b;
												}
										while(str2.next()) {
											int id3=str2.getInt(1);
	
											String balan=str2.getString("balance");
								 
											 b2=Integer.parseInt(balan); 
	                                           b2=b2+b;
												}
										
										
										
										String str3 ="UPDATE accounts SET balance=? where acc_id="+id1;
										String str4 ="UPDATE accounts SET balance=? where acc_id="+id2;
						    			 try {
											PreparedStatement state=ConnectionBuilderOracle.buildConnection().prepareStatement(str3);
											PreparedStatement state1=ConnectionBuilderOracle.buildConnection().prepareStatement(str4);
											state.setString(1,""+b1);
											state1.setString(1,""+b2);
											
											int inserted=state.executeUpdate();
											if(inserted>0)
											{
												System.out.println("Transfer successfull");
											}
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
						    			 
						    			 
										
									} catch (SQLException e) {
										// TODO Auto-generated catch block1
									
										e.printStackTrace();
									}
								
				    		 }
				    		 else if(temp9==3)
				    		 {
				    			 int b1=0,b2=0;
				    			 java.sql.Statement s1 = null;
				    			 java.sql.Statement s2 = null;
									try {
										s1 = ConnectionBuilderMysql.buildConnection().createStatement();
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
					    			 try {
										ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id1);
										
										while(str1.next()) {
											int id3=str1.getInt(1);
	
											String balan=str1.getString("balance");
								 
											 b1=Integer.parseInt(balan); 
	                                           b1=b1-b;
												}
										s2 = ConnectionBuilderMysql.buildConnection().createStatement();
										ResultSet str2 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id2);
										while(str2.next()) {
											int id3=str2.getInt(1);
	
											String balan=str2.getString("balance");
								 
											 b2=Integer.parseInt(balan); 
	                                           b2=b2+b;
												}
										
										
										System.out.println("Transfer successfull"+b1+"   "+b2);
										String str3 ="UPDATE accounts SET balance=? where acc_id="+id1;
										String str4 ="UPDATE accounts SET balance=? where acc_id="+id2;
						    			 try {
											PreparedStatement state=ConnectionBuilderMysql.buildConnection().prepareStatement(str3);
											
											state.setString(1,""+b1);
											PreparedStatement state1=ConnectionBuilderMysql.buildConnection().prepareStatement(str4);
											state1.setString(1,""+b2);
											
											int inserted=state.executeUpdate();
											int inserted1=state1.executeUpdate();
											if(inserted>0)
											{
												System.out.println("Transfer successfull");
											}
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
						    			 
						    			 
										
									} catch (SQLException e) {
										// TODO Auto-generated catch block1
									
										e.printStackTrace();
									}
				    		 }
			    	    	break;
			    	     case 7:
			    	    	 System.out.println("Enter Account ID");
		    	    		 obj= new Scanner(System.in);
		    	    		 id= obj.nextInt();
		    	    		 if(temp9==1)

					    		{
				    	    		double temp4=DisplayAllDeductions(id);
				        	    	System.out.println( "Deduction on this account is: " + temp4);
					    		}
							    		 else if(temp9==2)
							    		 {
							    			 
							    			 java.sql.Statement s1 = null;
												try {
													s1 = ConnectionBuilderOracle.buildConnection().createStatement();
												} catch (SQLException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
								    			 try {
													ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id);
													while(str1.next()) {
													
							
														String balan=str1.getString("balance");
														int bal=Integer.parseInt(balan); 
														Customer c1=new Customer();
														
													System.out.println("Deduction is is: "+	(bal*2.5)/100);
															}
													
												} catch (SQLException e) {
													// TODO Auto-generated catch block1
												
													e.printStackTrace();
												}
											
							    		 }
							    		 else if(temp9==3)
							    		 {
							    			 java.sql.Statement s1 = null;
												try {
													s1 = ConnectionBuilderMysql.buildConnection().createStatement();
												} catch (SQLException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
								    			 try {
								    				 ResultSet str1 =((java.sql.Statement) s1).executeQuery("Select * from accounts where Acc_id="+id);
														while(str1.next()) {
															
								
															String balan=str1.getString("balance");
															int bal=Integer.parseInt(balan); 
															Customer c1=new Customer();
															
														System.out.println("Deduction is is: "+	(bal*2.5)/100);
																}
													
												} catch (SQLException e) {
													// TODO Auto-generated catch block1
												
													e.printStackTrace();
												}
							    		 }
				    	    	break;
			    	     case 9:
			    		    	System.exit(0);
			    	     case 0:
			    	    	return;
			    	    	default:
			    	    		System.out.println("Wrong input! Try Again");
			    	    		
			    	     }
			    	 }
			    	    	 //obj2.close();	
			    	   // obj2.nextLine();	 
			    	 }
			    	 
			     case 9:
				    	System.exit(0);
			     case 0:
	    	    	 return;
			    	 
		     }
			
		 return;
	     
	}
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
//MainMenu m1= new MainMenu();
		//Oracle connection
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					System.out.println("SQL PLUS Driver successfully loaded");
					
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","aq4427");
					System.out.println("SQL PLUS Connection Established");
				}
				catch(ClassNotFoundException e) {
					System.out.println("SQL PLUS Driver not loaded");
				}
				
				catch(SQLException e) {
					System.out.println("SQL PLUS Connection Failed");
				}
				
				
				//Mysql connection
				try {
					 //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("MySQL Driver successfully loaded");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Account_Management_System","root","aq4427");
					System.out.println("MySQL Connection Established");
				}
				catch(ClassNotFoundException e) {
					//e.printStackTrace();
					System.out.println("MySQL Driver not loaded");
				}
				
				catch(SQLException e) {
					System.out.println("MySQL Connection Failed");
				}
				
			
		System.out.println("Please enter your choice to Store Data:");
		System.out.println("1)-->File");
		System.out.println("2)-->Oracle");
		System.out.println("3)-->MySQL");
		Scanner	obj4= new Scanner(System.in);
		int temp5= obj4.nextInt();
		while(temp5<1||temp5>3)
		{
			System.out.println("Oop! Wrong input---Try Again:");
		    temp5= obj4.nextInt();
		}
		

  


Accounts Acc= new Accounts(System.in);
Acc.menu1();  
System.out.println("Press The Button");
Scanner obj1= new Scanner(System.in);
int temp= obj1.nextInt();
while(true)
{if(temp==1)
	{ 
	Acc.addmin(temp5);
	Acc.menu1();    
	System.out.println("Press The Button");
	
	obj1= new Scanner(System.in);
	 temp= obj1.nextInt();
	}
if(temp==2)
	{
	Acc.Custom(temp5);
	Acc.menu1();    //static function call
	System.out.println("Press The Button");
	
	obj1= new Scanner(System.in);
	 temp= obj1.nextInt();
	}
if(temp==9)
    	System.exit(0);
}
	}

}






