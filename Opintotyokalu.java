/**
 * Luokakuvaus t�h�n
 *
 * @author Ryhm�
 *
 */
public class Opintotyokalu {
	public static void main(String[] args) {

		//luodaan k�ytt�liittym� olio
		Kayttoliittyma kali = new Kayttoliittyma();

		//luodaan tenttimuistutus olio
		Tenttimuistutus muistutus = new Tenttimuistutus();

		//K�ytt�liittym�n aloitusvalikko
		kali.aloitusValikko();

		//tenttimuistutukset
		muistutus.muistuta(kali.getTiedot());

		//K�ytt�liittym�n p��valikko
		kali.paaValikko();



	}
}

