package assiettesSpec;

import modele.Assiette;
import modele.assiette.iSale;
import modele.assiette.iSucre;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 */
public class Dessert extends Assiette implements iSucre, iSale{
	
	public Dessert() {
	}
	
	public Dessert(int id_assiette, String nom, String ingredients, String description, float prix, String type){
		super(id_assiette, nom, ingredients, description, prix, type);
	}
	
	
	
	@Override
	public String toString() {
		return "Dessert [getId_assiette()=" + getId_assiette() + ", getNom()="
				+ getNom() + ", getIngredients()=" + getIngredients()
				+ ", getDescription()=" + getDescription() + ", getPrix()="
				+ getPrix() + ", getType()=" + getType() + "]";
	}

	@Override
	public String tipoSucre() {
		return "Sucre";
	}

	@Override
	public String tipoSale() {
		return "Sale";
	}
}
