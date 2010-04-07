/**
 * Luokkakuvaus tähän
 * @author ryhmä?
 *
 */
public class Kurssi {

	private String nimi;
	private int laajuus;
	private boolean suoritettu;

	/**
	 * 
	 * @param nimi
	 * @param laajuus
	 */
	public Kurssi(String nimi, int laajuus) {
		this.nimi = nimi;
		this.laajuus = laajuus;
		this.suoritettu = false;	// oletus: ei suoritettu (?)
	}

	/**
	 * 
	 * @param onko
	 */
	public void setSuoritettu(boolean onko) {
		this.suoritettu = onko;
	}

	/**
	 * 
	 * @return
	 */
	public String getNimi() {
		return this.nimi;
	}

	/**
	 * 
	 * @return
	 */
	public int getLaajuus() {
		return this.laajuus;
	}

	/**
	 * 
	 * @return
	 */
	public boolean getSuoritettu() {
		return this.suoritettu;
	}

}
