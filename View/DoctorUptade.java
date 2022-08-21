package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Business.DoctorController;
 
import DataAccess.Doctor;
 

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoctorUptade extends JFrame {

	private JPanel contentPane;
	public JTextField id_getir;
	public JTextField tcc;
	public JTextField isimm;
	public JTextField sifree;
	public JTextField bolumm;
	public JTextField typee;
	

	DoctorController dC=new DoctorController();
	Doctor doc= new Doctor();
	
	DoctorV docV= new DoctorV();
	

	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorUptade frame = new DoctorUptade();
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
	public DoctorUptade() {
		setTitle("DOKTOR GÜNCELLE");
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(47, 54, 46, 14);
		contentPane.add(lblId);
		
		id_getir = new JTextField();
		id_getir.setEnabled(false);
		id_getir.setEditable(false);
		id_getir.setColumns(10);
		id_getir.setBounds(130, 51, 231, 20);
		contentPane.add(id_getir);
		
		JLabel lblNewLabel = new JLabel("TC");
		lblNewLabel.setBounds(47, 94, 46, 14);
		contentPane.add(lblNewLabel);
		
		tcc = new JTextField();
		tcc.setColumns(10);
		tcc.setBounds(130, 90, 231, 20);
		contentPane.add(tcc);
		
		JLabel lblIsim = new JLabel("İsim");
		lblIsim.setBounds(47, 132, 46, 14);
		contentPane.add(lblIsim);
		
		isimm = new JTextField();
		isimm.setColumns(10);
		isimm.setBounds(130, 128, 231, 20);
		contentPane.add(isimm);
		
		JLabel lblifre = new JLabel("Şifre");
		lblifre.setBounds(47, 173, 46, 14);
		contentPane.add(lblifre);
		
		sifree = new JTextField();
		sifree.setColumns(10);
		sifree.setBounds(130, 170, 231, 20);
		contentPane.add(sifree);
		
		JLabel lblYer = new JLabel("Bölüm No");
		lblYer.setBounds(47, 211, 56, 14);
		contentPane.add(lblYer);
		
		bolumm = new JTextField();
		bolumm.setColumns(10);
		bolumm.setBounds(130, 208, 231, 20);
		contentPane.add(bolumm);
		
		JLabel lblTip = new JLabel("Tip");
		lblTip.setBounds(47, 253, 56, 14);
		contentPane.add(lblTip);
		
		typee = new JTextField();
		typee.setColumns(10);
		typee.setBounds(130, 250, 231, 20);
		contentPane.add(typee);
		
		JButton cDuz = new JButton("Düzenle");
		cDuz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(tcc.getText().length()==0 || isimm.getText().length()==0 || sifree.getText().length()==0 || bolumm.getText().length()==0 ) {
					
					JOptionPane.showMessageDialog(null, "Boş Alan Bırakmayınız!", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
	
					doc=new Doctor(Integer.parseInt(id_getir.getText()),Integer.parseInt(bolumm.getText()),isimm.getText(),sifree.getText(),tcc.getText(),typee.getText());
	
					dC.updateDoctor(doc);
					
					JOptionPane.showMessageDialog(null, "Başarıyla Düzenlendi!", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
					 
					docV.listeYenileDoctor();
					 
					
				}


			}
		});
		cDuz.setBounds(130, 295, 231, 23);
		contentPane.add(cDuz);
	}
}
