
public class Date_Time {
	protected static String DepartureDateTime;
	protected static String ArivalDateTime;
	protected static String ReservedDateTime="NR";
	public void setDepartureDateTime(String n)
	{
		DepartureDateTime=n;
	}
	public String getDepartureDateTime()
	{
		return DepartureDateTime;
	}
	public void setArivalDateTime(String n)
	{
		ArivalDateTime=n;
	}
	public String getArivalDateTime()
	{
		return ArivalDateTime;
	}
	public void setReservedDateTime(String n)
	{
		ReservedDateTime=n;
	}
	public String getReservedDateTime()
	{
		return ReservedDateTime;
	}
	
}
