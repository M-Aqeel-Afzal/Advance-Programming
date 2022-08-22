import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.FileWriter;

//import java.io.*;
public class Customer {
	node head;
	 class node {
 String Name;
 String Address;
 String Contact;
 int AccountID;
 String  type;
 double balance=0;
 String date_created;
 String last_transection;
 String last_T;
 double fee_t=0;
 double interest=0.0;
	node next;
node(String n,String addr,String con,int id,String flg,double bal,String dat,String tran,String t,double ft,double intr)
{
	try {
	      File myfile = new File("accounts.txt");
	      if (myfile.createNewFile()) {
	        System.out.println("File has been created!" + myfile.getName());
	      } else {	        
	      }
	    } catch (IOException e) {
	      System.out.println("Error occurred!");
	      e.printStackTrace();
	    }
	  
	Name=n;
	Address=addr;
	Contact=con;
	AccountID=id;
	type=flg;
	balance=bal;
	date_created=dat;
	last_transection=tran;
	last_T=t;
	fee_t=ft;
	interest=intr;
}
	}
	
	public Customer insert(Customer C_list,String n,String addr,String con,int id,String flg,double bal,String dat,String tran,String t,double ft,double intr)
    {
		String temp="";
		boolean flag=true;
		try {
		      FileWriter myfile = new FileWriter("accounts.txt",true);
		      
		      try {
		          File myObj = new File("accounts.txt");
		          
		          Scanner myReader = new Scanner(myObj);
		          while (myReader.hasNextLine()) {
		            String data = myReader.nextLine();
		            String[] arr = data.split(",");    

		            for ( String ss : arr) {
		                temp=ss;
		                if(temp.equals("ACC_ID-"+id))
		                	flag=false;
		               
		                break;
		            }
		            
		          }
		          myReader.close();
		        } catch (FileNotFoundException e) {
		          System.out.println("An error occurred.");
		          e.printStackTrace();
		        }
		      
		      if(flag)
		      {  myfile.write("ACC_ID-"+id +","+"Name-"+ n +"," +"Contect-"+ con +"," +"Address-"+ addr +"," +"ACC_Type-"+ flg +"," +"ACC_Balance-"+ bal +"," +"ACC_CreatedAt-"+ dat +"," +"LastTransection-"+ tran +"," +"tex-"+ t +"," +"Transection-fee-"+ ft +"," +"Interest-"+ intr +"\r\n");
		      myfile.close();
		      System.out.println("Registration Successfull");
		      }
		      else 
		      {
		    	  System.out.println("Account Already Exists");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
        node temp_node = new node(n,addr,con,id,flg,bal,dat,tran,t,ft,intr);
        temp_node.next = null;
   
       
        if (C_list.head == null) {
        	C_list.head = temp_node;
        }
        else {
            
            node last = C_list.head;
            while (last.next != null) {
                last = last.next;
            }
   
           
            last.next = temp_node;
        }
		
       
        return C_list;
    }

	public Customer deleteAccount(int id) throws IOException 
{
node temp = this.head, prev = null;
String temp1="";
String lineToRemove = "bbb";
FileInputStream instream = null;
FileOutputStream outstream = null;

try {
    File myObj = new File("accounts.txt");
    
    Scanner myReader = new Scanner(myObj);
    while (myReader.hasNextLine()) {
      String data = myReader.nextLine();
      String[] arr = data.split(",");    

      for ( String ss : arr) {
          temp1=ss;
          if(temp1.equals("ACC_ID-"+id))
        	  lineToRemove=data;
        //  System.out.println("Account founded");
          break;
      }
      
    }
    myReader.close();
  } catch (FileNotFoundException e) {
    System.out.println("An error occurred.");
    e.printStackTrace();
  }
File myObj = new File("accounts.txt");
File tempFile = new File("myTempFile.txt");

BufferedReader reader= new BufferedReader(new FileReader(myObj));

BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));


String currentLine;

	while((currentLine = reader.readLine()) != null) {
	    // trim newline when comparing with lineToRemove
	    String trimmedLine = currentLine.trim();
	    if(trimmedLine.equals(lineToRemove)) continue;
	    writer.write(currentLine + System.getProperty("line.separator"));
	}
writer.close(); 
reader.close(); 
boolean successful = tempFile.renameTo(myObj);
try{
    

    instream = new FileInputStream(tempFile);
    outstream = new FileOutputStream(myObj);

    byte[] buffer = new byte[1024];

    int length;
    /*copying the contents from input stream to
     * output stream using read and write methods
     */
    while ((length = instream.read(buffer)) > 0){
    	outstream.write(buffer, 0, length);
    }

    //Closing the input/output file streams
    instream.close();
    outstream.close();

   

}catch(IOException ioe){
	ioe.printStackTrace();
 }
if (temp != null && temp.AccountID == id) {
this.head = temp.next; // Changed head


System.out.println("Account founded and deleted");
return this;
}
else {


while (temp != null && temp.AccountID != id) {
    prev = temp;
    temp = temp.next;
}


if (temp != null) {
    prev.next = temp.next;
    System.out.println("Account founded and deleted");
}

if (temp == null) {
    System.out.println("Account not found");
}
return this;
}


}
	
	
	public boolean Login(int id)
	{
		
		
		
		
		
		
		
		String temp1="";
		boolean flag=true;
		try {
		      FileWriter myfile = new FileWriter("accounts.txt",true);
		      
		      try {
		          File myObj = new File("accounts.txt");
		          
		          Scanner myReader = new Scanner(myObj);
		          while (myReader.hasNextLine()) {
		            String data = myReader.nextLine();
		            String[] arr = data.split(",");    

		            for ( String ss : arr) {
		            	temp1=ss;
		                if(temp1.equals("ACC_ID-"+id))
		                {	 System.out.println("Login Successful!");
		               flag=false;
		                break;}
		            }
		            
		          }
		         
		          if(flag)
		        	  System.out.println("Account not found");
		          myReader.close();
		        } catch (FileNotFoundException e) {
		          System.out.println("An error occurred.");
		          e.printStackTrace();
		        }
		  } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	node temp = this.head, prev = null;

	if (temp != null && temp.AccountID == id) {
	
		 System.out.println("Login Successful!");
	return true;
	}
	else {


	while (temp != null && temp.AccountID != id) {
	    prev = temp;
	    temp = temp.next;
	}


	if (temp != null) {
		// System.out.println("Login Successful!");
		 return true;
	}

	if (temp == null) {
	   // System.out.println("Account not found");
	    
	    return false;
	}
	}

	return true;
	
	}
	
	
	
