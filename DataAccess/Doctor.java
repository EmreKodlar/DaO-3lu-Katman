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




	Database conn= new Database();
	Statement st=null;
	ResultSet rs=null;
	Connection con=conn.connDb();
	PreparedStatement preparedStatement= null;
	public List<Doctor> list;
	Doctor doctor;
	
	
	public List<Doctor> getAllDoctor(){
	 
		list = new ArrayList<Doctor>();
		
	try {
		 
		st =(Statement) con.createStatement();
		rs=st.executeQuery("SELECT c_id,c_tc,c_isim,c_sifre,c_tip,c_bolum FROM calisan WHERE c_tip='Doktor'");
		while(rs.next()) {
			
	
		doctor=new Doctor(rs.getInt("c_id"),rs.getInt("c_bolum"),rs.getString("c_isim"),rs.getString("c_sifre"),rs.getString("c_tc"),rs.getString("c_tip"));
		list.add(doctor); } 
		
		 
	 
	} 
	catch (SQLException e) {e.printStackTrace();
	} 
 
	return list;
			}
	
	
	public void addDoctor(Doctor doc) {
		
	String sorguEkleme = " INSERT INTO calisan (c_tc,c_isim,c_sifre,c_bolum,c_tip)  VALUES (?, ?, ?, ?,?)";
		
		try {
			st=(Statement) con.createStatement();
			preparedStatement=(PreparedStatement) con.prepareStatement(sorguEkleme);
			 
			preparedStatement.setString (1, doc.getTc());
			preparedStatement.setString (2, doc.getName());
			preparedStatement.setString   (3, doc.getPassword());
			preparedStatement.setInt(4, doc.getBolum());
			preparedStatement.setString(5, doc.getType());
			 
			preparedStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public void deleteUser(Doctor user) {


		String query = "DELETE FROM calisan WHERE c_id=?";
		
		try {
			st=(Statement) con.createStatement();
			preparedStatement=(PreparedStatement) con.prepareStatement(query);
			preparedStatement.setInt(1,user.getId());
			 
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}
	
	public void updateDoctor(Doctor user) {

		String query = "UPDATE calisan SET c_tc=?, c_isim=?, c_sifre=?, c_tip=?, c_bolum=? WHERE c_id=?";
		
		 
			
		try {
			st=(Statement) con.createStatement();
			preparedStatement=(PreparedStatement) con.prepareStatement(query);
			preparedStatement.setString(1,user.getTc());
			preparedStatement.setString(2,user.getName());
			preparedStatement.setString(3,user.getPassword());
			preparedStatement.setString(4,user.getType());
			preparedStatement.setInt(5,user.getBolum());
			preparedStatement.setInt(6,user.getId());
			 
			preparedStatement.executeUpdate();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		}
	

}
