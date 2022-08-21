package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
Connection c=null;
	
	public Database(){}
	
	public Connection connDb() {
		
		try {
			this.c=DriverManager.getConnection("jdbc:mysql://localhost:3306/daoDB","root",""); 
		 
 
			return c;
		} 
		
		
		catch (SQLException e)
		
		{
			 
			e.printStackTrace();
		}
		
		return  c;
	}

}
