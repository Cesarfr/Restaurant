package controleur.Commande;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controleur.Controlateur;
import modele.Assiette;
import modele.Commande;
import modele.Employe;
import vue.Debut;
import vue.commande.PaiementGroup;
import vue.commande.PaiementIndiv;
import vue.commande.PayerCommande;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Controleur pour gestioner les paiements
 */
public class ControleurPayerComm implements ActionListener {
	private PayerCommande payCom;
	private Commande com;
	private Assiette assi;
	private Employe emplo;
	private int table;
	
	public ControleurPayerComm(PayerCommande pc, Commande c) {
		payCom = pc;
		com = c;

		payCom.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				payCom.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Debut deb = new Debut();
				Controlateur cont = new Controlateur(deb, emplo, assi, com);
				cont.initControl(getAssiePay(), getEmploPay());
				com.initialize(getAssiePay(), getEmploPay());
				cont.debutframe();
			}
		});
		payCom.txtNoTab.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if ((car < '0' || car > '9') || payCom.txtNoTab.getText().length() == 2)
					e.consume();
			}
		});
		payCom.btnchercher.addActionListener(this);
		payCom.btnAnnuler.addActionListener(this);
		payCom.btnGenerer.addActionListener(this);
		payCom.rdbtnParTab.addActionListener(this);
		payCom.rdbtnSeul.addActionListener(this);
	}
	
	/****************/
	public void recibePay(Assiette a, Employe e){
		assi = a;
		System.out.println("###### PAY :: "+assi);
		emplo = e;
		System.out.println("$$$$$$ PAY :: "+emplo);
	}
	public Employe getEmploPay(){
		System.out.println("PAY :: "+assi);
		return emplo;
	}
	public Assiette getAssiePay(){
		System.out.println("PAY :: "+assi);
		return assi;
	}
	/******************/
	
	public void startPayerComm(){
		payCom.setVisible(true);
		payCom.setLocationRelativeTo(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource().equals(payCom.btnAnnuler)){
			Debut deb = new Debut();
			Controlateur cont = new Controlateur(deb, emplo, assi, com);
			cont.initControl(getAssiePay(), getEmploPay());
			com.initialize(getAssiePay(), getEmploPay());
			cont.debutframe();
			payCom.setVisible(false);
		}else if(evt.getSource().equals(payCom.btnGenerer)){
			if(payCom.txtNoTab.getText().equals("") || payCom.txtNoTab.getText().equals(null)){
				JOptionPane.showMessageDialog(null, "escribe el numero de mesa");
				payCom.txtNoTab.requestFocus();
				payCom.btnGenerer.setEnabled(false);
			}else{
				table = Integer.parseInt(payCom.txtNoTab.getText());
				if(com.paTab(table)==10){
					payCom.btnGenerer.setEnabled(true);
					payCom.rdbtnParTab.setEnabled(true);
					payCom.rdbtnSeul.setEnabled(true);
					
					if(payCom.rdbtnParTab.isSelected()){
						PaiementGroup pg = new PaiementGroup();
						ControleurPaiementTab pai = new ControleurPaiementTab(pg, com);
						pai.recibeTab(getAssiePay(), getEmploPay());
						pai.initData(table);
						pai.startPaiementTab();
						payCom.setVisible(false);
					}else if(payCom.rdbtnSeul.isSelected()){
						PaiementIndiv pIn = new PaiementIndiv();
						ControleurPaiementInd cpi = new ControleurPaiementInd(pIn, com);
						cpi.recibePer(getAssiePay(), getEmploPay());
						cpi.initData(table);
						cpi.startPaiementInd();
						payCom.setVisible(false);
					}else{
						JOptionPane.showMessageDialog(null, "Selecciona metodo");
					}
				}else if (com.paTab(table)==11){
					JOptionPane.showMessageDialog(null, "Il n'y a pas une commande par cette table");
					payCom.btnGenerer.setEnabled(false);
					payCom.rdbtnParTab.setEnabled(false);
					payCom.rdbtnSeul.setEnabled(false);
				}
			}
		}else if(evt.getSource().equals(payCom.btnchercher)){
			if(payCom.txtNoTab.getText().equals("") || payCom.txtNoTab.getText().equals(null)){
				JOptionPane.showMessageDialog(null, "escribe el numero de mesa");
				payCom.txtNoTab.requestFocus();
				payCom.btnGenerer.setEnabled(false);
			}else{
				table = Integer.parseInt(payCom.txtNoTab.getText());
				if(com.paTab(table)==10){
//					JOptionPane.showMessageDialog(null, "Il y a une commande");
					payCom.btnGenerer.setEnabled(true);
					payCom.rdbtnParTab.setEnabled(true);
					payCom.rdbtnSeul.setEnabled(true);
				}else if (com.paTab(table)==11){
					JOptionPane.showMessageDialog(null, "Il n'y a pas une commande par cette table");
					payCom.btnGenerer.setEnabled(false);
					payCom.rdbtnParTab.setEnabled(false);
					payCom.rdbtnSeul.setEnabled(false);
				}
			}
		}else if(evt.getSource().equals(payCom.rdbtnParTab)){
			payCom.rdbtnSeul.setSelected(false);
		}else if(evt.getSource().equals(payCom.rdbtnSeul)){
			payCom.rdbtnParTab.setSelected(false);
		}
	}

}
