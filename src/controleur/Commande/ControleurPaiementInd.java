package controleur.Commande;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modele.Assiette;
import modele.Commande;
import modele.Employe;
import vue.commande.PaiementIndiv;
import vue.commande.PayerCommande;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Controleur pour paiement individuel
 */
public class ControleurPaiementInd implements ActionListener {
	private PaiementIndiv paiInd;
	private Commande com, tmp;
	private Assiette assi;
	private Employe emplo;
	private int table, noOrd, noCom, noEmpl, comAct=1;
	private String date;
	float suma, total, monn, cam, totgen;
	
	DecimalFormat dec = new DecimalFormat("#.##");
	ArrayList<Object[]> tabl = new ArrayList<Object[]>();
	
	public ControleurPaiementInd(PaiementIndiv pi, Commande co) {
		paiInd = pi;
		com = co;
		
		paiInd.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				paiInd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				PayerCommande pay = new PayerCommande();
				ControleurPayerComm cp = new ControleurPayerComm(pay, com);
				cp.recibePay(getAssiePer(), getEmploPer());
				com.initialize(getAssiePer(), getEmploPer());
				cp.startPayerComm();
			}
		});
		paiInd.txtMonn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if ((car < '0' || car > '9'))
					e.consume();
			}
		});
		paiInd.btnAnnuler.addActionListener(this);
		paiInd.btnMonnaie.addActionListener(this);
		paiInd.btnSuivante.addActionListener(this);
	}
	
	/****************/
	public void recibePer(Assiette a, Employe e){
		assi = a;
//		System.out.println("###### PAYPP :: "+assi);
		emplo = e;
//		System.out.println("$$$$$$ PAYPP :: "+emplo);
	}
	public Employe getEmploPer(){
//		System.out.println("PAYPP :: "+assi);
		return emplo;
	}
	public Assiette getAssiePer(){
//		System.out.println("PAYPP :: "+assi);
		return assi;
	}
	/******************/
	
	public void initData(int table){
		this.table=table;
		tabl.clear();
		tmp = com.payTable(this.table);
//		System.out.println("Recibimos la orden :: "+tmp);
		
		noOrd = tmp.getNo_orden();
		noCom = tmp.getNo_comensal();
		noEmpl = tmp.getNo_empleado();
		date = tmp.getFecha();
		
		paiInd.lblEmplo.setText(Integer.toString(noEmpl));
		paiInd.txtNoComm.setText(Integer.toString(noOrd));
		paiInd.txtNoPers.setText(Integer.toString(comAct));
		
		tabl = com.llenapayInd(tmp.getNo_orden(), this.table, 1);
		
		for (int i = 0; i < tabl.size(); i++) {
			paiInd.dtm.addRow(tabl.get(i));
		}
		
		int filas=paiInd.tabAssi.getRowCount();
		for (int i=0; filas>i; i++) {
			suma+=Float.parseFloat(paiInd.tabAssi.getValueAt(i, 2).toString());
		}
		paiInd.txtTotal.setText(dec.format(suma));
		
	}
	
	public void startPaiementInd(){
		paiInd.setVisible(true);
		paiInd.setLocationRelativeTo(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent actE) {
		if(actE.getSource().equals(paiInd.btnAnnuler)){
			PayerCommande pay = new PayerCommande();
			ControleurPayerComm cp = new ControleurPayerComm(pay, com);
			cp.recibePay(getAssiePer(), getEmploPer());
			com.initialize(getAssiePer(), getEmploPer());
			cp.startPayerComm();
			paiInd.setVisible(false);
		}else if(actE.getSource().equals(paiInd.btnMonnaie)){
			if(paiInd.txtMonto.getText().equals("") || paiInd.txtMonto.getText().equals(null)){
				JOptionPane.showMessageDialog(null, "Champ monnaie vide!");
				paiInd.txtMonto.requestFocus();
			}else {
				total = Float.parseFloat(paiInd.txtTotal.getText());
				monn = Float.parseFloat(paiInd.txtMonto.getText());
				
				if(monn>=total){
					paiInd.btnSuivante.setEnabled(true);
					cam = monn-total;
					paiInd.txtMonn.setText(dec.format(cam));
				}else{
					JOptionPane.showMessageDialog(null, "Pas assez de fonds,\nManque : "+dec.format(total-monn)+" \u20AC");
					paiInd.btnSuivante.setEnabled(false);
				}
			}
		}else if(actE.getSource().equals(paiInd.btnSuivante)){
			if(paiInd.txtMonto.getText().equals("") || paiInd.txtMonto.getText().equals(null)){
				JOptionPane.showMessageDialog(null, "Champ monnaie vide!");
				paiInd.txtMonto.requestFocus();
			}else {
				total = Float.parseFloat(paiInd.txtTotal.getText());
				monn = Float.parseFloat(paiInd.txtMonto.getText());
				
				if(monn>=total){
					totgen+=total;
					
					paiInd.btnSuivante.setEnabled(true);
					cam = monn-total;
					paiInd.txtMonn.setText(dec.format(cam));
					
					int nom = Integer.parseInt(paiInd.txtNoPers.getText());
					JOptionPane.showMessageDialog(null, "Per act "+nom);
					if(noCom>nom){
						suma = 0;
						tabl.clear();
						comAct = Integer.parseInt(paiInd.txtNoPers.getText());
						paiInd.txtNoPers.setText(Integer.toString(comAct+1));
						cleanTable();
						comAct = Integer.parseInt(paiInd.txtNoPers.getText());
						tabl = com.llenapayInd(tmp.getNo_orden(), this.table, comAct );
						
						for (int i = 0; i < tabl.size(); i++) {
							paiInd.dtm.addRow(tabl.get(i));
						}
						int filas=paiInd.tabAssi.getRowCount();
						for (int i=0; filas>i; i++) {
							suma+=Float.parseFloat(paiInd.tabAssi.getValueAt(i, 2).toString());
						}
						paiInd.txtTotal.setText(dec.format(suma));
						
					}else{
						JOptionPane.showMessageDialog(null, "Commande pay\u00E9e correctement! ");
						com.ajouterCommande(new Commande(noOrd, table, noCom, noEmpl, "Prepare", date, totgen));
						try {
							com.saveState();
						} catch (Exception e) {
							System.err.println("Error en saveState() debido a: "+e.getMessage());
						}
						paiInd.btnSuivante.setEnabled(false);
					}
				}else{
					JOptionPane.showMessageDialog(null, "Pas assez de fonds,\nManque : "+dec.format(total-monn)+" \u20AC");
					paiInd.btnSuivante.setEnabled(false);
				}
			}
		}
	}
	
	public void cleanTable(){
		tabl.clear();
		paiInd.txtMonto.setText("");
		paiInd.txtTotal.setText("");
		paiInd.txtMonn.setText("");
		int filas=paiInd.tabAssi.getRowCount();
		for (int i=0; filas>i; i++) {
			paiInd.dtm.removeRow(0);
		}
	}
}
