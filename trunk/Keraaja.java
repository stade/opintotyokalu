import java.io.Serializable;
import java.util.ArrayList;


public class Keraaja implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8333867660428826471L;
	private ArrayList<Tapahtuma> tentit;
	private ArrayList<Tapahtuma> tapahtumat;
	private ArrayList<Kurssi> kurssit;	
	
	public Keraaja(){
			
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
