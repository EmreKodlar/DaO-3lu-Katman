package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

 
import Business.DoctorController;
import DataAccess.Doctor;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoctorV extends JFrame {
	
	
	DoctorController dC=new DoctorController();
	Doctor doc= new Doctor();

	private JPanel contentPane;
	public JTable tableDoctor;
	private JTextField isimT;
	private JTextField tcT;
	private JTextField sifreT;
	private JTextField bolumT;
	private JTextField tipT;
	
	
	//tablo oluşturma
		private DefaultTableModel modelim = new DefaultTableModel();
		private Object[] kolonlar= {"ID","TC","Isim","Sifre","Tip"};
		private Object[] satirlar= new Object[5];
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorV frame = new DoctorV();
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
	public DoctorV() {
		setTitle("Doktor Paneli");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 409, 193);
		contentPane.add(scrollPane);
		
		tableDoctor = new JTable();
		tableDoctor.setBounds(10, 36, 409, 217);
		 
		 
		modelim.setColumnIdentifiers(kolonlar);
		scrollPane.setViewportView(tableDoctor);
		
		listeYenileDoctor();
		
		isimT = new JTextField();
		isimT.setBounds(527, 81, 166, 20);
		contentPane.add(isimT);
		isimT.setColumns(10);
		
		JLabel isim = new JLabel("İsim:");
		isim.setBounds(451, 81, 46, 14);
		contentPane.add(isim);
		
		JLabel tc = new JLabel("TC:");
		tc.setBounds(451, 110, 46, 14);
		contentPane.add(tc);
		
		JLabel sifre = new JLabel("Şifre:");
		sifre.setBounds(451, 143, 46, 14);
		contentPane.add(sifre);
		
		JLabel bolum = new JLabel("Bölüm:");
		bolum.setBounds(451, 176, 46, 14);
		contentPane.add(bolum);
		
		JLabel tip = new JLabel("Tip:");
		tip.setBounds(451, 209, 46, 14);
		contentPane.add(tip);  
		
		tcT = new JTextField();
		tcT.setColumns(10);
		tcT.setBounds(527, 112, 166, 20);
		contentPane.add(tcT);
		
		sifreT = new JTextField();
		sifreT.setColumns(10);
		sifreT.setBounds(527, 140, 166, 20);
		contentPane.add(sifreT);
		
		bolumT = new JTextField();
		bolumT.setColumns(10);
		bolumT.setBounds(527, 173, 166, 20);
		contentPane.add(bolumT);
		
		tipT = new JTextField("Doktor");
		tipT.setEditable(false);
		tipT.setEnabled(false);
		tipT.setColumns(10);
		tipT.setBounds(527, 206, 166, 20);
		contentPane.add(tipT);
		
		JButton ekleB = new JButton("EKLE");
		ekleB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				doc= new Doctor(Integer.parseInt(bolumT.getText()), isimT.getText(), sifreT.getText(), tcT.getText(), tipT.getText()); 
				
				dC.addUser(doc);
				
				JOptionPane.showMessageDialog(null, "Eklendi!", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
				
				 listeYenileDoctor();
				
				
			}
		});
		ekleB.setBounds(527, 237, 166, 23);
		contentPane.add(ekleB);
		
		JButton sil = new JButton("SİL");
		sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 
				 if(tableDoctor.getSelectedRow()<0) {
					 				
						JOptionPane.showMessageDialog(null, "Önce Seçiniz!", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
					
						
					}
					else {
						 doc=dC.getDoctorList().get(tableDoctor.getSelectedRow());  // tablodan nesne alma işlemi...
						 
						 dC.deleteDoctor(doc);
				 
				 JOptionPane.showMessageDialog(null,doc.getName() + " isimli Kullanıcı Başarıyla Silindi!", "Kullanıcı Silme Paneli", JOptionPane.INFORMATION_MESSAGE);
				
				 listeYenileDoctor();
					}
				
				
			}
		});
		sil.setBounds(578, 47, 117, 23);
		contentPane.add(sil);
		
		JButton duzenle = new JButton("DÜZENLE");
		duzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	if(tableDoctor.getSelectedRow()<0) {
					
					JOptionPane.showMessageDialog(null, "Önce Seçiniz!", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
				
					
				}
				else {
					
					 doc=dC.getDoctorList().get(tableDoctor.getSelectedRow());  // tablodan nesne alma işlemi...
					
					DoctorUptade cdu=new DoctorUptade();
					
					cdu.tcc.setText(doc.getTc());
					cdu.isimm.setText(doc.getName());
					cdu.sifree.setText(doc.getPassword());
					cdu.typee.setText(doc.getType());
					cdu.id_getir.setText(String.valueOf(doc.getId()));
					cdu.bolumm.setText(String.valueOf(doc.getBolum()));
					
					cdu.setVisible(true);
					
					
			 }
			}
		});
		duzenle.setBounds(451, 47, 117, 23);
		contentPane.add(duzenle);
		
		JButton yenile = new JButton("YENİLE");
		yenile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				listeYenileDoctor();
			}
		});
		yenile.setBounds(10, 47, 409, 23);
		contentPane.add(yenile);
		
		JLabel lblNewLabel = new JLabel("Hoş Geldiniz Sayın Yönetici");
		lblNewLabel.setBounds(10, 22, 180, 14);
		contentPane.add(lblNewLabel);
	}
	
	
public void listeYenileDoctor() {
		
		modelim.setRowCount(0);
		
	for(int i=0; i<dC.getDoctorList().size(); i++) {
			
			satirlar[0]=dC.getDoctorList().get(i).getId();
			satirlar[1]=dC.getDoctorList().get(i).getTc();
			satirlar[2]=dC.getDoctorList().get(i).getName();
			satirlar[3]=dC.getDoctorList().get(i).getPassword();
			satirlar[4]=dC.getDoctorList().get(i).getType();
			modelim.addRow(satirlar);
			}
				 tableDoctor.setModel(modelim);
	}
}
