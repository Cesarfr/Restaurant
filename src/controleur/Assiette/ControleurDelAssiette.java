package controleur.Assiette;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modele.Assiette;
import modele.Employe;
import vue.assiette.DelAssiette;
import vue.assiette.MenuAssiette;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Controleur pour delete une assiette
 */
public class ControleurDelAssiette implements ActionListener{
	private DelAssiette delAssi;
	private Assiette assi;
	private String type, nom;
	ArrayList<String> nomAssie = new ArrayList<String>();
	Employe employe;
	
	public ControleurDelAssiette(DelAssiette dA, Assiette as) {
		delAssi = dA;
		assi = as;
		
		delAssi.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				delAssi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				MenuAssiette ma = new MenuAssiette();
				ControleurMenuAssie cma = new ControleurMenuAssie(ma, assi);
				cma.setEmplo(cpEmDel());
				cma.startMenuAssie();
				delAssi.setVisible(false);
			}
		});
		delAssi.btnDelAssEffacer.addActionListener(this);
		delAssi.btnDelAssSortir.addActionListener(this);
		delAssi.cmbDelAssTipo.addActionListener(this);
	}
	/***********/
	public void setEmploDel(Employe lol){
		System.out.println("AJ NOS LLEGA :: "+lol);
		employe=lol;
		System.out.println("AJ EMPLO VALE :: "+employe);
	}
	public Employe cpEmDel(){
		System.out.println("Regresamos de CME:: "+employe);
		return employe;
	}
	/***********/
	public void startDelAssiette(){
		try {
			assi.cargaAssi();
		} catch (Exception e) {
			e.printStackTrace();
		}
		delAssi.setVisible(true);
		delAssi.setLocationRelativeTo(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent aEv) {
		if(aEv.getSource().equals(delAssi.btnDelAssEffacer)){
			nom=delAssi.cmbDelAssNom.getSelectedItem().toString();
			JOptionPane.showMessageDialog(null, "Envio: "+nom+" "+type);
			
			int resp = JOptionPane.showConfirmDialog(null,"Desea eliminar el registro?", "Advertencia!!!", 0, 0);
			if (resp == 0) {
				assi.searchIDeff(nom);
				try {
					assi.guardarEstadoAssi();
				} catch (Exception e) {
					e.printStackTrace();
				}
				effacerDonnes();
			} else {
				JOptionPane.showMessageDialog(null, "Registro intacto");
			}
		}else if(aEv.getSource().equals(delAssi.cmbDelAssTipo)){
			type=delAssi.cmbDelAssTipo.getSelectedItem().toString();
			if(type.equals("S\u00E9lectionnez un type")){
				JOptionPane.showMessageDialog(null, "Elige otra cosa");
				delAssi.btnDelAssEffacer.setEnabled(false);
				delAssi.cmbDelAssNom.setEnabled(false);
			}else{
				delAssi.cmbDelAssNom.removeAllItems();
				delAssi.cmbDelAssNom.setEnabled(true);
				delAssi.btnDelAssEffacer.setEnabled(true);
				nomAssie.clear();
				nomAssie=assi.llenaCombo(type);
				for (int i = 0; i < nomAssie.size(); i++) {
					System.out.println("Imprimo l l "+nomAssie.get(i));
					delAssi.cmbDelAssNom.addItem(nomAssie.get(i));
				}
			}
		}else if(aEv.getSource().equals(delAssi.btnDelAssSortir)){
			MenuAssiette ma = new MenuAssiette();
			ControleurMenuAssie cma = new ControleurMenuAssie(ma, assi);
			cma.setEmplo(cpEmDel());
			cma.startMenuAssie();
			delAssi.setVisible(false);
		}
	}
	
	public void effacerDonnes(){
		delAssi.cmbDelAssNom.setEnabled(false);
		delAssi.cmbDelAssTipo.setSelectedIndex(0);
		delAssi.btnDelAssEffacer.setEnabled(false);
	}

}
