/**
 * SaverLoader.java 
 * 
 * Luokka toteuttaa Serializable rajapinnan ja kirjoittaa aksessoreilla
 * olioita tiedostoon.
 * 
 * @author ryhmä?
 * 
 */

import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaverLoader implements Serializable {

	private FileOutputStream fileOut;
	private ObjectOutputStream objectOut;
	private FileInputStream fileIn;
	private ObjectInputStream objectIn;
	private Object loadedObject;
	private final String DEFAULTFILE = "opinnot.txt"; //default tiedosto jos ei määritellä erikseen
	
	/**
	 * Tallennetaan default lokaatioon
	 * 
	 * @param toBeSaved olio joka tallennetaan tiedostoon
	 * @return true jos onnistutaan, muuten false
	 * 
	 */
	public boolean saveObject(Object toBeSaved) {

		if (toBeSaved instanceof Keraaja) {
			try {
				this.fileOut = new FileOutputStream(this.DEFAULTFILE);
				this.objectOut = new ObjectOutputStream(this.fileOut);
				this.objectOut.writeObject(toBeSaved);
				this.objectOut.flush();
				this.objectOut.close();
				this.fileOut.close();
			} catch (Exception e) { //kiireinen poikkeuskäsittely
				e.printStackTrace();
				return false;
			}
			return true;
		}
		else return false;
	}

	/**
	 * Tallennetaan Keraaja olio parametrina saatuun tiedostoon
	 * 
	 * @param toBeSaved olio joka tallennetaan tiedostoon
	 * @param toSaveInto tiedosto johon tallennetaan
	 * @return true jos onnistutaan, muutoin false
	 * 
	 */
	public boolean saveObject(Object toBeSaved, String toSaveInto) {
		
		if (toBeSaved instanceof Keraaja) {
			try {
				this.fileOut = new FileOutputStream(toSaveInto);
				this.objectOut = new ObjectOutputStream(this.fileOut);
				this.objectOut.writeObject(toBeSaved);
				this.objectOut.flush();
				this.objectOut.close();
				this.fileOut.close();
			} catch (Exception e) { //kiireinen poikkeuskäsittely
				e.printStackTrace();
				return false;
			}
			return true;
		}
		else return false;
	}
	
	/**
	 * Ladataan Keraaja olio tiedostosta
	 * 
	 * @param path tiedostopolku jossa tiedosto sijaitsee
	 * @return tiedostosta ladattu Keraaja tai null jos lukeminen epäonnistuu
	 * 
	 */
	public Object loadObject(String path) {
		
		try {
			this.fileIn = new FileInputStream(path);
			this.objectIn = new ObjectInputStream(this.fileIn);
			this.loadedObject = this.objectIn.readObject();
			this.objectIn.close();
			this.fileIn.close();
		} catch (Exception e) { //kiireinen poikkeuskäsittely
			return null;
		}
		
		if (this.loadedObject instanceof Keraaja) {
			return this.loadedObject;
		}
		else return null;
	}
	
	/**
	 * Ladataan Keraaja olio default -tiedostosta
	 * 
	 * @return tiedostosta ladattu Keraaja tai null jos lukeminen epäonnistuu
	 * 
	 */
	public Object loadObject() {
		
		try {
			this.fileIn = new FileInputStream(this.DEFAULTFILE);
			this.objectIn = new ObjectInputStream(this.fileIn);
			this.loadedObject = this.objectIn.readObject();
		} catch (Exception e) { //kiireinen poikkeuskäsittely
			return null;
		}
		
		if (this.loadedObject instanceof Keraaja) {
			return this.loadedObject;
		}
		else return null;
	}

}
