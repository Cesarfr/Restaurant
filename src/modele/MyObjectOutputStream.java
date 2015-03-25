package modele;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
/**
 * @author Cesar HERNANDEZ ANTONIO, Joaquin GALVAN ANGELES
 * @version 1.0
 * Description : Classe pour ajouter les elements dans une fichier
 */
public class MyObjectOutputStream extends ObjectOutputStream {
	/** Constructor que recibe OutputStream */
	public MyObjectOutputStream(OutputStream out) throws IOException {
		super(out);
	}

	/** Constructor sin par�metros */
	public MyObjectOutputStream() throws IOException, SecurityException {

	}

	/** Redefinici�n del m�todo de escribir la cabecera para que no haga nada. */
	public void writeStreamHeader() throws IOException {

	}
}
