package Business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import DataAccess.Database;
import DataAccess.Doctor;
import DataAccess.Hasta;
import DataAccess.Randevu;
import View.IRandevu;

public class RandevuController implements IRandevu {
	
	
	Database conn= new Database();
	Statement st=null;
	ResultSet rs=null;
	Connection con=conn.connDb();
	PreparedStatement preparedStatement= null;
	public List<Randevu> list;
	Randevu randevu;

	@Override
	public void deleteRandevu(Randevu randevu) {



		String query = "DELETE FROM randevu WHERE id=?";
		
		try {
			st=(Statement) con.createStatement();
			preparedStatement=(PreparedStatement) con.prepareStatement(query);
			preparedStatement.setInt(1,randevu.getId());
			 
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		
	}

	@Override
	public void addRandevu(Randevu randevu) {


String sorguEkleme = " INSERT INTO randevu (hasta_id,doktor_id,klinik_id,tarih)  VALUES (?, ?, ?, ?)";
		
		try {
			st=(Statement) con.createStatement();
			preparedStatement=(PreparedStatement) con.prepareStatement(sorguEkleme);
			 
			preparedStatement.setInt (1, randevu.getHasta_id());
			preparedStatement.setInt (2, randevu.getDoctor_id());
			preparedStatement.setInt   (3, randevu.getClinic_id());
			preparedStatement.setString(4, randevu.getTarih());
			 
			 
			preparedStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateRandevu(Randevu randevu) {
		
		String query = "UPDATE randevu SET doktor_id=?, klinik_id=?, tarih=?  WHERE id=?";
		
		try {
			st=(Statement) con.createStatement();
			preparedStatement=(PreparedStatement) con.prepareStatement(query);
			preparedStatement.setInt(1,randevu.getDoctor_id());
			preparedStatement.setInt(2,randevu.getClinic_id());
			preparedStatement.setString(3,randevu.getTarih());
			preparedStatement.setInt(4,randevu.getId());
		 
			 
			preparedStatement.executeUpdate();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Randevu> randevuListele(int hastaID) {
		
	list = new ArrayList<Randevu>();
		
		try {
			 
			st =(Statement) con.createStatement();
			rs=st.executeQuery("SELECT id,hasta_id,doktor_id,klinik_id,tarih FROM randevu WHERE hasta_id="+hastaID);
			while(rs.next()) {
				
		
			randevu=new Randevu(rs.getInt("id"),rs.getInt("hasta_id"),rs.getInt("doktor_id"),rs.getInt("klinik_id"),rs.getString("tarih"));
			list.add(randevu); } 
			
			 
		 
		} 
		catch (SQLException e) {e.printStackTrace();
		} 
	 
		return list;
	}

}
