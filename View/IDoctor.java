package View;

import java.util.List;

import DataAccess.Doctor;


public interface IDoctor {
	
	   public void getDoctorsName();
	   public void deleteDoctor(Doctor doctor);
	   public void addUser(Doctor doctor);
	   public void updateDoctor(Doctor doctor);
	   public List<Doctor> getDoctorList();

}
