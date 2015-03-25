package controleur.Commande;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.OptionPaneUI;

import modele.Assiette;
import modele.Commande;
import modele.Employe;
import vue.commande.ListAssiettesCommandes;
import vue.commande.ModifyLigne;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Controleur pour modifier une ligne d'une commande
 */
public class ControleurModifLig implements ActionListener {
	private ModifyLigne modLig;
	private Commande com;
	private Assiette assi;
	private Employe emplo;
	private String type, nomAss, nomAss2;
	private int linea=0, ord = 0, tcom = 0, table;
	private float prix;
	ArrayList<String> nomAssiette = new ArrayList<String>();
	ArrayList<Commande> detalle = new ArrayList<Commande>();
	
	public ControleurModifLig(ModifyLigne m, Commande co) {
		modLig = m;
		com=co;
		modLig.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				modLig.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ListAssiettesCommandes lis = new ListAssiettesCommandes();
				ControleurListAssiCom lic = new ControleurListAssiCom(lis, com);
				lic.recibeList(getAssieMoLi(), getEmploMoLi());
				com.initialize(getAssieMoLi(), getEmploMoLi());
				lic.llena(ord);
				lic.initTab(table);
				lic.startListAssi();
			}
		});
		
		modLig.btnMLAnnuler.addActionListener(this);
		modLig.btnMLEnregistrer.addActionListener(this);
		modLig.cmbMLType.addActionListener(this);
		modLig.cmbMLMAss.addActionListener(this);
	}
	
	/****************/
	public void recibeMoLi(Assiette a, Employe e){
		assi = a;
		System.out.println("###### MOLI :: "+assi);
		emplo = e;
		System.out.println("$$$$$$ MOLI :: "+emplo);
	}
	public Employe getEmploMoLi(){
		System.out.println("MOLI :: "+assi);
		return emplo;
	}
	public Assiette getAssieMoLi(){
		System.out.println("MOLI :: "+assi);
		return assi;
	}
	/******************/
	
	public void startModifLig(){
		try {
			com.chargeStateDet();
		} catch (Exception e) {
			e.printStackTrace();
		}
		modLig.setVisible(true);
		modLig.setLocationRelativeTo(null);
	}
	public void recevoirDonnees(int orden, int Tcomensal, int ligne, int tab, String nomA){
		ord = orden;
		tcom = Tcomensal;
		linea = ligne;
		table = tab;
		nomAss = nomA;
		
		modLig.txtMLCom.setText(Integer.toString(ord));
		modLig.txtMLLig.setText(Integer.toString(linea));
		modLig.txtMLPersonne.setText(Integer.toString(tcom));
		
		System.out.println("fucking name : "+nomAss);
		modLig.cmbMLType.setSelectedItem(assi.schType(nomAss));
		
		modLig.cmbMLMAss.setSelectedItem(nomAss);
	}
	@Override
	public void actionPerformed(ActionEvent act) {
		if(act.getSource().equals(modLig.btnMLEnregistrer)){
			int id = assi.searchID(nomAss);
			com.searchModLig(ord, table, tcom, linea, new Commande(ord, table, tcom, linea, id, nomAss2, prix, "Sin pagar"));
			try {
				com.saveStateDet();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			/*** Rechergement de la liste ***/
			ListAssiettesCommandes lis = new ListAssiettesCommandes();
			ControleurListAssiCom lic = new ControleurListAssiCom(lis, com);
			lic.recibeList(getAssieMoLi(), getEmploMoLi());
			com.initialize(getAssieMoLi(), getEmploMoLi());
			lic.llena(ord);
			lic.initTab(table);
			lic.startListAssi();
			modLig.setVisible(false);
			
		}else if(act.getSource().equals(modLig.btnMLAnnuler)){
			ListAssiettesCommandes lis = new ListAssiettesCommandes();
			ControleurListAssiCom lic = new ControleurListAssiCom(lis, com);
			lic.recibeList(getAssieMoLi(), getEmploMoLi());
			com.initialize(getAssieMoLi(), getEmploMoLi());
			lic.llena(ord);
			lic.initTab(table);
			lic.startListAssi();
			modLig.setVisible(false);
		}else if(act.getSource().equals(modLig.cmbMLType)){
			type=modLig.cmbMLType.getSelectedItem().toString();
			if(type.equals("S\u00E9lectionnez un type")){
				JOptionPane.showMessageDialog(null, "Lol");
				modLig.cmbMLMAss.setEnabled(false);
			}else{
				modLig.cmbMLMAss.setEnabled(true);
				modLig.cmbMLMAss.removeAllItems();
				nomAssiette.clear();
				nomAssiette = assi.llenaCombo(type);
				for (int i = 0; i < nomAssiette.size(); i++) {
					System.out.println("Imprimo cosas " + nomAssiette.get(i));
					modLig.cmbMLMAss.addItem(nomAssiette.get(i));
				}
			}
		}else if(act.getSource().equals(modLig.cmbMLMAss)){
			if(modLig.cmbMLMAss.getSelectedIndex()!=-1){
				nomAss2 = modLig.cmbMLMAss.getSelectedItem().toString();
				prix = assi.retPrix(nomAss2);
				modLig.txtMLPrix.setText(Float.toString(prix));
				modLig.btnMLEnregistrer.setEnabled(true);
			}
		}
	}
}
