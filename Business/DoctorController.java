package Business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import DataAccess.Database;
import DataAccess.Doctor;
import View.DoctorV;
import View.IDoctor;

public class DoctorController implements IDoctor {

 
 
	
	Database conn= new Database();
	Statement st=null;
	ResultSet rs=null;
	Connection con=conn.connDb();
	PreparedStatement preparedStatement= null;
	public List<Doctor> list;
	Doctor doctor;
	
	

	@Override
	public String getDoctorsName(int id) {

 String isim=null;
		
		try {
			 
			st =(Statement) con.createStatement();
			rs=st.executeQuery("SELECT c_id, c_isim  FROM calisan WHERE c_id=" + id);
			if(rs.next()) {
				
		
			isim=rs.getString("c_isim");
		  } 
		 
		} 
		catch (SQLException e) {e.printStackTrace();
		} 
	 
		return isim;
	 
	}

	@Override
	public void deleteDoctor(Doctor doctor) {
		

		String query = "DELETE FROM calisan WHERE c_id=?";
		
		try {
			st=(Statement) con.createStatement();
			preparedStatement=(PreparedStatement) con.prepareStatement(query);
			preparedStatement.setInt(1,doctor.getId());
			 
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		
	}

	@Override
	public void addUser(Doctor doc) {

	 
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

	@Override
	public List<Doctor> getDoctorList() {
 
		
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

	@Override
	public void updateDoctor(Doctor doctor) {
		
		String query = "UPDATE calisan SET c_tc=?, c_isim=?, c_sifre=?, c_tip=?, c_bolum=? WHERE c_id=?";
		
		 
		
		try {
			st=(Statement) con.createStatement();
			preparedStatement=(PreparedStatement) con.prepareStatement(query);
			preparedStatement.setString(1,doctor.getTc());
			preparedStatement.setString(2,doctor.getName());
			preparedStatement.setString(3,doctor.getPassword());
			preparedStatement.setString(4,doctor.getType());
			preparedStatement.setInt(5,doctor.getBolum());
			preparedStatement.setInt(6,doctor.getId());
			 
			preparedStatement.executeUpdate();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		
	}
	



}
