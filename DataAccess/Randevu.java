package DataAccess;

public class Randevu {
	
	
	private int id, hasta_id, doctor_id, clinic_id;
	private String tarih;
	public Randevu(int id, int hasta_id, int doctor_id, int clinic_id, String tarih) {
		super();
		this.id = id;
		this.hasta_id = hasta_id;
		this.doctor_id = doctor_id;
		this.clinic_id = clinic_id;
		this.tarih = tarih;
	}
	
	public Randevu( int hasta_id, int doctor_id, int clinic_id, String tarih) {
		super();
		 
		this.hasta_id = hasta_id;
		this.doctor_id = doctor_id;
		this.clinic_id = clinic_id;
		this.tarih = tarih;
	}
	
	public Randevu () {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHasta_id() {
		return hasta_id;
	}

	public void setHasta_id(int hasta_id) {
		this.hasta_id = hasta_id;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public int getClinic_id() {
		return clinic_id;
	}

	public void setClinic_id(int clinic_id) {
		this.clinic_id = clinic_id;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}
	
	

}
