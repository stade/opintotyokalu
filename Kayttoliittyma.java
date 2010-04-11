/**
 * Luokkakuvaus tähän
 * @author ryhmä?
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *	K�ytt�liittym�-luokka luo tekstipohjaiset valikot ja mahdollistaa niiss� liikkumisen.
 */
public class Kayttoliittyma {
	
	private SimpleDateFormat paivaysMalli; // yhteinen malli p�iv�m��rille
	private Keraaja tiedot;
	private SaverLoader saveLoad = new SaverLoader();
		
	public Kayttoliittyma() {
		 this.paivaysMalli = new SimpleDateFormat("dd.MM.yy HH");	//K�ytt�j� sy�tt�� ajat t�ss� muodossa
		 this.tiedot = new Keraaja();
	}
	/**
	 * 
	 * @return
	 */
	public Keraaja getTiedot() {
		return this.tiedot;
	}
	
		
	/**
	 * 	Siirt�� alavalikkoon p��valikosta annetun valintanumeron mukaan.
	 * 	Palauttaa 1, jos virheellinen valinta. 0 jos halutaan poistua ohjelmasta.
	 * 
	 *	@param valintanum
	 *	@return 
	 */
	
	
	
	public int valintaAloitusValikko(int valintanum) {
		
		switch (valintanum) {
	       
	        case 1: avaaTiedostostaValikko();     		break;
	        case 2: return 0;
	        default : System.out.println("Virheellinen sy�te");  return 1;
	        
		}	
		return 0;
	}
	public int valintaPaaValikko(int valintanum) {
		
		switch (valintanum) {
	       
	        case 1: kurssiValikko();     			break;
	        case 2: tenttiValikko();    			break;
	        case 3: raporttiValikko();   			break;
	        case 4: tallennaValikko();				break;
	        case 0: lopetusValikko();	 return 0;
	        default : System.out.println("Virheellinen sy�te");  return 1;
	        
		}	
		return 0;
	}
	
	/**
	 * Siirt�� alavalikkoon tai p��valikkoon kurssivalikosta annetun 
	 * valintanumeron mukaan. Palauttaa 1, jos virheellinen valinta.
	 * 
	 * @param valintanum
	 * @return int
	 */
	public int valintaKurssiValikko(int valintanum) {
	
		switch (valintanum) {
	       
	        case 1: lisaaKurssiValikko();     	break;
	        case 2: muokkaaKurssiValikko();    	break;
	        case 3: poistaKurssiValikko();   	break;
	        case 0: paaValikko();				break;
	        default : System.out.println("Virheellinen sy�te");  return 1;
		}
		return 0;
	}
	
	/**
	 *	Siirt�� alavalikkoon tai p��valikkoon tenttivalikosta annetun 
	 *  valintanumeron mukaan. Palauttaa 1, jos virheellinen valinta.
	 *  
	 *  @param valintanum
	 *  @return
	 */
	public int valintaTenttiValikko(int valintanum) {
	
		switch (valintanum) {
	       
	        case 1: lisaaTenttiValikko();     	break;
	        case 2: muokkaaTenttiValikko();    	break;
	        case 3: poistaTenttiValikko();   	break;
	        case 0: paaValikko();				break;
	        default : System.out.println("Virheellinen sy�te");  return 1;

		}
		return 0;
		
	}
	
	/**
	 *	Siirt�� alavalikkoon tai p��valikkoon raporttivalikosta annetun 
	 * 	valintanumeron mukaan. Palauttaa 1, jos virheellinen valinta.
	 * 
	 * @param valintanum
	 * @return
	 */
	public int valintaRaporttiValikko(int valintanum) {
	
		switch (valintanum) {
	       
	        case 1: tulostaKurssitValikko();     	break;
	        case 2: tulostaLukkariValikko();    	break;
	        case 0: paaValikko();					break;
	        default : System.out.println("Virheellinen sy�te");  return 1;

		}
		return 0;
		
	}
	
	/**
	 *	Siirt�� alavalikkoon tai p��valikkoon tallennavalikosta annetun 
	 *  valintanumeron mukaan. Palauttaa 1, jos virheellinen valinta.
	 *  
	 *  @param valintanum
	 *  @return
	 */
	public int valintaTallennaValikko(int valintanum) {
	
		switch (valintanum) {
	       
	        case 1: tallennaTiedostoonValikko();		break;
	        case 2: avaaTiedostostaValikko();			break;
	        case 0: paaValikko();						break;
	        default : System.out.println("Virheellinen sy�te");  return 1;

		}
		return 0;
	}
	
	/**
	 *	Muokataan kursseja tai siirryt��n kurssivalikkoon kurssien muokkausvalikosta 
	 *  annetun valintanumeron mukaan.
	 *  
	 *  @param valintanum käyttäjän valitseman toiminnon numero
	 *  @return Palauttaa 1, jos virheellinen valinta.
	 */
	public int valintaKurssiMuokkausValikko(int valintanum) {
		
			if (valintanum == 0) {
			kurssiValikko();
			return 0;
		}
		else if (valintanum > 0 && valintanum <= this.tiedot.getKurssit().size()) {
			tietynKurssinMuokkausValikko(valintanum-1); // Kurssien numerot valikossa alkavat 1:st�, ArrayListiss� 0:sta, siisp� v�hennet��n yksi
			kurssiValikko();
			return 0;
		}
		else {System.out.println("Virheellinen sy�te");  return 1;}
	}	
		
