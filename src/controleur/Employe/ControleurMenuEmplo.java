package controleur.Employe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;

import modele.Assiette;
import modele.Employe;
import vue.employe.AjoEmploye;
import vue.employe.ConEmploye;
import vue.employe.DelEmploye;
import vue.employe.MenuEmployes;
import vue.employe.MenuManager;
import vue.employe.ModEmploye;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Controleur pour le menu d'employe
 */
public class ControleurMenuEmplo implements ActionListener {
	private MenuEmployes mEmp;	
	private Employe emplo;
	Assiette assi;
	ControleurMenuManag cmm;
	public ControleurMenuEmplo(MenuEmployes memp, Employe em) {
		mEmp=memp;
		emplo = em;
		
		mEmp.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				mEmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				MenuManager mm=new MenuManager();
				cmm = new ControleurMenuManag(mm, emplo);
				cmm.getAssiet(cpAs());
				cmm.startMenuManager();
			}
		});
		mEmp.btnMEmpConsulter.addActionListener(this);
		mEmp.btnmEmpEffacer.addActionListener(this);
		mEmp.btnMEmpModifier.addActionListener(this);
		mEmp.btnMEmpNouveau.addActionListener(this);
		mEmp.btnMEmpSalir.addActionListener(this);
	}
	
	/******************/
	public void xd(Assiette lol){
		System.out.println("NOS LLEGA :: "+lol);
		assi=lol;
		System.out.println("ASSI VALE :: "+assi);
	}
	public Assiette cpAs(){
		System.out.println("Regresamos de CME:: "+assi);
		return assi;
	}
	/**********************/
	
	public void startMenuEmplo(){
		try {
			emplo.carga();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mEmp.setVisible(true);
		mEmp.setLocationRelativeTo(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent aEv) {
		if(aEv.getSource().equals(mEmp.btnMEmpConsulter)){
			ConEmploye coE=new ConEmploye();
			ControleurAfficEmp caf = new ControleurAfficEmp(coE, emplo);
			caf.setAssAff(cpAs());
			caf.startConEmploye();
			mEmp.setVisible(false);
		}else if(aEv.getSource().equals(mEmp.btnmEmpEffacer)){
			DelEmploye del = new DelEmploye();
			ControleurDelEmp con = new ControleurDelEmp(del, emplo);
			con.setAssDel(cpAs());
			con.startDelEmp();
			mEmp.setVisible(false);
		}else if(aEv.getSource().equals(mEmp.btnMEmpModifier)){
			ModEmploye mod = new ModEmploye();
			ControleurModEmpl conMo = new ControleurModEmpl(mod, emplo);
			conMo.setAssMod(cpAs());
			conMo.startModEmp();
			mEmp.setVisible(false);
		}else if(aEv.getSource().equals(mEmp.btnMEmpNouveau)){
			AjoEmploye ajoEm = new AjoEmploye();
			ControleurAjoEmploye conae = new ControleurAjoEmploye(ajoEm, emplo);
			conae.setAssAjo(cpAs());
			conae.getIDempl(emplo.searchID());
			conae.startFrame();
			mEmp.setVisible(false);
		}else if(aEv.getSource().equals(mEmp.btnMEmpSalir)){
			MenuManager mm=new MenuManager();
			cmm = new ControleurMenuManag(mm, emplo);
			cmm.getAssiet(cpAs());
			cmm.startMenuManager();
			mEmp.setVisible(false);
		}
	}

}
