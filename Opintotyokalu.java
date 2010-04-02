
public class Opintotyokalu {
	public static void main(String[] args) {
		
		//luodaan käyttöliittymä olio
		Kayttoliittyma kali = new Kayttoliittyma();
		
		//luodaan tenttimuistutus olio
		Tenttimuistutus muistutus = new Tenttimuistutus();
		
		//tentti esimerkit
		String[] tentit = {
				"- Tietoliikenteen perusteet 19.3 klo: 16-20 salissa B123",
				"- Johdatus funktionaaliseen ohjelmointiin 30.3 klo: 16-19 salissa A111"
		};
		
		
		//tenttimuistutukset ennen varsinaisen ohjelman käynnistystä
		muistutus.muistuta(tentit);
		
		//käynnistetään käyttöliittymän päävalikko
		kali.paaValikko();
		
		
	}
}
