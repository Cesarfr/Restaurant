package modele;

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
import java.util.StringTokenizer;
import java.util.TreeMap;

import modele.employe.iEmploye;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Modele pour les employes
 */
public abstract class Employe implements iEmploye, Serializable {
	private static final long serialVersionUID = 3932695567075754321L;
	private String prenom = "", nom = "", sexe = "", date_N = "", rue = "",
			ville = "", pay = "";
	private String user, pass;
	private int telef = 0, id = 0, numero, cont2, login, valide;
	String app = "", pre = "";
	private String archivo = "employes.dat";
	ArrayList<Object[]> array = new ArrayList<Object[]>();
	ArrayList<Object[]> array1 = new ArrayList<Object[]>();
	ArrayList<String> combo = new ArrayList<String>();

	Map<Integer, Employe> treeMap = new TreeMap<Integer, Employe>();

	public Employe() {
	}

	public Employe(int id, String nom, String prenom, String sexe,
			String date_N, String rue, int numero, String ville, String pay,
			int telef, String user, String pass) {
		setId(id);
		setNom(nom);
		setPrenom(prenom);
		setSexe(sexe);
		setDate_N(date_N);
		setRue(rue);
		setNumero(numero);
		setVille(ville);
		setPay(pay);
		setTelef(telef);
		setUser(user);
		setPass(pass);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getDate_N() {
		return date_N;
	}

	public void setDate_N(String date_N) {
		this.date_N = date_N;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getTelef() {
		return telef;
	}

	public void setTelef(int telef) {
		this.telef = telef;
	}

	/**
	 * Uso de Map y TreeMap para guardar mediante un identificador
	 **/
	@Override
	public void ajouterEmploye(Employe em) {
		treeMap.put(em.getId(), em);
//		System.out.println(em);
//		System.out.println("Guardado");
		System.out.println("****RAAAA "+treeMap.size()+" :: "+treeMap.values());
	}

	@Override
	public void effaccerEmploye(int ID) {
		for (Employe emplo : treeMap.values()) {
			if (emplo.getId() == ID) {
				System.out.println(emplo);
				treeMap.remove(ID);
				break;
			}
		}
	}

	public int searchID() {
		for (Employe emplo : treeMap.values()) {
			cont2 = emplo.getId();
		}
		return cont2 + 1;
	}

	/**
	 * Imprimiendo los valores del TreeMap (Normal)
	 */
	@Override
	public ArrayList<Object[]> tousEmplo() {
		for (Employe emplo : treeMap.values()) {
			Object[] aux = { emplo.getId(), emplo.getNom(), emplo.getPrenom(),
					emplo.getDate_N(), emplo.getSexe(), emplo.getRue(),
					emplo.getNumero(), emplo.getVille(), emplo.getPay(),
					emplo.getTelef(), emplo.getClass().getName().substring(13) };
			array.add(aux);
		}
		return array;
	}

	/**
	 * Imprimiendo los valores del TreeMap (dividido)
	 */
	@Override
	public ArrayList<Object[]> parEmplo(String puesto) {
		for (Employe emplo : treeMap.values()) {
			if (emplo.getClass().getName().substring(13).equals(puesto)) {
				// System.out.println(emplo);
				Object[] aux = { emplo.getId(), emplo.getNom(),
						emplo.getPrenom(), emplo.getDate_N(), emplo.getSexe(),
						emplo.getRue(), emplo.getNumero(), emplo.getVille(),
						emplo.getPay(), emplo.getTelef(),
						emplo.getClass().getName().substring(13) };
				array1.add(aux);
			}
		}
		return array1;
	}

	public ArrayList<String> llenaCombo(String employe) {
		int it = 0;
		for (Employe emplo : treeMap.values()) {
			if (emplo.getClass().getName().substring(13).equals(employe)) {
				combo.add(emplo.getNom() + "/" + emplo.getPrenom());
				++it;
			}
		}
		return combo;
	}

	public Employe llenaDat(String nom) {
		Employe tmp = null;
		StringTokenizer tokens = new StringTokenizer(nom, "/"); 
		while (tokens.hasMoreTokens()) {
			app = tokens.nextToken();
			pre = tokens.nextToken();
		}
		for (Employe emplo : treeMap.values()) {
			if (emplo.getNom().equals(app) && emplo.getPrenom().equals(pre)) {
				tmp = emplo;
				System.out.println(tmp);
				break;
			}
		}
		return tmp;
	}

	public void modifier(Employe mod) {
		treeMap.remove(mod.getId());
		treeMap.put(mod.getId(), mod);
		for (Employe emplo : treeMap.values()) {
			System.err.println(emplo);
		}
	}
	
	public void guardarEstado(){
		try{
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(archivo)); // buffer que utiliza el nombre del archivo y permite escribir en el archivo sin borrar lo anterior
			ObjectOutputStream moos = new ObjectOutputStream(bos); // utilizamos un ObjectOutputStream personalizado para cuando exista un encabezado en el archivo de texto
			moos.writeObject(treeMap);// escribimos en el archivo los datos del formulario
			moos.close(); // cerramos conexiones
			bos.close();
		}catch(Exception e){
			
		}
	}

	public void carga() {
		try {
			BufferedInputStream entrada = new BufferedInputStream(
					new FileInputStream(archivo));
			ObjectInputStream DataEnt = new ObjectInputStream(entrada);

			treeMap = (Map<Integer, Employe>) DataEnt.readObject();
			System.err.println("****CARGA " + treeMap.size() + " :: "
					+ treeMap.values());
			DataEnt.close();// cerramos conexiones
			entrada.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public int loginEmp(String user, String pass, String trav){
		for (Employe emplo : treeMap.values()) {
			if(emplo.getUser().equals(user) && emplo.getPass().equals(pass)){
				if(trav.equals("Serveur")){
					login=90;
				}else if(trav.equals("Caissier")){
					login=91;
				}else if(trav.equals("Cuisinier")){
					login=92;
				}else if(trav.equals("Manager")){
					login=93;
				}
				break;
			}
		}
		return login;
	}
	@Override
	public String toString() {
		return "Employe [ id = " + id + ", prenom=" + prenom + ", nom=" + nom
				+ ", sexe=" + sexe + ", date_N=" + date_N + ", rue=" + rue
				+ "numero = " + numero + ", ville=" + ville + ", pay=" + pay
				+ ", user=" + user + ", pass=" + pass + ", telef=" + telef
				+ "]";
	}

}
