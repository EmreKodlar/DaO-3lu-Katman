package Business;

import java.util.ArrayList;
import java.util.List;

import DataAccess.Clinic;
import DataAccess.Doctor;
import View.IClinic;

public class ClinicController implements IClinic {
	
	
	Clinic clinic= new Clinic();
	
	List<Clinic> listClinic=new ArrayList<Clinic>();

	@Override
	public void deleteClinic(Clinic clinic) {


		clinic.deleteClinic(clinic);
		
	}

	@Override
	public void addClinic(Clinic clinic) {
		clinic.addClinic(clinic);
		
	}

	@Override
	public void updateClinic(Clinic clinic) {
		clinic.updateClinic(clinic);
		
	}

	@Override
	public List<Clinic> getClinicList() {


		return clinic.getAllClinic();
	}

}
