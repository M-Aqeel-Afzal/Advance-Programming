
public class Ticket extends Payment{
	protected static int SeatNo;
	protected static String Status;
	
	public void setSeatNo(int n)
	{
		SeatNo=n;
	}
	public int getSeatNo()
	{
		return SeatNo;
	}
	
	public void setStatus(String n)
	{
		Status=n;
	}
	public String getStatus()
	{
		return Status;
	}
	
	
	
}
