/**
 * Luokkakuvaus tähän
 * @author ryhmä?
 */

import java.io.Serializable;
import java.util.ArrayList;

public class Keraaja implements Serializable {

	private ArrayList<Tapahtuma> tentit; // Tarviiko tenttien olla erikseen vai laitetaanko tapahtumataulukkoon
	private ArrayList<Tapahtuma> tapahtumat;
	private ArrayList<Kurssi> kurssit;

	/**
	 *
	 */
	public Keraaja(){
		this.tentit = new ArrayList<Tapahtuma>();
		this.tapahtumat = new ArrayList<Tapahtuma>();
		this.kurssit = new ArrayList<Kurssi>();
	}

	/**
	 *
	 * @return
	 */
	public ArrayList<Tapahtuma> getTentit() {
		return this.tentit;
	}

	/**
	 *
	 * @return
	 */
	public ArrayList<Tapahtuma> getTapahtumat() {
		return this.tapahtumat;
	}

	/**
	 *
	 * @return
	 */
	public ArrayList<Kurssi> getKurssit() {
		return this.kurssit;
	}


	/**
	 * Tulostaa yhteenvedon kursseista, KESKENERÄINEN
	 *
	 */
	public void tulostaKurssit() {
		System.out.println("Suoritetut kurssit");
		for (int i = 0; i < kurssit.size(); i++) {
			System.out.println(kurssit.get(i).getNimi());
		}
	}

	/**
	 *
	 * @param nimi
	 * @return
	 */
	public Tapahtuma etsiTentti(String nimi) {
		for (int i = 0; i < tentit.size(); i++) {
			if (nimi.equals(tentit.get(i).getNimi())) {
				return tentit.get(i);
			}
		}
		return null;
	}

	/**
	 *
	 * @param nimi
	 * @return
	 */
	public Kurssi etsiKurssi(String nimi) {
		for (int i = 0; i < kurssit.size(); i++) {
			if (nimi.equals(kurssit.get(i).getNimi())) {
				return kurssit.get(i);
			}
		}
		return null;
	}

	/**
	 *
	 * @param nimi
	 * @return
	 */
	public Tapahtuma etsiTapahtuma(String nimi) {
		for (int i = 0; i < tapahtumat.size(); i++) {
			if (nimi.equals(tapahtumat.get(i).getNimi())) {
				return tapahtumat.get(i);
			}
		}
		return null;
	}

	/**
	 *
	 * @param e
	 * @return
	 */
	public boolean addKurssi(Kurssi e) {
		return kurssit.add(e);
	}

	/**
	 *
	 * @param o
	 * @return
	 */
	public boolean removeKurssi(Object o) {
		return kurssit.remove(o);
	}

	/**
	 *
	 * @param e
	 * @return
	 */
	public boolean addTapahtuma(Tapahtuma e) {
		return tapahtumat.add(e);
	}

	/**
	 *
	 * @param o
	 * @return
	 */
	public boolean removeTapahtuma(Object o) {
		return tapahtumat.remove(o);
	}

	/**
	 *
	 * @param e
	 * @return
	 */
	public boolean addTentti(Tapahtuma e) {
		return tentit.add(e);
	}

	/**
	 *
	 * @param o
	 * @return
	 */
	public boolean removeTentti(Object o) {
		return tentit.remove(o);
	}

}
