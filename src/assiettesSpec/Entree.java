package assiettesSpec;

import modele.Assiette;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 */
public class Entree extends Assiette{

	public Entree(int id_assiette, String nom, String ingredients, String description, float prix){
		super(id_assiette, nom, ingredients, description, prix);
	}
	@Override
	public String toString() {
		return "Entree [getId_assiette()=" + getId_assiette() + ", getNom()="
				+ getNom() + ", getIngredients()=" + getIngredients()
				+ ", getDescription()=" + getDescription() + ", getPrix()="
				+ getPrix() + "]";
	}
}
