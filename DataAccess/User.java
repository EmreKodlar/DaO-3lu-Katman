package DataAccess;

public class User {
	
	private int id,bolum;
	private String name,password,tc,type;
	
	public User(int id, int bolum, String name, String password, String tc, String type) {
		super();
		this.id = id;
		this.bolum = bolum;
		this.name = name;
		this.password = password;
		this.tc = tc;
		this.type = type;
	}
	public User( int bolum, String name, String password, String tc, String type) {
		super();
		 
		this.bolum = bolum;
		this.name = name;
		this.password = password;
		this.tc = tc;
		this.type = type;
	}
	
	public User() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBolum() {
		return bolum;
	}

	public void setBolum(int bolum) {
		this.bolum = bolum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTc() {
		return tc;
	}

	public void setTc(String tc) {
		this.tc = tc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	

}
