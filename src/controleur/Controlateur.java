package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jvnet.substance.SubstanceLookAndFeel;

import controleur.Commande.ControleurChangStatus;
import controleur.Commande.ControleurNewCom;
import controleur.Commande.ControleurPayerComm;
import controleur.Employe.ControleurMenuManag;
import modele.Assiette;
import modele.Commande;
import modele.Employe;
import vue.Debut;
import vue.commande.ChangerStatusCom;
import vue.commande.NewCommande;
import vue.commande.PayerCommande;
import vue.employe.MenuManager;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Controleur par le fenetre principale
 */
public class Controlateur implements ActionListener {
	private Debut debut;
	private Employe log, emplo;
	private Assiette assi;
	private Commande comma;
	private int cont = 0;
	private String user, pass, trav;

	public Controlateur(Debut vue, Employe chargeDat, Assiette as, Commande com) {
		debut = vue;
		log = chargeDat;
		emplo = log;
		assi = as;
		comma = com;
		debut.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				debut.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				System.exit(0);
			}
		});
		debut.btnConnecter.addActionListener(this);
		debut.cmbEmployes.addActionListener(this);
	}
	public void debutframe() {
		try {
			log.carga();
			assi.cargaAssi();
			comma.chargeState();
			comma.chargeStateDet();
		} catch (Exception e) {
			e.printStackTrace();
		}
		debut.setVisible(true);
		debut.setLocationRelativeTo(null);
		JFrame.setDefaultLookAndFeelDecorated(true);
		SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.AutumnSkin");
		SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceBrownTheme");
		SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceWoodWatermark");
	}

	@Override
	public void actionPerformed(ActionEvent aE) {
		if (aE.getSource().equals(debut.btnConnecter)) {
			user = debut.txtUser.getText();
			pass = debut.passPswd.getText();
//			cont = log.valideEmpl(user, pass);
			trav = debut.cmbEmployes.getSelectedItem().toString();
//			if (cont == 100) {
//				JOptionPane.showMessageDialog(null, "Manque l'user");
//			} else if (cont == 101) {
//				JOptionPane.showMessageDialog(null, "Manque le password");
//			} else if (cont == 1) {
//				JOptionPane.showMessageDialog(null, "Ya rifa");
				int i=log.loginEmp(user, pass, trav);
				switch (i) {
				case 90:		
//					JOptionPane.showMessageDialog(null, "Serveur");
					NewCommande nc = new NewCommande();
					ControleurNewCom cnc = new ControleurNewCom(nc, comma);
					comma.initialize(assi, emplo);
					cnc.recibe(assi, emplo);
					cnc.initIDEmp(comma.schID(trav, user));
					cnc.initID(comma.searchID());
					cnc.startNewCom();
					debut.setVisible(false);
					break;
				case 91:		
//					JOptionPane.showMessageDialog(null, "Caissier");
					PayerCommande pay = new PayerCommande();
					ControleurPayerComm cp = new ControleurPayerComm(pay, comma);
					cp.recibePay(getAssieIn(), getEmploIn());
					comma.initialize(getAssieIn(), getEmploIn());
					cp.startPayerComm();
					debut.setVisible(false);
					break;
				case 92:		
//					JOptionPane.showMessageDialog(null, "Cuisinier");
					ChangerStatusCom chs = new ChangerStatusCom();
					ControleurChangStatus conCh = new ControleurChangStatus(chs, comma);
					comma.initialize(assi, emplo);
					conCh.recibeChange(getAssieIn(), getEmploIn());
					conCh.ajouTc();
					conCh.startChangStatus();
					debut.setVisible(false);
					break;
				case 93:		
//					JOptionPane.showMessageDialog(null, "Manager");
					MenuManager man = new MenuManager();
					System.err.println("PRUEBA EMPLO INIT :: "+emplo);
					ControleurMenuManag cMm = new ControleurMenuManag(man, assi, emplo);
					cMm.startMenuManager();
					debut.setVisible(false);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Resvisa select");
					break;
				}
//			}
		} else if (aE.getSource().equals(debut.cmbEmployes)) {
			typeEmploye();
		}
	}

	/**************/
	public void initControl(Assiette a, Employe e){
		assi = a;
		System.out.println("###### INIT "+assi);
		emplo = e;
		System.out.println("$$$$$$ INIT "+emplo);
	}
	public Employe getEmploIn(){
		System.out.println("Regresamos :: "+emplo);
		return emplo;
	}
	public Assiette getAssieIn(){
		System.out.println("Regresamos :: "+assi);
		return assi;
	}
	/*****************/
	
	public void typeEmploye() {
		if (debut.cmbEmployes.getSelectedItem().equals("Serveur")) {
			debut.passPswd.setEnabled(false);
			debut.passPswd.setText("");
		} else if (debut.cmbEmployes.getSelectedItem().equals("Caissier")) {
			debut.passPswd.setEnabled(true);
		} else if (debut.cmbEmployes.getSelectedItem().equals("Cuisinier")) {
			debut.passPswd.setEnabled(false);
			debut.passPswd.setText("");
		} else if (debut.cmbEmployes.getSelectedItem().equals("Manager")) {
			debut.passPswd.setEnabled(true);
		}
	}

}
