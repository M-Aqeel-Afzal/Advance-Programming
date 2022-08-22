import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Driver {

public static void main(String[] args) throws IOException{
	Flight flight=new Flight();
	Login login=new Login();
	boolean flag=false;
	login.loginMenu();
	while(true)
	{System.out.println("\n\n<=========> Wellcome to MainMenu <=========> ");
	System.out.println("1) Reserve a Seat");
	System.out.println("2) Show Flights Detail");
	System.out.println("4) Cancel Reservation");
	System.out.println("5) Print Ticket");
	System.out.println("6) Show Cheapest Flight Detail on a sepecific Date");
	Scanner obj1= new Scanner(System.in);
	Scanner obj3= new Scanner(System.in);
	int temp1= obj1.nextInt();
	switch(temp1)
	{
	case 1:
		System.out.println("Enter Your Name ");
		String name= obj1.next();
		System.out.println("Enter Your Gender(F/f,M/m) ");
		char g = obj3.next().charAt(0);
		while(g!='M'&&g!='m'&&g!='f'&&g!='F')
		{
			System.out.println("Wrong input!");
			System.out.println("Enter again ");
			 g = obj3.next().charAt(0);
		}
		System.out.println("Enter Your Age(5 to 110)");
		int age= obj1.nextInt();
		while(age<5||age>110)
		{
			System.out.println("Wrong input!");
			System.out.println("Enter again ");
			age= obj1.nextInt();
		}
		System.out.println("Enter Your address ");
		String addr= obj1.next();
		System.out.println("Enter Your Nationality ");
		String na= obj1.next();
		System.out.println("Enter Your Contact Information ");
		String con= obj1.next();
		System.out.println("Enter Desire Flight Class:\n\n");
		System.out.println("press 1 for Economy class");
		System.out.println("press 2 for premium Economy class");
		System.out.println("press 3 for Bussiness class");
		System.out.println("press 4 for First class");
		int ch= obj1.nextInt();
		String cl="";
		boolean flag2=false;
		while(true)
		{switch(ch)
		{
		case 1:
			
			cl="economy";
			flag2=true;
			break;
		case 2:
			cl="premium_economy";
			flag2=true;
			break;
		case 3:
			cl="business";
			flag2=true;
			break;
		case 4:
			cl="first_class";
			flag2=true;
			break;
		default: 
			System.out.println("Wrong choice Try again!");
			
		}
		if(flag2)
		{
			
			break;
		}
		}
		System.out.println("Class Based Flights\n\n");
		flight.ShowClassBaseFlights(cl);
		System.out.println("Enter Your Desire Date (format must be: 01/01/2020) ");
		String date= obj1.next();
		flight.ShowReservedSeats(date);
		System.out.println("Enter Seat Number:");
		int seat= obj1.nextInt();
		System.out.println("Enter Your Passport Number:");
	    String  passport= obj1.next();
	    int temp=flight.PerformReservation(name,age,g,addr,na,con,cl,seat,passport,date);
	  if( temp ==-1)
	  {
		 
	  }
	  if(temp==2)
		{
		 
		
		}
		


		flag=true;
		break;
	case 2:
		flight.AllFlights();
		flag=true;
		break;
	case 3:
		flag=true;
		break;
	case 4:
		System.out.println("Enter Your Passport ID:");
		String pas= obj1.next();
		System.out.println("Enter Date of Reservation(format must be: 01/01/2020):");
		String d= obj1.next();
		System.out.println("Enter Your Reserved Seat Number: ");
		int s= obj1.nextInt();
		flight.CancelReservation( s,pas,d);
		flag=true;
		break;
	case 5:
		System.out.println("Enter Your Passport ID:");
		String pas1= obj1.next();
		System.out.println("Enter SeatNo:");
		int se= obj1.nextInt();
		flight.PrintTicket(se,pas1);
		flag=true;
		break;
	case 6:
		flight.ShowCheapestFlight();
		flag=true;
		break;
	default:
		System.out.println("Wrong Input!");
		
	
	}
	if(flag)
		break;
	}
}

}
