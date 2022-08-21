

public class Room extends Hotel {
	node head;
public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

node next;
 class node {
	protected int RoomNo;
	protected String guestName;
	node next;
	public node(String GName,int Rno,double bi,String loc,String Hname)
	{
		RoomNo=Rno;
		guestName=GName;
		bill=bi;
		Location=loc;
		hotelName=Hname;
		
	}
	
 }
public void Addroom(String GName,int Rno,double bi,String loc,String Hname)
{
	

	 node temp_node = new node(GName,Rno,bi,loc,Hname);
     temp_node.next = null;

    
     if (this.head == null) {
     	this.head = temp_node;
     }
     else {
         
         node last = this.head;
         while (last.next != null) {
             last = last.next;
         }

        
         last.next = temp_node;
     }
}
     public void DisplayAllRoom()
 	{
 	    node temp = this.head;

 	    System.out.print(" All Rooms are: ");

 	    while (temp != null) {
 	    	 System.out.println();
 	        System.out.println("Hotel Name: " + temp.hotelName + "\nAccount ID: " + temp.AccountID + "\nAddress: " + temp.Address
 	        		+ "\nContact: " + temp.Contact + "\nAccount Type: " + temp.type + "\n\nBalance: " + temp.balance +"\n\nLast Transection: "
 	        		+ temp.date_created + "\n\n\n");

 	       
 	        temp = temp.next;
 	    }

 	    System.out.println();
 	}

    
    


}
