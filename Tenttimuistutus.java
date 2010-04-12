/**

 * Luokkakuvaus tähän jos jää aikaa
 * 
 * @author ryhmä?
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;


public class Tenttimuistutus {

	/**
	 * Muistuttaa tulevista tenteist�
	 * @param tiedot
	 */
	public void muistuta(Keraaja tiedot) {
		
		int indeksi = 0;
		Tapahtuma lahinna = null;
		Tapahtuma tentti = null;
		
		//Tentit
		ArrayList<Tapahtuma> tentit;
		
		//V�liaikainen tietorakenne tenttien tulostamista varten
		ArrayList<Tapahtuma> temp = new ArrayList<Tapahtuma>();
		
		//Haetaan tentit ker��j�st�
		tentit = tiedot.getTentit();
		
		//J�rjestelm�n t�m�n hetkinen aika.
		Date aika = new Date();
		
		//Kopioidaan tentit v�liaikaiseen tietorakenteeseen
		for (int i = 0; i < tentit.size(); i++ ) {
			
			//Kopioidaan vain tulevat tentit.
			if (tentit.get(i).getAlku().after(aika)) {
				temp.add(tentit.get(i));
			}
			
			
		}
		
		Scanner nappaimisto;
		Kayttoliittyma.tyhjennaNakyma();
		tulostaVali(10);
		System.out.print("Huom!");
		
		tulostaVali(10);
		rivinvaihto(2);
		tulostaVali(5);
		
		System.out.print("Tulevat tentit:");
		tulostaVali(5);
		rivinvaihto(2);
		
	
		//Tulostaa tulevat tentit aikaj�rjestyksess� niin, ett� etsii l�himp�n� olevan
		//tentin poistaa sen tietorakenteesta ja tulostaa sen. T�t� jatketaan kunnes
		//tietorakenne on tyhj�.
		while (temp.isEmpty() == false) {
			
			lahinna = temp.get(0);
			
			if (indeksi >= temp.size()) {
				
				break;
				
			}
			
			//K�yd��n kaikki tentit l�pi ja etsit��n tentti johon on v�hiten aikaa
			for (int i = 0; i < temp.size(); i++ ) {
			
				tentti = temp.get(i);
				
				//Jos l�ytyi tentti joka on l�hemp�n� kuin edellinen l�hin korvataan se.
				if (tentti.getAlku().after(lahinna.getAlku())) {
					lahinna = tentti;
					indeksi = i;
				}
			}
			
			//Poistetaan l�hinn� oleva tentti v�liaikaisesta tietorakenteesta
			temp.remove(indeksi);
			tulostaVali(1);
			
			//Tulostetaan kurssi johon tentti kuuluu
			System.out.print(lahinna.getKuuluuKurssiinNimelta());
			tulostaVali(1);
			
			//Tulostetaan tentin sijainti
			System.out.print(lahinna.getSijainti());
			tulostaVali(1);
			
			//Tulostetaan tentin alkamisaika muodossa "dd.MM. hh"
			DateFormat dateFormat = new SimpleDateFormat("dd.MM. 'klo' hh");
			System.out.print(dateFormat.format(lahinna.getAlku()));
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
	 * Tulostaa tyhj�n v�lin
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