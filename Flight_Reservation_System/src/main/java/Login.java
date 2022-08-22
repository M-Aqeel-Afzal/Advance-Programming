import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Login {
protected static String UserType="Admin";
protected static String UserID;
public void setUserID(String n)
{
	UserID=n;
}
public String getUserID()
{
	return UserID;
}
public static boolean loginMenu()
{
	System.out.println("<================> Wellcome <===================>");
	System.out.println("\n\n 1) Sign In");
	System.out.println("2) Sign Up");
	Scanner obj1= new Scanner(System.in);
	int temp1= obj1.nextInt();
	if(temp1==1)
	{
		boolean flag= Signin();
		while(true)
		{
			if(flag)
			{System.out.println("Sign IN Successful!");
			break;
			}
			else {
			System.out.println("Account does not exist with this ID...Please Create an account!");
			
			}
			 flag=loginMenu();
		}
		
	}
	else if(temp1==2)
	{
		boolean flag= Signup();
		while(true)
		{
			if(flag)
			{System.out.println("Sign up Successful!");
			break;
			}
			else {
			System.out.println("Account Already Exists");
			System.out.println("Try Again!");
			
			}
			 flag=Signup();
		}
	}
	else
	{
		System.out.println("Wrong Input!");
		 loginMenu();
	}
	return true;
}
public static boolean Signup()
{
	System.out.println("Please Enter User ID:");
	Scanner obj1= new Scanner(System.in);
	String temp1= obj1.nextLine();
	String temp="";
	boolean flag=true;
	
		try {
		      FileWriter myfile = new FileWriter("login.txt",true);
		      
		      try {
		          File myObj = new File("login.txt");
		          
		          Scanner myReader = new Scanner(myObj);
		          while (myReader.hasNextLine()) {
		            String data = myReader.nextLine();
		            String[] arr = data.split(",");    

		            for ( String ss : arr) {
		                temp=ss;
		                if(temp.equals(temp1))
		                {
		                			              
		                		flag=false;
		                }
		            }
		            
		          }
		          myReader.close();
		        } catch (FileNotFoundException e) {
		          System.out.println("An error occurred.");
		          e.printStackTrace();
		        }
		      
		      if(flag)
		      { String s1="\n"+temp1+",Customer";
		    	  myfile.write(s1);
		      myfile.close();
		      return true;
		      }
		      else 
		      {
		    	  
		    	  myfile.close();
		    	  return false;
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	
	return true;
}
public static boolean Signin()
{
	System.out.println("Please Enter User ID:");
	Scanner obj1= new Scanner(System.in);
	String temp1= obj1.nextLine();
	String temp="";
	boolean flag=false;
	
		try {
		      FileWriter myfile = new FileWriter("login.txt",true);
		      
		      try {
		          File myObj = new File("login.txt");
		          
		          Scanner myReader = new Scanner(myObj);
		          while (myReader.hasNextLine()) {
		            String data = myReader.nextLine();
		            String[] arr = data.split(",");    

		            for ( String ss : arr) {
		                temp=ss;
		                if(temp.equals(temp1))
		                {
		                			              
		                		flag=true;
		                }
		            }
		            
		          }
		          myReader.close();
		        } catch (FileNotFoundException e) {
		          System.out.println("An error occurred.");
		          e.printStackTrace();
		        }
		      
		     
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	
	return flag;
}

	
	
}


