import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class testing {

	public static void main(String args[]) throws SQLException {
		
		//Oracle connection
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("SQL PLUS Driver successfully loaded");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","aq4427");
			System.out.println("SQL PLUS Connection Established");
		}
		catch(ClassNotFoundException e) {
			System.out.println("SQL PLUS Driver not loaded");
		}
		
		catch(SQLException e) {
			System.out.println("SQL PLUS Connection Failed");
		}
		
		
		//Mysql connection
		try {
			 //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("MySQL Driver successfully loaded");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Account_Management_System","root","aq4427");
			System.out.println("MySQL Connection Established");
		}
		catch(ClassNotFoundException e) {
			//e.printStackTrace();
			System.out.println("MySQL Driver not loaded");
		}
		
		catch(SQLException e) {
			System.out.println("MySQL Connection Failed");
		}
		
	}
	
	
	
	

}
