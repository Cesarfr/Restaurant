package employesSpec;

import modele.Employe;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 */
public class Manager extends Employe{
	public Manager(int id, String nom, String prenom, String sexe, String date_N, String rue, int numero, String ville, String pay, int telef, String user, String pass){
		super(id, nom, prenom, sexe, date_N, rue, numero, ville, pay, telef, user, pass);
	}
	@Override
	public String toString() {
		return "Manager [getId()=" + getId() + ", getPrenom()=" + getPrenom()
				+ ", getNom()=" + getNom() + ", getSexe()=" + getSexe()
				+ ", getDate_N()=" + getDate_N() + ", getRue()=" + getRue()
				+ ", getNumero()=" + getNumero() + ", getVille()=" + getVille()
				+ ", getPay()=" + getPay() + ", getUser()=" + getUser()
				+ ", getPass()=" + getPass() + ", getTelef()=" + getTelef()
				+ "]";
	}
}
