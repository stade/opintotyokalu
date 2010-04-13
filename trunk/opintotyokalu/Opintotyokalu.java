package opintotyokalu;
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
		

		//Käyttöliittymän aloitusvalikko
		kali.aloitusValikko();

		//tenttimuistutukset
		Tenttimuistutus.muistuta(kali.getTiedot());

		//Käyttöliittymän päävalikko
		kali.paaValikko();

	}
}

