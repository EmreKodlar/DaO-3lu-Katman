package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Business.ClinicController;
import Business.DoctorController;
import DataAccess.Clinic;
import DataAccess.Doctor;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClinicV extends JFrame {

	private JPanel contentPane;
	private JTable table;
 
	//tablo oluşturma
	private DefaultTableModel modelim = new DefaultTableModel();
	private Object[] kolonlar= {"ID","Klinik İsim"};
	private Object[] satirlar= new Object[2];
	
	ClinicController cC=new ClinicController();
	Clinic cli= new Clinic();
	private JTextField k_isim;
	
 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClinicV frame = new ClinicV();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClinicV() {
		setTitle("Klinik İşlemleri");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
   
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 409, 293);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBounds(10, 36, 409, 217);
 
		modelim.setColumnIdentifiers(kolonlar);
		scrollPane.setViewportView(table);
		
		JButton sil = new JButton("SİL");
		sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 if(table.getSelectedRow()<0) {
		 				
						JOptionPane.showMessageDialog(null, "Önce Seçiniz!", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
					
						
					}
					else {
						 cli=cC.getClinicList().get(table.getSelectedRow());  // tablodan nesne alma işlemi...
						 
						 cC.deleteClinic(cli);
				 
				 JOptionPane.showMessageDialog(null,cli.getName() + " isimli Klinik Başarıyla Silindi!", "Klinik Silme Paneli", JOptionPane.INFORMATION_MESSAGE);
				
				 listeYenileClinic();
					}
				
			}
		});
		sil.setBounds(432, 11, 89, 23);
		contentPane.add(sil);
		
		JButton duz = new JButton("DÜZENLE");
		duz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(table.getSelectedRow()<0) {
					
					JOptionPane.showMessageDialog(null, "Önce Seçiniz!", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
				
					
				}
				else {
					 
					  int i = table.getSelectedRow();
					  
					  String isimAl=table.getModel().getValueAt(i,1).toString();
		              int idAl= Integer.parseInt(table.getModel().getValueAt(i, 0).toString());
		            
		         
		               table.revalidate();
		               table.repaint();
		               
				 
					cli= new Clinic(idAl,isimAl);
					
					cC.updateClinic(cli);
					
					
			 }
				
				 
			}
		});
		duz.setBounds(531, 11, 134, 23);
		contentPane.add(duz);
		
		JLabel lblNewLabel = new JLabel("YENİ KLİNİK EKLEME");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(429, 85, 236, 14);
		contentPane.add(lblNewLabel);
		
		k_isim = new JTextField();
		k_isim.setText("Klinik Adı Giriniz");
		k_isim.setBounds(439, 110, 226, 20);
		contentPane.add(k_isim);
		k_isim.setColumns(10);
		
		JButton ekle = new JButton("EKLE");
		ekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				cli= new Clinic(k_isim.getText()); 
				
				cC.addClinic(cli);
				
				JOptionPane.showMessageDialog(null, "Eklendi!", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
				
				listeYenileClinic();
				
			}
		});
		ekle.setBounds(439, 141, 226, 23);
		contentPane.add(ekle);
		
		listeYenileClinic();
		
	}
	
	
public void listeYenileClinic() {
		
		modelim.setRowCount(0);
		
	for(int i=0; i<cC.getClinicList().size(); i++) {
			
			satirlar[0]=cC.getClinicList().get(i).getId();
			 
			satirlar[1]=cC.getClinicList().get(i).getName();
			 
			modelim.addRow(satirlar);
			}
				 table.setModel(modelim);
	}
}
