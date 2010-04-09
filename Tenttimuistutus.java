/**
 * Luokkakuvaus t√§h√§n jos j√§√§ aikaa
 * 
 * @author ryhm√§?
 */

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
		
		
		
		//Tulostaa tulevat tentit
		for (int i = 0; i < tentit.size(); i++ ) {
			tulostaVali(1);
			System.out.print(tentit.get(i));
			tulostaVali(1);
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