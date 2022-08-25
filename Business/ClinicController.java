package Business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import DataAccess.Clinic;
import DataAccess.Database;
import DataAccess.Doctor;
import View.IClinic;

public class ClinicController implements IClinic {
	
	
	 
	
	Database conn= new Database();
	private Statement st=null;
	private ResultSet rs=null;
	private Connection con=conn.connDb();
	private PreparedStatement preparedStatement= null;
	public List<Clinic> list;
	private Clinic clinic;

	@Override
	public void deleteClinic(Clinic clinic) {


		String query = "DELETE FROM clinic WHERE id=?";
		
		try {
			st=(Statement) con.createStatement();
			preparedStatement=(PreparedStatement) con.prepareStatement(query);
			preparedStatement.setInt(1,clinic.getId());
			 
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addClinic(Clinic clinic) {
		String sorguEkleme = " INSERT INTO clinic (isim)  VALUES (?)";
		
		try {
			st=(Statement) con.createStatement();
			preparedStatement=(PreparedStatement) con.prepareStatement(sorguEkleme);
			 
			preparedStatement.setString (1, clinic.getName());
		 
			 
			preparedStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateClinic(Clinic clinic) {
		
		String query = "UPDATE clinic SET  isim=?  WHERE  id=?";
		
		try {
			st=(Statement) con.createStatement();
			
			preparedStatement=(PreparedStatement) con.prepareStatement(query);
			
			preparedStatement.setString(1,clinic.getName());
		 
			preparedStatement.setInt(2,clinic.getId());
			 
			preparedStatement.executeUpdate();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Clinic> getClinicList() {

		list = new ArrayList<Clinic>();
		
		try {
			 
			st =(Statement) con.createStatement();
			rs=st.executeQuery("SELECT id,isim FROM clinic");
			while(rs.next()) {	
			clinic=new Clinic(rs.getInt("id"),rs.getString("isim"));
			list.add(clinic); } 
		} 
		catch (SQLException e) {e.printStackTrace();
		} 
	 
		return list;
	}
	
	
	public String getClinicName(int id) {

		String isim=null;
		
		try {
			 
			st =(Statement) con.createStatement();
			rs=st.executeQuery("SELECT id, isim  FROM clinic WHERE id=" + id);
			if(rs.next()) {
				
		
			isim=rs.getString("isim");
		  } 
		 
		} 
		catch (SQLException e) {e.printStackTrace();
		} 
	 
		return isim;
	 
	}

}
