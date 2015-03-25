package controleur.Assiette;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import assiettesSpec.Dessert;
import assiettesSpec.Entree;
import assiettesSpec.Salade;
import modele.Assiette;
import modele.Employe;
import vue.assiette.MenuAssiette;
import vue.assiette.ModAssiette;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Controleur pour modifier une assiette
 */
public class ControleurModAssie implements ActionListener {
	private ModAssiette modAssi;
	private Assiette assi, assTmp, assitmp;
	private String ingredients, description, nom, type, typeDess;
	private float prix;
	private int id_Assi;
	private Dessert dess;
	ArrayList<String> nomAssie = new ArrayList<String>();
	Employe employe;
	
	public ControleurModAssie(ModAssiette ma, Assiette as) {
		modAssi = ma;
		assi = as;
		
		modAssi.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				modAssi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				MenuAssiette ma = new MenuAssiette();
				ControleurMenuAssie cma = new ControleurMenuAssie(ma, assi);
				cma.setEmplo(cpEmMod());
				cma.startMenuAssie();
				modAssi.setVisible(false);
			}
		});
		modAssi.txtMAssPrix.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != '.')) {
					e.consume();
				}
				if (c == '.' && modAssi.txtMAssPrix.getText().contains(".")) {
					e.consume();
				}
			}
		});
		modAssi.btnMAssModif.addActionListener(this);
		modAssi.btnMAssSearch.addActionListener(this);
		modAssi.cmbMAssType.addActionListener(this);
		modAssi.btnMAssSortir.addActionListener(this);
		modAssi.cmbTypeDess.addActionListener(this);
	}
	
	/***********/
	public void setEmploMod(Employe lol){
		System.out.println("MOD NOS LLEGA :: "+lol);
		employe=lol;
		System.out.println("MOD EMPLO VALE :: "+employe);
	}
	public Employe cpEmMod(){
		System.out.println("Regresamos de CME:: "+employe);
		return employe;
	}
	/***********/
	
	public void startModAssie(){
		try {
			assi.cargaAssi();
		} catch (Exception e) {
			e.printStackTrace();
		}
		modAssi.setVisible(true);
		modAssi.setLocationRelativeTo(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent acEv) {
		if(acEv.getSource().equals(modAssi.btnMAssModif)){
			verifType();
		}else if(acEv.getSource().equals(modAssi.btnMAssSearch)){
			String req = modAssi.cmbMAssNom.getSelectedItem().toString();
			assTmp = assi.raquestForm(req);
			
			/******/
			modAssi.txtDNI.setText(Integer.toString(assTmp.getId_assiette()));
			modAssi.txtMAssNom.setText(assTmp.getNom());
			modAssi.txtMAssDesc.setText(assTmp.getDescription());
			modAssi.txtMAssPrix.setText(Float.toString(assTmp.getPrix()));
			modAssi.txtDAssIngre.setText(assTmp.getIngredients());
			/******/
			
			if(modAssi.cmbMAssType.getSelectedItem().equals("Dessert")){
				modAssi.lblType.setVisible(true);
				modAssi.cmbTypeDess.setVisible(true);
				modAssi.btnMAssModif.setEnabled(true);
//				if(assTmp.getType().equals("Soy Dulce xD")){
					modAssi.cmbTypeDess.setSelectedItem(assTmp.getType());
//				}else{
//					modAssi.cmbTypeDess.setSelectedItem("Sal\u00E9");
//				}
			}else{
				modAssi.lblType.setVisible(false);
				modAssi.cmbTypeDess.setVisible(false);
			}
		}else if(acEv.getSource().equals(modAssi.btnMAssSortir)){
			MenuAssiette ma = new MenuAssiette();
			ControleurMenuAssie cma = new ControleurMenuAssie(ma, assi);
			cma.setEmplo(cpEmMod());
			cma.startMenuAssie();
			modAssi.setVisible(false);
		}else if(acEv.getSource().equals(modAssi.cmbMAssType)){
			type=modAssi.cmbMAssType.getSelectedItem().toString();
			if(type.equals("S\u00E9lectionnez un type")){
				JOptionPane.showMessageDialog(null, "Elige otra cosa");
				effacerDonnees();
			}else{
				modAssi.cmbMAssNom.setEnabled(true);
				modAssi.cmbMAssNom.removeAllItems();
				nomAssie.clear();
				modAssi.btnMAssSearch.setEnabled(true);
				nomAssie = assi.llenaCombo(type);
				for (int i = 0; i < nomAssie.size(); i++) {
					System.out.println("Imprimo l l "+nomAssie.get(i));
					modAssi.cmbMAssNom.addItem(nomAssie.get(i));
				}
			}
		}
	}
	
	public void verifType(){
		type=modAssi.cmbMAssType.getSelectedItem().toString();
		typeDess=modAssi.cmbTypeDess.getSelectedItem().toString();
		
		if(type.equals("S\u00E9lectionnez un type")){
			JOptionPane.showMessageDialog(null, "Elige otra cosa");
			modAssi.cmbMAssType.requestFocus();
		}else if(modAssi.txtMAssNom.getText().equals("") || modAssi.txtMAssNom.getText().equals(null)){
			JOptionPane.showMessageDialog(null, "Nombre vacio");
			modAssi.txtMAssNom.requestFocus();
		}else if(modAssi.txtMAssDesc.getText().equals("") || modAssi.txtMAssDesc.getText().equals(null)){
			JOptionPane.showMessageDialog(null, "Descripcion vacio");
			modAssi.txtMAssDesc.requestFocus();
		}else if(modAssi.txtMAssPrix.getText().equals("") || modAssi.txtMAssPrix.getText().equals(null)){
			JOptionPane.showMessageDialog(null, "prix vacio");
			modAssi.txtMAssPrix.requestFocus();
		}else if(modAssi.txtDAssIngre.getText().equals("") || modAssi.txtDAssIngre.getText().equals(null)){
			JOptionPane.showMessageDialog(null, "Ingredientes vacio");
			modAssi.txtDAssIngre.requestFocus();
		}else if(typeDess.equals("S\u00E9lectionnez un type") && type.equals("Dessert")){
			JOptionPane.showMessageDialog(null, "Elige un tipo de Dessert");
			modAssi.cmbTypeDess.requestFocus();
		}else{
			nom=modAssi.txtMAssNom.getText();
			description=modAssi.txtMAssDesc.getText();
			ingredients=modAssi.txtDAssIngre.getText();
			prix=Float.parseFloat(modAssi.txtMAssPrix.getText());
			id_Assi = Integer.parseInt(modAssi.txtDNI.getText());
			if(type.equals("Salade")){
				assitmp = new Salade(id_Assi, nom, ingredients, description, prix);
			}else if(type.equals("Entr\u00E9e")){
				assitmp = new Entree(id_Assi, nom, ingredients, description, prix);
			}else if(type.equals("Dessert")){
				if(typeDess.equals("Sal\u00E9")){
					assitmp = new Dessert(id_Assi, nom, ingredients, description, prix, typeDess);
				}else{
					assitmp = new Dessert(id_Assi, nom, ingredients, description, prix, typeDess);
				}
			}
			assi.modifier(assitmp);
			try {
				assi.guardarEstadoAssi();
			} catch (Exception e) {
				e.printStackTrace();
			}
			effacerDonnees();
		}
	}
	
	public void effacerDonnees(){
		modAssi.btnMAssModif.setEnabled(false);
		modAssi.cmbMAssNom.removeAllItems();
		modAssi.cmbMAssNom.setEnabled(false);
		modAssi.btnMAssSearch.setEnabled(false);
		modAssi.txtDNI.setText("");
		modAssi.txtMAssNom.setText("");
		modAssi.txtMAssDesc.setText("");
		modAssi.txtMAssPrix.setText("");
		modAssi.txtDAssIngre.setText("");
	}

}
