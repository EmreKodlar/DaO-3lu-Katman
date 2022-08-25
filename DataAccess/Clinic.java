package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Clinic {
	
	private int id;
	private String name;
	
	public Clinic(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Clinic(String name) {
		super();
		
		this.name = name;
	}
	public Clinic( ) {	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	 
	

}
