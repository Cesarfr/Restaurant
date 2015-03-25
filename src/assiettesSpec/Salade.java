package assiettesSpec;

import modele.Assiette;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 */
public class Salade extends Assiette{

	public Salade(int id_assiette, String nom, String ingredients, String description, float prix){
		super(id_assiette, nom, ingredients, description, prix);
	}

	@Override
	public String toString() {
		return "Salade [getId_assiette()=" + getId_assiette() + ", getNom()="
				+ getNom() + ", getIngredients()=" + getIngredients()
				+ ", getDescription()=" + getDescription() + ", getPrix()="
				+ getPrix() + "]";
	}
}
