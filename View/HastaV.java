package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

 
import Business.DoctorController;
import Business.HastaController;
import DataAccess.Clinic;
import DataAccess.Doctor;
import DataAccess.Hasta;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HastaV extends JFrame {
	
	
	HastaController hC=new HastaController();
	Hasta hasta= new Hasta();

	private JPanel contentPane;
	private JTable tableHasta;
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
					HastaV frame = new HastaV();
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
	public HastaV() {
		setTitle("Hasta Paneli");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 135, 409, 193);
		contentPane.add(scrollPane);
		
		tableHasta = new JTable();
		tableHasta.setBounds(10, 36, 409, 217);
		 
		 
		modelim.setColumnIdentifiers(kolonlar);
		scrollPane.setViewportView(tableHasta);
		
		listeYenileHasta();
		
		isimT = new JTextField();
		isimT.setBounds(527, 135, 166, 20);
		contentPane.add(isimT);
		isimT.setColumns(10);
		
		JLabel isim = new JLabel("İsim:");
		isim.setBounds(451, 135, 46, 14);
		contentPane.add(isim);
		
		JLabel tc = new JLabel("TC:");
		tc.setBounds(451, 164, 46, 14);
		contentPane.add(tc);
		
		JLabel sifre = new JLabel("Şifre:");
		sifre.setBounds(451, 197, 46, 14);
		contentPane.add(sifre);
		
		JLabel bolum = new JLabel("Bölüm:");
		bolum.setBounds(451, 230, 46, 14);
		contentPane.add(bolum);
		
		JLabel tip = new JLabel("Tip:");
		tip.setBounds(451, 263, 46, 14);
		contentPane.add(tip);  
		
		tcT = new JTextField();
		tcT.setColumns(10);
		tcT.setBounds(527, 166, 166, 20);
		contentPane.add(tcT);
		
		sifreT = new JTextField();
		sifreT.setColumns(10);
		sifreT.setBounds(527, 194, 166, 20);
		contentPane.add(sifreT);
		
		bolumT = new JTextField();
		bolumT.setColumns(10);
		bolumT.setBounds(527, 227, 166, 20);
		contentPane.add(bolumT);
		
		tipT = new JTextField("Hasta");
		tipT.setEditable(false);
		tipT.setEnabled(false);
		tipT.setColumns(10);
		tipT.setBounds(527, 260, 166, 20);
		contentPane.add(tipT);
		
		JButton ekleB = new JButton("EKLE");
		ekleB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				hasta= new Hasta(Integer.parseInt(bolumT.getText()), isimT.getText(), sifreT.getText(), tcT.getText(), tipT.getText()); 
				
				hC.addHasta(hasta);
				
				JOptionPane.showMessageDialog(null, "Eklendi!", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
				
				listeYenileHasta();
				bolumT.setText("");
				isimT.setText("");
				sifreT.setText("");
				tcT.setText("");
				
				
				
			}
		});
		ekleB.setBounds(527, 291, 166, 23);
		contentPane.add(ekleB);
		
		JButton sil = new JButton("SİL");
		sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 
				 if(tableHasta.getSelectedRow()<0) {
					 				
						JOptionPane.showMessageDialog(null, "Önce Seçiniz!", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
					
						
					}
					else {
						hasta=hC.getHastaList().get(tableHasta.getSelectedRow());  // tablodan nesne alma işlemi...
						 
						 hC.deleteHasta(hasta);
				 
				 JOptionPane.showMessageDialog(null,hasta.getName() + " isimli Kullanıcı Başarıyla Silindi!", "Kullanıcı Silme Paneli", JOptionPane.INFORMATION_MESSAGE);
				
				 listeYenileHasta();
					}
				
				
			}
		});
		sil.setBounds(578, 101, 117, 23);
		contentPane.add(sil);
		
		JButton duzenle = new JButton("DÜZENLE");
		duzenle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	if(tableHasta.getSelectedRow()<0) {
					
					JOptionPane.showMessageDialog(null, "Önce Seçiniz!", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
				
					
				}
				else {
					
					// Tabloyu hücre içinden güncelleme
					 int ii = tableHasta.getSelectedRow();
					 int id_Al= Integer.parseInt(tableHasta.getModel().getValueAt(ii, 0).toString());
					  String tc_Al=tableHasta.getModel().getValueAt(ii,1).toString();
		              String isim_Al=tableHasta.getModel().getValueAt(ii,2).toString();
		              String sifre_Al=tableHasta.getModel().getValueAt(ii,3).toString();
		              String tip_Al=tableHasta.getModel().getValueAt(ii,4).toString();
		    
		              tableHasta.revalidate();
		              tableHasta.repaint();
		        
		              hasta= new Hasta(id_Al,0,isim_Al,sifre_Al,tc_Al,tip_Al);
		      
					  hC.updateHasta(hasta);
					
			
					
					
			 }
			}
		});
		duzenle.setBounds(451, 101, 117, 23);
		contentPane.add(duzenle);
		
		JButton yenile = new JButton("YENİLE");
		yenile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				listeYenileHasta();
			}
		});
		yenile.setBounds(10, 101, 409, 23);
		contentPane.add(yenile);
		
		JLabel lblNewLabel = new JLabel("Hoş Geldiniz Sayın Yönetici");
		lblNewLabel.setBounds(10, 76, 180, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Doktor İşlemleri");
		lblNewLabel_1.setBounds(10, 23, 109, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Klinik İşlemleri");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ClinicV cV= new ClinicV();
				cV.setVisible(true);
			}
		});
	 
		lblNewLabel_1_1.setBounds(136, 23, 109, 14);
		contentPane.add(lblNewLabel_1_1);
	}
	
	
public void listeYenileHasta() {
		
		modelim.setRowCount(0);
		
	for(int i=0; i<hC.getHastaList().size(); i++) {
			
			satirlar[0]=hC.getHastaList().get(i).getId();
			satirlar[1]=hC.getHastaList().get(i).getTc();
			satirlar[2]=hC.getHastaList().get(i).getName();
			satirlar[3]=hC.getHastaList().get(i).getPassword();
			satirlar[4]=hC.getHastaList().get(i).getType();
			modelim.addRow(satirlar);
			}
	tableHasta.setModel(modelim);
	}
}
