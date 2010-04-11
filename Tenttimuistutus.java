/**

 * Luokkakuvaus tÃ¤hÃ¤n jos jÃ¤Ã¤ aikaa
 * 
 * @author ryhmÃ¤?
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;


public class Tenttimuistutus {
	

	/**
	 * Muistuttaa tulevista tenteistï¿½
	 * @param tiedot
	 */
	public void muistuta(Keraaja tiedot) {
		
		int indeksi = 0;
		Tapahtuma lahinna = null;
		Tapahtuma tentti = null;
		
		//Tentit
		ArrayList<Tapahtuma> tentit;
		
		//Väliaikainen tietorakenne tenttien tulostamista varten
		ArrayList<Tapahtuma> temp = new ArrayList<Tapahtuma>();
		
		//Haetaan tentit kerääjästä
		tentit = tiedot.getTentit();
		
		//Kopioidaan tentit väliaikaiseen tietorakenteeseen
		for (int i = 0; i < tentit.size(); i++ ) {
			
			temp.add(tentit.get(i));
			
		}
		
		Scanner nappaimisto;
		tulostaVali(10);
		System.out.print("Huom!");
		
		tulostaVali(10);
		rivinvaihto(2);
		tulostaVali(5);
		
		System.out.print("Tulevat tentit:");
		tulostaVali(5);
		rivinvaihto(2);
		
		//	Järjestelmän tämän hetkinen aika.
		Date aika = new Date();
		
		
		// Poistetaan menneet tentit väliaikaisesta tietorakenteesta
		for (int i = 0; i < temp.size();  i++ ) {
			
			tentti = temp.get(i);
			
			if (tentti.getAlku().after(aika)) {
				
				temp.remove(i);
				
			}
			
		}
	
		//Tulostaa tulevat tentit aikajärjestyksessä niin, että etsii lähimpänä olevan
		//tentin poistaa sen tietorakenteesta ja tulostaa sen. Tätä jatketaan kunnes
		//tietorakenne on tyhjä.
		while (temp.isEmpty() == false) {
			
			lahinna = temp.get(0);
			
			//Käydään kaikki tentit läpi ja etsitään tentti johon on vähiten aikaa
			for (int i = 0; i < temp.size(); i++ ) {
			
				tentti = temp.get(i);
				
				//Jos löytyi tentti joka on lähempänä kuin edellinen lähin korvataan se.
				if (tentti.getAlku().before(lahinna.getAlku())) {
						
					lahinna = tentti;
					indeksi = i;
						
				}
			}
			
			//Poistetaan lähinnä oleva tentti väliaikaisesta tietorakenteesta
			temp.remove(indeksi);
			
			
			tulostaVali(1);
			//Tulostetaan kurssi johon tentti kuuluu
			System.out.println(lahinna.getKuuluuKurssiinNimelta());
			tulostaVali(1);
			//Tulostetaan tentin sijainti
			System.out.println(lahinna.getSijainti());
			tulostaVali(1);
			//Tulostetaan tentin alkamisaika muodossa "dd.MM. hh"
			DateFormat dateFormat = new SimpleDateFormat("dd.MM. hh");
			System.out.println(dateFormat.format(lahinna.getAlku().toString()));
			rivinvaihto(1);
			
			
			
		}
	
		rivinvaihto(1);
		tulostaVali(3);
		System.out.print("Paina enter jatkaaksesi!");
		
		tulostaVali(3);
		rivinvaihto(1);
		nappaimisto = new Scanner(System.in);
		
		//odottaa kunnes painetaan enter
		nappaimisto.nextLine();
		
		Kayttoliittyma.tyhjennaNakyma();
		
	}
	

	/**
	 * Tulostaa tyhjï¿½n vï¿½lin
	 * @param k
	 */
	public void tulostaVali(int k) {
		while (0 < k) {	
			System.out.print(" ");
			k--;
		}
	}
	
	/**
	 * Vaihtaa rivin
	 * @param k
	 */
	public void rivinvaihto(int k) {
		while(0 < k) {
			System.out.println("");
			k--;
		}
		
	}
}