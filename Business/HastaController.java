package Business;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import DataAccess.Doctor;
import DataAccess.Hasta;
import View.DoctorV;
import View.IDoctor;
import View.IHasta;

public class HastaController implements IHasta {

 
	Hasta hasta= new Hasta();
	
	List<Hasta> listHasta=new ArrayList<Hasta>();
	
 

	@Override
	public void addHasta(Hasta has) {
		 
		hasta.addHasta(has);
	}

	@Override
	public void updateHasta(Hasta has) {
		 
		hasta.updateHasta(has);
	}

	@Override
	public List<Hasta> getHastaList() {
		// TODO Auto-generated method stub
		return hasta.getAllHasta();
	}

	@Override
	public void getHastaName() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteHasta(Hasta has) {

		hasta.deleteUser(has);
		
	}
	



}
