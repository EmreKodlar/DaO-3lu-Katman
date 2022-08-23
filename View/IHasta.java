package View;

import java.util.List;

import DataAccess.Doctor;
import DataAccess.Hasta;


public interface IHasta {
	
	   public void getHastaName();
	   public void deleteHasta(Hasta hasta);
	   public void addHasta(Hasta hasta);
	   public void updateHasta(Hasta hasta);
	   public List<Hasta> getHastaList();

}
