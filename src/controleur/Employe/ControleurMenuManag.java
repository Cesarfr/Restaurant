package controleur.Employe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;

import controleur.Assiette.ControleurMenuAssie;
import controleur.Controlateur;
import modele.Assiette;
import modele.Commande;
import modele.Employe;
import vue.Debut;
import vue.assiette.MenuAssiette;
import vue.employe.MenuEmployes;
import vue.employe.MenuManager;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Controleur par le Menu Manager
 */
public class ControleurMenuManag implements ActionListener {
	private MenuManager menMa;
	private Employe employe;
	private Assiette assi;
	private Commande com;
	public ControleurMenuManag(MenuManager menM, Assiette as, Employe emp) {
		menMa=menM;
		assi = as;
		employe = emp;
		menMa.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				menMa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Debut db=new Debut();
				Controlateur c = new Controlateur(db, employe, assi, com);
				c.debutframe();
			}
		});
		menMa.btnMenManEmp.addActionListener(this);
		menMa.btnMenManAss.addActionListener(this);
	}
	/******************/
	public Assiette copiaAs(){
		return assi;
	}
	public void getAssiet(Assiette a){
		System.out.println("Nos llega un :: "+a);
		assi=a;
		System.out.println("Ahora assi vale :: "+assi);
	}
	public Employe copiaEm() {
		return employe;
	}
	public void getEmplo(Employe e){
		System.out.println("MG Nos llega ,, "+e);
		employe = e;
		System.out.println("MG Ahora employe vale ,, "+employe);
	}
	/********************/
	public ControleurMenuManag(MenuManager menM, Assiette as) {
		menMa=menM;
		assi = as;
		
		menMa.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				menMa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Debut db=new Debut();
				Controlateur c = new Controlateur(db, employe, assi, com);
				c.debutframe();
			}
		});
		menMa.btnMenManEmp.addActionListener(this);
		menMa.btnMenManAss.addActionListener(this);
	}
	
	public ControleurMenuManag(MenuManager menM, Employe epml) {
		menMa=menM;
		employe = epml;
		
		menMa.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				menMa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Debut db=new Debut();
				Controlateur c = new Controlateur(db, employe, assi, com);
				c.debutframe();
			}
		});
		menMa.btnMenManEmp.addActionListener(this);
		menMa.btnMenManAss.addActionListener(this);
	}
	public void startMenuManager(){
		menMa.setVisible(true);
		menMa.setLocationRelativeTo(null);
	}
	@Override
	public void actionPerformed(ActionEvent aEv) {
		if(aEv.getSource().equals(menMa.btnMenManEmp)){
			MenuEmployes mep = new MenuEmployes();
			System.err.println("TTTT // "+employe);
			ControleurMenuEmplo cpm = new ControleurMenuEmplo(mep, employe);
			cpm.xd(copiaAs());
			cpm.startMenuEmplo();
			menMa.setVisible(false);
		}else if(aEv.getSource().equals(menMa.btnMenManAss)){
			MenuAssiette ma = new MenuAssiette();
			System.err.println(assi);
			ControleurMenuAssie cma = new ControleurMenuAssie(ma, assi);
			cma.setEmplo(copiaEm());
			cma.startMenuAssie();
			menMa.setVisible(false);
		}
	}

}
