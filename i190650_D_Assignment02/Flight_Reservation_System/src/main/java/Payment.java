
public class Payment extends Date_Time {
	protected static double Fare_Amount;
	protected static String PaymentMethod;
	public void setFare(double n)
	{
		Fare_Amount=n;
	}
	public double getFare()
	{
		return Fare_Amount;
	}
	public void setPaymentMethod(String n)
	{
		PaymentMethod=n;
	}
	public String getPaymentMethod()
	{
		return PaymentMethod;
	}
}
