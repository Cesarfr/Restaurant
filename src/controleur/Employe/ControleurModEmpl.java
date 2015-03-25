package controleur.Employe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;

import employesSpec.Caissier;
import employesSpec.Cuisinier;
import employesSpec.Serveur;
import modele.Assiette;
import modele.Employe;
import vue.employe.MenuEmployes;
import vue.employe.ModEmploye;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Controleur pour modifier une employe
 */
public class ControleurModEmpl implements ActionListener {
	private ModEmploye modEmplo;
	private Employe emplo, tmp, tmp2;
	Assiette assi;
	private int edad, numer, telef, id,an=0, m=0, d=0;;
	private String sexe;
	private String puesto, nom, prenom, rue, date_N, ville, pays, user, pass;
	ArrayList<String> modify = new ArrayList<String>();
	
	public ControleurModEmpl(ModEmploye mod, Employe em) {
		 modEmplo = mod;
		 emplo = em;
		 
		 modEmplo.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent arg0) {
					modEmplo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					MenuEmployes men = new MenuEmployes();
					ControleurMenuEmplo cm = new ControleurMenuEmplo(men, emplo);
					cm.xd(cpAsMod());
					cm.startMenuEmplo();
				}
			});
		 modEmplo.txtModEmpNom.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')
							&& (c != (char) KeyEvent.VK_SPACE) && c != '-')
						e.consume(); // Validar solo letras, espacios y -
				}
			});
		 modEmplo.txtModEmpPrenom.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')
							&& (c != (char) KeyEvent.VK_SPACE) && c != '-')
						e.consume(); // Validar solo letras, espacios y -
				}
			});
		 modEmplo.txtModEmpNum.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char car = e.getKeyChar();
					if ((car < '0' || car > '9'))
						e.consume();
				}
			});
		 modEmplo.txtModEmpTel.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char car = e.getKeyChar();
					if ((car < '0' || car > '9'))
						e.consume();
				}
			});
		 modEmplo.calModEmp.addDateListener(new DateListener() {
				public void dateChanged(DateEvent arg0) {
					GregorianCalendar fecha=new GregorianCalendar();
					int anios=fecha.get(GregorianCalendar.YEAR);
					edad=anios-modEmplo.calModEmp.getCalendar().get(Calendar.YEAR);
					if(edad<=-1){
						JOptionPane.showMessageDialog(null, "Aun no llegamos a esa fecha!!");
					}
					else{
						//btnAgregarRegistro.setEnabled(true); ??????
					}
				}
			});
		 modEmplo.btnModEmpEditarReg.addActionListener(this);
		 modEmplo.btnModEmpSearch.addActionListener(this);
		 modEmplo.btnModEmpSortir.addActionListener(this);
		 modEmplo.cmbModEmpPuesto.addActionListener(this);
		 modEmplo.cmbModEmpNom.addActionListener(this);
		 modEmplo.rdbtnModEmpFemme.addActionListener(this);
		 modEmplo.rdbtnModEmpFemme.addActionListener(this);
	}
	
	/***********/
	public void setAssMod(Assiette lol){
		System.out.println("MOD NOS LLEGA :: "+lol);
		assi=lol;
		System.out.println("MOD ASSI VALE :: "+assi);
	}
	public Assiette cpAsMod(){
		System.out.println("Regresamos de CME:: "+assi);
		return assi;
	}
	/***********/
	
	public void startModEmp(){
		modEmplo.setVisible(true);
		modEmplo.setLocationRelativeTo(null);
	}
	
	public String recFech(){
		String fecha="";
		fecha=modEmplo.calModEmp.getCalendar().get(Calendar.YEAR)+"/"+modEmplo.calModEmp.getCalendar().get(Calendar.MONTH)+"/"+modEmplo.calModEmp.getCalendar().get(Calendar.DAY_OF_MONTH);
		return fecha;
	}
	
	public boolean verifyOption(){
		if(modEmplo.cmbModEmpPuesto.getSelectedItem().equals("Emploi")){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			if (arg0.getSource().equals(modEmplo.btnModEmpEditarReg)) {
				valideForm();
			} else if (arg0.getSource().equals(modEmplo.rdbtnModEmpFemme)) {
				modEmplo.rdbtnModEmpHomme.setSelected(false);
				sexe = modEmplo.rdbtnModEmpFemme.getText().toString();
			} else if (arg0.getSource().equals(modEmplo.rdbtnModEmpHomme)) {
				modEmplo.rdbtnModEmpFemme.setSelected(false);
				sexe = modEmplo.rdbtnModEmpHomme.getText().toString();
			} else if (arg0.getSource().equals(modEmplo.btnModEmpSearch)) {
				String app = modEmplo.cmbModEmpNom.getSelectedItem().toString();
				tmp = emplo.llenaDat(app);
				init();
			} else if (arg0.getSource().equals(modEmplo.btnModEmpSortir)) {
				MenuEmployes men = new MenuEmployes();
				ControleurMenuEmplo cm = new ControleurMenuEmplo(men, emplo);
				cm.xd(cpAsMod());
				cm.startMenuEmplo();
				modEmplo.setVisible(false);
			} else if (arg0.getSource().equals(modEmplo.cmbModEmpPuesto)) {
				if (verifyOption()) {
					modEmplo.cmbModEmpNom.removeAllItems();
					modify.clear();
					modEmplo.cmbModEmpNom.setEnabled(true);
					puesto = modEmplo.cmbModEmpPuesto.getSelectedItem().toString();
					modify = emplo.llenaCombo(puesto);
					for (int i = 0; i < modify.size(); i++) {
						System.out.println("Imprimo l l "+modify.get(i));
						modEmplo.cmbModEmpNom.addItem(modify.get(i));
					}
				} else {
					JOptionPane.showMessageDialog(null, "Elige otra opcion");
				}
			} else if (arg0.getSource().equals(modEmplo.cmbModEmpNom)) {
				modEmplo.btnModEmpSearch.setEnabled(true);
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	public void valideForm() {
		if (modEmplo.textModEmplNo.getText().equals("")
				|| modEmplo.textModEmplNo.getText().equals(null)) {
			JOptionPane.showMessageDialog(null, "Falta ID");
		} else if (modEmplo.txtModEmpNom.getText().equals("")
				|| modEmplo.txtModEmpNom.getText().equals(null)) {
			JOptionPane.showMessageDialog(null, "Falta NOM");
			modEmplo.txtModEmpNom.requestFocus();
		} else if (modEmplo.txtModEmpPrenom.getText().equals("")
				|| modEmplo.txtModEmpPrenom.getText().equals(null)) {
			JOptionPane.showMessageDialog(null, "Falta PRENOM");
			modEmplo.txtModEmpPrenom.requestFocus();
		} else if (!modEmplo.rdbtnModEmpFemme.isSelected()
				&& !modEmplo.rdbtnModEmpHomme.isSelected()) {
			JOptionPane.showMessageDialog(null, "Falta SEXO");
			modEmplo.rdbtnModEmpFemme.requestFocus();
		} else if (recFech().equals("") || recFech().equals(null)) {
			JOptionPane.showMessageDialog(null, "Falta FECHA");
			modEmplo.calModEmp.requestFocus();
		} else if (modEmplo.txtModEmpRue.getText().equals("")
				|| modEmplo.txtModEmpRue.getText().equals(null)) {
			JOptionPane.showMessageDialog(null, "Falta RUE");
			modEmplo.txtModEmpRue.requestFocus();
		} else if (modEmplo.txtModEmpNum.getText().equals("")
				|| modEmplo.txtModEmpNum.getText().equals(null)) {
			JOptionPane.showMessageDialog(null, "Falta NUMERO");
			modEmplo.txtModEmpNum.requestFocus();
		} else if (modEmplo.txtModEmpVille.getText().equals("")
				|| modEmplo.txtModEmpVille.getText().equals(null)) {
			JOptionPane.showMessageDialog(null, "Falta VILLE");
			modEmplo.txtModEmpVille.requestFocus();
		} else if (modEmplo.txtModEmpPays.getText().equals("")
				|| modEmplo.txtModEmpPays.getText().equals(null)) {
			JOptionPane.showMessageDialog(null, "Falta PAYS");
			modEmplo.txtModEmpPays.requestFocus();
		} else if (modEmplo.txtModEmpTel.getText().equals("")
				|| modEmplo.txtModEmpTel.getText().equals(null)) {
			JOptionPane.showMessageDialog(null, "Falta TELEF");
			modEmplo.txtModEmpTel.requestFocus();
		} else if (modEmplo.txtModEmpUser.getText().equals("") || modEmplo.txtModEmpUser.getText().equals(null)) {
			JOptionPane.showMessageDialog(null, "Falta USUARIO, eleige algo dif");
			modEmplo.txtModEmpUser.requestFocus();
		} else if (modEmplo.cmbModEmpNouPuesto.getSelectedItem().equals("Emploi")) {
			JOptionPane.showMessageDialog(null, "ELIGE OTRA COSA");
			modEmplo.cmbModEmpNouPuesto.requestFocus();
		} else if (modEmplo.cmbModEmpNouPuesto.getSelectedItem().equals("Caissier")
				&& modEmplo.txtModEmpPass.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Falta PASSWORD");
			modEmplo.txtModEmpPass.requestFocus();
		}else{
			JOptionPane.showMessageDialog(null, "Chido lml");
			
			/*
			 * Recuperation des valeurs des champs du formulaire
			 */
			nom=modEmplo.txtModEmpNom.getText();
			prenom=modEmplo.txtModEmpPrenom.getText();
			rue=modEmplo.txtModEmpRue.getText();
			date_N=recFech();
			numer = Integer.parseInt(modEmplo.txtModEmpNum.getText());
			ville=modEmplo.txtModEmpVille.getText().toString();
			pays=modEmplo.txtModEmpPays.getText();
			telef=Integer.parseInt(modEmplo.txtModEmpTel.getText());
			user=modEmplo.txtModEmpUser.getText();
			pass=modEmplo.txtModEmpPass.getText();
			puesto=modEmplo.cmbModEmpNouPuesto.getSelectedItem().toString();
			id=Integer.parseInt(modEmplo.textModEmplNo.getText());
			
			if(modEmplo.rdbtnModEmpFemme.isSelected()){
				sexe = modEmplo.rdbtnModEmpFemme.getText().toString();
			}else{
				sexe = modEmplo.rdbtnModEmpHomme.getText().toString();
			}
			
			JOptionPane.showMessageDialog(null, sexe);
			
			if(puesto.equals("Serveur")){
				tmp2 = new Serveur(id, nom, prenom, sexe, date_N, rue, numer, ville, pays, telef, user, "");
			}else if(puesto.equals("Caissier")){
				tmp2=new Caissier(id, nom, prenom, sexe, date_N, rue, numer, ville, pays, telef, user, pass);
			}else if(puesto.equals("Cuisinier")){
				tmp2=new Cuisinier(id, nom, prenom, sexe, date_N, rue, numer, ville, pays, telef, user, "");
			}
			emplo.modifier(tmp2);
			try {
				emplo.guardarEstado();
			} catch (Exception e) {
				e.printStackTrace();
			}
			effacerDonnes();
		}
	}
	
	public void init(){
		/*******************/
		modEmplo.textModEmplNo.setText(Integer.toString(tmp.getId()));
		modEmplo.txtModEmpNom.setText(tmp.getNom());
		modEmplo.txtModEmpPrenom.setText(tmp.getPrenom());
		
		String fe = tmp.getDate_N();
		StringTokenizer tokens = new StringTokenizer(fe, "/"); 
		while (tokens.hasMoreTokens()) {
			an=Integer.parseInt(tokens.nextToken());
			m=Integer.parseInt(tokens.nextToken());
			d=Integer.parseInt(tokens.nextToken());
		}
		JOptionPane.showMessageDialog(null, "Fecha :: "+an+" :: "+m+" :: "+d);
//		an = Integer.parseInt(fe.substring(0, 4));
//		m = Integer.parseInt(fe.substring(5, 7));
//		d = Integer.parseInt(fe.substring(8, 10));
		an = an - 1900;
		Date fec = new Date(an, m - 1, d);
		modEmplo.calModEmp.setDate(fec);
		modEmplo.calModEmp.repaint();
		
		System.err.println(tmp.getSexe());
		if(tmp.getSexe().equals("Homme")){
			modEmplo.rdbtnModEmpHomme.setSelected(true);
			modEmplo.rdbtnModEmpFemme.setSelected(false);
		}else{
			modEmplo.rdbtnModEmpFemme.setSelected(true);
			modEmplo.rdbtnModEmpHomme.setSelected(false);
		}
		
		modEmplo.txtModEmpRue.setText(tmp.getRue());
		modEmplo.txtModEmpNum.setText(Integer.toString(tmp.getNumero()));
		modEmplo.txtModEmpVille.setText(tmp.getVille());
		modEmplo.txtModEmpPays.setText(tmp.getPay());
		modEmplo.txtModEmpTel.setText(Integer.toString(tmp.getTelef()));
		modEmplo.cmbModEmpNouPuesto.setSelectedItem(tmp.getClass().getName().substring(13));
		if(tmp.getClass().getName().substring(13).equals("Cuisinier") || tmp.getClass().getName().substring(13).equals("Serveur")){
			modEmplo.txtModEmpPass.setEnabled(false);
			modEmplo.txtModEmpPass.setText("");
		}
		modEmplo.txtModEmpUser.setText(tmp.getUser());
		modEmplo.txtModEmpPass.setText(tmp.getPass());
		/********************/
	}
	
	/**
	 * Methode pour effacer les donnes
	 */
	public void effacerDonnes(){
		modEmplo.txtModEmpNom.setText("");
		modEmplo.txtModEmpPrenom.setText("");
		modEmplo.txtModEmpRue.setText("");
		modEmplo.txtModEmpNum.setText("");
		modEmplo.txtModEmpVille.setText("");
		modEmplo.txtModEmpPays.setText("");
		modEmplo.txtModEmpTel.setText("");
		modEmplo.txtModEmpUser.setText("");
		modEmplo.txtModEmpPass.setText("");
		modEmplo.cmbModEmpNouPuesto.setSelectedItem("Emploi");
		modEmplo.textModEmplNo.setText("");
		GregorianCalendar fec=new GregorianCalendar(); 
		int an=fec.get(Calendar.YEAR);
		int mm=fec.get(Calendar.MONTH);
		int dd=fec.get(Calendar.DAY_OF_MONTH);
		Date fechaact= new Date(an-1900,mm,dd);
		modEmplo.calModEmp.setDate(fechaact);
		modEmplo.calModEmp.repaint();
	}
}
