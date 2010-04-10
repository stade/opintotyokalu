/**

 * Luokkakuvaus t√§h√§n jos j√§√§ aikaa
 * 
 * @author ryhm√§?
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;
import java.util.Scanner;

public class Tenttimuistutus {
	

	/**
	 * Muistuttaa tulevista tenteistÔøΩ
	 * @param tiedot
	 */
	public void muistuta(Keraaja tiedot) {
		
		//Tentit
		ArrayList<Tapahtuma> tentit;
		
		//Haetaan tentit ker‰‰j‰st‰
		tentit = tiedot.getTentit();
		
		Scanner nappaimisto;
		tulostaVali(10);
		System.out.print("Huom!");
		
		tulostaVali(10);
		rivinvaihto(2);
		tulostaVali(5);
		
		System.out.print("Tulevat tentit:");
		tulostaVali(5);
		rivinvaihto(2);
		
		//J‰rjestelm‰n t‰m‰n hetkinen aika.
		Date aika = new Date();
	
		//Tulostaa tulevat tentit
		for (int i = 0; i < tentit.size(); i++ ) {
			
			Tapahtuma tentti = null;
			
			tentti = tentit.get(i);
			
			//Tulostaa tentti joita ei ole viel‰ pidetty
			if (tentti.getAlku().before(aika)) { 
			
				tulostaVali(1);
				//Tulostetaan Kurssi johon tentti kuuluu
				System.out.println(tentti.getKuuluuKurssiinNimelta());
				tulostaVali(1);
				//Tulostetaan tentin sijainti
				System.out.println(tentti.getSijainti());
				tulostaVali(1);
				//Tulostetaan tentin alkamisaika muodossa "dd.MM. hh"
				DateFormat dateFormat = new SimpleDateFormat("dd.MM. hh");
				System.out.println(dateFormat.format(tentti.getAlku().toString()));
				rivinvaihto(1);
			}	
			
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
	 * Tulostaa tyhjÔøΩn vÔøΩlin
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