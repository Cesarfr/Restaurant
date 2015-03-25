package modele;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Modele pour les commandes
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

import modele.commande.iCommande;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Controleur par les commandes
 */
public class Commande implements Serializable, iCommande {
	private static final long serialVersionUID = -8317840631610092868L;
	private int no_orden = 0, no_mesa = 0, no_comensal = 0, no_empleado = 0, no_linea = 0, id_platOr = 0, cont2=0, cont3=0, cont4=0, idEmp, usTab, exist;
	private String fecha = "", nombrePlat = "", status;
	private float total = 0f, costo = 0f;
	private String archivo="commandes.dat", archivo_2="details.dat";
	Assiette assi;
	Employe emplo;
	Map<Integer, Commande> treeMapComm = new TreeMap<Integer, Commande>();
	
	ArrayList<Commande> detalle = new ArrayList<Commande>();
	
	ArrayList<Object[]> dComm = new ArrayList<Object[]>();
	ArrayList<Object[]> tousCom = new ArrayList<Object[]>();
	ArrayList<Object[]> payTab = new ArrayList<Object[]>();
	ArrayList<Object[]> payInd = new ArrayList<Object[]>();
	
	ArrayList<String> combo = new ArrayList<String>();
	
	public Commande() {}

	public Commande(int no_orden, int no_mesa, int no_comensal, int no_empleado, String status, String fecha, float total) {
		setNo_orden(no_orden);
		setNo_mesa(no_mesa);
		setNo_comensal(no_comensal);
		setNo_empleado(no_empleado);
		setStatus(status);
		setFecha(fecha);
		setTotal(total);
	}
	public Commande(int no_orden, int no_mesa, int no_comensal, int no_linea, int id_platOr, String nombrePlat, float costo, String status) {
		setNo_orden(no_orden);
		setNo_mesa(no_mesa);
		setNo_comensal(no_comensal);
		setNo_linea(no_linea);
		setId_platOr(id_platOr);
		setNombrePlat(nombrePlat);
		setCosto(costo);
		setStatus(status);
	}
	public int getNo_orden() {
		return no_orden;
	}
	public void setNo_orden(int no_orden) {
		this.no_orden = no_orden;
	}
	public int getNo_mesa() {
		return no_mesa;
	}
	public void setNo_mesa(int no_mesa) {
		this.no_mesa = no_mesa;
	}
	public int getNo_comensal() {
		return no_comensal;
	}
	public void setNo_comensal(int no_comensal) {
		this.no_comensal = no_comensal;
	}
	public int getNo_empleado() {
		return no_empleado;
	}
	public void setNo_empleado(int no_empleado) {
		this.no_empleado = no_empleado;
	}
	public int getNo_linea() {
		return no_linea;
	}
	public void setNo_linea(int no_linea) {
		this.no_linea = no_linea;
	}
	public int getId_platOr() {
		return id_platOr;
	}
	public void setId_platOr(int id_platOr) {
		this.id_platOr = id_platOr;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getNombrePlat() {
		return nombrePlat;
	}
	public void setNombrePlat(String nombrePlat) {
		this.nombrePlat = nombrePlat;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	@Override
	public void ajouterCommande(Commande cm){
		treeMapComm.put(cm.getNo_orden(), cm);
		System.out.println("****COMMM "+treeMapComm.size()+" :: "+treeMapComm.values());
	}
	/**
	 * Methode pour enegistrer les details du commande en cours
	 */
	public void ajouterDetCommande(Commande com){
		detalle.add(com);
	}

	@Override
	public void effaccerCommande(int ID) {
		for (Commande com : treeMapComm.values()) {
			if (com.getNo_orden() == ID) {
				System.out.println("se va borrar "+com);
				treeMapComm.remove(ID);
				break;
			}
		}
	}

	@Override
	public ArrayList<Object[]> tousCommande() {
		tousCom.clear();
		for (Commande com : treeMapComm.values()) {
			if(com.getStatus().equals("Cours")){
				Object[] tc = {com.getNo_orden(), com.getNo_mesa(), com.getNo_comensal(), com.getStatus(), com.getFecha()};
				tousCom.add(tc);
			}
		}
		return tousCom;
	}
	
	/* ID EMPLEADO PARA CAMBIAR EL ESTADO */
	public int reqEmplo(int NCom){
		for (Commande com : treeMapComm.values()) {
			if(com.getNo_orden()==NCom){
				idEmp = com.getNo_empleado();
			}
		}
		return idEmp;
	}
	
	/**************/
	public void initialize(Assiette a, Employe e){
		assi = a;
		System.out.println("###### COMMA "+assi);
		emplo = e;
		System.out.println("$$$$$$ COMMA "+emplo);
	}
	public Employe getEmploCom(){
		System.out.println("Reg :: "+emplo);
		return emplo;
	}
	public Assiette getAssieCom(){
		System.out.println("Reg :: "+assi);
		return assi;
	}
	/*****************/
	
	public ArrayList<Object[]> listCommande(int IDC){
		dComm.clear();
		for (Commande comn : detalle) {
			if(IDC==comn.getNo_orden()){
				System.err.println("-*-* LISTECOMMANDE(IDC)"+comn);
				Object[] aux={comn.getNo_orden(), comn.getNo_comensal(), comn.getNo_linea(), comn.getNombrePlat()};
				dComm.add(aux);
			}
		}
		return dComm;		
	}
	
	public void searchModLig(int idC, int idT, int idU, int idLi, Commande co){
		Object object=null;
		int l = 0;
		for (Commande comn : detalle) {
			if (comn.getNo_orden() == idC && comn.getNo_mesa() == idT
					&& comn.getNo_comensal() == idU
					&& comn.getNo_linea() == idLi) {
				
				object=comn;
				System.err.println("Found "+object);
				System.err.println("POSICION DEL OBJETO :: "+detalle.indexOf(object));
				System.out.println("L DICE: "+l);
				detalle.set(l, co);
				break;
			}
			l++;
		}
	}
	
	public void changeEt(int idC, Commande co){
		Object object=null;
		for (Commande comn : treeMapComm.values()) {
			if (comn.getNo_orden() == idC) {
				object=comn;
				System.err.println("Found "+object);
				System.err.println("POSICION DEL OBJETO :: "+comn.getNo_orden());
				treeMapComm.put(comn.getNo_orden(), co);
				break;
			}
		}
	}
	
	public int useTab(int tab){
		usTab =0;
		for(Commande comn : treeMapComm.values()){
			if(comn.getNo_mesa()==tab && comn.getTotal()==0.0){
				usTab = 50;
				break;
			}
		}
		return usTab;
	}
	
	public int paTab(int tb){
		for(Commande comn : treeMapComm.values()){
			if(comn.getNo_mesa()==tb && comn.getTotal()==0 && comn.getStatus().equals("Prepare")){
				System.out.println("Hay una orden aqui\n"+comn);
				exist = 10;
				break;
			}else{
				exist = 11;
			}
		}
		return exist;
	}
	
	public Commande payTable(int tb){
		Commande rt=null;
		for(Commande comn : treeMapComm.values()){
			if(comn.getNo_mesa()==tb && comn.getStatus().equals("Prepare")){
				System.out.println("Hay una orden aqui\n"+comn);
				rt=comn;
				System.out.println("RAWR :: "+rt);
			}
		}
		return rt;
	}
	
	public ArrayList<Object[]> llenapayTable(int idCom, int tb){
		payTab.clear();
		for(Commande comn : detalle){
			if(comn.getNo_mesa()==tb && comn.getNo_orden()==idCom){
				Object[] lol = {comn.getNo_comensal(), comn.getNo_linea(), comn.getNombrePlat(), comn.getCosto()};
				payTab.add(lol);
			}
		}
		return payTab;
	}
	
	public ArrayList<Object[]> llenapayInd(int idCom, int tb, int com){
		payInd.clear();
		for(Commande comn : detalle){
			if(comn.getNo_mesa()==tb && comn.getNo_orden()==idCom && comn.getNo_comensal()==com){
				Object[] lol = {comn.getNo_linea(), comn.getNombrePlat(), comn.getCosto()};
				payInd.add(lol);
			}
		}
		return payInd;
	}
	
	public int valideNewCom(int tab, int per){
		if(tab<=0){
			cont4 = 30;
		}else if(useTab(tab)==50){
			cont4 = 32;
		}else if(per<=0){
			cont4 = 31;
		}else {
			cont4 = 29;
		}
		return cont4;
	}
	
	public int searchID() {
		for (Commande com : treeMapComm.values()) {
			cont2 = com.getNo_orden();
		}
		return cont2 + 1;
	}
	public int schID(String emploi, String user) {
		for (Employe em : emplo.treeMap.values()) {
			if(em.getClass().getName().substring(13).equals(emploi) && em.getUser().equals(user)){
				cont3=em.getId();
				break;
			}
		}
		return cont3;
	}
	
	public void saveState(){
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(archivo)); // buffer que utiliza el nombre del archivo y permite escribir en el archivo sin borrar lo anterior
			ObjectOutputStream moos = new ObjectOutputStream(bos); // utilizamos un ObjectOutputStream personalizado para cuando exista un encabezado en el archivo de texto
			moos.writeObject(treeMapComm);// escribimos en el archivo los datos del formulario
			moos.close(); // cerramos conexiones
			bos.close();
		} catch (Exception e) {
			
		}
		
	}
	public void chargeState(){
		try{
	        BufferedInputStream entrada = new BufferedInputStream(new FileInputStream(archivo));
	        ObjectInputStream DataEnt=new ObjectInputStream(entrada);
            treeMapComm=(Map<Integer, Commande>) DataEnt.readObject();// leemos el primer objeto del archivo
            System.err.println("****CH COMM "+treeMapComm.size()+" :: "+treeMapComm.values());
            DataEnt.close();// cerramos conexiones
            entrada.close();
        }catch(Exception e){
        	System.out.println(e.getMessage());
        }
        
	}
	
