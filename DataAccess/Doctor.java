package DataAccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

 
import View.DoctorV;

 

public class Doctor extends User {
	 
	 
	public Doctor(int id, int bolum, String name, String password, String tc, String type) {
		super(id, bolum, name, password, tc, type);
		// TODO Auto-generated constructor stub
	}
	
	//eklemek için gerekli...
	public Doctor(int bolum, String name, String password, String tc, String type) {
		super(bolum, name, password, tc, type);
		 
	}
	
	 
	public Doctor( ) {
		 
	}

	
	 

}
