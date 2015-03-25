package controleur.Assiette;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;

import modele.Assiette;
import modele.Employe;
import controleur.Employe.ControleurMenuManag;
import controleur.Controlateur;
import vue.Debut;
import vue.assiette.AjoAssiette;
import vue.assiette.ConAssiette;
import vue.assiette.DelAssiette;
import vue.assiette.MenuAssiette;
import vue.assiette.ModAssiette;
import vue.employe.MenuManager;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Controleur par le menu d'assiettes
 */
public class ControleurMenuAssie implements ActionListener{
	private MenuAssiette meAssi;
	private Assiette as;
	Employe employe;
	
	public ControleurMenuAssie(MenuAssiette meAs, Assiette aso) {
		meAssi=meAs;
		as = aso;
		meAssi.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				meAssi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				MenuManager mm=new MenuManager();
				ControleurMenuManag cmm = new ControleurMenuManag(mm, as);
				cmm.startMenuManager();
			}
		});
		meAssi.btnMAssConsulter.addActionListener(this);
		meAssi.btnMAssEffacer.addActionListener(this);
		meAssi.btnMAssModifier.addActionListener(this);
		meAssi.btnMAssNouveau.addActionListener(this);
		meAssi.btnMAssSalir.addActionListener(this);
	}
	
	/***********/
	public void setEmplo(Employe lol){
		System.out.println("MA NOS LLEGA :: "+lol);
		employe=lol;
		System.out.println("MA EMPLO VALE :: "+employe);
	}
	public Employe cpEm(){
		System.out.println("Regresamos de CME:: "+employe);
		return employe;
	}
	/***********/
	
	public void startMenuAssie(){
		try {
			as.cargaAssi();
		} catch (Exception e) {
			e.printStackTrace();
		}
		meAssi.setVisible(true);
		meAssi.setLocationRelativeTo(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent aEve) {
		if(aEve.getSource().equals(meAssi.btnMAssConsulter)){
			ConAssiette coa = new ConAssiette();
			ControleurConAssiette concon = new ControleurConAssiette(coa, as);
			concon.setEmploCon(cpEm());
			concon.startConAssiette();
			meAssi.setVisible(false);
		}else if(aEve.getSource().equals(meAssi.btnMAssEffacer)){
			DelAssiette del = new DelAssiette();
			ControleurDelAssiette condel = new ControleurDelAssiette(del, as);
			condel.setEmploDel(cpEm());
			condel.startDelAssiette();
			meAssi.setVisible(false);
		}else if(aEve.getSource().equals(meAssi.btnMAssModifier)){
			ModAssiette mod = new ModAssiette();
			ControleurModAssie conmod = new ControleurModAssie(mod, as);
			conmod.setEmploMod(cpEm());
			conmod.startModAssie();
			meAssi.setVisible(false);
		}else if(aEve.getSource().equals(meAssi.btnMAssNouveau)){
			AjoAssiette ajo = new AjoAssiette();
			ControleurAjoAssiette conajo = new ControleurAjoAssiette(ajo, as);
			conajo.setEmploAjo(cpEm());
			conajo.getIDAssi(as.searchIDAssi());
			conajo.startAjoAssiette();
			meAssi.setVisible(false);
		}else if(aEve.getSource().equals(meAssi.btnMAssSalir)){
			MenuManager mm=new MenuManager();
			ControleurMenuManag cmm = new ControleurMenuManag(mm, as);
			cmm.getEmplo(cpEm());
			cmm.startMenuManager();
			meAssi.setVisible(false);
		}
	}

}
