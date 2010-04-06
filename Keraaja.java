import java.io.Serializable;
import java.util.ArrayList;


public class Keraaja implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8333867660428826471L;
	private ArrayList<Tapahtuma> tentit; // Tarviiko tenttien olla erikseen vai laitetaanko tapahtumataulukkoon
	private ArrayList<Tapahtuma> tapahtumat;
	private ArrayList<Kurssi> kurssit;	
	
	public Keraaja(){
		tentit = new ArrayList<Tapahtuma>();
		tapahtumat = new ArrayList<Tapahtuma>();
		kurssit = new ArrayList<Kurssi>();
	}
	
	public ArrayList<Tapahtuma> getTentit() {
		return tentit;
	}

	public ArrayList<Tapahtuma> getTapahtumat() {
		return tapahtumat;
	}

	public ArrayList<Kurssi> getKurssit() {
		return kurssit;
	}
	
	
	/* Tulostaa yhteenvedon kursseista, KESKENERÄINEN */
	public void tulostaKurssit() {
		System.out.println("Suoritetut kurssit");
		for (int i = 0; i < kurssit.size(); i++) {
			System.out.println(kurssit.get(i).getNimi());
			}
	}

	public Tapahtuma etsiTentti(String nimi) {
		for (int i = 0; i < tentit.size(); i++) {
			if (nimi.equals(tentit.get(i).getNimi())) {
				return tentit.get(i);
			}
		}	
	return null;
	}
	
	public Kurssi etsiKurssi(String nimi) {
		for (int i = 0; i < kurssit.size(); i++) {
			if (nimi.equals(kurssit.get(i).getNimi())) {
				return kurssit.get(i);
			}
		}	
	return null;
	}
	
	public Tapahtuma etsiTapahtuma(String nimi) {
		for (int i = 0; i < tapahtumat.size(); i++) {
			if (nimi.equals(tapahtumat.get(i).getNimi())) {
				return tapahtumat.get(i);
			}
		}	
	return null;
	}

	public boolean addKurssi(Kurssi e) {
		return kurssit.add(e);
	}

	public boolean removeKurssi(Object o) {
		return kurssit.remove(o);
	}

	public boolean addTapahtuma(Tapahtuma e) {
		return tapahtumat.add(e);
	}

	public boolean removeTapahtuma(Object o) {
		return tapahtumat.remove(o);
	}

	public boolean addTentti(Tapahtuma e) {
		return tentit.add(e);
	}

	public boolean removeTentti(Object o) {
		return tentit.remove(o);
	}

}
