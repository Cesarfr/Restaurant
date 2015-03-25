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
import vue.assiette.ConAssiette;
import vue.assiette.MenuAssiette;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Controleur pour consulter une assiette
 */
public class ControleurConAssiette implements ActionListener{
	private ConAssiette cAssi;
	private Assiette assi;
	private Object [] tmp;
	private String nom, type;
	ArrayList<String> nomAssie = new ArrayList<String>();
	Employe employe;
	
	public ControleurConAssiette(ConAssiette cAs, Assiette as) {
		cAssi = cAs;
		assi=as;
		
		cAssi.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				cAssi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				MenuAssiette ma = new MenuAssiette();
				ControleurMenuAssie cma = new ControleurMenuAssie(ma, assi);
				cma.setEmplo(cpEmCon());
				cma.startMenuAssie();
				cAssi.setVisible(false);
			}
		});
		cAssi.btnCAssSearch.addActionListener(this);
		cAssi.btnCAssSortir.addActionListener(this);
		cAssi.cmbCAssTipo.addActionListener(this);
	}
	
	/***********/
	public void setEmploCon(Employe lol){
		System.out.println("CON NOS LLEGA :: "+lol);
		employe=lol;
		System.out.println("CON EMPLO VALE :: "+employe);
	}
	public Employe cpEmCon(){
		System.out.println("Regresamos de CME:: "+employe);
		return employe;
	}
	/***********/
	
	public void startConAssiette(){
		try {
			assi.cargaAssi();
		} catch (Exception e) {
			e.printStackTrace();
		}
		cAssi.setVisible(true);
		cAssi.setLocationRelativeTo(null);
	}
	@Override
	public void actionPerformed(ActionEvent acE) {
		if(acE.getSource().equals(cAssi.cmbCAssTipo)){
			type=cAssi.cmbCAssTipo.getSelectedItem().toString();
			if(type.equals("S\u00E9lectionnez un type")){
				JOptionPane.showMessageDialog(null, "Elige otra cosa");
			}else{
				cAssi.cmbCAssNom.removeAllItems();
				nomAssie.clear();
				cAssi.cmbCAssNom.setEnabled(true);
				nomAssie=assi.llenaCombo(type);
				for (int i = 0; i < nomAssie.size(); i++) {
					System.out.println("Imprimo l l "+nomAssie.get(i));
					cAssi.cmbCAssNom.addItem(nomAssie.get(i));
				}
			}
		}else if(acE.getSource().equals(cAssi.btnCAssSearch)){
			cleanTable();
			nom=cAssi.cmbCAssNom.getSelectedItem().toString();
			System.out.println("escogido :: "+nom);
			tmp = assi.llenaDat(nom);
			cAssi.dTblMdl.addRow(tmp);
		}else if(acE.getSource().equals(cAssi.btnCAssSortir)){
			MenuAssiette ma = new MenuAssiette();
			ControleurMenuAssie cma = new ControleurMenuAssie(ma, assi);
			cma.setEmplo(cpEmCon());
			cma.startMenuAssie();
			cAssi.setVisible(false);
		}
	}
	public void cleanTable(){
		tmp=null;
		int filas=cAssi.tblCAssAssiettes.getRowCount();
		for (int i=0; filas>i; i++) {
			cAssi.dTblMdl.removeRow(0);
		}
	}
}
