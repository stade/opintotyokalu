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
	private final String DEFAULTFILE = "opinnot.txt";
	
	/*
	 * Tallennetaan default lokaatioon
	 * 
	 * @param toBeSaved olio joka tallennetaan tiedostoon
	 * @return 		true jos onnistutaan, muuten false
	 * 
	 * TODO: objection tyypin tarkistus
	 */
	public boolean saveObject(Object toBeSaved) {

		try {
			this.fileOut = new FileOutputStream(this.DEFAULTFILE);
			this.objectOut = new ObjectOutputStream(this.fileOut);
			
			this.objectOut.writeObject(toBeSaved);
		} catch (Exception e) { // vituiks meni tarkistaa kaikki exceptionit apista syssymmällä
			return false;
		}
		return true;	
	
	}

	/*
	 * Tallennetaan parametrina saatuun tiedostoon
	 * 
	 * @param toBeSaved olio joka tallennetaan tiedostoon
	 * @param toSaveInto tiedosto johon tallennetaan
	 * @return 		true jos onnistutaan, muutoin false
	 * 
	 * TODO: objection tyypin tarkistus
	 */
	private boolean saveObject(Object toBeSaved, String toSaveInto) {
		
		try {
			this.fileOut = new FileOutputStream(toSaveInto);
			this.objectOut = new ObjectOutputStream(this.fileOut);
			this.objectOut.writeObject(toBeSaved);
		} catch (Exception e) { // vituiks meni tarkistaa kaikki exceptionit apista syssymmällä
			return false;
		}
		return true;
	}
	
	/*
	 * Ladataan objecti tiedostosta
	 * 
	 * @param path tiedostopolku jossa tiedosto sijaitsee
	 * @return 		tiedostosta ladattu olio tai false jos lukeminen epäonnistuu
	 * 
	 * TODO: objection tyypin tarkistus
	 */
	public Object loadObject(String path) {
		
		try {
			this.fileIn = new FileInputStream(path);
			this.objectIn = new ObjectInputStream(this.fileIn);
			this.loadedObject = this.objectIn.readObject();
		} catch (Exception e) { // vituiks meni tarkistaa kaikki exceptionit apista syssymmällä
			return false;
		}
		return this.loadedObject;
	}
	
	/*
	 * Ladataan objecti default -tiedostosta
	 * 
	 * @return 		tiedostosta ladattu olio tai false jos lukeminen epäonnistuu
	 * 
	 * TODO: objection tyypin tarkistus
	 */
	public Object loadObject() {
		
		try {
			this.fileIn = new FileInputStream(this.DEFAULTFILE);
			this.objectIn = new ObjectInputStream(this.fileIn);
			this.loadedObject = this.objectIn.readObject();
		} catch (Exception e) { // vituiks meni tarkistaa kaikki exceptionit apista syssymmällä
			return false;
		}
		return this.loadedObject;
	}
		
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
