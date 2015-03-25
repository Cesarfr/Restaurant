package principal;

import java.io.IOException;

import assiettesSpec.Dessert;
import assiettesSpec.Entree;
import assiettesSpec.Salade;
import modele.Assiette;
import modele.Commande;
import modele.Employe;
import vue.Debut;
import controleur.Controlateur;
import employesSpec.Caissier;
import employesSpec.Cuisinier;
import employesSpec.Manager;
import employesSpec.Serveur;

/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Classe principale qui execute le programme
 */
public class Principal {

	public static void main(String[] args) {
		Employe emplo = new Employe() {};
//		Employe emp1 = new Caissier(1, "LOPEZ", "Juan", "Homme", "1968/09/15", "Conchitas", 15, "Aix en provence", "France", 159365758,"juan","1234");
//		Employe emp2 = new Cuisinier(2, "RODRIGUEZ", "Pedro", "Homme", "1967/12/16", "Conchitas", 25, "Aix en provence", "France", 159365758,"pedro","");
//		Employe emp3 = new Serveur(3, "GUZMAN", "Mauricio", "Femme", "2009/10/12", "Conchitas", 33, "Aix en provence", "France", 159365758,"mau12","");
//		Employe emp4 = new Manager(4, "MARTINEZ", "Daniel", "Homme", "2002/01/16", "Conchitas", 33, "Aix en provence", "France", 159365758,"daniel","147");
//		Employe emp5 = new Caissier(5, "LOPEZ", "Juan Carlos", "Homme", "1991/06/19", "Conchitas", 15, "Aix en provence", "France", 159365758,"carlos","3369");
//		Employe emp6 = new Cuisinier(6, "RODRIGUEZ", "Rodrigo", "Homme", "1989/01/17", "Conchitas", 25, "Aix en provence", "France", 159365758,"rock","");
//		Employe emp7 = new Caissier(7, "GUZMAN", "Joel", "Femme", "1978/03/22", "Conchitas", 33, "Aix en provence", "France", 159365758,"joel","1234");
//		Employe emp8 = new Caissier(8, "MARTINEZ", "Nicolas", "Femme", "1996/05/05", "Conchitas", 33, "Aix en provence", "France", 159365758,"nico","1234");

		Assiette assiette = new Assiette() {};
		Commande commmm = new Commande();
		
		Debut bebut=new Debut();
		Controlateur cont=new Controlateur(bebut, emplo, assiette, commmm);
		cont.debutframe();
	}

}
