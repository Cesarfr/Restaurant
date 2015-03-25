package controleur.Employe;

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
import vue.employe.DelEmploye;
import vue.employe.MenuEmployes;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Controleur pour effecer une employe
 */
public class ControleurDelEmp implements ActionListener{
	private DelEmploye delEmp;
	private Employe employe;
	Assiette assi;
	ArrayList<Object[]> arrayD = new ArrayList<Object[]>();
	ArrayList<Object[]> arrayD2 = new ArrayList<Object[]>();
	
	public ControleurDelEmp(DelEmploye del, Employe e) {
		delEmp = del;
		employe = e;
		
		delEmp.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				delEmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				MenuEmployes men = new MenuEmployes();
				ControleurMenuEmplo cm = new ControleurMenuEmplo(men, employe);
				cm.xd(cpAsDel());
				cm.startMenuEmplo();
			}
		});
		delEmp.btnDelEmpSortir.addActionListener(this);
		delEmp.cmbDelEmpPuesto.addActionListener(this);
		delEmp.rdbtnDelEmpPuesto.addActionListener(this);
		delEmp.rdbtnDelEmpTous.addActionListener(this);
		delEmp.mntmEliminar.addActionListener(this);
	}
	
	/***********/
	public void setAssDel(Assiette lol){
		System.out.println("DEL NOS LLEGA :: "+lol);
		assi=lol;
		System.out.println("DEL ASSI VALE :: "+assi);
	}
	public Assiette cpAsDel(){
		System.out.println("Regresamos de CME:: "+assi);
		return assi;
	}
	/***********/
	
	@Override
	public void actionPerformed(ActionEvent acEv) {
		try {
			if(acEv.getSource().equals(delEmp.btnDelEmpSortir)){
				MenuEmployes men = new MenuEmployes();
				ControleurMenuEmplo cm = new ControleurMenuEmplo(men, employe);
				cm.xd(cpAsDel());
				cm.startMenuEmplo();
				delEmp.setVisible(false);
			}else if(acEv.getSource().equals(delEmp.rdbtnDelEmpPuesto)){
				delEmp.rdbtnDelEmpTous.setSelected(false);
				delEmp.cmbDelEmpPuesto.setEnabled(true);
			}else if(acEv.getSource().equals(delEmp.rdbtnDelEmpTous)){
				cleanTable();
				delEmp.rdbtnDelEmpPuesto.setSelected(false);
				delEmp.cmbDelEmpPuesto.setEnabled(false);
				tous();
			}else if(acEv.getSource().equals(delEmp.cmbDelEmpPuesto)){
				if(verifyOption()){
					parEmploi();
				}else {
					JOptionPane.showMessageDialog(null, "Elige otra opcion");
					cleanTable();
				}
			}else if (acEv.getSource().equals(delEmp.mntmEliminar)) {
				int res = delEmp.tblDelEmp.getSelectedRow();
				if (res >= 0) {
					int resp = JOptionPane.showConfirmDialog(null,"Desea eliminar el registro?", "Advertencia!!!", 0, 0);
					if (resp == 0) {
						employe.effaccerEmploye(Integer.parseInt(delEmp.tblDelEmp.getValueAt(res, 0).toString()));
						JOptionPane.showMessageDialog(null, "Borrado");
						try {
							employe.guardarEstado();
						} catch (Exception e) {
							e.printStackTrace();
						}
						if(delEmp.rdbtnDelEmpTous.isSelected()){
							tous();
						}else if(delEmp.rdbtnDelEmpPuesto.isSelected()){
							parEmploi();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Registro intacto");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void parEmploi(){
		cleanTable();
		String empleo=delEmp.cmbDelEmpPuesto.getSelectedItem().toString();
		arrayD2=employe.parEmplo(empleo);
		for (int i=0; i<arrayD2.size();i++) {
			delEmp.dTblMdl.addRow(arrayD2.get(i));
		}
	}
	
	public void tous(){
		cleanTable();
		arrayD=employe.tousEmplo();
		for (int i=0; i<arrayD.size();i++) {
			delEmp.dTblMdl.addRow(arrayD.get(i));
		}
	}
	public void startDelEmp(){
		delEmp.setVisible(true);
		delEmp.setLocationRelativeTo(null);
	}
	
	public boolean verifyOption(){
		if(delEmp.cmbDelEmpPuesto.getSelectedItem().equals("Emploi")){
			return false;
		}else{
			return true;
		}
	}
	public void cleanTable(){
		arrayD.clear();
		arrayD2.clear();
		int filas=delEmp.tblDelEmp.getRowCount();
		for (int i=0; filas>i; i++) {
			delEmp.dTblMdl.removeRow(0);
		}
	}
}