	/**
	 *	Poistetaan kursseja tai siirryt��n kurssivalikkoon kurssien poistovalikosta 
	 *  annetun valintanumeron mukaan.
	 *  
	 *  @param valintanum käyttäjän valitseman toiminnon numero
	 *  @return Palauttaa 1, jos virheellinen valinta.
	 */
	public int valintaKurssiPoistoValikko(int valintanum) {
		
		// t�h�n parempi virheenk�sittely esim isInteger
		
		if (valintanum == 0) {
			kurssiValikko();
			return 0;
		}
		else if (valintanum > 0 && valintanum <= this.tiedot.getKurssit().size()) {
			this.tiedot.getKurssit().remove(valintanum-1); // Kurssien numerot valikossa alkavat 1:st�, ArrayListiss� 0:sta, siisp� v�hennet��n yksi
			kurssiValikko();
			return 0;
		}
		else {System.out.println("Virheellinen sy�te");  return 1;}
	}	
	
	/**
	 * 
	 * @param valintanum
	 * @return
	 */
	public int valintaTenttiMuokkausValikko(int valintanum) {
		
		switch (valintanum) {
	        //Keskener�inen ei toimintoja
	        case 1: System.out.print("t�st� 1. tentin muokkaus");     	break;
	        case 2: System.out.print("t�st� 2. tentin muokkaus");     	break;
	        case 3: System.out.print("t�st� 3. tentin muokkaus");   	break;
	        case 4: System.out.print("t�st� lis�� tenttej�");			break;
	        case 0: tenttiValikko();									break;
	        default : System.out.println("Virheellinen sy�te");  return 1;

		}
		return 0;
		
	}
	
	/**
	 * 
	 * @param valintanum
	 * @return
	 */
	public int valintaTenttiPoistoValikko(int valintanum) {
		
	// t�h�n parempi virheenk�sittely esim isInteger
		
		if (valintanum == 0) {
			tenttiValikko();
			return 0;
		}
		else if (valintanum > 0 && valintanum <= this.tiedot.getTentit().size()) {
			this.tiedot.getTentit().remove(valintanum-1); // Tenttien numerot valikossa alkavat 1:st�, ArrayListiss� 0:sta, siisp� v�hennet��n yksi
			tenttiValikko();
			return 0;
		}
		else {System.out.println("Virheellinen sy�te");  return 1;}
	}	
	public int valintaLopetusValikko(int valintanum) {
		
		switch (valintanum) {
	       
	        case 1: tallennaTiedostoonValikko();		break;
	        case 2: System.out.println("N�kemiin!");	return 0;
	        case 0: paaValikko();						break;
	        default : System.out.println("Virheellinen sy�te");  return 1;

		}
		return 0;
	}
	
	
	
