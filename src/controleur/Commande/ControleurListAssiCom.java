package controleur.Commande;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controleur.Controlateur;
import modele.Assiette;
import modele.Commande;
import modele.Employe;
import vue.Debut;
import vue.commande.ListAssiettesCommandes;
import vue.commande.ModifyLigne;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Controleur pour lister les assietes d' une commande
 */
public class ControleurListAssiCom implements ActionListener{
	private ListAssiettesCommandes list;
	private Commande com;
	private Assiette assi;
	private Employe emplo;
	ArrayList<Object[]> lCom = new ArrayList<Object[]>();
	private int idOr, idTab, idUs, idLig;
	private String nomAs;
	
	public ControleurListAssiCom(ListAssiettesCommandes li, Commande c){
		list = li;
		com = c;
		
		list.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				list.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Debut deb = new Debut();
				Controlateur cont = new Controlateur(deb, emplo, assi, com);
				cont.initControl(getAssieList(), getEmploList());
				com.initialize(getAssieList(), getEmploList());
				cont.debutframe();
			}
		});
		list.btnAssCommCancelar.addActionListener(this);
		list.mntmModificarASCom.addActionListener(this);
	}
	/****************/
	public void recibeList(Assiette a, Employe e){
		assi = a;
		System.out.println("###### LIST :: "+assi);
		emplo = e;
		System.out.println("$$$$$$ LIST :: "+emplo);
	}
	public Employe getEmploList(){
		System.out.println("LIST :: "+assi);
		return emplo;
	}
	public Assiette getAssieList(){
		System.out.println("LIST :: "+assi);
		return assi;
	}
	/******************/
	public void startListAssi(){
		list.setVisible(true);
		list.setLocationRelativeTo(null);
	}
	public void initTab(int tb){
		idTab=tb;
	}
	public void llena(int ID){
		cleanTable();
		lCom.clear();
		lCom=com.listCommande(ID);
		for (int i = 0; i < lCom.size(); i++) {
			list.dtmList.addRow(lCom.get(i));;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent acEv) {
		if(acEv.getSource().equals(list.btnAssCommCancelar)){
			Debut deb = new Debut();
			Controlateur cont = new Controlateur(deb, emplo, assi, com);
			cont.initControl(getAssieList(), getEmploList());
			com.initialize(getAssieList(), getEmploList());
			cont.debutframe();
			list.setVisible(false);
		}else if(acEv.getSource().equals(list.mntmModificarASCom)){
			int res = list.tableAssComm.getSelectedRow();
			if (res >= 0) {
				int resp = JOptionPane.showConfirmDialog(null,"Desea editar el registro?", "Advertencia!!!", 0, 0);
				if (resp == 0) {
					idOr = Integer.parseInt(list.tableAssComm.getValueAt(res, 0).toString());
					idUs= Integer.parseInt(list.tableAssComm.getValueAt(res, 1).toString());
					idLig=Integer.parseInt(list.tableAssComm.getValueAt(res, 2).toString());
					nomAs=list.tableAssComm.getValueAt(res, 3).toString();
					JOptionPane.showConfirmDialog(null, "Datos "+idOr+" : "+idUs+" : "+idLig+" : "+nomAs);
					
					ModifyLigne mod = new ModifyLigne();
					ControleurModifLig cml = new ControleurModifLig(mod, com);
					cml.recibeMoLi(getAssieList(), getEmploList());
					com.initialize(getAssieList(), getEmploList());
					cml.recevoirDonnees(idOr, idUs, idLig, idTab, nomAs);
					cml.startModifLig();
					list.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Registro intacto");
				}
			}
		}
	}
	public void cleanTable(){
		lCom.clear();
		int filas=list.dtmList.getRowCount();
		for (int i=0; filas>i; i++) {
			list.dtmList.removeRow(0);
		}
	}

}
