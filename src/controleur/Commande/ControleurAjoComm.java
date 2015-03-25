package controleur.Commande;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controleur.Controlateur;
import modele.Assiette;
import modele.Commande;
import modele.Employe;
import vue.Debut;
import vue.commande.AjoCommande;
import vue.commande.ListAssiettesCommandes;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Controleur pour ajouter une commande
 */
public class ControleurAjoComm implements ActionListener{
	private AjoCommande ajoCom;
	private Commande com;
	private Assiette assi;
	private Employe emplo;
	private String type, nomAssi; 
	private int linea=0, ord = 0, tcom = 0, user = 1, lig=0, ln, ps, table;
	private float prix;
	ArrayList<String> nomAssie = new ArrayList<String>();
	ArrayList<Commande> detalle = new ArrayList<Commande>();
	
	public ControleurAjoComm(AjoCommande ajo, Commande c) {
		ajoCom = ajo;
		com = c;
		ajoCom.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				ajoCom.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				System.out.println("*** EFF ID :: "+ajoCom.txtDComm.getText());
				com.effaccerCommande(Integer.parseInt(ajoCom.txtDComm.getText()));
				try {
					com.saveState();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		ajoCom.btnDAjouter.addActionListener(this);
		ajoCom.btnDCancelar.addActionListener(this);
		ajoCom.btnPerSuiv.addActionListener(this);
		ajoCom.cmbDTipAss.addActionListener(this);
		ajoCom.cmbDNomAss.addActionListener(this);
	}
	
	/****************/
	public void recibeAjo(Assiette a, Employe e){
		assi = a;
		System.out.println("###### AJO :: "+assi);
		emplo = e;
		System.out.println("$$$$$$ AJO :: "+emplo);
	}
	public Employe getEmploAjo(){
		System.out.println("AJO :: "+assi);
		return emplo;
	}
	public Assiette getAssieAjo(){
		System.out.println("AJO :: "+assi);
		return assi;
	}
	/******************/
	
	public void startAjoCom(){
		ajoCom.setVisible(true);
		ajoCom.setLocationRelativeTo(null);
	}
	
	public void recevoirDonnees(int orden, int Tcomensal, int ligne, int tab){
		ord = orden;
		tcom = Tcomensal;
		linea = ligne;
		table = tab;
		
		ajoCom.txtDComm.setText(Integer.toString(ord));
		ajoCom.txtDNPer.setText(Integer.toString(user));
		ajoCom.txtDNLin.setText(Integer.toString(linea));
	}
	
	@Override
	public void actionPerformed(ActionEvent aEv) {
		if (aEv.getSource().equals(ajoCom.btnDAjouter)) {
			lig=Integer.parseInt(ajoCom.txtDNLin.getText());
			int id = assi.searchID(nomAssi);
			
			System.out.println("ID RAWR EN AJO "+id);
			System.out.println("USER EN RAWR "+user);
			
			ln=Integer.parseInt(ajoCom.txtDNLin.getText());
			ps=Integer.parseInt(ajoCom.txtDNPer.getText());
			
			com.ajouterDetCommande(new Commande(ord, table, ps, ln, id, nomAssi, prix, "Sin Pagar"));
			ajoCom.txtDNLin.setText(Integer.toString(lig+1));
			effData();
			
		} else if (aEv.getSource().equals(ajoCom.btnDCancelar)) {
			System.out.println("*** EFF ID :: " + ajoCom.txtDComm.getText());
			com.effaccerCommande(Integer.parseInt(ajoCom.txtDComm.getText()));
			try {
				com.saveState();
			} catch (Exception e) {
				e.printStackTrace();
			}
			Debut deb = new Debut();
			Controlateur cont = new Controlateur(deb, emplo, assi, com);
			cont.initControl(getAssieAjo(), getEmploAjo());
			com.initialize(getAssieAjo(), getEmploAjo());
			cont.debutframe();
			ajoCom.setVisible(false);
		} else if (aEv.getSource().equals(ajoCom.btnPerSuiv)) {
			int sr = Integer.parseInt(ajoCom.txtDNPer.getText());
			System.out.println("Total de pers :: "+tcom);
			System.err.println("Pers act :; "+sr);
			if(tcom>sr){
				user = Integer.parseInt(ajoCom.txtDNPer.getText());
				ajoCom.txtDNPer.setText(Integer.toString(user+1));
				effData();
				linea=1;
				ajoCom.txtDNLin.setText(Integer.toString(linea));
			}else{
				effData();
				try {
					com.saveStateDet();
				} catch (Exception e) {
					e.printStackTrace();
				}
				ListAssiettesCommandes lis = new ListAssiettesCommandes();
				ControleurListAssiCom lic = new ControleurListAssiCom(lis, com);
				lic.recibeList(getAssieAjo(), getEmploAjo());
				com.initialize(getAssieAjo(), getEmploAjo());
				lic.llena(ord);
				lic.initTab(table);
				lic.startListAssi();
				ajoCom.setVisible(false);
			}
		} else if (aEv.getSource().equals(ajoCom.cmbDTipAss)) {
			type = ajoCom.cmbDTipAss.getSelectedItem().toString();
			if (type.equals("S\u00E9lectionnez un type")) {
				JOptionPane.showMessageDialog(null, "Elige otra cosa");
				ajoCom.cmbDNomAss.setEnabled(false);
			} else {
				ajoCom.cmbDNomAss.setEnabled(true);
				ajoCom.cmbDNomAss.removeAllItems();
				nomAssie.clear();
				nomAssie = assi.llenaCombo(type);
				for (int i = 0; i < nomAssie.size(); i++) {
					System.out.println("Imprimo l l " + nomAssie.get(i));
					ajoCom.cmbDNomAss.addItem(nomAssie.get(i));
				}
			}
		} else if (aEv.getSource().equals(ajoCom.cmbDNomAss)) {
			if(ajoCom.cmbDNomAss.getSelectedIndex()!=-1){
				nomAssi = ajoCom.cmbDNomAss.getSelectedItem().toString();
				prix = assi.retPrix(nomAssi);
				ajoCom.txtPrix.setText(Float.toString(prix));
				ajoCom.btnDAjouter.setEnabled(true);
			}
		}
	}
	public void effData(){
		ajoCom.cmbDNomAss.setEnabled(false);
		ajoCom.cmbDNomAss.removeAllItems();
		ajoCom.cmbDTipAss.setSelectedIndex(0);
		ajoCom.txtPrix.setText("");
		ajoCom.btnDAjouter.setEnabled(false);
	}
}