	public void ShowAllAccount()
	{
		

		
		String temp1="";
		boolean flag=true;
		try {
		      FileWriter myfile = new FileWriter("accounts.txt",true);
		      
		      try {
		          File myObj = new File("accounts.txt");
		          
		          Scanner myReader = new Scanner(myObj);
		          while (myReader.hasNextLine()) {
		            String data = myReader.nextLine();
		            System.out.println(data);
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
	 /*   node temp = this.head;

	    System.out.print(" All Bank Accounts Are: ");

	    while (temp != null) {
	    	 System.out.println();
	        System.out.println("Holder Name: " + temp.Name + "\nAccount ID: " + temp.AccountID + "\nAddress: " + temp.Address
	        		+ "\nContact: " + temp.Contact + "\nAccount Type: " + temp.type + "\n\nBalance: " + temp.balance +"\n\nLast Transection: "
	        		+ temp.date_created + "\n\n\n");

	       
	        temp = temp.next;
	    }
*/
	    System.out.println();
	}
	
	
	
	public void makeDeposit(double b,int id) throws IOException  //deposit function
	
	{
		String name,addr,con,flg,da,tran,t;
		double ft,bal,intr;
		int j=-1;
		boolean flag=true;
		String tempp="",reqrline="";
		String str1="ACC_ID-"+id;
		
		 try {
	          File myObj = new File("accounts.txt");
	          
	          Scanner myReader = new Scanner(myObj);
	          while (myReader.hasNextLine()) {
	            String data = myReader.nextLine();
	            String[] arr = data.split(",");    

	            for ( String ss : arr) {
	            	if(flag)
	            	tempp=ss;
	            	if(flag==false)
                	{
	            		if(j==6)
	            		{
	            			
	            			
	            			   String numb= ss.replaceAll("[^0-9]", "");
	            			
	            			double ba = Double.parseDouble(numb);
	            			
	            			ba=ba+b;
	            			
	            			ss="ACC_Balance-"+ba;
	            			
	            			
	            			
	            		}
	            		if(j==3)
	            		{
	            			
	            			ss="Deposited-" + b;	
	            		}
	            		str1=str1+","+ss;
                	
                	j--;}
	                if(tempp.equals("ACC_ID-"+id)&&flag)
	                { 	reqrline=data;
	                flag=false;
	                j=10;
	                }
	                
	                	
	                if(j==0)
	                {//str1=str1+"";
	                break;}
	               
	            }
	            if(flag==false)
	            	break;
	            
	           
	          }
	          if(flag)
	          System.out.println( "Account not found");
	          myReader.close();
	        } catch (FileNotFoundException e) {
	          System.out.println("error occurred.");
	          e.printStackTrace();
	        }
		
		Path path = Paths.get("accounts.txt");
		List<String> file_cont= new ArrayList<>(Files.readAllLines(path, StandardCharsets.UTF_8));
		

		

		for (int i = 0; i < file_cont.size(); i++) {
		    if (file_cont.get(i).equals(reqrline)) {
		    	 System.out.println("running");
			  //    String str=id +","+ n +"," + con +"," + addr +"," + flg +"," + "Deposited "+ +"," + dat +"," + tran +"," + t +"," + ft +"," + intr +"\r\n";

		    	 file_cont.set(i,str1);
		        break;
		    }
		}
		
		Files.write(path, file_cont, StandardCharsets.UTF_8);

node temp = this.head, prev = null;

if (temp != null && temp.AccountID == id) {
	temp.balance+=b;
	if(temp.type.equals("Checking")||temp.type.equals("checking"))
	temp.fee_t +=10;

	DateTimeFormatter d= DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a z");
	ZonedDateTime dat = ZonedDateTime.now();
	String date = d.format(dat);
	temp.last_T="Deposied " + b;
    temp.last_transection=date;
    
System.out.println("Deposit Successful---!");

}
else {

while (temp != null && temp.AccountID != id) {
    prev = temp;
    temp = temp.next;
}


if (temp != null) {
	temp.balance+=b;
	if(temp.type.equals("Checking")||temp.type.equals("checking"))
		temp.fee_t +=10;

	DateTimeFormatter d= DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a z");
	ZonedDateTime dat = ZonedDateTime.now();
	String date = d.format(dat);
    temp.last_transection=date;
    temp.last_T="Deposied " + b;
	System.out.println("Deposit Successful---!");
}

if (temp == null) {
    //System.out.println( "Account not found");
}
}

		
	}
	public void makeWithDraw(double b,int id) throws IOException  //Withdraw function
	{
		String name,addr,con,flg,da,tran,t;
		double ft,bal,intr;
		int j=-1;
		boolean flag=true;
		String tempp="",reqrline="";
		String str1="ACC_ID-"+id;
		
		 try {
	          File myObj = new File("accounts.txt");
	          
	          Scanner myReader = new Scanner(myObj);
	          while (myReader.hasNextLine()) {
	            String data = myReader.nextLine();
	            String[] arr = data.split(",");    

	            for ( String ss : arr) {
	            	if(flag)
	            	tempp=ss;
	            	if(flag==false)
                	{
	            		if(j==6)
	            		{
	            			
	            			
	            			   String numb= ss.replaceAll("[^0-9]", "");
	            			
	            			double ba = Double.parseDouble(numb);
	            			 System.out.println("----------->  "+ba);
	            			 if(b>ba)
	            			{
	            				 System.out.println("Account balance is not Enough! ");
	            			}else
	            			{
	            				ba=ba-b;
	            			}
	            			 System.out.println("----------->  "+ba);
	            			ss="ACC_Balance-"+ba;
	            			
	            			
	            			
	            		}
	            		if(j==3)
	            		{
	            			
	            			ss="WithDrawn-" + b;	
	            		}
	            		str1=str1+","+ss;
                	
                	j--;}
	                if(tempp.equals("ACC_ID-"+id)&&flag)
	                { 	reqrline=data;
	                flag=false;
	                j=10;
	                }
	                
	                	
	                if(j==0)
	                {//str1=str1+"";
	                break;}
	               
	            }
	            if(flag==false)
	            	break;
	            
	           
	          }
	          myReader.close();
	        } catch (FileNotFoundException e) {
	          System.out.println("error occurred.");
	          e.printStackTrace();
	        }
		
		Path path = Paths.get("accounts.txt");
		List<String> file_cont= new ArrayList<>(Files.readAllLines(path, StandardCharsets.UTF_8));
		

		

		for (int i = 0; i < file_cont.size(); i++) {
		    if (file_cont.get(i).equals(reqrline)) {
		    	
		    	 file_cont.set(i,str1);
		        break;
		    }
		}
		
		Files.write(path, file_cont, StandardCharsets.UTF_8);

node temp = this.head, prev = null;

if (temp != null && temp.AccountID == id) {
	temp.balance-=b;
	temp.last_T="WithDrawn-" + b;
	if(temp.type.equals("Checking")||temp.type.equals("checking"))
		temp.fee_t +=10;
	DateTimeFormatter d= DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a z");
	ZonedDateTime dat = ZonedDateTime.now();
	String date = d.format(dat);
    temp.last_transection=date;
    
System.out.println("Withdraw Successful---!");

}


while (temp != null && temp.AccountID != id) {
    prev = temp;
    temp = temp.next;
}


if (temp != null) {
	temp.balance-=b;
	temp.last_T="WithDrawn-" + b;
	
	if(temp.type.equals("Checking")||temp.type.equals("checking"))
		temp.fee_t +=10;
	DateTimeFormatter d= DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a z");
	ZonedDateTime dat = ZonedDateTime.now();
	String date = d.format(dat);
    temp.last_transection=date;
    
	System.out.println("Withdraw Successful---!");
}

if (temp == null) {
    System.out.println("Account not found");
}



		
		
	}
	public double CheckBalance(int id)  //CheckBalance function          
	{

		
		
		String name,addr,con,flg,da,tran,t;
		double ft,bal,intr;
		int j=-1;
		boolean flag=true;
		String tempp="",reqrline="";
		String str1="ACC_ID-"+id;
		
		 try {
	          File myObj = new File("accounts.txt");
	          
	          Scanner myReader = new Scanner(myObj);
	          while (myReader.hasNextLine()) {
	            String data = myReader.nextLine();
	            String[] arr = data.split(",");    

	            for ( String ss : arr) {
	            	if(flag)
	            	tempp=ss;
	            	if(flag==false)
                	{
	            		if(j==6)
	            		{
	            			
	            			
	            			   String numb= ss.replaceAll("[^0-9]", "");
	            			
	            			double ba = Double.parseDouble(numb);
	            			
	            				 System.out.println("Account balance is: "+ ba);
	            			
	            			
	            			
	            			
	            			
	            		}
	            		
	            		
                	
                	j--;}
	                if(tempp.equals("ACC_ID-"+id)&&flag)
	                { 
	                flag=false;
	                j=10;
	                }
	                
	                	
	                if(j==0)
	                {//str1=str1+"";
	                break;}
	               
	            }
	            if(flag==false)
	            	break;
	            
	           
	          }
	          if(flag)
	        	  System.out.println( "Account not found");
	          myReader.close();
	        } catch (FileNotFoundException e) {
	          System.out.println("error occurred.");
	          e.printStackTrace();
	        }
		
		

		
		
		
		
		
		
		
		
		
node temp = this.head, prev = null;

if (temp != null && temp.AccountID == id) {

return temp.balance;
}
else {

while (temp != null && temp.AccountID != id) {
    prev = temp;
    temp = temp.next;
}


if (temp != null) {
	
	return temp.balance;
}

if (temp == null) {
  //  System.out.println( "Account not found");
    
}


}

return 0;	
	}
public void printStatement(int id)              //printing transection statement

	{
		node temp = this.head, prev = null;

		if (temp != null && temp.AccountID == id) {
		
			 System.out.println("\n\nTransection Staement\n\n");
		        System.out.println("Holder Name: " + temp.Name + "\nAccount ID: " + temp.AccountID + "\nAddress: " + temp.Address
		        		+ "\nContact: " + temp.Contact + "\nAccount Type: " + temp.type + "\n\nCurrent Balance: " + temp.balance +"\n\nTransected at:  " 
		        		+ temp.date_created + "Last Transection" + temp.last_T + "\n\n\n");

		
		}


		while (temp != null && temp.AccountID != id) {
		    prev = temp;
		    temp = temp.next;
		}


		if (temp != null) {
			System.out.println();
	        System.out.println("Holder Name: " + temp.Name + "\nAccount ID: " + temp.AccountID + "\nAddress: " + temp.Address
	        		+ "\nContact: " + temp.Contact + "\nAccount Type: " + temp.type + "\n\nCurrent Balance: " + temp.balance +"\n\nTransected at:  " 
	        		+ temp.date_created + "Last Transection" + temp.last_T + "\n\n\n");

		}

		if (temp == null) {
		    System.out.println(id + " Account not found");
		}


		
		
}

public double calculateZakat(int id) throws IOException            //zakat calution
{

	double ba=0,zak;
	String name,addr,con,flg,da,tran,t;
	double ft,bal,intr;
	int j=-1;
	boolean flag=true;
	String tempp="",reqrline="";
	String str1="ACC_ID-"+id;
	
	 try {
          File myObj = new File("accounts.txt");
          
          Scanner myReader = new Scanner(myObj);
          while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] arr = data.split(",");    

            for ( String ss : arr) {
            	if(flag)
            	tempp=ss;
            	if(flag==false)
            	{
            		if(j==6)
            		{
            			
            			
            			   String numb= ss.replaceAll("[^0-9]", "");
            			  if( ba>=20000)
            			{ba = Double.parseDouble(numb);
            			zak=(ba*2.5)/100;
            			 System.out.println( "Zakat on the Account is: "+zak);
            			}
            			  else
            			  {
            				  System.out.println( "Balance is less then 20000/-");
            			  }
            		
            		}
            		
            		str1=str1+","+ss;
            	
            	j--;}
                if(tempp.equals("ACC_ID-"+id)&&flag)
                { 	reqrline=data;
                flag=false;
                j=10;
                }
                
                	
                if(j==0)
                {//str1=str1+"";
                break;}
               
            }
            if(flag==false)
            	break;
            
           
          }
          if(flag)
          System.out.println( "Account not found");
          myReader.close();

        } catch (FileNotFoundException e) {
          System.out.println("error occurred.");
          e.printStackTrace();
        }
	
	Path path = Paths.get("accounts.txt");
	List<String> file_cont= new ArrayList<>(Files.readAllLines(path, StandardCharsets.UTF_8));
	

	

	for (int i = 0; i < file_cont.size(); i++) {
	    if (file_cont.get(i).equals(reqrline)) {
	    	 System.out.println("running");
		  //    String str=id +","+ n +"," + con +"," + addr +"," + flg +"," + "Deposited "+ +"," + dat +"," + tran +"," + t +"," + ft +"," + intr +"\r\n";

	    	 file_cont.set(i,str1);
	        break;
	    }
	}
	
	Files.write(path, file_cont, StandardCharsets.UTF_8);

	
node temp = this.head, prev = null;

if (temp != null && temp.AccountID == id&& temp.type.equals("saving")&&temp.balance>=20000) {
	
	 zak=(temp.balance*2.5)/100;
return zak;
	

}

else {
while (temp != null && temp.AccountID != id) {
    prev = temp;
    temp = temp.next;
}


if (temp != null&& temp.type.equals("saving")&&temp.balance>=20000) {
	 zak=(temp.balance*2.5)/100;
	return zak;
}

if (temp == null) {
 //   System.out.println( " Account not found or balance is less then 20000/-");
}
}
return 0;
}
public double deduction(int id)                                 //deduction function      
{
	double zak=0;
node temp = this.head, prev = null;

	if (temp != null && temp.AccountID == id) {
		if(temp.type.equals("saving"))
		{
			
			return temp.fee_t;				
		}
		else
		{
			 zak=(temp.balance*2.5)/100;
			return zak;
		}

}
	else
	{


while (temp != null && temp.AccountID != id) {
    prev = temp;
    temp = temp.next;
}


if (temp != null) {
	if(temp.type.equals("saving"))
	{
		
			return temp.fee_t;		
	}
	else
	{
		zak=(temp.balance*2.5)/100;
		return zak;
	}
}

if (temp == null) {
    System.out.println( " Account not found");
}

}
	return zak;
}




public double interest(double intr,int id)                //interest function
{

node temp = this.head, prev = null;

	if (temp != null && temp.AccountID == id) {
		System.out.println( "entered");
		if(temp.type.equals("saving"))
		{
			
				temp.interest=(temp.balance*intr)/100;
				return temp.interest;
		}
		else
		{
			
			return -1;
		}

}
	else
	{
	



while (temp != null && temp.AccountID != id) {
    prev = temp;
    temp = temp.next;
}


if (temp != null) {
	if(temp.type.equals("saving"))
	{
		
			temp.interest=(temp.balance*intr)/100;
			return temp.interest;
			
	}
	else 
	{
		return -1;
	}
}

if (temp == null) {
    System.out.println( "Account not found");
}
	
}
	return 0;
}
	
}
