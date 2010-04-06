
public class Kurssi {

	private String nimi;
	private int laajuus;
	private boolean suoritettu;

	public Kurssi(String nimi, int laajuus) {
		this.nimi = nimi;
		this.laajuus = laajuus;
		this.suoritettu = false;	// oletus: ei suoritettu (?)
	}

	public void setSuoritettu(boolean onko) {
		this.suoritettu = onko;
	}

	public String getNimi() {
		return this.nimi;
	}

	public int getLaajuus() {
		return this.laajuus;
	}

	public boolean getSuoritettu() {
		return this.suoritettu;
	}

}
