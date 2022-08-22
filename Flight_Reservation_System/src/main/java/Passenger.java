
public class Passenger extends Ticket {
protected String Name;
protected char Gender;
protected int Age;
protected String Address;
protected String passport_No;
protected String Nationality;
protected String Contect;
public void setName(String n)
{
	Name=n;
}
public String getName()
{
	return Name;
}
public void setGender(char g)
{
	Gender=g;
}
public char getGender()
{
	return Gender;
}
public void setAge(int a)
{
	Age=a;
}
public int getAge()
{
		return Age;
}
public void setAddress(String n)
{
	Address=n;
}
public String getAddress()
{
		return Address;
}
public void setpassport_No(String n)
{
	passport_No=n;
}
public String getpassport_No()
{
		return passport_No;
}
public void setNationality(String n)
{
	Nationality=n;
}

public void setContect(String n)
{
	Contect=n;
}

public String getNationality()
{
		return Nationality;
}
public String getContect()
{
		return Contect;
}
public void Reserve_Seat(String n,char g,int a,String addr,String pass,String na,String con)
{
 Name=n;
	 Gender=g;
	 Age=a;
	 Address=addr;
 passport_No=pass;
	 Nationality=na;
	 Contect=con;
}

}
