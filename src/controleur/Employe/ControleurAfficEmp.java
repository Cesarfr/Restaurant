package controleur.Employe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modele.Assiette;
import modele.Employe;
import vue.employe.ConEmploye;
import vue.employe.MenuEmployes;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Controleur pour afficher une employe
 */
public class ControleurAfficEmp implements ActionListener{
	private ConEmploye conEmploye;
	private Employe emp;
	ArrayList<Object[]> array1 = new ArrayList<Object[]>();
	ArrayList<Object[]> array2 = new ArrayList<Object[]>();
	Assiette assi;
	public ControleurAfficEmp(ConEmploye coE, Employe em) {
		conEmploye=coE;
		emp=em;
		
		conEmploye.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				conEmploye.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				MenuEmployes men = new MenuEmployes();
				ControleurMenuEmplo cm = new ControleurMenuEmplo(men, emp);
				cm.xd(cpAsAff());
				cm.startMenuEmplo();
				conEmploye.setVisible(false);
			}
		});
		conEmploye.rdbtnConEmpPue.addActionListener(this);
		conEmploye.rdbtnConEmpTous.addActionListener(this);
		conEmploye.btnConEmpSortir.addActionListener(this);
		conEmploye.cmbConEmpPuesto.addActionListener(this);
	}
	
	/***********/
	public void setAssAff(Assiette lol){
		System.out.println("AF NOS LLEGA :: "+lol);
		assi=lol;
		System.out.println("AF ASSI VALE :: "+assi);
	}
	public Assiette cpAsAff(){
		System.out.println("Regresamos de CME:: "+assi);
		return assi;
	}
	/***********/
	
	public void startConEmploye(){
		conEmploye.setVisible(true);
		conEmploye.setLocationRelativeTo(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent aE) {
		try {
			if(aE.getSource().equals(conEmploye.rdbtnConEmpPue)){
				conEmploye.rdbtnConEmpTous.setSelected(false);
				cleanTable();
				conEmploye.cmbConEmpPuesto.setEnabled(true);
			}else if(aE.getSource().equals(conEmploye.rdbtnConEmpTous)){
				cleanTable();
				conEmploye.rdbtnConEmpPue.setSelected(false);
				conEmploye.cmbConEmpPuesto.setEnabled(false);
				array1=emp.tousEmplo();
				for (int i=0; i<array1.size();i++) {
					conEmploye.dTblMdl.addRow(array1.get(i));
				}
			}else if (aE.getSource().equals(conEmploye.cmbConEmpPuesto)){
				if(verifyOption()){
					cleanTable();
					String empleo=conEmploye.cmbConEmpPuesto.getSelectedItem().toString();
					array2=emp.parEmplo(empleo);
					for (int i=0; i<array2.size();i++) {
						conEmploye.dTblMdl.addRow(array2.get(i));
					}
				}else {
					JOptionPane.showMessageDialog(null, "Elige otra opcion");
					cleanTable();
				}
			}else if(aE.getSource().equals(conEmploye.btnConEmpSortir)){
				MenuEmployes men = new MenuEmployes();
				ControleurMenuEmplo cm = new ControleurMenuEmplo(men, emp);
				cm.xd(cpAsAff());
				cm.startMenuEmplo();
				conEmploye.setVisible(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean verifyOption(){
		if(conEmploye.cmbConEmpPuesto.getSelectedItem().equals("Emploi")){
			return false;
		}else{
			return true;
		}
	}
	public void cleanTable(){
		array1.clear();
		array2.clear();
		int filas=conEmploye.tblemp.getRowCount();
		for (int i=0; filas>i; i++) {
			conEmploye.dTblMdl.removeRow(0);
		}
	}
}
