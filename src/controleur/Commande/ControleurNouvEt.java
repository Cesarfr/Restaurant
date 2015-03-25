package controleur.Commande;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controleur.Controlateur;
import vue.Debut;
import vue.commande.ChangerStatusCom;
import vue.commande.NouvelleStat;
import modele.Assiette;
import modele.Commande;
import modele.Employe;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Controleur pour une nouvelle etat d'une commande
 */
public class ControleurNouvEt implements ActionListener {
	private Commande com;
	private Employe emplo;
	private Assiette assi;
	private NouvelleStat nve;
	private int idOr, idTab, idUs, idEmpl;
	private String stat, date;
	
	public ControleurNouvEt(NouvelleStat n, Commande c) {
		com = c;
		nve = n;
		
		nve.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				nve.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ChangerStatusCom chs = new ChangerStatusCom();
				ControleurChangStatus conCh = new ControleurChangStatus(chs, com);
				com.initialize(getAssieNou(), getEmploNou());
				conCh.recibeChange(getAssieNou(), getEmploNou());
				conCh.ajouTc();
				conCh.startChangStatus();
				nve.setVisible(false);
			}
		});
		
		nve.btnAnnuler.addActionListener(this);
		nve.btnChEst.addActionListener(this);
	}
	
	public void initVari(int idCom, int idt, int ids, String st, String dat, int idEm){
		idOr = idCom;
		idTab = idt;
		idUs = ids;
		stat = st;
		date = dat;
		idEmpl = idEm;
		
		nve.lblEtatAct.setText(stat);
	}
	
	public void startNouvelle(){
		nve.setVisible(true);
		nve.setLocationRelativeTo(null);
	}
	
	/****************/
	public void recibeNou(Assiette a, Employe e){
		assi = a;
		System.out.println("###### NOUV :: "+assi);
		emplo = e;
		System.out.println("$$$$$$ NOUV :: "+emplo);
	}
	public Employe getEmploNou(){
		System.out.println("NOUV :: "+assi);
		return emplo;
	}
	public Assiette getAssieNou(){
		System.out.println("NOUV :: "+assi);
		return assi;
	}
	/******************/
	
	@Override
	public void actionPerformed(ActionEvent acEv) {
		if(acEv.getSource().equals(nve.btnAnnuler)){
			ChangerStatusCom chs = new ChangerStatusCom();
			ControleurChangStatus conCh = new ControleurChangStatus(chs, com);
			com.initialize(getAssieNou(), getEmploNou());
			conCh.recibeChange(getAssieNou(), getEmploNou());
			conCh.ajouTc();
			conCh.startChangStatus();
			nve.setVisible(false);
		}else if(acEv.getSource().equals(nve.btnChEst)){
			JOptionPane.showMessageDialog(null, "Datos :: "+idOr+" : "+idTab+" : "+idUs+" : "+idEmpl+" : "+stat+" : "+date);
			nve.lblEtatAct.setForeground(Color.GREEN);
			nve.lblEtatAct.setText("Pr\u00E9par\u00E9");
			com.changeEt(idOr, new Commande(idOr, idTab, idUs, idEmpl, "Prepare", date, 0.0f));
			try {
				com.saveState();
			} catch (Exception e) {
				e.printStackTrace();
			}
			nve.btnChEst.setEnabled(false);
		}
	}

}