	public void aloitusValikko() {
		
		int valintanum;
		Scanner nappaimisto;
		
		tyhjennaNakyma();
		System.out.println("Opintoty�kalu");
		System.out.println("");
		System.out.println("1. Lataa tiedot");
		System.out.println("");
		System.out.println("2. Aloita lataamatta tietoja");
		System.out.println("");
		System.out.print("Valinta:");
		
		nappaimisto = new Scanner(System.in);
		
		//Kysyt��n sy�tett� niin kauan kunnes annetaan kokonaislukusy�te
		while(nappaimisto.hasNextInt() != true) {
			
			System.out.println("Virheellinen sy�te");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
			
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysyt��n valikkonumeroa kunnes se on oikea
		while(valintaAloitusValikko(valintanum) == 1) {
			  
			System.out.print("Valinta:");
			nappaimisto = new Scanner(System.in);
			
			//Kysyt��n sy�tett� niin kauan kunnes annetaan kokonaislukusy�te
			while(nappaimisto.hasNextInt() != true) {
					
				System.out.println("Virheellinen sy�te");
				System.out.println("");
				System.out.print("Valinta:");
					
				nappaimisto = new Scanner(System.in);	
					
			}
			valintanum = nappaimisto.nextInt(); 	
		}
	}
	/**
	 *	K�ytt�liittym�n p��valikko.
	 */
	public void paaValikko() {
		
		int valintanum;
		Scanner nappaimisto;
		
		tyhjennaNakyma();
		System.out.println("Opintoty�kalu");
		System.out.println("");
		System.out.println("1. Hallinnoi kursseja");
		System.out.println("");
		System.out.println("2. Hallinnoi tenttej�");
		System.out.println("");
		System.out.println("3. Tulosta raportteja");
		System.out.println("");
		System.out.println("4. Tallenna tai lataa");
		System.out.println("");
		System.out.println("0. Poistu sovelluksesta");
		System.out.println("");
		System.out.print("Valinta:");
		
		nappaimisto = new Scanner(System.in);
		
		//Kysyt��n sy�tett� niin kauan kunnes annetaan kokonaislukusy�te
		while(nappaimisto.hasNextInt() != true) {
			
			System.out.println("Virheellinen sy�te");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
			
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysyt��n valikkonumeroa kunnes se on oikea
		while(valintaPaaValikko(valintanum) == 1) {
			  
			System.out.print("Valinta:");
			nappaimisto = new Scanner(System.in);
			
			//Kysyt��n sy�tett� niin kauan kunnes annetaan kokonaislukusy�te
			while(nappaimisto.hasNextInt() != true) {
					
				System.out.println("Virheellinen sy�te");
				System.out.println("");
				System.out.print("Valinta:");
					
				nappaimisto = new Scanner(System.in);	
					
			}
			valintanum = nappaimisto.nextInt(); 	
		}
	}
	
	/**
	 *	K�ytt�liittym�n kurssivalikko.
	 */
	public void kurssiValikko() {
		
		
		int valintanum;
		Scanner nappaimisto;
		
		tyhjennaNakyma();
		System.out.println("Opintoty�kalu - Hallinoi kursseja");
		System.out.println("");
		System.out.println("1. Lis�� kursseja");
		System.out.println("");
		System.out.println("2. Muokkaa kursseja");
		System.out.println("");
		System.out.println("3. Poista kursseja");
		System.out.println("");
		System.out.println("0. Palaa takaisin");
		System.out.println("");
		System.out.println("");
		System.out.print("Valinta:");
		
		nappaimisto = new Scanner(System.in);
		
		//Kysyt��n sy�tett� niin kauan kunnes annetaan kokonaislukusy�te
		while(nappaimisto.hasNextInt() != true) {
			
			System.out.println("Virheellinen sy�te");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
			
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysyt��n valikkonumeroa kunnes se on oikea
		while(valintaKurssiValikko(valintanum) == 1) {
			  
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);
			  
			//Kysyt��n sy�tett� niin kauan kunnes annetaan kokonaislukusy�te
			while(nappaimisto.hasNextInt() != true) {
				System.out.println("Virheellinen sy�te");
				System.out.println("");
				System.out.print("Valinta:");
					
				nappaimisto = new Scanner(System.in);		
			}
			valintanum = nappaimisto.nextInt(); 	
		}
	}
	
	/**
	 *	K�ytt�liittym�n tenttivalikko.
	 */
	public void tenttiValikko() {
		
		int valintanum;
		Scanner nappaimisto;
		
		tyhjennaNakyma();
		System.out.println("Opintoty�kalu - Hallinnoi tenttej�");
		System.out.println("");
		System.out.println("1. Lis�� tenttej�");
		System.out.println("");
		System.out.println("2. Muokkaa tenttej�");
		System.out.println("");
		System.out.println("3. Poista tenttej�");
		System.out.println("");
		System.out.println("0. Palaa takaisin");
		System.out.println("");
		System.out.println("");
		System.out.print("Valinta:");
		
		nappaimisto = new Scanner(System.in);
		
		//Kysyt��n sy�tett� niin kauan kunnes annetaan kokonaislukusy�te
		while(nappaimisto.hasNextInt() != true) {
			
			System.out.println("Virheellinen sy�te");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
			
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysyt��n valikkonumeroa kunnes se on oikea
		while(valintaTenttiValikko(valintanum) == 1) {
			System.out.print("Valinta:");
			nappaimisto = new Scanner(System.in);
			
			//Kysyt��n sy�tett� niin kauan kunnes annetaan kokonaislukusy�te
			while(nappaimisto.hasNextInt() != true) {
				System.out.println("Virheellinen sy�te");
				System.out.println("");
				System.out.print("Valinta:");
					
				nappaimisto = new Scanner(System.in);		
			}
			valintanum = nappaimisto.nextInt(); 	
		}
	}
		
	/**
	 *	K�ytt�liittym�n raporttivalikko.
	 */
	public void raporttiValikko() {
		
		int valintanum;
		Scanner nappaimisto;
		
		tyhjennaNakyma();
		System.out.println("Opintoty�kalu - Tulosta raportteja");
		System.out.println("");
		System.out.println("1. Tulosta suoritetut kurssit");
		System.out.println("");
		System.out.println("2. Tulosta lukuj�rjestys");
		System.out.println("");
		System.out.println("0. Palaa takaisin");
		System.out.println("");
		System.out.println("");
		System.out.print("Valinta:");
		nappaimisto = new Scanner(System.in);
		
		//Kysyt��n sy�tett� niin kauan kunnes annetaan kokonaislukusy�te
		while(nappaimisto.hasNextInt() != true) {
			
			System.out.println("Virheellinen sy�te");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
			
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysyt��n valikkonumeroa kunnes se on oikea
		while(valintaRaporttiValikko(valintanum) == 1) {
			System.out.print("Valinta:");
			nappaimisto = new Scanner(System.in);
			
			//Kysyt��n sy�tett� niin kauan kunnes annetaan kokonaislukusy�te
			while(nappaimisto.hasNextInt() != true) {
				System.out.println("Virheellinen sy�te");
				System.out.println("");
				System.out.print("Valinta:");
					
				nappaimisto = new Scanner(System.in);		
			}
			valintanum = nappaimisto.nextInt(); 	
		}
	}
		
	/**
	 *	K�ytt�liittym�n tallennusvalikko.
	 */
	public void tallennaValikko() {
		
		int valintanum;
		Scanner nappaimisto;
		
		tyhjennaNakyma();
		System.out.println("Opintoty�kalu - Tallenna tai lataa");
		System.out.println("");
		System.out.println("1. Tallenna tiedostoon");
		System.out.println("");
		System.out.println("2. Lataa tiedostosta");
		System.out.println("");
		System.out.println("0. Palaa takaisin");
		System.out.println("");
		System.out.println("");
		System.out.print("Valinta:");
		nappaimisto = new Scanner(System.in);
		
		//Kysyt��n sy�tett� niin kauan kunnes annetaan kokonaislukusy�te
		while(nappaimisto.hasNextInt() != true) {
			
			System.out.println("Virheellinen sy�te");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
			
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysyt��n valikkonumeroa kunnes se on oikea
		while(valintaTallennaValikko(valintanum) == 1) { 
			System.out.print("Valinta:");
			nappaimisto = new Scanner(System.in);
			
			//Kysyt��n sy�tett� niin kauan kunnes annetaan kokonaislukusy�te
			while(nappaimisto.hasNextInt() != true) {
				System.out.println("Virheellinen sy�te");
				System.out.println("");
				System.out.print("Valinta:");
					
				nappaimisto = new Scanner(System.in);			
			}
			valintanum = nappaimisto.nextInt(); 	
		}
	}
	
	/**
	 * 
	 */
	public void lisaaTenttiValikko() {
	Scanner nappaimisto;
		
		//N�m� korvataan oikeilla tietotyypeill�
		String tenttinimi;
		String luento;
		
		tyhjennaNakyma();
		System.out.println("Opintoty�kalu - Tentin lis�ys");
		System.out.println("");
		System.out.print("Anna tentin nimi: ");
	
		nappaimisto = new Scanner(System.in);
		tenttinimi = nappaimisto.nextLine();
		
		tyhjennaNakyma();
		System.out.println("Opintoty�kalu - Tentin lis�ys");
		System.out.println("");
		System.out.println(tenttinimi);
		System.out.println("");
		System.out.println("Anna tentin ajankohta esim. 16.12. 10-12");
		//System.out.println(paivaysMalli.toPattern() + ""); huono tapa ilmoittaa
        System.out.print("Tentin Ajankohta: ");
        
        nappaimisto = new Scanner(System.in);
        luento = nappaimisto.nextLine();
        
        tyhjennaNakyma();
		System.out.println("Opintoty�kalu - Tenttien lis�ys");
		System.out.println("");
		System.out.println(tenttinimi);
		System.out.println(luento);
		System.out.println("");
        System.out.print("Paina enter palataksesi takaisin");
        
        nappaimisto = new Scanner(System.in);
        nappaimisto.nextLine();
        
        //lisätään tentti kerääjään.
        Tapahtuma lisattyTapahtuma = new Tapahtuma(tenttinimi);
        this.tiedot.addTentti(lisattyTapahtuma);
        
        //Ajan parseaminen k�ytt�j�n sy�tteest� ja sen lis��minen tapahtumaan
        String[] parametrit = luento.split(" ");
        String aika1 = parametrit[0];
        String aika2 = parametrit[0];
        String[] tunnit = luento.split("-");
        aika1 += " " + tunnit[0].charAt(tunnit[0].length()-2);
        aika1 += tunnit[0].charAt(tunnit[0].length()-1);
        aika2 += " " + tunnit[1].charAt(0);
        aika2 += tunnit[1].charAt(1);
        
        lisattyTapahtuma.setAlku(parseKayttajanAntamaAika(aika1));
        lisattyTapahtuma.setLoppu(parseKayttajanAntamaAika(aika2));
         
        //Palataan tenttivalikkoon.
        tenttiValikko();

	}
	
	/**
	 * 
	 */
	public void muokkaaTenttiValikko() {
		
		
		Scanner nappaimisto;
		int valintanum;
		
		tyhjennaNakyma();
		System.out.println("Opintoty�kalu � Tenttien muokkaus");
		System.out.println("");
		System.out.println("Muokkaa");
		
		System.out.println("1. Tentti 1.");
		System.out.println("2. Tentti 2.");
		System.out.println("3. Tentti 3.");
		System.out.println("4. Lis�� tenttej�");
		System.out.println("0. Palaa takaisin");
		System.out.println("");
		System.out.print("Valinta:");
		
		nappaimisto = new Scanner(System.in);
		
		//Kysyt��n sy�tett� niin kauan kunnes annetaan kokonaislukusy�te
		while(nappaimisto.hasNextInt() != true) {
			
			System.out.println("Virheellinen sy�te");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
			
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysyt��n valikkonumeroa kunnes se on oikea
		while(valintaTenttiMuokkausValikko(valintanum) == 1) {
			System.out.print("Valinta:");
			nappaimisto = new Scanner(System.in);
			  
			//Kysyt��n sy�tett� niin kauan kunnes annetaan kokonaislukusy�te
			while(nappaimisto.hasNextInt() != true) {
				System.out.println("Virheellinen sy�te");
				System.out.println("");
				System.out.print("Valinta:");
					
				nappaimisto = new Scanner(System.in);			
			}
			valintanum = nappaimisto.nextInt(); 	
		}		
	}
	
	/**
	 * 
	 */
	public void poistaTenttiValikko() {
		
		Scanner nappaimisto;
		int valintanum;
		
		ArrayList<Tapahtuma> tentit = this.tiedot.getTentit();
		
		tyhjennaNakyma();
		System.out.println("Opintoty�kalu � Tenttien poisto");
		System.out.println("");
		System.out.println("Poista");
		
		for(int i =0;i<tentit.size();i++) {
			  System.out.println(i+1 + ". " + tentit.get(i).getNimi()); 
					  }		
		System.out.println("0. Palaa takaisin");
		System.out.println("");
		System.out.print("Valinta:");
		
		nappaimisto = new Scanner(System.in);
		
		//Kysyt��n sy�tett� niin kauan kunnes annetaan kokonaislukusy�te
		while(nappaimisto.hasNextInt() != true) {
			
			System.out.println("Virheellinen sy�te");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
			
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysyt��n valikkonumeroa kunnes se on oikea
		while(valintaTenttiPoistoValikko(valintanum) == 1) {
			System.out.print("Valinta:");
			nappaimisto = new Scanner(System.in);
			  
			//Kysyt��n sy�tett� niin kauan kunnes annetaan kokonaislukusy�te
			while(nappaimisto.hasNextInt() != true) {
				System.out.println("Virheellinen sy�te");
				System.out.println("");
				System.out.print("Valinta:");
					
				nappaimisto = new Scanner(System.in);	
					
			}
			valintanum = nappaimisto.nextInt(); 	
		}		
	}
	
	/**
	 *	K�ytt�liittym�n kurssin lis�ysvalikko. Ei k�yt� viel� oikeita tietorakenteita. 
	 *  Tapahtumien lis�yksen toteutus vajaa. Ei virheellisten sy�tteiden k�sittely�
	 */
	public void lisaaKurssiValikko() {
		
		Scanner nappaimisto;
		
		//N�m� korvataan oikeilla tietotyypeill�
		String kurssinimi;
		int op;
		String luento;
		ArrayList<Tapahtuma> uudetTapahtumat = new ArrayList<Tapahtuma>();
		Tapahtuma uusiTapahtuma;
		
		Date currenttime = new Date(System.currentTimeMillis());
		DateFormat dateFormat = new SimpleDateFormat("yy");
		
		
		tyhjennaNakyma();
		System.out.println("Opintoty�kalu - Kurssin lis�ys");
		System.out.println("");
		System.out.print("Anna kurssin nimi: ");
	
		nappaimisto = new Scanner(System.in);
		kurssinimi = nappaimisto.nextLine();
		
		tyhjennaNakyma();
		System.out.println("Opintoty�kalu - Kurssin lis�ys");
		System.out.println("");
		System.out.println(kurssinimi);
		System.out.println("");
		System.out.print("Anna kurssin laajuus opintopistein�: ");
		
		nappaimisto = new Scanner(System.in);
		op = nappaimisto.nextInt();
		
	
		//Loopataan kunnes tyhja sy�te. N�in voidaan lis�t� useampia tapahtumia per�kk�in.
		
		do {
		tyhjennaNakyma();
		System.out.println("Opintoty�kalu - Kurssien lis�ys");
		System.out.println("");
		System.out.println(kurssinimi);
		System.out.println(op + "op");
	
		//tulostetaan lis�tyt tapahtumat
		
		for(int i=0;i<uudetTapahtumat.size();i++){ 
			System.out.println(uudetTapahtumat.get(i).getNimi());
		}
		
		System.out.println("");
		
		System.out.println("Anna kurssin opetustiedot pilkulla erottaen esim.");
		System.out.println("16.7. 10-12 Harjoitukset");
        System.out.println("Voit sy�tt�� useampia aikoja, mutta vain yhden kerrallaan. Tyhj� sy�te lopettaa.");
        System.out.print("Opetusajat: ");
        
        nappaimisto = new Scanner(System.in);
        luento = nappaimisto.nextLine();
        
        if(luento.equals("")) break;
        
        //lisätään kurssi kerääjään.
        Kurssi lisattyKurssi = new Kurssi(kurssinimi, op);
        this.tiedot.addKurssi(lisattyKurssi);
               
        uusiTapahtuma = new Tapahtuma(luento);
        uusiTapahtuma.setKuuluuKurssiinNimelta(lisattyKurssi.getNimi());
        
        Date[] taulukkoAjoista = palautaStringDatena(luento);        
        uusiTapahtuma.setAlku(taulukkoAjoista[0]);
        uusiTapahtuma.setLoppu(taulukkoAjoista[1]);
        
        String[] parametrit = luento.split(" ", 3);
        
        //Viimeinen parametri on tapahtuman nimi, jos parametrej� ei ole tarpeeksi, s�ilyy nimen� k�ytt�j�n sy�te.
        if(parametrit.length > 2) uusiTapahtuma.setNimi(parametrit[2]);
        
        this.tiedot.getTapahtumat().add(uusiTapahtuma);
        uudetTapahtumat.add(uusiTapahtuma);
      
		} while (!luento.equals(""));
		
        tyhjennaNakyma();
		System.out.println("Opintoty�kalu - Kurssien lis�ys");
		System.out.println("");
		System.out.println(kurssinimi);
		System.out.println(op + "op");
		System.out.println(luento);
		System.out.println("");
        System.out.print("Paina enter palataksesi takaisin");
        
        nappaimisto = new Scanner(System.in);
        nappaimisto.nextLine();
        
        //Palataan kurssivalikkoon.
        kurssiValikko();

	}
	
	/**
	 *	Muuttaa k�ytt�j�n String muodossa antaman ajan Date-olioksi ja palauttaa sen.
	 *  Ei toteutettu virheenhallintaa kunnolla!
	 */
	
	public Date parseKayttajanAntamaAika(String str){
		Date aika = null;
		try {
			aika = paivaysMalli.parse(str);
		} catch (ParseException e) {
			System.out.println("ERROR");
			e.printStackTrace();
			return null;
		}
		
		return aika;
	}
	
	/**
	 *	K�ytt�liittym�n kurssin muokkausvalikko. Keskener�inen.  
	 */
	public void muokkaaKurssiValikko() {
		
		Scanner nappaimisto;
		int valintanum;
		
		ArrayList<Kurssi> kurssit = this.tiedot.getKurssit();
		
		tyhjennaNakyma();
		System.out.println("Opintoty�kalu � Kurssien poisto");
		System.out.println("");
		System.out.println("Poista");

		
		tyhjennaNakyma();
		System.out.println("Opintoty�kalu � Kurssien muokkaus");
		System.out.println("");
		System.out.println("Muokkaa");
		
		for(int i =0;i<kurssit.size();i++) {
			  System.out.println(i+1 + ". " + kurssit.get(i).getNimi()); 
					  }		
		
		System.out.println("0. Palaa takaisin");
		System.out.println("");
		System.out.print("Valinta:");
		
		nappaimisto = new Scanner(System.in);
		
		//Kysyt��n sy�tett� niin kauan kunnes annetaan kokonaislukusy�te
		while(nappaimisto.hasNextInt() != true) {
			System.out.println("Virheellinen sy�te");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysyt��n valikkonumeroa kunnes se on oikea
		while(valintaKurssiMuokkausValikko(valintanum) == 1) {
			System.out.print("Valinta:");
			nappaimisto = new Scanner(System.in);
			  
			//Kysyt��n sy�tett� niin kauan kunnes annetaan kokonaislukusy�te
			while(nappaimisto.hasNextInt() != true) {
				System.out.println("Virheellinen sy�te");
				System.out.println("");
				System.out.print("Valinta:");
					
				nappaimisto = new Scanner(System.in);		
			}
			valintanum = nappaimisto.nextInt(); 	
		}
	}
	
	/**
	 *	K�ytt�liittym�n kurssin poistovalikko. Keskener�inen.  
	 */
	public void poistaKurssiValikko() {
		
		Scanner nappaimisto;
		int valintanum;
		
			
		ArrayList<Kurssi> kurssit = this.tiedot.getKurssit();
		
		tyhjennaNakyma();
		System.out.println("Opintoty�kalu � Kurssien poisto");
		System.out.println("");
		System.out.println("Poista");
		for(int i =0;i<kurssit.size();i++) {
		  System.out.println(i+1 + ". " + kurssit.get(i).getNimi()); 
				  }		

		System.out.println(kurssit.size()+1 + ". Lis�� kursseja");
		System.out.println("0. Palaa takaisin");
		System.out.println("");
		System.out.print("Valinta:");
		
		nappaimisto = new Scanner(System.in);
		
		//Kysyt��n sy�tett� niin kauan kunnes annetaan kokonaislukusy�te
		while(nappaimisto.hasNextInt() != true) {
			System.out.println("Virheellinen sy�te");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysyt��n valikkonumeroa kunnes se on oikea
		while(valintaKurssiPoistoValikko(valintanum) == 1) {
			System.out.print("Valinta:");
			nappaimisto = new Scanner(System.in);
			  
			//Kysyt��n sy�tett� niin kauan kunnes annetaan kokonaislukusy�te
			while(nappaimisto.hasNextInt() != true) {
				System.out.println("Virheellinen sy�te");
				System.out.println("");
				System.out.print("Valinta:");
					
				nappaimisto = new Scanner(System.in);		
			}
			valintanum = nappaimisto.nextInt(); 	
		}
	}
	
	/**
	 * 
	 */
	public void tulostaKurssitValikko() {
		Exporter.printCourses();
		this.raporttiValikko();
	}
	
	/**
	 * 
	 */
	public void tulostaLukkariValikko() {
		Exporter.printTimetable();
		this.raporttiValikko();
	}
	
	/**
	 *	Tallentaan tiedostoon annetun tiedostopolun mukaan.   
	 */
	public void tallennaTiedostoonValikko() {
		
		Scanner nappaimisto;
		
		//N�m� korvataan oikeilla tietotyypeill�
		String tallennuspolku;
		
		tyhjennaNakyma();
		System.out.println("Opintoty�kalu - Tallennus tiedostoon");
		System.out.println("");
		System.out.println("Sy�t� tiedostonimi ja paina enter.");
		System.out.println("");
		System.out.print("Tiedostonimi: ");
	
		nappaimisto = new Scanner(System.in);
		tallennuspolku = nappaimisto.nextLine();
		
		//T�ss� tallennetaan annetun tiedostonimen perusteella
		if (this.saveLoad.saveObject(this.tiedot, tallennuspolku)) {
			System.out.println("Tallentaminen onnistui!");
		}
		else {
			System.out.println("Tallentaminen epäonnistui.");
		}
		
		//palataan päävalikkoon
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		paaValikko();
		
	}
	
	/**
	 *	Avaa tiedoston annetun tiedostopolun mukaan.   
	 */
	public void avaaTiedostostaValikko() {
		
		Scanner nappaimisto;
		
		//N�m� korvataan oikeilla tietotyypeill�
		String avauspolku;
		
		tyhjennaNakyma();
		System.out.println("Opintoty�kalu - Tiedostosta avaaminen");
		System.out.println("");
		System.out.println("Sy�t� tiedostonimi ja paina enter.");
		System.out.println("");
		System.out.print("Tiedostonimi: ");
	
		nappaimisto = new Scanner(System.in);
		avauspolku = nappaimisto.nextLine();
		
		//T�ss� avataan tiedostosta annetun tiedostonimen perusteella
		this.tiedot = (Keraaja)this.saveLoad.loadObject(avauspolku);
		if (!(this.tiedot instanceof Keraaja)) {
			System.out.println("Lataaminen epäonnistui!");
		}
		else {
			System.out.println("Lataaminen onnistui!");
		}
		
		//palataan päävalikkoon ja nukutaan sekunti jotta palaute näkyy käyttäjälle
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		paaValikko();
		
	}
	
	public void tietynKurssinMuokkausValikko(int kurssiIndeksi) {
		ArrayList<Kurssi> kurssit = this.tiedot.getKurssit();
		ArrayList<Tapahtuma> tapahtumat = this.tiedot.getTapahtumat();
		ArrayList<Tapahtuma> tentit = this.tiedot.getTentit();

		Scanner nappaimisto;
		int valintanum;
		ArrayList<Tapahtuma> valikonTapahtumat = new ArrayList<Tapahtuma>();
		
		tyhjennaNakyma();
		System.out.println("Opintoty�kalu �  Kurssin muokkaus");
		System.out.println("");
		System.out.println("Muokkaa");
		
		System.out.println("1." + kurssit.get(kurssiIndeksi).getNimi());
		System.out.println("2." + kurssit.get(kurssiIndeksi).getLaajuus());
		
		String kurssinNimi = kurssit.get(kurssiIndeksi).getNimi();
		for(int i= 0;i <tapahtumat.size();i++) {
			if(kurssinNimi.equals(tapahtumat.get(i).getKuuluuKurssiinNimelta())) {
				valikonTapahtumat.add(tapahtumat.get(i));
			}
		}
		
		for(int i= 0;i <tentit.size();i++) {
			if(kurssinNimi.equals(tentit.get(i).getKuuluuKurssiinNimelta())) {
				valikonTapahtumat.add(tentit.get(i));
			}
		}
		
		//Tulostetaan valittavissa olevat tapahtumat
		
		for(int i=0;i<valikonTapahtumat.size();i++){
			System.out.println(3+i + ". " + valikonTapahtumat.get(i).getNimi());
		}
		
		System.out.println("0. Palaa takaisin");
		System.out.println("");
		System.out.print("Valinta:");
		
		nappaimisto = new Scanner(System.in);
		
		//Kysyt��n sy�tett� niin kauan kunnes annetaan kokonaislukusy�te
		while(nappaimisto.hasNextInt() != true) {
			
			System.out.println("Virheellinen sy�te");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
			
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysyt��n valikkonumeroa kunnes se on oikea
		while(kasitteleAnnettuValintaKurssinmuokkausvalikossa(valintanum, kurssit.get(kurssiIndeksi),valikonTapahtumat) == 1) {
			System.out.print("Valinta:");
			nappaimisto = new Scanner(System.in);
			  
			//Kysyt��n sy�tett� niin kauan kunnes annetaan kokonaislukusy�te
			while(nappaimisto.hasNextInt() != true) {
				System.out.println("Virheellinen sy�te");
				System.out.println("");
				System.out.print("Valinta:");
					
				nappaimisto = new Scanner(System.in);	
					
			}
			valintanum = nappaimisto.nextInt(); 	
		}		
	}
	public void lopetusValikko() {
		
		Scanner nappaimisto;
		int valintanum;
		
		
		System.out.println("Opintoty�kalu - Lopetus");
		System.out.println("");
		System.out.println("1. Tallenna ja lopeta");
		System.out.println("");
		System.out.println("2. Lopeta tallentamatta");
		System.out.println("");
		System.out.println("3. Palaa p��valikkoon");
		System.out.println("");
		System.out.print("Valinta: ");
		
		nappaimisto = new Scanner(System.in);
		
		//Kysyt��n sy�tett� niin kauan kunnes annetaan kokonaislukusy�te
		while(nappaimisto.hasNextInt() != true) {
			
			System.out.println("Virheellinen sy�te");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
			
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysyt��n valikkonumeroa kunnes se on oikea
		while(valintaLopetusValikko(valintanum) == 1) {
			  
			System.out.print("Valinta:");
			nappaimisto = new Scanner(System.in);
			
			//Kysyt��n sy�tett� niin kauan kunnes annetaan kokonaislukusy�te
			while(nappaimisto.hasNextInt() != true) {
					
				System.out.println("Virheellinen sy�te");
				System.out.println("");
				System.out.print("Valinta:");
					
				nappaimisto = new Scanner(System.in);	
					
			}
			valintanum = nappaimisto.nextInt(); 	
		}
		
	}
	
	
	

		private int kasitteleAnnettuValintaKurssinmuokkausvalikossa(int valintanum,
				Kurssi kurssi, ArrayList<Tapahtuma> valikonTapahtumat) {

		switch(valintanum) {
		
		case 1:
				//muokkaaKurssinNime�(kurssiIndeksi);
			return 0;
		case 2: 
				//muokkaaKurssinLaajuutta(kurssiIndeksi);
			return 0;
		case 0: return 0;
		default:
			tapahtumanMuokkausValikko(valikonTapahtumat.get(valintanum-3));
			return 0;
		}
		
	}
	
	
		private void tapahtumanMuokkausValikko(Tapahtuma tapahtuma) {

		tyhjennaNakyma();
		System.out.println("Muokkaa tapahtumaa " + tapahtuma.getNimi());
		System.out.println("1. Nimi:" + tapahtuma.getNimi());
		System.out.println("2. Sijainti:" + tapahtuma.getSijainti());
		System.out.println("3. Alku:" + tapahtuma.getAlku().toString());
		System.out.println("4. Loppu:" + tapahtuma.getLoppu().toString());
		System.out.println("0. Palaa takaisin");
		
		int valinta = getValikkoValinta();
		while (valinta < 0 && valinta > 5) {
			System.out.println("Virheellinen sy�te");
			System.out.println("");
			System.out.print("Valinta:");
			valinta = getValikkoValinta();
		}
		
		switch(valinta) {
		case 1:tapahtuma.setNimi(lueString()); break;
		case 2:tapahtuma.setSijainti(lueString()); break;
		case 3:tapahtuma.setAlku(lueYksiPVM());
		case 4:tapahtuma.setLoppu(lueYksiPVM());
		case 0:break;
		default:break;
		}
		
	}
	private Date lueYksiPVM() {
		Scanner nappaimisto = new Scanner(System.in);
		
		System.out.println("Anna aika:");
		return palautaStringDatena(nappaimisto.nextLine())[0];		
		
	}
	
	private Date[] palautaStringDatena(String str){
		
		Date currenttime = new Date(System.currentTimeMillis());
		DateFormat dateFormat = new SimpleDateFormat("yy");
		
		//Ajan parseaminen k�ytt�j�n sy�tteest� ja sen lis��minen tapahtumaan
        String[] parametrit = str.split(" ", 3);
        
        //Aika1 ja Aika2:een muodostetaan stringit joista parseri sitten luo Date-oliot.
        
        //Lis�t��n p�iv�m��r�
        String aika1 = parametrit[0];
        String aika2 = parametrit[0];
        
        //Lis�t��n nykyinen vuosi
        aika1 += dateFormat.format(currenttime);
        aika2 += dateFormat.format(currenttime);
        
        //K�sitell��n k�ytt�j�n antama tuntisy�te esim. 10-12
        
        //Jaetaan koko k�ytt�j�n antama sy�te kahtia -merkist�
        String[] tunnit = str.split("-");
        
        //Otetaan vasemman splitin kaksi viimeist� merkki� ja lis�t��n parserille tarjottavaan stringiin
        aika1 += " " + tunnit[0].charAt(tunnit[0].length()-2);
        aika1 += tunnit[0].charAt(tunnit[0].length()-1);
        
        //Otetaan kaksi ensimm�ist� oikealta puolelta ja lis�t��n ne toiseen parserille tarjottavaan stringiin
        aika2 += " " + tunnit[1].charAt(0);
        aika2 += tunnit[1].charAt(1);

        //Lopuksi n�m� stringit parsetaan ja aika talletetaan tapahtumaaan.
        
        Date[] ret = new Date[2];
        ret[0] = parseKayttajanAntamaAika(aika1);
        ret[1] = parseKayttajanAntamaAika(aika2);
        
        return ret;
	}
	
	private String lueString() {
		Scanner nappaimisto = new Scanner(System.in);
		
		System.out.println("Sy�t� teksti:");
		return nappaimisto.nextLine();		
	}
	
	
	private int getValikkoValinta() {
		Scanner nappaimisto = new Scanner(System.in);
		
		//Kysyt��n sy�tett� niin kauan kunnes annetaan kokonaislukusy�te
		while(nappaimisto.hasNextInt() != true) {
			
			System.out.println("Virheellinen sy�te");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
			
		}
		
		return nappaimisto.nextInt();		
	}
	/**
	 * 
	 */
	public static void tyhjennaNakyma() {
		int i = 0;
		
		for(i=0;i<300;i++) {
			System.out.println("\n");
		}
	}

}

