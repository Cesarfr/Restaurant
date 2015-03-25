package controleur.Commande;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

import controleur.Controlateur;
import modele.Assiette;
import modele.Commande;
import modele.Employe;
import vue.Debut;
import vue.commande.ChangerStatusCom;
import vue.commande.NouvelleStat;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Controleur pour changer le status d'une commande
 */
public class ControleurChangStatus implements ActionListener{
	private ChangerStatusCom chSt;
	private Commande com;
	private Assiette assi;
	private Employe emplo;
	private int idCom, idt, ids, idEmpl;
	private String st, date;
	ArrayList<Object[]> toChi = new ArrayList<Object[]>();
	
	public ControleurChangStatus(ChangerStatusCom csc, Commande co) {
		chSt = csc;
		com = co;
		chSt.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				chSt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Debut deb = new Debut();
				Controlateur cont = new Controlateur(deb, emplo, assi, com);
				cont.initControl(getAssieChan(), getEmploChan());
				com.initialize(getAssieChan(), getEmploChan());
				cont.debutframe();
			}
		});
		chSt.btnChStSortir.addActionListener(this);
		chSt.mntmChangerStausAss.addActionListener(this);
	}
	
	/****************/
	public void recibeChange(Assiette a, Employe e){
		assi = a;
		System.out.println("###### CHZN :: "+assi);
		emplo = e;
		System.out.println("$$$$$$ CHZN :: "+emplo);
	}
	public Employe getEmploChan(){
		System.out.println("CHZN :: "+assi);
		return emplo;
	}
	public Assiette getAssieChan(){
		System.out.println("CHZN :: "+assi);
		return assi;
	}
	/******************/
	
	public void startChangStatus(){
		chSt.setVisible(true);
		chSt.setLocationRelativeTo(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent acEv) {
		if(acEv.getSource().equals(chSt.btnChStSortir)){
			Debut deb = new Debut();
			Controlateur cont = new Controlateur(deb, emplo, assi, com);
			cont.initControl(getAssieChan(), getEmploChan());
			com.initialize(getAssieChan(), getEmploChan());
			cont.debutframe();
			chSt.setVisible(false);
		}else if(acEv.getSource().equals(chSt.mntmChangerStausAss)){
			int res = chSt.tablaOrdenesChSt.getSelectedRow();
			if (res >= 0) {
				NouvelleStat no = new NouvelleStat();
				ControleurNouvEt ne = new ControleurNouvEt(no, com);
				idCom = Integer.parseInt(chSt.tablaOrdenesChSt.getValueAt(res, 0).toString());
				idt = Integer.parseInt(chSt.tablaOrdenesChSt.getValueAt(res, 1).toString());
				ids = Integer.parseInt(chSt.tablaOrdenesChSt.getValueAt(res, 2).toString());
				st = chSt.tablaOrdenesChSt.getValueAt(res, 3).toString();
				date = chSt.tablaOrdenesChSt.getValueAt(res, 4).toString();
				idEmpl = com.reqEmplo(idCom);
				ne.initVari(idCom, idt, ids, st, date, idEmpl);
				ne.recibeNou(getAssieChan(), getEmploChan());
				com.initialize(getAssieChan(), getEmploChan());
				ne.startNouvelle();
				chSt.setVisible(false);
			}
			
		}
	}
	
	public void ajouTc(){
		cleanTable();
		toChi.clear();
		toChi=com.tousCommande();
		for (int i = 0; i < toChi.size(); i++) {
			chSt.dtm.addRow(toChi.get(i));;
		}
	}
	
	public void cleanTable(){
		toChi.clear();
		int filas=chSt.dtm.getRowCount();
		for (int i=0; filas>i; i++) {
			chSt.dtm.removeRow(0);
		}
	}
}
