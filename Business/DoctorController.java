package Business;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import DataAccess.Doctor;
import View.DoctorV;
import View.IDoctor;

public class DoctorController implements IDoctor {

 
	Doctor doctor= new Doctor();
	
	List<Doctor> listDoctor=new ArrayList<Doctor>();
	

	@Override
	public void getDoctorsName() {

 
	 
	}

	@Override
	public void deleteDoctor(Doctor doctor) {
		
		doctor.deleteUser(doctor);
		
		
	}

	@Override
	public void addUser(Doctor doc) {

	 
		doctor.addDoctor(doc);
		
	}

	@Override
	public List<Doctor> getDoctorList() {
 
		
		return doctor.getAllDoctor();
	}

	@Override
	public void updateDoctor(Doctor doctor) {
		
		doctor.updateDoctor(doctor);
		 
		
	}
	



}
