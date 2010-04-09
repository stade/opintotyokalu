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
		
	public Kayttoliittyma() {
		 this.paivaysMalli = new SimpleDateFormat("dd.MM. hh");	//K�ytt�j� sy�tt�� ajat t�ss� muodossa
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
	public int valintaPaaValikko(int valintanum) {
		
		switch (valintanum) {
	       
	        case 1: kurssiValikko();     			break;
	        case 2: tenttiValikko();    			break;
	        case 3: raporttiValikko();   			break;
	        case 4: tallennaValikko();				break;
	        case 0: System.out.println("n�kemiin");	 return 0;
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
		
		switch (valintanum) {
	        //Keskener�inen ei toimintoja
	        case 1: System.out.print("t�st� 1. tentin poisto");     	break;
	        case 2: System.out.print("t�st� 2. tentin poisto");     	break;
	        case 3: System.out.print("t�st� 3. tentin poisto");   		break;
	        case 4: System.out.print("t�st� lis�� tenttej�");			break;
	        case 0: tenttiValikko();									break;
	        default : System.out.println("Virheellinen sy�te");  return 1;

		}
		return 0;
		
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

		/* 
		 * Allaosa tarvittavat koodista tenttien tietorakenteisiin lis��mist� varten,
		 * Ei viel� kysy k�ytt�j�lt� mit��n!  
		 */
		Tapahtuma lisattavaTentti = new Tapahtuma(null);
		
		System.out.println("Tentin lis��minen:");
		System.out.println("Anna ajat muodossa " + paivaysMalli.toPattern() + " esim. 15.01 14");
		
		lisattavaTentti.setNimi("K�ytt�j�n sy�tt�m� kurssinimi");
		Date alkuAika = null;
		
		try {
			alkuAika = paivaysMalli.parse("15.01 14");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		lisattavaTentti.setAlku(alkuAika);	
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
		
		tyhjennaNakyma();
		System.out.println("Opintoty�kalu � Tenttien poisto");
		System.out.println("");
		System.out.println("Poista");
		
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
		
		tyhjennaNakyma();
		System.out.println("Opintoty�kalu - Kurssien lis�ys");
		System.out.println("");
		System.out.println(kurssinimi);
		System.out.println(op + "op");
		System.out.println("");
		System.out.println("Anna kurssin opetustiedot pilkulla erottaen esim.");
		System.out.println(paivaysMalli.toPattern() + ",Harjoitukset");
        System.out.println("Voit sy�tt�� useampia aikoja, mutta vain yhden kerrallaan");
        System.out.print("Opetusajat: ");
        
        nappaimisto = new Scanner(System.in);
        luento = nappaimisto.nextLine();
        
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
        
        //lisätään kurssi kerääjään. KESKEN!!
        Kurssi lisattyKurssi = new Kurssi(kurssinimi, op);
        this.tiedot.addKurssi(lisattyKurssi);
        
        Tapahtuma uusiTapahtuma = new Tapahtuma(luento);
        uusiTapahtuma.setKuuluuKurssiinNimelta(lisattyKurssi.getNimi());
        
        String[] parametrit = luento.split(" ");
        String aika1 = parametrit[0];
        String aika2 = parametrit[0];
        String[] tunnit = luento.split("-");
        aika1 += " " + tunnit[0].charAt(tunnit[0].length()-2);
        aika1 += tunnit[0].charAt(tunnit[0].length()-1);
        aika2 += " " + tunnit[1].charAt(0);
        aika2 += tunnit[1].charAt(1);
        
        uusiTapahtuma.setAlku(parseKayttajanAntamaAika(aika1));
        uusiTapahtuma.setLoppu(parseKayttajanAntamaAika(aika2));
        
        this.tiedot.getTapahtumat().add(uusiTapahtuma);
     
        //Palataan kurssivalikkoon.
        System.out.println(aika1);
        System.out.println(aika2);
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
		//valinta poistaa kurssi.olio.kurssinro(valinta)

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
		
	}
	
	public void tietynKurssinMuokkausValikko(int kurssiIndeksi) {
		ArrayList<Kurssi> kurssit = this.tiedot.getKurssit();
		ArrayList<Tapahtuma> tapahtumat = this.tiedot.getTapahtumat();

		Scanner nappaimisto;
		int valintanum;
		
		tyhjennaNakyma();
		System.out.println("Opintoty�kalu �  Kurssin muokkaus");
		System.out.println("");
		System.out.println("Muokkaa");
		
		System.out.println("1." + kurssit.get(kurssiIndeksi).getNimi());
		System.out.println("2." + kurssit.get(kurssiIndeksi).getLaajuus());
		
		String kurssinNimi = kurssit.get(kurssiIndeksi).getNimi();
		for(int i= 0;i <tapahtumat.size();i++) {
			if(kurssinNimi.equals(tapahtumat.get(i).getKuuluuKurssiinNimelta())) System.out.println(i+3 + ". " + tapahtumat.get(i).getNimi());
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
	 * 
	 */
	public static void tyhjennaNakyma() {
		int i = 0;
		
		for(i=0;i<300;i++) {
			System.out.println("\n");
		}
	}

}

