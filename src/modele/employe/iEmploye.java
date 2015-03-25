package modele.employe;

import java.util.ArrayList;

import modele.Employe;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 */
public interface iEmploye {
	public void ajouterEmploye(Employe em);
	public void effaccerEmploye(int ID);
	public ArrayList<Object[]> tousEmplo();
	public ArrayList<Object[]> parEmplo(String emplo);
	
}
