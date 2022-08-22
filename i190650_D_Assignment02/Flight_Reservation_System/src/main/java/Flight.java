import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Flight extends Passenger{
	protected static String FlightName;
	protected static String FlightType;
	protected static String FlightID;
	protected static String DeparturePoint;
	protected static String ArivalPoint;
	protected static int TotalSeat;
	protected static int AvailableSeats;
	protected static int ReservedSeats;
	public void setFlightName(String n)
	{
		FlightName=n;
	}
	public String getFlightName()
	{
		return FlightName;
	}
	public void setFlightType(String n)
	{
		FlightType=n;
	}
	public String getFlightType()
	{
		return FlightType;
	}
	public void setFlightID(String n)
	{
		FlightID=n;
	}
	public String getFlightID()
	{
		return FlightID;
	}
	public void setDeparturePoint(String n)
	{
		DeparturePoint=n;
	}
	public String getDeparturePoint()
	{
		return DeparturePoint;
	}
	public void setArivalPoint(String n)
	{
		ArivalPoint=n;
	}
	public String getArivalPoint()
	{
		return ArivalPoint;
	}
	public void setTotalSeat(int n)
	{
		TotalSeat=n;
	}
	public int getTotalSeat()
	{
		return TotalSeat;
	}
	public void setAvailableSeats(int n)
	{
		AvailableSeats=n;
	}
	public int getAvailableSeats()
	{
		return AvailableSeats;
	}
	public void setReservedSeats(int n)
	{
		ReservedSeats=n;
	}
	public int getReservedSeats()
	{
		return ReservedSeats;
	}
	public void ShowFlight()
	{
		
		boolean flag=true,flag1=true;
		try {
		      FileWriter myfile = new FileWriter("Flight.txt",true);
		      
		      try {
		          File myObj = new File("Flight.txt");
		          
		          Scanner myReader = new Scanner(myObj);
		          System.out.println("Flight ID \tFlight Name   \tFlight Type \t\t Departure \t\t\t\t      Arival \t\t      \t \t Total Seats \t     Available Seats \t     Reserved Seats");
		          while (myReader.hasNextLine()) {
		            String data = myReader.nextLine();
		            String[] arr = data.split(",");    
if(flag1)
{flag1=false;}
else {
		                FlightID =arr[0];
		            	FlightName =arr[1];
		            	FlightType =arr[2];
		            	DeparturePoint =arr[3];
		            	ArivalPoint =arr[4];
		            	TotalSeat =Integer.parseInt(arr[5]);
		            	AvailableSeats =Integer.parseInt(arr[6]);
		            	ReservedSeats =Integer.parseInt(arr[7]);
		            	String format = "%-16s%-18s%-23s%-45s%-35s%-20s%-25s%s%n";
		            	System.out.printf(format, FlightID, FlightName,FlightType,DeparturePoint,ArivalPoint,TotalSeat,AvailableSeats,ReservedSeats);
		           	
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
	}
	
	public void ShowCheapestFlight()
	{
		int min=700000;
		 String str1="",str2="",str3="",str4="",str5="",id="",fare="",meth="";
		 boolean flag=true,flag1=true,flag2=true,flag3=false;
	
	try {
		FileWriter myfile1= new FileWriter("Payment.txt",true);
	      
	      try {
	          File myObj1 = new File("Payment.txt");
	          
	          Scanner myReader1 = new Scanner(myObj1);
	          while (myReader1.hasNextLine()) {
	            String data1 = myReader1.nextLine();
	            String[] arr1 = data1.split(",");    
	            if(flag1)
	            {flag1=false;}
	            else {

str1 =arr1[0];
str2 =arr1[1];
str3=arr1[2];
int far =Integer.parseInt(str2);
if(far<min)
{	min=far;
id=str1;
fare=str2;
meth=str3;
}
	            }
	    
	            }
	          
	        	
	          
	          myReader1.close();
	        } catch (FileNotFoundException e) {
	          System.out.println("An error occurred.");
	          e.printStackTrace();
	        }
	      
	      
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	

	flag1=true;
	
	try {
	      FileWriter myfile = new FileWriter("Flight.txt",true);
	      FileWriter myfile1 = new FileWriter("Date_Time.txt",true);
	      
	      try {
	          File myObj = new File("Flight.txt");
	          File myObj1 = new File("Date_Time.txt");
	          
	          Scanner myReader = new Scanner(myObj);
	          Scanner myReader1 = new Scanner(myObj1);
	      //    System.out.println("Flight ID \tFlight Name   \tFlight Type \t\t Departure \t\t\t\t      Arival \t\t      \t \t Total Seats \t     Available Seats \t     Reserved Seats");
	          while (myReader.hasNextLine()) {
	            String data = myReader.nextLine();
	            String[] arr = data.split(",");    
if(flag1)
{flag1=false;}
else {




FlightID =arr[0];
FlightName =arr[1];
FlightType =arr[2];
DeparturePoint =arr[3];
ArivalPoint =arr[4];
TotalSeat =Integer.parseInt(arr[5]);
AvailableSeats =Integer.parseInt(arr[6]);
ReservedSeats =Integer.parseInt(arr[7]);
if(FlightID.equals(id))
{
	
	
	 while (myReader1.hasNextLine()) {
         String data1 = myReader1.nextLine();
         String[] arr1 = data.split(",");    
if(flag1)
{flag1=false;}
else {
	str3 =arr1[0];
	str4 =arr1[1];
	str5 =arr1[2];
	if(str3.equals(id))
	{
		
	}
	
}
	 }
     System.out.println("Flight ID \tFlight Name   \tFlight Type \t\t Departure \t\t\t\t      Arival \t\t      \t \t Total Seats \t     Available Seats \t     Reserved Seats\t\tDeparture Date_Time\t\tArival Date_Time\t\tFare\t\tPayment Method");

	 String format = "%-16s%-18s%-23s%-45s%-35s%-20s%-25s%-26s%-32s%-28s%-28s%s%n";
		//System.out.println(str2+str3);
   	System.out.printf(format, FlightID, FlightName,FlightType,DeparturePoint,ArivalPoint,TotalSeat,AvailableSeats,ReservedSeats,str4,str5,fare,meth);
break;
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
	}
	
	public void ShowClassBaseFlights(String eco)
	{
		
		boolean flag=true,flag1=true,flag2=true;
		try {
		      FileWriter myfile = new FileWriter("Flight.txt",true);
		      FileWriter myfile1 = new FileWriter("Date_Time.txt",true);
		      try {
		          File myObj = new File("Flight.txt");
		          File myObj1 = new File("Date_Time.txt");
		          Scanner myReader = new Scanner(myObj);
		          Scanner myReader1 = new Scanner(myObj1);
		          System.out.println("Flight ID \tFlight Name   \tFlight Type \t\t Departure \t\t\t\t      Arival \t\t      \t \t Total Seats \t     Available Seats \t     Reserved Seats\t\tDeparture Date_Time\t\tArival Date_Time");
		          while (myReader.hasNextLine()) {
		            String data = myReader.nextLine();
		            String[] arr = data.split(",");    
if(flag1)
{flag1=false;}
else {
		                FlightID =arr[0];
		            	FlightName =arr[1];
		            	FlightType =arr[2];
		            	DeparturePoint =arr[3];
		            	ArivalPoint =arr[4];
		            	TotalSeat =Integer.parseInt(arr[5]);
		            	AvailableSeats =Integer.parseInt(arr[6]);
		            	ReservedSeats =Integer.parseInt(arr[7]);
		            	if(FlightType.equals(eco))
		            	{
		            		
		            		
		            		
		            		String str1="",str2="",str3="";
		            		  while (myReader1.hasNextLine()) {
		      		            String data1 = myReader1.nextLine();
		      		            String[] arr1 = data1.split(",");    
		      if(flag2)
		      {flag2=false;}
		      else {
		      		                str1 =arr1[0];
		      		                str2 =arr1[1];
		      		            	str3 =arr1[2];
		      		            	if(FlightID.equals(str1))
		      		            	{
		      		            		
		      		            		String format = "%-16s%-18s%-23s%-45s%-35s%-20s%-25s%-26s%-32s%s%n";
		      		            		//System.out.println(str2+str3);
			      		            	System.out.printf(format, FlightID, FlightName,FlightType,DeparturePoint,ArivalPoint,TotalSeat,AvailableSeats,ReservedSeats,str2,str3);
			      		           	break;
		      		            	}
		      		            	
		      		            	
		      }
		      		           
		      		            
		      		            
		      		            }
		            		
		            		
		            		
		            		
		            		
		            		
		            		
		            		
		            		
		            		
		            		
		            		
		            		
		            		
		            	}
		            	
		            //	String format = "%-16s%-18s%-23s%-45s%-35s%-20s%-25s%s%n";
		            //	System.out.printf(format, FlightID, FlightName,FlightType,DeparturePoint,ArivalPoint,TotalSeat,AvailableSeats,ReservedSeats);
		           	
}
		           
		            
		            
		            }
		        	
		          
		          myReader.close();
		          myReader1.close();
		        } catch (FileNotFoundException e) {
		          System.out.println("An error occurred.");
		          e.printStackTrace();
		        }
		      
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public void ShowReservedSeats(String date)
	{
		 String str1="",str2="",str3="",str4="",str5="";
		boolean flag=true,flag1=true,flag2=true,flag3=false;
		try {
		      FileWriter myfile = new FileWriter("Date_Time.txt",true);
		     
		      try {
		          File myObj = new File("Date_Time.txt");
		        
		          Scanner myReader = new Scanner(myObj);
		       
		         
		          int n=0;
		          while (myReader.hasNextLine()) {
		            String data = myReader.nextLine();
		            String[] arr = data.split(",");    
if(flag1)
{flag1=false;}
else {
	 str1 =arr[0];
       str2 =arr[1];
   	str3 =arr[2];
    String[] arr2 = str2.split(":"); 
    str2=arr2[0];
		            	if(str2.equals(date))
		            	{
		            		flag=true;
		            		 FileWriter myfile1 = new FileWriter("./seats/"+str1+".txt",true);
		            		  File myObj1 = new File("./seats/"+str1+".txt");
		            		   Scanner myReader1 = new Scanner(myObj1);
		            		  while (myReader1.hasNextLine()) {
		      		            String data1 = myReader1.nextLine();
		      		            String[] arr1 = data1.split(",");    
		     
		      		                str4 =arr1[0];
		      		                str5 =arr1[1];
		      		            	
		      		            		
		      		            		//System.out.println(str2+str3);
		      		              String format = "%-16s%s%n";
	      		            		//System.out.println(str2+str3);
		      		            	System.out.printf(format, str4, str5);
		      		           
			      		            	//System.out.print(str4+"\t"+str5);
			      		            	n++;
			      		           if(n==10)
			      		           {
			      		        		System.out.println("");
			      		        		n=0;
			      		           }
		      		            	
		      		            	
		      }
		      		           
		            		  myReader1.close();   
		            		 
		      		        break;    
		      		            
		            		
		            		
		            		
		            		
		            		
		            		
		            		
		            		
		            		
		            		
		            		
		            		
		            		 
		            		
		            	}
		            	
		            //	String format = "%-16s%-18s%-23s%-45s%-35s%-20s%-25s%s%n";
		            //	System.out.printf(format, FlightID, FlightName,FlightType,DeparturePoint,ArivalPoint,TotalSeat,AvailableSeats,ReservedSeats);
		           	
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
		if(flag3==false)
		 System.out.println("No flight on this date");
	   
		
	}
	
	
	public int PerformReservation(String name,int age,char gen,String addr,String nation,String con,String cls,int seatNo,String passp,String dat)
	{//Passport_No,Name,Gender,Age,Address,Nationality,Contect
		//SeatNo,Flight_ID,Status,ReservedDateTime,Passport_No
		 String str1="",str2="",str3="",str4="";
		boolean flag=true,flag1=true,flag2=false;
		try {
			int temp=UpdateSeat(dat,seatNo);
			if(temp==-1)
				{
				 throw new SeatAlreadyReserved("Seat Already Reserved");
				//return -1;
				
				}
				
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			
		}
		
		catch (SeatAlreadyReserved e) {
			// TODO Auto-generated catch block
			 System.err.print(e);
			 return -1;
		}
		
		try {
			FileWriter myfile = new FileWriter("Date_Time.txt",true);
		      
		      try {
		          File myObj = new File("Date_Time.txt");
		          
		          Scanner myReader = new Scanner(myObj);
		          while (myReader.hasNextLine()) {
		            String data = myReader.nextLine();
		            String[] arr = data.split(",");    
if(flag1)
{flag1=false;}
else {
	str1 =arr[0];
    str2 =arr[1];
    str4=str1;
 String[] arr2 = str2.split(":"); 
 str3=arr2[0];
		            	if(str3.equals(dat))
		            	{
		            		flag2=true;
		            		break;
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
		
	
		if(flag2==false)
		{
			try {
				
				
					
					 throw new NoFlightOnThisDate("No Flight On this Date:");
					//return -1;
					
					
					
			} catch (NoFlightOnThisDate e) {
				// TODO Auto-generated catch block
				System.err.print(e);
				return 2;
			}
			
		}
			//return 2;
		
		FileWriter myfile1;
		FileWriter myfile2;
		try {
			myfile1 = new FileWriter("Passenger.txt",true);
			myfile2 = new FileWriter("Ticket.txt",true);
			try {
				myfile1.write(passp+","+name+","+gen+","+age+","+addr+","+nation+","+con+"\r\n");
				myfile2.write(seatNo+","+str1+","+"Reserved"+","+str2+","+passp+"\r\n");
				
				
				 myfile1.close();
				 myfile2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		
	
		
		
		
		
		try {
			FileWriter myfile = new FileWriter("Payment.txt",true);
		      
		      try {
		          File myObj = new File("Payment.txt");
		          
		          Scanner myReader = new Scanner(myObj);
		          while (myReader.hasNextLine()) {
		            String data = myReader.nextLine();
		            String[] arr = data.split(",");    

	str1 =arr[0];
    str2 =arr[1];
    str3=arr[2];
		            	if(str1.equals(str4))
		            	{
		            		System.out.println("Payment Method and Fare:\n");
		            		System.out.println("Total Fare is: "+str2);
		            		System.out.println("Payment Method is: "+str3);
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
		
	
		
		
		
		
		
		
		 System.out.println("Reservation is Done\n");
	     return 1;
	}
	public int UpdateSeat(String date,int seat) throws IOException
	{
		
		 String str1="",str2="",str3="",str4="";
		boolean flag=true,flag1=true,flag2=false;
		try {
			FileWriter myfile = new FileWriter("Date_Time.txt",true);
		      
		      try {
		          File myObj = new File("Date_Time.txt");
		          
		          Scanner myReader = new Scanner(myObj);
		          while (myReader.hasNextLine()) {
		            String data = myReader.nextLine();
		            String[] arr = data.split(",");    
if(flag1)
{flag1=false;}
else {
	str1 =arr[0];
	str4=str1;
   str2 =arr[1];
String[] arr2 = str2.split(":"); 
str3=arr2[0];
		            	if(str3.equals(date))
		            	{
		            		flag2=true;
		            		break;
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
		if(flag2==false)
			return 2;
//reading in temp file		
		 FileWriter   myfile2 = new FileWriter("temp.txt");
		 try {
	          File myObj = new File("./seats/"+str1+".txt");
	         
	          Scanner myReader = new Scanner(myObj);
	          while (myReader.hasNextLine()) {
	            String data = myReader.nextLine();
	            String[] arr = data.split(",");    


str1 =arr[0];
str2 =arr[1];
String s=Integer.toString(seat);
					if(str1.equals(s))
	            	{
						if(str2.equals("Reserved"))
							return -1;
	            	data=s+","+"Reserved\r\n";
	            	myfile2.write(data);
	            	}
					else
					{
						data=data+"\r\n";
		            	myfile2.write(data);
					}
					// myfile1.close();
	               
}
	           
	            
	            
	            
	        	
	          myfile2.close();
	          myReader.close();
	          
	        } catch (FileNotFoundException e) {
	          System.out.println("An error occurred.");
	          e.printStackTrace();
	        }
		
		 
		 
		 
		 
		 
//updating original
		 
		 FileWriter   myfile3 = new FileWriter("./seats/"+str4+".txt");
		 try {
	          File myObj = new File("temp.txt");
	         
	          Scanner myReader = new Scanner(myObj);
	          while (myReader.hasNextLine()) {
	            String data = myReader.nextLine();
	           
					data=data+"\r\n";
		            	myfile3.write(data);
					
					// myfile1.close();
	               
}
	           
	            
	            
	            
	        	
	          myfile3.close();
	          myReader.close();
	          
	        } catch (FileNotFoundException e) {
	          System.out.println("An error occurred.");
	          e.printStackTrace();
	        }
		 
		 
		 
		 
		 
		 
		 
		 
		//reading in temp file		
				 FileWriter   myfile4 = new FileWriter("temp.txt");
				 try {
			          File myObj = new File("Flight.txt");
			         
			          Scanner myReader = new Scanner(myObj);
			          while (myReader.hasNextLine()) {
			            String data = myReader.nextLine();
			            String[] arr = data.split(",");    


			            FlightID =arr[0];
							if(FlightID.equals(str4))
			            	{
								 
					            	FlightName =arr[1];
					            	FlightType =arr[2];
					            	DeparturePoint =arr[3];
					            	ArivalPoint =arr[4];
					            	TotalSeat =Integer.parseInt(arr[5]);
					            
					            	AvailableSeats =Integer.parseInt(arr[6]);
					            	ReservedSeats =Integer.parseInt(arr[7]);
					            	//Flight_ID,Airline,FlightType,DeparturePoint,ArivalPoint,TotalSeat,AvailableSeats,ReservedSeats
					            	AvailableSeats=AvailableSeats-1;
					            	ReservedSeats=ReservedSeats+1;
					String s1=Integer.toString(AvailableSeats);
					String s2=Integer.toString(ReservedSeats);
					System.out.println(arr[5]+"  "+s1+"   "+s2);
			            	data=FlightID+","+FlightName+","+FlightType+","+DeparturePoint+","+ArivalPoint+","+arr[5]+","+s1+","+s2+"\r\n";
			            	myfile4.write(data);
			            	}
							else
							{
								
								data=data+"\r\n";
				            	myfile4.write(data);
							}
							// myfile1.close();
			               
		}
			           
			            
			            
			            
			        	
			          myfile4.close();
			          myReader.close();
			          
			        } catch (FileNotFoundException e) {
			          System.out.println("An error occurred.");
			          e.printStackTrace();
			        }
				
				 
				 
				 
				 
				 
		//updating original
				 
				 FileWriter   myfile5 = new FileWriter("Flight.txt");
				 try {
			          File myObj = new File("temp.txt");
			         
			          Scanner myReader = new Scanner(myObj);
			          while (myReader.hasNextLine()) {
			            String data = myReader.nextLine();
			           
							data=data+"\r\n";
				            	myfile5.write(data);
							
							// myfile1.close();
			               
		}
			           
			            
			            
			            
			        	
			          myfile5.close();
			          myReader.close();
			          
			        } catch (FileNotFoundException e) {
			          System.out.println("An error occurred.");
			          e.printStackTrace();
			        }
				 
		 
		 
	 return 1;

	}
	
	
	
	

	public void CancelReservation(int seatNo,String passp,String dat) throws IOException
	{//Passport_No,Name,Gender,Age,Address,Nationality,Contect
		//SeatNo,Flight_ID,Status,ReservedDateTime,Passport_No
		 String str1="",str2="",str3="",str4="";
		boolean flag=true,flag1=true;
		try {
			FileWriter myfile = new FileWriter("Date_Time.txt",true);
		      
		      try {
		          File myObj = new File("Date_Time.txt");
		          
		          Scanner myReader = new Scanner(myObj);
		          while (myReader.hasNextLine()) {
		            String data = myReader.nextLine();
		            String[] arr = data.split(",");    
if(flag1)
{flag1=false;}
else {
	str1 =arr[0];
	str4=str1;
    str2 =arr[1];
 String[] arr2 = str2.split(":"); 
 str3=arr2[0];
		            	if(str3.equals(dat))
		            	{
		            		break;
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
		
	
		
		
		//reading in temp file		
		 FileWriter   myfile2 = new FileWriter("temp.txt");
		 try {
	          File myObj = new File("./seats/"+str4+".txt");
	         
	          Scanner myReader = new Scanner(myObj);
	          while (myReader.hasNextLine()) {
	            String data = myReader.nextLine();
	            String[] arr = data.split(",");    


str1 =arr[0];
str2 =arr[1];
String s=Integer.toString(seatNo);
					if(str1.equals(s))
	            	{
	            	data=s+","+"NR\r\n";
	            	myfile2.write(data);
	            	}
					else
					{
						data=data+"\r\n";
		            	myfile2.write(data);
					}
					// myfile1.close();
	               
}
	           
	            
	            
	            
	        	
	          myfile2.close();
	          myReader.close();
	          
	        } catch (FileNotFoundException e) {
	          System.out.println("An error occurred.");
	          e.printStackTrace();
	        }
		
		 
		 
		 
		 
		 
//updating original
		 
		 FileWriter   myfile3 = new FileWriter("./seats/"+str4+".txt");
		 try {
	          File myObj = new File("temp.txt");
	         
	          Scanner myReader = new Scanner(myObj);
	          while (myReader.hasNextLine()) {
	            String data = myReader.nextLine();
	           
					data=data+"\r\n";
		            	myfile3.write(data);
					
					// myfile1.close();
	               
}
	           
	            
	           
	          myfile3.close();
	          myReader.close();
	          
	        } catch (FileNotFoundException e) {
	          System.out.println("An error occurred.");
	          e.printStackTrace();
	        }
		 
		 
		 
		 
		 
		 
		 
		//reading in temp file		
		 FileWriter   myfile4 = new FileWriter("temp.txt");
		 try {
	          File myObj = new File("./seats/"+str4+".txt");
	         
	          Scanner myReader = new Scanner(myObj);
	          while (myReader.hasNextLine()) {
	            String data = myReader.nextLine();
	            String[] arr = data.split(",");    


str1 =arr[0];
str2 =arr[1];
String s=Integer.toString(seatNo);
					if(str1.equals(s))
	            	{
	            	data=s+","+"NR\r\n";
	            	myfile4.write(data);
	            	}
					else
					{
						data=data+"\r\n";
		            	myfile4.write(data);
					}
					// myfile1.close();
	               
}
	           
	            
	            
	            
	        	
	          myfile4.close();
	          myReader.close();
	          
	        } catch (FileNotFoundException e) {
	          System.out.println("An error occurred.");
	          e.printStackTrace();
	        }
		
		 
		 
		 
		 
		 
//updating original
		 
		 FileWriter   myfile5= new FileWriter("./seats/"+str4+".txt");
		 try {
	          File myObj = new File("temp.txt");
	         
	          Scanner myReader = new Scanner(myObj);
	          while (myReader.hasNextLine()) {
	            String data = myReader.nextLine();
	           
					data=data+"\r\n";
		            	myfile5.write(data);
					
					// myfile1.close();
	               
}
	           
	            
	           
	          myfile5.close();
	          myReader.close();
	          
	        } catch (FileNotFoundException e) {
	          System.out.println("An error occurred.");
	          e.printStackTrace();
	        }
		 
		 
		 
		 
		 
		 
		 
		 
		 
			//reading in temp file		
					 FileWriter   myfile6 = new FileWriter("temp.txt");
					 try {
				          File myObj = new File("Flight.txt");
				         
				          Scanner myReader = new Scanner(myObj);
				          while (myReader.hasNextLine()) {
				            String data = myReader.nextLine();
				            String[] arr = data.split(",");    


				            FlightID =arr[0];
								if(FlightID.equals(str4))
				            	{
									 
						            	FlightName =arr[1];
						            	FlightType =arr[2];
						            	DeparturePoint =arr[3];
						            	ArivalPoint =arr[4];
						            	TotalSeat =Integer.parseInt(arr[5]);
						            
						            	AvailableSeats =Integer.parseInt(arr[6]);
						            	ReservedSeats =Integer.parseInt(arr[7]);
						            	//Flight_ID,Airline,FlightType,DeparturePoint,ArivalPoint,TotalSeat,AvailableSeats,ReservedSeats
						            	AvailableSeats=AvailableSeats+1;
						            	ReservedSeats=ReservedSeats-1;
						String s1=Integer.toString(AvailableSeats);
						String s2=Integer.toString(ReservedSeats);
					
				            	data=FlightID+","+FlightName+","+FlightType+","+DeparturePoint+","+ArivalPoint+","+arr[5]+","+s1+","+s2+"\r\n";
				            	myfile6.write(data);
				            	}
								else
								{
									
									data=data+"\r\n";
					            	myfile6.write(data);
								}
								// myfile1.close();
				               
			}
				           
				            
				            
				            
				        	
				          myfile6.close();
				          myReader.close();
				          
				        } catch (FileNotFoundException e) {
				          System.out.println("An error occurred.");
				          e.printStackTrace();
				        }
					
					 
					 
					 
					 
					 
			//updating original
					 
					 FileWriter   myfile7 = new FileWriter("Flight.txt");
					 try {
				          File myObj = new File("temp.txt");
				         
				          Scanner myReader = new Scanner(myObj);
				          while (myReader.hasNextLine()) {
				            String data = myReader.nextLine();
				           
								data=data+"\r\n";
					            	myfile7.write(data);
								
								// myfile1.close();
				               
			}
				           
				            
				            
				            
				        	
				          myfile7.close();
				          myReader.close();
				          
				        } catch (FileNotFoundException e) {
				          System.out.println("An error occurred.");
				          e.printStackTrace();
				        }
					 
			 
					 
					 
						//Passport_No,Name,Gender,Age,Address,Nationality,Contect
						//SeatNo,Flight_ID,Status,ReservedDateTime,Passport_No
		 
		 

					 
					 
					 
					 
					 
						//reading in temp file		
								 FileWriter   myfile8 = new FileWriter("temp.txt");
								 try {
							          File myObj = new File("Ticket.txt");
							         
							          Scanner myReader = new Scanner(myObj);
							          while (myReader.hasNextLine()) {
							            String data = myReader.nextLine();
							            String[] arr = data.split(",");    


							       str1 =arr[0];
							       String s1=Integer.toString(seatNo);
											if(str1.equals(s1))
							            	{
												 
									            	        	
							            	}
											else
											{
												
												data=data+"\r\n";
								            	myfile8.write(data);
											}
											// myfile1.close();
							               
						}
							           
							            
							            
							            
							        	
							          myfile8.close();
							          myReader.close();
							          
							        } catch (FileNotFoundException e) {
							          System.out.println("An error occurred.");
							          e.printStackTrace();
							        }
								
								 
								 
								 
								 
								 
						//updating original
								 
								 FileWriter   myfile9 = new FileWriter("Ticket.txt");
								 try {
							          File myObj = new File("temp.txt");
							         
							          Scanner myReader = new Scanner(myObj);
							          while (myReader.hasNextLine()) {
							            String data = myReader.nextLine();
							           
											data=data+"\r\n";
								            	myfile9.write(data);
											
											// myfile1.close();
							               
						}
							           
							            
							            
							            
							        	
							          myfile9.close();
							          myReader.close();
							          
							        } catch (FileNotFoundException e) {
							          System.out.println("An error occurred.");
							          e.printStackTrace();
							        }
								 
								 
								 
								 
									//reading in temp file		
											 FileWriter   myfile10 = new FileWriter("temp.txt");
											 try {
										          File myObj = new File("Passenger.txt");
										         
										          Scanner myReader = new Scanner(myObj);
										          while (myReader.hasNextLine()) {
										            String data = myReader.nextLine();
										            String[] arr = data.split(",");    


										       str1 =arr[0];
														if(str1.equals(passp))
										            	{
															 
												            	        	
										            	}
														else
														{
															
															data=data+"\r\n";
											            	myfile10.write(data);
														}
														// myfile1.close();
										               
									}
										           
										            
										            
										            
										        	
										          myfile10.close();
										          myReader.close();
										          
										        } catch (FileNotFoundException e) {
										          System.out.println("An error occurred.");
										          e.printStackTrace();
										        }
											
											 
											 
											 
											 
											 
									//updating original
											 
											 FileWriter   myfile11 = new FileWriter("Passenger.txt");
											 try {
										          File myObj = new File("temp.txt");
										         
										          Scanner myReader = new Scanner(myObj);
										          while (myReader.hasNextLine()) {
										            String data = myReader.nextLine();
										           
														data=data+"\r\n";
											            	myfile11.write(data);
														
														// myfile1.close();
										               
									}
										           
										            
										            
										            
										        	
										          myfile11.close();
										          myReader.close();
										          
										        } catch (FileNotFoundException e) {
										          System.out.println("An error occurred.");
										          e.printStackTrace();
										        }
											 
											 
											 
						 
											 System.out.println("Cancenlation is Done\n");
	}
	
	public void AllFlights()
	{
		ShowClassBaseFlights("economy");
		System.out.println("");
		ShowClassBaseFlights("premium_economy");
		System.out.println("");
		ShowClassBaseFlights("business");
		System.out.println("");
		ShowClassBaseFlights("first_class");
	}
	
	public void PrintTicket(int seatno,String passp)
	{
		
		 String str1="",str2="",str3="",str4="",str5="",gen="",ag="";
			boolean flag=true,flag1=true;
			
			
			
			
			
			
				
			      
			      try {
			          File myObj = new File("Ticket.txt");
			          File myObj1 = new File("Passenger.txt");
			          Scanner myReader = new Scanner(myObj);
			          Scanner myReader1 = new Scanner(myObj1);
			          while (myReader.hasNextLine()) {
			            String data = myReader.nextLine();
			            String[] arr = data.split(",");    

		str1 =arr[0];
	    str2 =arr[1];
	    str3=arr[2];
		str4 =arr[3];
	    str5 =arr[4];


			            	if(str5.equals(passp))
			            	{  while (myReader1.hasNextLine()) {
			  			            String data1 = myReader1.nextLine();
			  			            String[] arr1 = data1.split(","); 
			  			        //Passport_No,Name,Gender,Age,Address,Nationality,Contect
			  			  		
			  			          passport_No=arr1[0];
			  			          Name=arr1[1];
			  					 gen=arr1[2];
			  					 ag=arr1[3];
			  					 Address=arr1[4];
			  					 Nationality=arr1[5];
			  					 Contect=arr1[6];
			  				
			  					if(passport_No.equals(passp))
				            	{
			  						
				            	System.out.println("<==============> Ticket <================>");
				            	System.out.println("Name: "+Name);
				            	System.out.println("Age: "+ag);
				            	System.out.println("Passport ID: "+passport_No);
				            	System.out.println("SeatNo: "+seatno);
				            	System.out.println("Flight ID: "+str2);
				            	System.out.println("Date&Time: "+str4);
				            	System.out.println("Contect: "+Contect);
				            	System.out.println("Nationality: "+Nationality);
				            	System.out.println("Address: "+Address);
				            	flag1=false;
				            	break;
			  					
				            	}
			  			            
			            		  }
			            	}
			               

			           if(flag1==false)
			            break;
			            
			            }
			        	
			          
			          myReader.close();
			        } catch (FileNotFoundException e) {
			          System.out.println("An error occurred.");
			          e.printStackTrace();
			        }
			      
			      
			   
			
		
			
			
			
			
			
	}
	
}

