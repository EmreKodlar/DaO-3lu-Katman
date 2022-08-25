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
import DataAccess.Hasta;
import View.DoctorV;
import View.IDoctor;
import View.IHasta;

public class HastaController implements IHasta {

 
	Hasta hasta;
	public List<Hasta> list;
	 
	Database conn= new Database();
	Statement st=null;
	ResultSet rs=null;
	Connection con=conn.connDb();
	PreparedStatement preparedStatement= null;
	
	 
 

	@Override
	public void addHasta(Hasta has) {
		 
String sorguEkleme = " INSERT INTO calisan (c_tc,c_isim,c_sifre,c_bolum,c_tip)  VALUES (?, ?, ?, ?,?)";
		
		try {
			st=(Statement) con.createStatement();
			preparedStatement=(PreparedStatement) con.prepareStatement(sorguEkleme);
			 
			preparedStatement.setString (1, has.getTc());
			preparedStatement.setString (2, has.getName());
			preparedStatement.setString   (3, has.getPassword());
			preparedStatement.setInt(4, has.getBolum());
			preparedStatement.setString(5, has.getType());
			 
			preparedStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateHasta(Hasta has) {
		 
		String query = "UPDATE calisan SET c_tc=?, c_isim=?, c_sifre=?, c_tip=? WHERE c_id=?";
		
		 
		
		try {
			st=(Statement) con.createStatement();
			preparedStatement=(PreparedStatement) con.prepareStatement(query);
			preparedStatement.setString(1,has.getTc());
			preparedStatement.setString(2,has.getName());
			preparedStatement.setString(3,has.getPassword());
			preparedStatement.setString(4,has.getType());
			preparedStatement.setInt(5,has.getId());
			
			 
			preparedStatement.executeUpdate();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Hasta> getHastaList() {
		list = new ArrayList<Hasta>();
		
		try {
			 
			st =(Statement) con.createStatement();
			rs=st.executeQuery("SELECT c_id,c_tc,c_isim,c_sifre,c_tip,c_bolum FROM calisan WHERE c_tip='Hasta'");
			while(rs.next()) {
				
		
			hasta=new Hasta(rs.getInt("c_id"),rs.getInt("c_bolum"),rs.getString("c_isim"),rs.getString("c_sifre"),rs.getString("c_tc"),rs.getString("c_tip"));
			list.add(hasta); } 
			
			 
		 
		} 
		catch (SQLException e) {e.printStackTrace();
		} 
	 
		return list;
	}

	@Override
	public void getHastaName() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteHasta(Hasta has) {

	String query = "DELETE FROM calisan WHERE c_id=?";
		
		try {
			st=(Statement) con.createStatement();
			preparedStatement=(PreparedStatement) con.prepareStatement(query);
			preparedStatement.setInt(1,has.getId());
			 
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}
	



}
