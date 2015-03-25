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
import vue.commande.PaiementGroup;
import vue.commande.PayerCommande;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Classe qui gestionne le paiement en general
 */
public class ControleurPaiementTab implements ActionListener {
	private PaiementGroup paiGro;
	private Commande com, tmp;
	private Assiette assi;
	private Employe emplo;
	private int table, noOrd, noCom, noEmpl ;
	private String date;
	float suma, total, monn, cam;
	
	DecimalFormat dec = new DecimalFormat("#.##");
	ArrayList<Object[]> tabl = new ArrayList<Object[]>();
	public ControleurPaiementTab(PaiementGroup pG, Commande co) {
		paiGro = pG;
		com = co;
		
		paiGro.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				paiGro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				PayerCommande pay = new PayerCommande();
				ControleurPayerComm cp = new ControleurPayerComm(pay, com);
				cp.recibePay(getAssieTab(), getEmploTab());
				com.initialize(getAssieTab(), getEmploTab());
				cp.startPayerComm();
			}
		});
		paiGro.txtMontoG.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != '.')) {
					e.consume();
				}
				if (c == '.' && paiGro.txtMontoG.getText().contains(".")) {
					e.consume();
				}
			}
		});
		
		paiGro.btnAnnulerG.addActionListener(this);
		paiGro.btnMonnaieG.addActionListener(this);
		paiGro.btnPayerG.addActionListener(this);
	}
	
	/****************/
	public void recibeTab(Assiette a, Employe e){
		assi = a;
		System.out.println("###### PAYTAB :: "+assi);
		emplo = e;
		System.out.println("$$$$$$ PAYTAB :: "+emplo);
	}
	public Employe getEmploTab(){
		System.out.println("PAYTAB :: "+assi);
		return emplo;
	}
	public Assiette getAssieTab(){
		System.out.println("PAYTAB :: "+assi);
		return assi;
	}
	/******************/
	
	public void initData(int table){
		this.table=table;
		tabl.clear();
		tmp = com.payTable(this.table);
		System.out.println("Recibimos la orden :: "+tmp);
		
		noOrd = tmp.getNo_orden();
		noCom = tmp.getNo_comensal();
		noEmpl = tmp.getNo_empleado();
		date = tmp.getFecha();
		
		paiGro.lblLblemplo.setText(Integer.toString(noEmpl));
		paiGro.txtNoCommG.setText(Integer.toString(noOrd));
		paiGro.txtNoPersG.setText(Integer.toString(noCom));
		
		tabl = com.llenapayTable(tmp.getNo_orden(), this.table);
		
		for (int i = 0; i < tabl.size(); i++) {
			paiGro.dtm.addRow(tabl.get(i));
		}
		
		int filas=paiGro.tabAssiG.getRowCount();
		System.out.println(filas);
		for (int i=0; filas>i; i++) {
			suma+=Float.parseFloat(paiGro.tabAssiG.getValueAt(i, 3).toString());
		}
		paiGro.txtTotalG.setText(dec.format(suma));
	}
	
	public void startPaiementTab(){
		paiGro.setVisible(true);
		paiGro.setLocationRelativeTo(null);
	}
		
	@Override
	public void actionPerformed(ActionEvent actE) {
		if(actE.getSource().equals(paiGro.btnAnnulerG)){
			PayerCommande pay = new PayerCommande();
			ControleurPayerComm cp = new ControleurPayerComm(pay, com);
			cp.recibePay(getAssieTab(), getEmploTab());
			com.initialize(getAssieTab(), getEmploTab());
			cp.startPayerComm();
			paiGro.setVisible(false);
		}else if(actE.getSource().equals(paiGro.btnMonnaieG)){
			if(paiGro.txtMontoG.getText().equals("") || paiGro.txtMontoG.getText().equals(null)){
				JOptionPane.showMessageDialog(null, "Champ monnaie vide!");
				paiGro.txtMontoG.requestFocus();
			}else {
				total = Float.parseFloat(paiGro.txtTotalG.getText());
				monn = Float.parseFloat(paiGro.txtMontoG.getText());
				
				if(monn>=total){
					paiGro.btnPayerG.setEnabled(true);
					cam = monn-total;
					paiGro.txtMonnG.setText(dec.format(cam));
				}else{
					JOptionPane.showMessageDialog(null, "Pas assez de fonds,\nManque : "+dec.format(total-monn)+" \u20AC");
					paiGro.btnPayerG.setEnabled(false);
				}
			}
		}else if(actE.getSource().equals(paiGro.btnPayerG)){
			if(paiGro.txtMontoG.getText().equals("") || paiGro.txtMontoG.getText().equals(null)){
				JOptionPane.showMessageDialog(null, "Champ monnaie vide!");
				paiGro.txtMontoG.requestFocus();
			}else {
				total = Float.parseFloat(paiGro.txtTotalG.getText());
				monn = Float.parseFloat(paiGro.txtMontoG.getText());
				if(monn>=total){
					paiGro.btnPayerG.setEnabled(true);
					cam = monn-total;
					paiGro.txtMonnG.setText(dec.format(cam));
					com.ajouterCommande(new Commande(noOrd, table, noCom, noEmpl, "Prepare", date, total));
					try {
						com.saveState();
					} catch (Exception e) {
						System.err.println("Error en saveState() debido a: "+e.getMessage());
					}
					
					JOptionPane.showMessageDialog(null, "Commande pay\u00E9e correctement!");
					paiGro.btnPayerG.setEnabled(false);
				}else{
					JOptionPane.showMessageDialog(null, "Pas assez de fonds,\nManque : "+dec.format(total-monn)+" \u20AC");
					paiGro.btnPayerG.setEnabled(false);
				}
			}
		}
	}
}
