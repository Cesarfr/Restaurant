package controleur.Assiette;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import assiettesSpec.Dessert;
import assiettesSpec.Entree;
import assiettesSpec.Salade;
import modele.Assiette;
import modele.Employe;
import vue.assiette.AjoAssiette;
import vue.assiette.MenuAssiette;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Controleur pour ajouter une assiette
 */
public class ControleurAjoAssiette implements ActionListener{
	private AjoAssiette ajoA;
	private Assiette assi, assitmp;
	private Dessert dess;
	private int id_Assi;
	private String ingredients, description, nom, type, typeDess;
	private float prix;
	Employe employe;
	public ControleurAjoAssiette(AjoAssiette aj, Assiette as) {
		ajoA=aj;
		assi=as;
		ajoA.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				ajoA.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				MenuAssiette ma = new MenuAssiette();
				ControleurMenuAssie cma = new ControleurMenuAssie(ma,assi);
				cma.setEmplo(cpEmAj());
				cma.startMenuAssie();
				ajoA.setVisible(false);
			}
		});
		ajoA.txtPrix.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != '.')) {
					e.consume();
				}
				if (c == '.' && ajoA.txtPrix.getText().contains(".")) {
					e.consume();
				}
			}
		});
		ajoA.btnEnregistrer.addActionListener(this);
		ajoA.btnSortir.addActionListener(this);
		ajoA.cmbType.addActionListener(this);
	}
	
	/***********/
	public void setEmploAjo(Employe lol){
		System.out.println("AJ NOS LLEGA :: "+lol);
		employe=lol;
		System.out.println("AJ EMPLO VALE :: "+employe);
	}
	public Employe cpEmAj(){
		System.out.println("Regresamos de CME:: "+employe);
		return employe;
	}
	/***********/
	
	public void startAjoAssiette(){
		try {
			assi.cargaAssi();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ajoA.setVisible(true);
		ajoA.setLocationRelativeTo(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(ajoA.btnEnregistrer)){
			verifType();
		}else if(arg0.getSource().equals(ajoA.cmbType)){
			if(ajoA.cmbType.getSelectedItem().toString().equals("Dessert")){
				ajoA.cmbSalSuc.setVisible(true);
			}else{
				ajoA.cmbSalSuc.setVisible(false);
			}			
		}else if(arg0.getSource().equals(ajoA.btnSortir)){
			MenuAssiette ma = new MenuAssiette();
			ControleurMenuAssie cma = new ControleurMenuAssie(ma, assi);
			cma.setEmplo(cpEmAj());
			cma.startMenuAssie();
			ajoA.setVisible(false);
		}
	}
	public void verifType(){
		type=ajoA.cmbType.getSelectedItem().toString();
		typeDess=ajoA.cmbSalSuc.getSelectedItem().toString();
		
		if(type.equals("S\u00E9lectionnez un type")){
			JOptionPane.showMessageDialog(null, "Elige otra cosa");
			ajoA.cmbType.requestFocus();
		}else if(ajoA.txtAjoAssNom.getText().equals("") || ajoA.txtAjoAssNom.getText().equals(null)){
			JOptionPane.showMessageDialog(null, "Nombre vacio");
			ajoA.txtAjoAssNom.requestFocus();
		}else if(ajoA.txtDes.getText().equals("") || ajoA.txtDes.getText().equals(null)){
			JOptionPane.showMessageDialog(null, "Descripcion vacio");
			ajoA.txtDes.requestFocus();
		}else if(ajoA.txtPrix.getText().equals("") || ajoA.txtPrix.getText().equals(null)){
			JOptionPane.showMessageDialog(null, "prix vacio");
			ajoA.txtPrix.requestFocus();
		}else if(ajoA.txtIngred.getText().equals("") || ajoA.txtIngred.getText().equals(null)){
			JOptionPane.showMessageDialog(null, "Ingredientes vacio");
			ajoA.txtIngred.requestFocus();
		}else if(typeDess.equals("S\u00E9lectionnez un type") && type.equals("Dessert")){
			JOptionPane.showMessageDialog(null, "Elige un tipo de Dessert");
			ajoA.cmbSalSuc.requestFocus();
		}else{
			nom=ajoA.txtAjoAssNom.getText();
			description=ajoA.txtDes.getText();
			ingredients=ajoA.txtIngred.getText();
			prix=Float.parseFloat(ajoA.txtPrix.getText());
			id_Assi = Integer.parseInt(ajoA.lblIDAssi.getText());
			if(type.equals("Salade")){
				assitmp = new Salade(id_Assi, nom, ingredients, description, prix);
			}else if(type.equals("Entr\u00E9e")){
				assitmp = new Entree(id_Assi, nom, ingredients, description, prix);
			}else if(type.equals("Dessert")){
//				if(typeDess.equals("Sal\u00E9")){
//					assitmp = new Dessert(id_Assi, nom, ingredients, description, prix, typeDess);
//				}else{
					assitmp = new Dessert(id_Assi, nom, ingredients, description, prix, typeDess);
//				}
			}
			assi.ajouterAssiette(assitmp);
			try {
				assi.guardarEstadoAssi();
			} catch (Exception e) {
				e.printStackTrace();
			}
			effacerDonner();
		}
	}
	
	/**
	 * Test para buscar el ultimo ID del empleado
	 */
	public void getIDAssi(int iden){
		ajoA.lblIDAssi.setText(Integer.toString(iden));
	}
	
	public void effacerDonner(){
		ajoA.txtAjoAssNom.setText("");
		ajoA.txtDes.setText("");
		ajoA.txtIngred.setText("");
		ajoA.txtPrix.setText("");
		ajoA.lblIDAssi.setText(Integer.toString(assi.searchIDAssi()));
		ajoA.cmbType.setSelectedIndex(0);
	}
}
