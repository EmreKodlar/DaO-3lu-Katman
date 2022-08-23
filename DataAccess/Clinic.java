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
	
	
	Database conn= new Database();
	private Statement st=null;
	private ResultSet rs=null;
	private Connection con=conn.connDb();
	private PreparedStatement preparedStatement= null;
	public List<Clinic> list;
	private Clinic clinic;
	
	
	public List<Clinic> getAllClinic(){
		 
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
		
	public void deleteClinic(Clinic cli) {


		String query = "DELETE FROM clinic WHERE id=?";
		
		try {
			st=(Statement) con.createStatement();
			preparedStatement=(PreparedStatement) con.prepareStatement(query);
			preparedStatement.setInt(1,cli.getId());
			 
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}
	
	
	public void updateClinic(Clinic cli) {

		String query = "UPDATE clinic SET  isim=?  WHERE  id=?";
		
		 
			
		try {
			st=(Statement) con.createStatement();
			
			preparedStatement=(PreparedStatement) con.prepareStatement(query);
			
			preparedStatement.setString(1,cli.getName());
		 
			preparedStatement.setInt(2,cli.getId());
			 
			preparedStatement.executeUpdate();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		}
	
	
	public void addClinic(Clinic cli) {
		
		String sorguEkleme = " INSERT INTO clinic (isim)  VALUES (?)";
			
			try {
				st=(Statement) con.createStatement();
				preparedStatement=(PreparedStatement) con.prepareStatement(sorguEkleme);
				 
				preparedStatement.setString (1, cli.getName());
			 
				 
				preparedStatement.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	
	

}
