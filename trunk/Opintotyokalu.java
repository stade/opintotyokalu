/**
 * Luokakuvaus tähän
 *
 * @author Ryhmä
 *
 */
public class Opintotyokalu {
	public static void main(String[] args) {

		//luodaan käyttöliittymä olio
		Kayttoliittyma kali = new Kayttoliittyma();

		//luodaan tenttimuistutus olio
		Tenttimuistutus muistutus = new Tenttimuistutus();

		//Käyttöliittymän aloitusvalikko
		kali.aloitusValikko();

		//tenttimuistutukset
		muistutus.muistuta(kali.getTiedot());

		//Käyttöliittymän päävalikko
		kali.paaValikko();



	}
}