	public void saveStateDet(){
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(archivo_2)); // buffer que utiliza el nombre del archivo y permite escribir en el archivo sin borrar lo anterior
			ObjectOutputStream moos = new ObjectOutputStream(bos); // utilizamos un ObjectOutputStream personalizado para cuando exista un encabezado en el archivo de texto
			moos.writeObject(detalle);// escribimos en el archivo los datos del formulario
			moos.close(); // cerramos conexiones
			bos.close();
		} catch (Exception e) {
			
		}
		
	}
	public void chargeStateDet(){
		try{
	        BufferedInputStream entrada = new BufferedInputStream(new FileInputStream(archivo_2));
	        ObjectInputStream DataEnt=new ObjectInputStream(entrada);
        
        	detalle = (ArrayList<Commande>) DataEnt.readObject();// leemos el primer objeto del archivo
            System.err.println("****LOAD DET "+detalle.size()+" :: "+detalle);
            DataEnt.close();// cerramos conexiones
            entrada.close();
        }catch(Exception e){
        	System.out.println(e.getMessage());
        }
	}
	@Override
	public String toString() {
		return "Commande [no_orden=" + no_orden + ", no_mesa=" + no_mesa
				+ ", no_comensal=" + no_comensal + ", no_empleado="
				+ no_empleado + ", no_linea=" + no_linea + ", id_platOr="
				+ id_platOr + ", fecha=" + fecha + ", nombrePlat=" + nombrePlat
				+ ", status=" + status + ", total=" + total + ", costo="
				+ costo + "]";
	}
}
