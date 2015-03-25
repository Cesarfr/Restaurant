package modele;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Modele pour les assittes
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import modele.assiette.iAssiette;

public abstract class Assiette implements iAssiette, Serializable{
	private static final long serialVersionUID = 5312190494804032702L;
	private int id_assiette, cont2, retID;
	private String nom, ingredients, description, type, retType;
	private float prix, retprix;
	private String archivo="assiette.dat";
	
	ArrayList<Object[]> arrTousAssi = new ArrayList<Object[]>();
	ArrayList<Object[]> arrTriAssi = new ArrayList<Object[]>();
	ArrayList<String> combo = new ArrayList<String>();
	Map<Integer, Assiette> treeMapAssietes = new TreeMap<Integer, Assiette>();
	
	public Assiette(){
		
	}
	public Assiette(int id_assiette, String nom, String ingredients, String description, float prix){
		setId_assiette(id_assiette);
		setNom(nom);
		setIngredients(ingredients);
		setDescription(description);
		setPrix(prix);
	}
	public Assiette(int id_assiette, String nom, String ingredients, String description, float prix, String type){
		setId_assiette(id_assiette);
		setNom(nom);
		setIngredients(ingredients);
		setDescription(description);
		setPrix(prix);
		setType(type);
	}
	/*Creation des setters et getters pour acceder aux elements*/
	public int getId_assiette() {
		return id_assiette;
	}
	public void setId_assiette(int id_assiette) {
		this.id_assiette = id_assiette;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	/* Methodes de l'inteface Assiette */
	@Override
	public void ajouterAssiette(Assiette assi) {
		treeMapAssietes.put(assi.getId_assiette(), assi);
		System.out.println("****ASSSIIIEEEE "+treeMapAssietes.size()+" :: "+treeMapAssietes.values());
	}

	@Override
	public void effaccerAssiette(int ID) {
		for (Assiette assi : treeMapAssietes.values()) {
			if(assi.getId_assiette()==ID){
				System.out.println(assi);
				treeMapAssietes.remove(ID);
				System.err.println(assi);
				break;
			}
		}
	}
	public void modifier(Assiette mod) {
		treeMapAssietes.remove(mod.getId_assiette());
		treeMapAssietes.put(mod.getId_assiette(), mod);
		for (Assiette assi : treeMapAssietes.values()) {
			System.err.println(assi);
		}
	}
	
	public ArrayList<String> llenaCombo(String assiet) {
		for (Assiette assie : treeMapAssietes.values()) {
			//System.err.println(assie.getClass().getName().substring(14));
			if (assie.getClass().getName().substring(14).equals(assiet)) {
				System.out.println("AGREGAMOS COMB // "+assiet);
				combo.add(assie.getNom());
			}
		}
		return combo;
	}
	
	public float retPrix(String nomAssi){
		for (Assiette assie : treeMapAssietes.values()) {
			if (assie.getNom().equals(nomAssi)) {
				
				retprix=assie.getPrix();
				System.err.println("RET XP"+assie.getClass().getName().substring(14)+" ### "+retprix);
				break;
			}
		}
		return retprix;
	}
	public Object[] llenaDat(String nom) {
		Object[] tmp = null;
		for (Assiette assie : treeMapAssietes.values()) {
			if (assie.getNom().equals(nom)) {
				if(assie.getClass().getName().substring(14).equals("Dessert")){
					Object[] tmp1 = {assie.getId_assiette(), assie.getDescription(), assie.getPrix(), assie.getIngredients(), assie.getType()};
					System.out.println(tmp1.length);
					tmp = tmp1;
					System.out.println(tmp.length);
					break;
				}else{
					Object[] tmp1 = {assie.getId_assiette(), assie.getDescription(), assie.getPrix(), assie.getIngredients(),"N/A"};
					System.out.println(tmp1.length);
					tmp = tmp1;
					System.out.println(tmp.length);
					break;
				}
			}
		}
		return tmp;
	}
	public Assiette raquestForm(String assiet) {
		Assiette tmpA = null;
		for (Assiette assie : treeMapAssietes.values()) {
			if (assie.getNom().equals(assiet)) {
				tmpA = assie;
				System.out.println(tmpA);
				break;
			}
		}
		return tmpA;
	}
	public void searchIDeff(String eff){
		for (Assiette assi : treeMapAssietes.values()) {
			if(assi.getNom().equals(eff)){
				effaccerAssiette(assi.getId_assiette());
				break;
			}
		}
	}
	public int searchID(String eff){
		for (Assiette assi : treeMapAssietes.values()) {
			if(assi.getNom().equals(eff)){
				retID = assi.getId_assiette();
				break;
			}
		}
		System.out.println("REGRESAMOS EL ID ASS: "+retID);
		return retID;
	}
	public int searchIDAssi() {
		for (Assiette aso : treeMapAssietes.values()) {
			cont2 = aso.getId_assiette();
		}
		return cont2 + 1;
	}
	
	public String schType(String nom){
		System.err.println("NOS LLEGA ESTE : "+nom);
		for (Assiette aso : treeMapAssietes.values()) {
			if(aso.getNom().equals(nom)){
				retType = aso.getClass().getName().substring(14);
				System.err.println("Tipo found = "+retType);
			}
		}
		return retType;
	}
	
	public void guardarEstadoAssi(){
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(archivo)); // buffer que utiliza el nombre del archivo y permite escribir en el archivo sin borrar lo anterior
			ObjectOutputStream moos = new ObjectOutputStream(bos); // utilizamos un ObjectOutputStream personalizado para cuando exista un encabezado en el archivo de texto
			moos.writeObject(treeMapAssietes);// escribimos en el archivo los datos del formulario
			moos.close(); // cerramos conexiones
			bos.close();
		} catch (Exception e) {
			
		}
	}
	
	public void cargaAssi(){
		try {
			BufferedInputStream entrada = new BufferedInputStream(
					new FileInputStream(archivo));
			ObjectInputStream DataEnt = new ObjectInputStream(entrada);

			treeMapAssietes = (Map<Integer, Assiette>) DataEnt.readObject();
			System.err.println("****charge ASSI " + treeMapAssietes.size()
					+ " :: " + treeMapAssietes.values());
			DataEnt.close();// cerramos conexiones
			entrada.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
	}
}
