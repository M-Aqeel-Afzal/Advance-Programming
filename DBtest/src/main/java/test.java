import java.sql.*;
public class test {

	public static void main(String args[]) throws SQLException {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver successfully loaded");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","aq4427");
			System.out.println("Connection Established");
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver not loaded");
		}
		
		catch(SQLException e) {
			System.out.println("Connection Failed");
		}
		
	}
	

}

