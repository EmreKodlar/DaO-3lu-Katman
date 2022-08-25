package View;

import java.util.List;

import DataAccess.Hasta;
import DataAccess.Randevu;

public interface IRandevu {

	public void deleteRandevu (Randevu randevu);
	   public void addRandevu (Randevu randevu);
	   public void updateRandevu (Randevu randevu);
	   public List<Randevu> randevuListele(int hasta_id);
}
