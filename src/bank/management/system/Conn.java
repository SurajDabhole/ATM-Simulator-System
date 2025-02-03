package bank.management.system;

import java.sql.*;

public class Conn {
	
	Connection c;
	Statement s;
	
	public Conn() {
		try {
			// registering the driver
//			Class.forName(com.mysql.cj.jdbc.Driver);
			
			// connection creation
			c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","AdmiN@567#");
			
			// statement creation
			s = c.createStatement();
		} 
		catch(Exception e) {
			System.out.println(e);
		}
	}
}

/* 
Steps for JDBC Connectivity :
1. Import the JDBC Package
2. Load the JDBC Driver
3. Establish a Connection
4. Create a Statement Object
5. Execute SQL Queries
6. Handle Exceptions
7. Close the Resources
 */
