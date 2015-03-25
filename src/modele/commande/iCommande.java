package modele.commande;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import modele.Commande;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 */
public interface iCommande {
	public void ajouterCommande(Commande cm);
	public void effaccerCommande(int ID);
	public ArrayList<Object[]> tousCommande(); 
}
