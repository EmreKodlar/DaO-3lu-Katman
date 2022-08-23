package View;

import java.util.List;

import DataAccess.Clinic;


public interface IClinic {
	
	    
	   public void deleteClinic(Clinic clinic);
	   public void addClinic(Clinic clinic);
	   public void updateClinic(Clinic clinic);
	   public List<Clinic> getClinicList();

}
