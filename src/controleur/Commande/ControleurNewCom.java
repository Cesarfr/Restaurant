package controleur.Commande;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controleur.Controlateur;
import modele.Assiette;
import modele.Commande;
import modele.Employe;
import vue.Debut;
import vue.commande.AjoCommande;
import vue.commande.NewCommande;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Controleur pour une nouvelle commande
 */
public class ControleurNewCom implements ActionListener {
	private NewCommande newCom;
	private Commande com;
	private int orden, tcom, tab, nEmp;
	private Assiette assi;
	private Employe emplo;
	
	
	public ControleurNewCom(NewCommande ne, Commande c) {
		 newCom = ne;
		 com = c;

		 newCom.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent arg0) {
					newCom.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					com.effaccerCommande(orden);
					try {
						com.saveState();
					} catch (Exception e) {
						e.printStackTrace();
					}
					Debut deb = new Debut();
					Controlateur cont = new Controlateur(deb, emplo, assi, com);
					cont.initControl(getAssieNew(), getEmploNew());
					com.initialize(getAssieNew(), getEmploNew());
					cont.debutframe();

					newCom.setVisible(false);
				}
			});
		 newCom.txtNTab.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char car = e.getKeyChar();
					if ((car < '0' || car > '9') || newCom.txtNTab.getText().length() == 2)
						e.consume();
				}
			});
		 newCom.txtNomPers.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char car = e.getKeyChar();
					if ((car < '0' || car > '9') || newCom.txtNomPers.getText().length() == 1)
						e.consume();
				}
			});
		 newCom.btnGenerar.addActionListener(this);
		 newCom.btnAnnuler.addActionListener(this);
	}
	public void initIDEmp(int ID2){
		newCom.txtEmplo.setText(Integer.toString(ID2));
	}
	public void initID(int ID){
		if(ID==0){
			newCom.txtNComm.setText(Integer.toString(1));
		}else{
			newCom.txtNComm.setText(Integer.toString(ID));
		}
	}
	/****************/
	public void recibe(Assiette a, Employe e){
		assi = a;
		System.out.println("###### NEW :: "+assi);
		emplo = e;
		System.out.println("$$$$$$ NEW :: "+emplo);
	}
	public Employe getEmploNew(){
		System.out.println("NEW :: "+assi);
		return emplo;
	}
	public Assiette getAssieNew(){
		System.out.println("NEW :: "+assi);
		return assi;
	}
	/******************/
	public void startNewCom(){
		newCom.setVisible(true);
		newCom.setLocationRelativeTo(null);
	}
	
	public String recFech(){
		String fecha="";
		fecha=newCom.calendario.getCalendar().get(Calendar.YEAR)+"/"+newCom.calendario.getCalendar().get(Calendar.MONTH)+"/"+newCom.calendario.getCalendar().get(Calendar.DAY_OF_MONTH);
		return fecha;
	}
	
	@Override
	public void actionPerformed(ActionEvent acEv) {
		if(acEv.getSource().equals(newCom.btnGenerar)){
			if(newCom.txtNTab.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Escribe el numero de mesa");
				newCom.txtNTab.requestFocus();
			}else if(newCom.txtNomPers.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Escribe un numero de personas");
				newCom.txtNomPers.requestFocus();
			}else{
				orden = Integer.parseInt(newCom.txtNComm.getText());
				nEmp=Integer.parseInt(newCom.txtEmplo.getText());
				tab = Integer.parseInt(newCom.txtNTab.getText());
				tcom = Integer.parseInt(newCom.txtNomPers.getText());
				JOptionPane.showMessageDialog(null, tab+" :: "+tcom);
				int control = com.valideNewCom(tab, tcom);
				
				if(control==30){
					JOptionPane.showMessageDialog(null, "Escribe el numero de mesa");
					newCom.txtNTab.requestFocus();
				}else if(control==31){
					JOptionPane.showMessageDialog(null, "Escribe un numero de personas");
					newCom.txtNomPers.requestFocus();
				}else if(control==32){
					JOptionPane.showMessageDialog(null, "Table ocup\u00E9e");
					newCom.txtNTab.requestFocus();
				}else if(control==29){
					AjoCommande ajoC = new AjoCommande();
					ControleurAjoComm cAc = new ControleurAjoComm(ajoC, com);
					
					cAc.recibeAjo(getAssieNew(), getEmploNew());
					com.initialize(getAssieNew(), getEmploNew());
					cAc.recevoirDonnees(orden, tcom, 1, tab);
					
					com.ajouterCommande(new Commande(orden, tab, tcom, nEmp, "Cours", recFech(), 0.0f));
					try {
						com.saveState();
					} catch (Exception e) {
						System.err.println("Error en saveState() debido a: "+e.getMessage());
					}
					cAc.startAjoCom();
					newCom.setVisible(false);
				}
			}
		}else if(acEv.getSource().equals(newCom.btnAnnuler)){
			com.effaccerCommande(orden);
			try {
				com.saveState();
			} catch (Exception e) {
				e.printStackTrace();
			}
			Debut deb = new Debut();
			Controlateur cont = new Controlateur(deb, emplo, assi, com);
			cont.initControl(getAssieNew(), getEmploNew());
			com.initialize(getAssieNew(), getEmploNew());
			cont.debutframe();
			newCom.setVisible(false);
		}
	}
}
