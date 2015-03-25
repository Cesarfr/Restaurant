package controleur.Employe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;

import employesSpec.Caissier;
import employesSpec.Cuisinier;
import employesSpec.Manager;
import employesSpec.Serveur;
import modele.Assiette;
import modele.Employe;
import vue.employe.AjoEmploye;
import vue.employe.MenuEmployes;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Controleur pour ajouter une employe
 */
public class ControleurAjoEmploye implements ActionListener {
	// Vue
	private AjoEmploye ajEmp;
	// Modele
	private Employe emp, emp2;
	Assiette assi;
	private int edad, numer, telef, id;
	private String sexe;
	private String puesto, nom, prenom, rue, date_N, ville, pays, user, pass;
	private int limite = 8;
	
	public ControleurAjoEmploye(AjoEmploye conEmp, Employe emplo) {
		ajEmp = conEmp;
		emp = emplo;
		
		ajEmp.txtNom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')
						&& (c != (char) KeyEvent.VK_SPACE) && c != '-')
					e.consume(); // Validar solo letras, espacios y -
			}
		});
		ajEmp.txtPrenom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')
						&& (c != (char) KeyEvent.VK_SPACE) && c != '-')
					e.consume(); // Validar solo letras, espacios y -
			}
		});

		ajEmp.txtNum.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if ((car < '0' || car > '9'))
					e.consume();
			}
		});
		ajEmp.txtTel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if ((car < '0' || car > '9') || ajEmp.txtTel.getText().length() == limite)
					e.consume();
			}
		});
		
		
		ajEmp.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				ajEmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				MenuEmployes men = new MenuEmployes();
				ControleurMenuEmplo cm = new ControleurMenuEmplo(men, emp);
				cm.xd(cpAsAjo());
				cm.startMenuEmplo();
			}
		});
		ajEmp.calendario.addDateListener(new DateListener() {
			public void dateChanged(DateEvent arg0) {
				GregorianCalendar fecha=new GregorianCalendar();
				int anios=fecha.get(GregorianCalendar.YEAR);
				edad=anios-ajEmp.calendario.getCalendar().get(Calendar.YEAR);
				if(edad<=-1){
					JOptionPane.showMessageDialog(null, "Aun no llegamos a esa fecha!!");
				}
				else{
					//btnAgregarRegistro.setEnabled(true); ??????
				}
			}
		});
		ajEmp.rdbtnFemme.addActionListener(this);
		ajEmp.rdbtnHomme.addActionListener(this);
		ajEmp.cmbEmploi.addActionListener(this);
		ajEmp.btnAddEmploi.addActionListener(this);
		ajEmp.btnSortirAjoEmp.addActionListener(this);
	}
	
	/***********/
	public void setAssAjo(Assiette lol){
		System.out.println("AJO NOS LLEGA :: "+lol);
		assi=lol;
		System.out.println("AJO ASSI VALE :: "+assi);
	}
	public Assiette cpAsAjo(){
		System.out.println("Regresamos de CME:: "+assi);
		return assi;
	}
	/***********/
	
	public void startFrame() {
		ajEmp.setVisible(true);
		ajEmp.setLocationRelativeTo(null);
	}
	public String recFech(){
		String fecha="";
		fecha=ajEmp.calendario.getCalendar().get(Calendar.YEAR)+"/"+ajEmp.calendario.getCalendar().get(Calendar.MONTH)+"/"+ajEmp.calendario.getCalendar().get(Calendar.DAY_OF_MONTH);
		return fecha;
	}
	
	@Override
	public void actionPerformed(ActionEvent aE) {
		if (aE.getSource().equals(ajEmp.rdbtnFemme)) {
			ajEmp.rdbtnHomme.setSelected(false);
			sexe=ajEmp.rdbtnFemme.getText().toString();
		}else if (aE.getSource().equals(ajEmp.rdbtnHomme)) {
			ajEmp.rdbtnFemme.setSelected(false);
			sexe=ajEmp.rdbtnHomme.getText().toString();
		}else if(aE.getSource().equals(ajEmp.cmbEmploi)){
			userPass();
		}else if(aE.getSource().equals(ajEmp.btnAddEmploi)){
			valide();
		}else if(aE.getSource().equals(ajEmp.btnSortirAjoEmp)){
			MenuEmployes men = new MenuEmployes();
			ControleurMenuEmplo cm = new ControleurMenuEmplo(men, emp);
			cm.xd(cpAsAjo());
			cm.startMenuEmplo();
			ajEmp.setVisible(false);
		}
	}
	/**
	 * Cette methode valide que les chmps ne sont pas vide
	 */
	public void valide(){
		if(ajEmp.lblIDAjo.getText().equals("") || ajEmp.lblIDAjo.getText().equals(null)){
			JOptionPane.showMessageDialog(null, "Falta ID");
		}else if(ajEmp.txtNom.getText().equals("") || ajEmp.txtNom.getText().equals(null)){
			JOptionPane.showMessageDialog(null, "Falta NOM");
			ajEmp.txtNom.requestFocus();
		}else if(ajEmp.txtPrenom.getText().equals("") || ajEmp.txtPrenom.getText().equals(null)){
			JOptionPane.showMessageDialog(null, "Falta PRENOM");
			ajEmp.txtPrenom.requestFocus();
		}else if(!ajEmp.rdbtnFemme.isSelected() && !ajEmp.rdbtnHomme.isSelected()){
			JOptionPane.showMessageDialog(null, "Falta SEXO");
			ajEmp.rdbtnFemme.requestFocus();
		}else if(recFech().equals("") || recFech().equals(null)){
			JOptionPane.showMessageDialog(null, "Falta FECHA");
			ajEmp.calendario.requestFocus();
		}else if(ajEmp.txtRue.getText().equals("") || ajEmp.txtRue.getText().equals(null)){
			JOptionPane.showMessageDialog(null, "Falta RUE");
			ajEmp.txtRue.requestFocus();
		}else if(ajEmp.txtNum.getText().equals("") || ajEmp.txtNum.getText().equals(null)){
			JOptionPane.showMessageDialog(null, "Falta NUMERO");
			ajEmp.txtNum.requestFocus();
		}else if(ajEmp.txtVille.getText().equals("") || ajEmp.txtVille.getText().equals(null)){
			JOptionPane.showMessageDialog(null, "Falta VILLE");
			ajEmp.txtVille.requestFocus();
		}else if(ajEmp.txtPay.getText().equals("") || ajEmp.txtPay.getText().equals(null)){
			JOptionPane.showMessageDialog(null, "Falta PAYS");
			ajEmp.txtPay.requestFocus();
		}else if(ajEmp.txtTel.getText().equals("") || ajEmp.txtTel.getText().equals(null)){
			JOptionPane.showMessageDialog(null, "Falta TELEF");
			ajEmp.txtTel.requestFocus();
		}else if(ajEmp.txtUserS.getText().equals("") || ajEmp.txtUserS.getText().equals(null)){
			JOptionPane.showMessageDialog(null, "Falta USUARIO, eleige algo dif");
			ajEmp.txtUserS.requestFocus();
		}else if(ajEmp.cmbEmploi.getSelectedItem().equals("Emploi")){
			JOptionPane.showMessageDialog(null, "ELIGE OTRA COSA");
			ajEmp.cmbEmploi.requestFocus();
		}else if(ajEmp.cmbEmploi.getSelectedItem().equals("Manager") && ajEmp.txtPassS.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Falta PASSWORD");
			ajEmp.txtPassS.requestFocus();
		}else if(ajEmp.cmbEmploi.getSelectedItem().equals("Caissier") && ajEmp.txtPassS.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Falta PASSWORD");
			ajEmp.txtPassS.requestFocus();
		}else{
			JOptionPane.showMessageDialog(null, "Bien todo lleno");
			
			/*
			 * Recuperation des valeurs des champs du formulaire
			 */
			nom=ajEmp.txtNom.getText();
			prenom=ajEmp.txtPrenom.getText();
			rue=ajEmp.txtRue.getText();
			date_N=recFech();
			numer = Integer.parseInt(ajEmp.txtNum.getText());
			ville=ajEmp.txtVille.getText().toString();
			pays=ajEmp.txtPay.getText();
			telef=Integer.parseInt(ajEmp.txtTel.getText());
			user=ajEmp.txtUserS.getText();
			pass=ajEmp.txtPassS.getText();
			puesto=ajEmp.cmbEmploi.getSelectedItem().toString();
			id=Integer.parseInt(ajEmp.lblIDAjo.getText());
			
			
			
			if(puesto.equals("Serveur")){
				emp2 = new Serveur(id, nom, prenom, sexe, date_N, rue, numer, ville, pays, telef, user, "");
			}else if(puesto.equals("Caissier")){
				emp2=new Caissier(id, nom, prenom, sexe, date_N, rue, numer, ville, pays, telef, user, pass);
			}else if(puesto.equals("Cuisinier")){
				emp2=new Cuisinier(id, nom, prenom, sexe, date_N, rue, numer, ville, pays, telef, user, "");
			}else if(puesto.equals("Manager")){
				emp2=new Manager(id, nom, prenom, sexe, date_N, rue, numer, ville, pays, telef, user, pass);
			}
			/*
			 * On appelle a le methode enregistrer pour ajouter l'employe
			 */
			emp.ajouterEmploye(emp2);
			try {
				emp.guardarEstado();
			} catch (Exception e) {
				
			}
			effacerDonnes();
		}
	}
	
	/**
	 * Methode pour effacer les donnes
	 */
	public void effacerDonnes(){
		ajEmp.txtNom.setText("");
		ajEmp.txtPrenom.setText("");
		ajEmp.txtRue.setText("");
		ajEmp.txtNum.setText("");
		ajEmp.txtVille.setText("");
		ajEmp.txtPay.setText("");
		ajEmp.txtTel.setText("");
		ajEmp.txtUserS.setText("");
		ajEmp.txtPassS.setText("");
		ajEmp.cmbEmploi.setSelectedItem("Emploi");
		ajEmp.lblIDAjo.setText(Integer.toString(emp.searchID()));
		GregorianCalendar fec=new GregorianCalendar(); 
		int an=fec.get(Calendar.YEAR);
		int mm=fec.get(Calendar.MONTH);
		int dd=fec.get(Calendar.DAY_OF_MONTH);
		Date fechaact= new Date(an-1900,mm,dd);
		ajEmp.calendario.setDate(fechaact);
		ajEmp.calendario.repaint();
	}
	/**
	 * Test para buscar el ultimo ID del empleado
	 */
	public void getIDempl(int iden){
		ajEmp.lblIDAjo.setText(Integer.toString(iden));
	}
	/**
	 * Activation du champs pour ajouter l'user et le password pendant que peut ajouter le password
	 */
	public void userPass(){
		if (ajEmp.cmbEmploi.getSelectedItem().equals("Emploi")) {
			JOptionPane.showMessageDialog(null, "Escoge une opcion");
			ajEmp.txtUserS.setEnabled(false);
			ajEmp.txtPassS.setEnabled(false);
		}else if (ajEmp.cmbEmploi.getSelectedItem().equals("Serveur")) {
			ajEmp.txtUserS.setEnabled(true);
			ajEmp.txtPassS.setEnabled(false);
		} else if (ajEmp.cmbEmploi.getSelectedItem().equals("Caissier")) {
			ajEmp.txtUserS.setEnabled(true);
			ajEmp.txtPassS.setEnabled(true);
		} else if (ajEmp.cmbEmploi.getSelectedItem().equals("Cuisinier")) {
			ajEmp.txtUserS.setEnabled(true);
			ajEmp.txtPassS.setEnabled(false);
		} else if (ajEmp.cmbEmploi.getSelectedItem().equals("Manager")) {
			ajEmp.txtUserS.setEnabled(true);
			ajEmp.txtPassS.setEnabled(true);
		}
	}
}
