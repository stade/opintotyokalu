/**
 * Luokakuvaus tähän
 * 
 * @author Ryhmä?
 *
 */
public class Opintotyokalu {
	public static void main(String[] args) {
		
		//luodaan k�ytt�liittym� olio
		Kayttoliittyma kali = new Kayttoliittyma();
		
		//luodaan tenttimuistutus olio
		Tenttimuistutus muistutus = new Tenttimuistutus();
		
		
		//tenttimuistutukset ennen varsinaisen ohjelman k�ynnistyst�
		muistutus.muistuta(kali.getTiedot());
		
		//k�ynnistet��n k�ytt�liittym�n p��valikko
		kali.paaValikko();
		
	}
}

