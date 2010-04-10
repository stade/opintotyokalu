/**
 * Luokkakuvaus tÃ¤hÃ¤n
 * @author ryhmÃ¤?
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *	Kï¿½yttï¿½liittymï¿½-luokka luo tekstipohjaiset valikot ja mahdollistaa niissï¿½ liikkumisen.
 */
public class Kayttoliittyma {
	
	private SimpleDateFormat paivaysMalli; // yhteinen malli pï¿½ivï¿½mï¿½ï¿½rille
	private Keraaja tiedot;
		
	public Kayttoliittyma() {
		 this.paivaysMalli = new SimpleDateFormat("dd.MM. hh");	//Kï¿½yttï¿½jï¿½ syï¿½ttï¿½ï¿½ ajat tï¿½ssï¿½ muodossa
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
	 * 	Siirtï¿½ï¿½ alavalikkoon pï¿½ï¿½valikosta annetun valintanumeron mukaan.
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
	        case 0: System.out.println("nï¿½kemiin");	 return 0;
	        default : System.out.println("Virheellinen syï¿½te");  return 1;
	        
		}	
		return 0;
	}
	
	/**
	 * Siirtï¿½ï¿½ alavalikkoon tai pï¿½ï¿½valikkoon kurssivalikosta annetun 
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
	        default : System.out.println("Virheellinen syï¿½te");  return 1;
		}
		return 0;
	}
	
	/**
	 *	Siirtï¿½ï¿½ alavalikkoon tai pï¿½ï¿½valikkoon tenttivalikosta annetun 
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
	        default : System.out.println("Virheellinen syï¿½te");  return 1;

		}
		return 0;
		
	}
	
	/**
	 *	Siirtï¿½ï¿½ alavalikkoon tai pï¿½ï¿½valikkoon raporttivalikosta annetun 
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
	        default : System.out.println("Virheellinen syï¿½te");  return 1;

		}
		return 0;
		
	}
	
	/**
	 *	Siirtï¿½ï¿½ alavalikkoon tai pï¿½ï¿½valikkoon tallennavalikosta annetun 
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
	        default : System.out.println("Virheellinen syï¿½te");  return 1;

		}
		return 0;
	}
	
	/**
	 *	Muokataan kursseja tai siirrytï¿½ï¿½n kurssivalikkoon kurssien muokkausvalikosta 
	 *  annetun valintanumeron mukaan.
	 *  
	 *  @param valintanum kÃ¤yttÃ¤jÃ¤n valitseman toiminnon numero
	 *  @return Palauttaa 1, jos virheellinen valinta.
	 */
	public int valintaKurssiMuokkausValikko(int valintanum) {
		
			if (valintanum == 0) {
			kurssiValikko();
			return 0;
		}
		else if (valintanum > 0 && valintanum <= this.tiedot.getKurssit().size()) {
			tietynKurssinMuokkausValikko(valintanum-1); // Kurssien numerot valikossa alkavat 1:stä, ArrayListissä 0:sta, siispä vähennetään yksi
			kurssiValikko();
			return 0;
		}
		else {System.out.println("Virheellinen syï¿½te");  return 1;}
	}	
		
	/**
	 *	Poistetaan kursseja tai siirrytï¿½ï¿½n kurssivalikkoon kurssien poistovalikosta 
	 *  annetun valintanumeron mukaan.
	 *  
	 *  @param valintanum kÃ¤yttÃ¤jÃ¤n valitseman toiminnon numero
	 *  @return Palauttaa 1, jos virheellinen valinta.
	 */
	public int valintaKurssiPoistoValikko(int valintanum) {
		
		// tähän parempi virheenkäsittely esim isInteger
		
		if (valintanum == 0) {
			kurssiValikko();
			return 0;
		}
		else if (valintanum > 0 && valintanum <= this.tiedot.getKurssit().size()) {
			this.tiedot.getKurssit().remove(valintanum-1); // Kurssien numerot valikossa alkavat 1:stä, ArrayListissä 0:sta, siispä vähennetään yksi
			kurssiValikko();
			return 0;
		}
		else {System.out.println("Virheellinen syï¿½te");  return 1;}
	}	
	
	/**
	 * 
	 * @param valintanum
	 * @return
	 */
	public int valintaTenttiMuokkausValikko(int valintanum) {
		
		switch (valintanum) {
	        //Keskenerï¿½inen ei toimintoja
	        case 1: System.out.print("tï¿½stï¿½ 1. tentin muokkaus");     	break;
	        case 2: System.out.print("tï¿½stï¿½ 2. tentin muokkaus");     	break;
	        case 3: System.out.print("tï¿½stï¿½ 3. tentin muokkaus");   	break;
	        case 4: System.out.print("tï¿½stï¿½ lisï¿½ï¿½ tenttejï¿½");			break;
	        case 0: tenttiValikko();									break;
	        default : System.out.println("Virheellinen syï¿½te");  return 1;

		}
		return 0;
		
	}
	
	/**
	 * 
	 * @param valintanum
	 * @return
	 */
	public int valintaTenttiPoistoValikko(int valintanum) {
		
	// tähän parempi virheenkäsittely esim isInteger
		
		if (valintanum == 0) {
			tenttiValikko();
			return 0;
		}
		else if (valintanum > 0 && valintanum <= this.tiedot.getTentit().size()) {
			this.tiedot.getTentit().remove(valintanum-1); // Tenttien numerot valikossa alkavat 1:stä, ArrayListissä 0:sta, siispä vähennetään yksi
			tenttiValikko();
			return 0;
		}
		else {System.out.println("Virheellinen syï¿½te");  return 1;}
	}	
	
	/**
	 *	Kï¿½yttï¿½liittymï¿½n pï¿½ï¿½valikko.
	 */
	public void paaValikko() {
		
		int valintanum;
		Scanner nappaimisto;
		
		tyhjennaNakyma();
		System.out.println("Opintotyï¿½kalu");
		System.out.println("");
		System.out.println("1. Hallinnoi kursseja");
		System.out.println("");
		System.out.println("2. Hallinnoi tenttejï¿½");
		System.out.println("");
		System.out.println("3. Tulosta raportteja");
		System.out.println("");
		System.out.println("4. Tallenna tai lataa");
		System.out.println("");
		System.out.println("0. Poistu sovelluksesta");
		System.out.println("");
		System.out.print("Valinta:");
		
		nappaimisto = new Scanner(System.in);
		
		//Kysytï¿½ï¿½n syï¿½tettï¿½ niin kauan kunnes annetaan kokonaislukusyï¿½te
		while(nappaimisto.hasNextInt() != true) {
			
			System.out.println("Virheellinen syï¿½te");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
			
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysytï¿½ï¿½n valikkonumeroa kunnes se on oikea
		while(valintaPaaValikko(valintanum) == 1) {
			  
			System.out.print("Valinta:");
			nappaimisto = new Scanner(System.in);
			
			//Kysytï¿½ï¿½n syï¿½tettï¿½ niin kauan kunnes annetaan kokonaislukusyï¿½te
			while(nappaimisto.hasNextInt() != true) {
					
				System.out.println("Virheellinen syï¿½te");
				System.out.println("");
				System.out.print("Valinta:");
					
				nappaimisto = new Scanner(System.in);	
					
			}
			valintanum = nappaimisto.nextInt(); 	
		}
	}
	
	/**
	 *	Kï¿½yttï¿½liittymï¿½n kurssivalikko.
	 */
	public void kurssiValikko() {
		
		
		int valintanum;
		Scanner nappaimisto;
		
		tyhjennaNakyma();
		System.out.println("Opintotyï¿½kalu - Hallinoi kursseja");
		System.out.println("");
		System.out.println("1. Lisï¿½ï¿½ kursseja");
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
		
		//Kysytï¿½ï¿½n syï¿½tettï¿½ niin kauan kunnes annetaan kokonaislukusyï¿½te
		while(nappaimisto.hasNextInt() != true) {
			
			System.out.println("Virheellinen syï¿½te");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
			
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysytï¿½ï¿½n valikkonumeroa kunnes se on oikea
		while(valintaKurssiValikko(valintanum) == 1) {
			  
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);
			  
			//Kysytï¿½ï¿½n syï¿½tettï¿½ niin kauan kunnes annetaan kokonaislukusyï¿½te
			while(nappaimisto.hasNextInt() != true) {
				System.out.println("Virheellinen syï¿½te");
				System.out.println("");
				System.out.print("Valinta:");
					
				nappaimisto = new Scanner(System.in);		
			}
			valintanum = nappaimisto.nextInt(); 	
		}
	}
	
	/**
	 *	Kï¿½yttï¿½liittymï¿½n tenttivalikko.
	 */
	public void tenttiValikko() {
		
		int valintanum;
		Scanner nappaimisto;
		
		tyhjennaNakyma();
		System.out.println("Opintotyï¿½kalu - Hallinnoi tenttejï¿½");
		System.out.println("");
		System.out.println("1. Lisï¿½ï¿½ tenttejï¿½");
		System.out.println("");
		System.out.println("2. Muokkaa tenttejï¿½");
		System.out.println("");
		System.out.println("3. Poista tenttejï¿½");
		System.out.println("");
		System.out.println("0. Palaa takaisin");
		System.out.println("");
		System.out.println("");
		System.out.print("Valinta:");
		
		nappaimisto = new Scanner(System.in);
		
		//Kysytï¿½ï¿½n syï¿½tettï¿½ niin kauan kunnes annetaan kokonaislukusyï¿½te
		while(nappaimisto.hasNextInt() != true) {
			
			System.out.println("Virheellinen syï¿½te");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
			
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysytï¿½ï¿½n valikkonumeroa kunnes se on oikea
		while(valintaTenttiValikko(valintanum) == 1) {
			System.out.print("Valinta:");
			nappaimisto = new Scanner(System.in);
			
			//Kysytï¿½ï¿½n syï¿½tettï¿½ niin kauan kunnes annetaan kokonaislukusyï¿½te
			while(nappaimisto.hasNextInt() != true) {
				System.out.println("Virheellinen syï¿½te");
				System.out.println("");
				System.out.print("Valinta:");
					
				nappaimisto = new Scanner(System.in);		
			}
			valintanum = nappaimisto.nextInt(); 	
		}
	}
		
	/**
	 *	Kï¿½yttï¿½liittymï¿½n raporttivalikko.
	 */
	public void raporttiValikko() {
		
		int valintanum;
		Scanner nappaimisto;
		
		tyhjennaNakyma();
		System.out.println("Opintotyï¿½kalu - Tulosta raportteja");
		System.out.println("");
		System.out.println("1. Tulosta suoritetut kurssit");
		System.out.println("");
		System.out.println("2. Tulosta lukujï¿½rjestys");
		System.out.println("");
		System.out.println("0. Palaa takaisin");
		System.out.println("");
		System.out.println("");
		System.out.print("Valinta:");
		nappaimisto = new Scanner(System.in);
		
		//Kysytï¿½ï¿½n syï¿½tettï¿½ niin kauan kunnes annetaan kokonaislukusyï¿½te
		while(nappaimisto.hasNextInt() != true) {
			
			System.out.println("Virheellinen syï¿½te");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
			
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysytï¿½ï¿½n valikkonumeroa kunnes se on oikea
		while(valintaRaporttiValikko(valintanum) == 1) {
			System.out.print("Valinta:");
			nappaimisto = new Scanner(System.in);
			
			//Kysytï¿½ï¿½n syï¿½tettï¿½ niin kauan kunnes annetaan kokonaislukusyï¿½te
			while(nappaimisto.hasNextInt() != true) {
				System.out.println("Virheellinen syï¿½te");
				System.out.println("");
				System.out.print("Valinta:");
					
				nappaimisto = new Scanner(System.in);		
			}
			valintanum = nappaimisto.nextInt(); 	
		}
	}
		
	/**
	 *	Kï¿½yttï¿½liittymï¿½n tallennusvalikko.
	 */
	public void tallennaValikko() {
		
		int valintanum;
		Scanner nappaimisto;
		
		tyhjennaNakyma();
		System.out.println("Opintotyï¿½kalu - Tallenna tai lataa");
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
		
		//Kysytï¿½ï¿½n syï¿½tettï¿½ niin kauan kunnes annetaan kokonaislukusyï¿½te
		while(nappaimisto.hasNextInt() != true) {
			
			System.out.println("Virheellinen syï¿½te");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
			
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysytï¿½ï¿½n valikkonumeroa kunnes se on oikea
		while(valintaTallennaValikko(valintanum) == 1) { 
			System.out.print("Valinta:");
			nappaimisto = new Scanner(System.in);
			
			//Kysytï¿½ï¿½n syï¿½tettï¿½ niin kauan kunnes annetaan kokonaislukusyï¿½te
			while(nappaimisto.hasNextInt() != true) {
				System.out.println("Virheellinen syï¿½te");
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
		
		//Nï¿½mï¿½ korvataan oikeilla tietotyypeillï¿½
		String tenttinimi;
		String luento;
		
		tyhjennaNakyma();
		System.out.println("Opintotyï¿½kalu - Tentin lisï¿½ys");
		System.out.println("");
		System.out.print("Anna tentin nimi: ");
	
		nappaimisto = new Scanner(System.in);
		tenttinimi = nappaimisto.nextLine();
		
		tyhjennaNakyma();
		System.out.println("Opintotyï¿½kalu - Tentin lisï¿½ys");
		System.out.println("");
		System.out.println(tenttinimi);
		System.out.println("");
		System.out.println("Anna tentin ajankohta esim. 16.12. 10-12");
		//System.out.println(paivaysMalli.toPattern() + ""); huono tapa ilmoittaa
        System.out.print("Tentin Ajankohta: ");
        
        nappaimisto = new Scanner(System.in);
        luento = nappaimisto.nextLine();
        
        tyhjennaNakyma();
		System.out.println("Opintotyï¿½kalu - Tenttien lisï¿½ys");
		System.out.println("");
		System.out.println(tenttinimi);
		System.out.println(luento);
		System.out.println("");
        System.out.print("Paina enter palataksesi takaisin");
        
        nappaimisto = new Scanner(System.in);
        nappaimisto.nextLine();
        
        //lisÃ¤tÃ¤Ã¤n tentti kerÃ¤Ã¤jÃ¤Ã¤n.
        Tapahtuma lisattyTapahtuma = new Tapahtuma(tenttinimi);
        this.tiedot.addTentti(lisattyTapahtuma);
        
        //Ajan parseaminen käyttäjän syötteestä ja sen lisääminen tapahtumaan
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
		System.out.println("Opintotyï¿½kalu ï¿½ Tenttien muokkaus");
		System.out.println("");
		System.out.println("Muokkaa");
		
		System.out.println("1. Tentti 1.");
		System.out.println("2. Tentti 2.");
		System.out.println("3. Tentti 3.");
		System.out.println("4. Lisï¿½ï¿½ tenttejï¿½");
		System.out.println("0. Palaa takaisin");
		System.out.println("");
		System.out.print("Valinta:");
		
		nappaimisto = new Scanner(System.in);
		
		//Kysytï¿½ï¿½n syï¿½tettï¿½ niin kauan kunnes annetaan kokonaislukusyï¿½te
		while(nappaimisto.hasNextInt() != true) {
			
			System.out.println("Virheellinen syï¿½te");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
			
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysytï¿½ï¿½n valikkonumeroa kunnes se on oikea
		while(valintaTenttiMuokkausValikko(valintanum) == 1) {
			System.out.print("Valinta:");
			nappaimisto = new Scanner(System.in);
			  
			//Kysytï¿½ï¿½n syï¿½tettï¿½ niin kauan kunnes annetaan kokonaislukusyï¿½te
			while(nappaimisto.hasNextInt() != true) {
				System.out.println("Virheellinen syï¿½te");
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
		System.out.println("Opintotyï¿½kalu ï¿½ Tenttien poisto");
		System.out.println("");
		System.out.println("Poista");
		
		for(int i =0;i<tentit.size();i++) {
			  System.out.println(i+1 + ". " + tentit.get(i).getNimi()); 
					  }		
		System.out.println("0. Palaa takaisin");
		System.out.println("");
		System.out.print("Valinta:");
		
		nappaimisto = new Scanner(System.in);
		
		//Kysytï¿½ï¿½n syï¿½tettï¿½ niin kauan kunnes annetaan kokonaislukusyï¿½te
		while(nappaimisto.hasNextInt() != true) {
			
			System.out.println("Virheellinen syï¿½te");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
			
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysytï¿½ï¿½n valikkonumeroa kunnes se on oikea
		while(valintaTenttiPoistoValikko(valintanum) == 1) {
			System.out.print("Valinta:");
			nappaimisto = new Scanner(System.in);
			  
			//Kysytï¿½ï¿½n syï¿½tettï¿½ niin kauan kunnes annetaan kokonaislukusyï¿½te
			while(nappaimisto.hasNextInt() != true) {
				System.out.println("Virheellinen syï¿½te");
				System.out.println("");
				System.out.print("Valinta:");
					
				nappaimisto = new Scanner(System.in);	
					
			}
			valintanum = nappaimisto.nextInt(); 	
		}		
	}
	
	/**
	 *	Kï¿½yttï¿½liittymï¿½n kurssin lisï¿½ysvalikko. Ei kï¿½ytï¿½ vielï¿½ oikeita tietorakenteita. 
	 *  Tapahtumien lisï¿½yksen toteutus vajaa. Ei virheellisten syï¿½tteiden kï¿½sittelyï¿½
	 */
	public void lisaaKurssiValikko() {
		
		Scanner nappaimisto;
		
		//Nï¿½mï¿½ korvataan oikeilla tietotyypeillï¿½
		String kurssinimi;
		int op;
		String luento;
		
		tyhjennaNakyma();
		System.out.println("Opintotyï¿½kalu - Kurssin lisï¿½ys");
		System.out.println("");
		System.out.print("Anna kurssin nimi: ");
	
		nappaimisto = new Scanner(System.in);
		kurssinimi = nappaimisto.nextLine();
		
		tyhjennaNakyma();
		System.out.println("Opintotyï¿½kalu - Kurssin lisï¿½ys");
		System.out.println("");
		System.out.println(kurssinimi);
		System.out.println("");
		System.out.print("Anna kurssin laajuus opintopisteinï¿½: ");
		
		nappaimisto = new Scanner(System.in);
		op = nappaimisto.nextInt();
		
		tyhjennaNakyma();
		System.out.println("Opintotyï¿½kalu - Kurssien lisï¿½ys");
		System.out.println("");
		System.out.println(kurssinimi);
		System.out.println(op + "op");
		System.out.println("");
		System.out.println("Anna kurssin opetustiedot pilkulla erottaen esim.");
		System.out.println(paivaysMalli.toPattern() + ",Harjoitukset");
        System.out.println("Voit syï¿½ttï¿½ï¿½ useampia aikoja, mutta vain yhden kerrallaan");
        System.out.print("Opetusajat: ");
        
        nappaimisto = new Scanner(System.in);
        luento = nappaimisto.nextLine();
        
        tyhjennaNakyma();
		System.out.println("Opintotyï¿½kalu - Kurssien lisï¿½ys");
		System.out.println("");
		System.out.println(kurssinimi);
		System.out.println(op + "op");
		System.out.println(luento);
		System.out.println("");
        System.out.print("Paina enter palataksesi takaisin");
        
        nappaimisto = new Scanner(System.in);
        nappaimisto.nextLine();
        
        //lisÃ¤tÃ¤Ã¤n kurssi kerÃ¤Ã¤jÃ¤Ã¤n.
        Kurssi lisattyKurssi = new Kurssi(kurssinimi, op);
        this.tiedot.addKurssi(lisattyKurssi);
        
        Tapahtuma uusiTapahtuma = new Tapahtuma(luento);
        uusiTapahtuma.setKuuluuKurssiinNimelta(lisattyKurssi.getNimi());
        
        
        //Ajan parseaminen käyttäjän syötteestä ja sen lisääminen tapahtumaan
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
        kurssiValikko();

	}
	
	/**
	 *	Muuttaa käyttäjän String muodossa antaman ajan Date-olioksi ja palauttaa sen.
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
	 *	Kï¿½yttï¿½liittymï¿½n kurssin muokkausvalikko. Keskenerï¿½inen.  
	 */
	public void muokkaaKurssiValikko() {
		
		Scanner nappaimisto;
		int valintanum;
		
		ArrayList<Kurssi> kurssit = this.tiedot.getKurssit();
		
		tyhjennaNakyma();
		System.out.println("Opintotyï¿½kalu ï¿½ Kurssien poisto");
		System.out.println("");
		System.out.println("Poista");

		
		tyhjennaNakyma();
		System.out.println("Opintotyï¿½kalu ï¿½ Kurssien muokkaus");
		System.out.println("");
		System.out.println("Muokkaa");
		
		for(int i =0;i<kurssit.size();i++) {
			  System.out.println(i+1 + ". " + kurssit.get(i).getNimi()); 
					  }		
		
		System.out.println("0. Palaa takaisin");
		System.out.println("");
		System.out.print("Valinta:");
		
		nappaimisto = new Scanner(System.in);
		
		//Kysytï¿½ï¿½n syï¿½tettï¿½ niin kauan kunnes annetaan kokonaislukusyï¿½te
		while(nappaimisto.hasNextInt() != true) {
			System.out.println("Virheellinen syï¿½te");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysytï¿½ï¿½n valikkonumeroa kunnes se on oikea
		while(valintaKurssiMuokkausValikko(valintanum) == 1) {
			System.out.print("Valinta:");
			nappaimisto = new Scanner(System.in);
			  
			//Kysytï¿½ï¿½n syï¿½tettï¿½ niin kauan kunnes annetaan kokonaislukusyï¿½te
			while(nappaimisto.hasNextInt() != true) {
				System.out.println("Virheellinen syï¿½te");
				System.out.println("");
				System.out.print("Valinta:");
					
				nappaimisto = new Scanner(System.in);		
			}
			valintanum = nappaimisto.nextInt(); 	
		}
	}
	
	/**
	 *	Kï¿½yttï¿½liittymï¿½n kurssin poistovalikko. Keskenerï¿½inen.  
	 */
	public void poistaKurssiValikko() {
		
		Scanner nappaimisto;
		int valintanum;
		
			
		ArrayList<Kurssi> kurssit = this.tiedot.getKurssit();
		
		tyhjennaNakyma();
		System.out.println("Opintotyï¿½kalu ï¿½ Kurssien poisto");
		System.out.println("");
		System.out.println("Poista");
		for(int i =0;i<kurssit.size();i++) {
		  System.out.println(i+1 + ". " + kurssit.get(i).getNimi()); 
				  }		

		System.out.println(kurssit.size()+1 + ". Lisï¿½ï¿½ kursseja");
		System.out.println("0. Palaa takaisin");
		System.out.println("");
		System.out.print("Valinta:");
		
		nappaimisto = new Scanner(System.in);
		
		//Kysytï¿½ï¿½n syï¿½tettï¿½ niin kauan kunnes annetaan kokonaislukusyï¿½te
		while(nappaimisto.hasNextInt() != true) {
			System.out.println("Virheellinen syï¿½te");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysytï¿½ï¿½n valikkonumeroa kunnes se on oikea
		while(valintaKurssiPoistoValikko(valintanum) == 1) {
			System.out.print("Valinta:");
			nappaimisto = new Scanner(System.in);
			  
			//Kysytï¿½ï¿½n syï¿½tettï¿½ niin kauan kunnes annetaan kokonaislukusyï¿½te
			while(nappaimisto.hasNextInt() != true) {
				System.out.println("Virheellinen syï¿½te");
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
		
		//Nï¿½mï¿½ korvataan oikeilla tietotyypeillï¿½
		String tallennuspolku;
		
		tyhjennaNakyma();
		System.out.println("Opintotyï¿½kalu - Tallennus tiedostoon");
		System.out.println("");
		System.out.println("Syï¿½tï¿½ tiedostonimi ja paina enter.");
		System.out.println("");
		System.out.print("Tiedostonimi: ");
	
		nappaimisto = new Scanner(System.in);
		tallennuspolku = nappaimisto.nextLine();
		
		//Tï¿½ssï¿½ tallennetaan annetun tiedostonimen perusteella
		
	}
	
	/**
	 *	Avaa tiedoston annetun tiedostopolun mukaan.   
	 */
	public void avaaTiedostostaValikko() {
		
		Scanner nappaimisto;
		
		//Nï¿½mï¿½ korvataan oikeilla tietotyypeillï¿½
		String avauspolku;
		
		tyhjennaNakyma();
		System.out.println("Opintotyï¿½kalu - Tiedostosta avaaminen");
		System.out.println("");
		System.out.println("Syï¿½tï¿½ tiedostonimi ja paina enter.");
		System.out.println("");
		System.out.print("Tiedostonimi: ");
	
		nappaimisto = new Scanner(System.in);
		avauspolku = nappaimisto.nextLine();
		
		//Tï¿½ssï¿½ avataan tiedostosta annetun tiedostonimen perusteella
		
	}
	
	public void tietynKurssinMuokkausValikko(int kurssiIndeksi) {
		ArrayList<Kurssi> kurssit = this.tiedot.getKurssit();
		ArrayList<Tapahtuma> tapahtumat = this.tiedot.getTapahtumat();

		Scanner nappaimisto;
		int valintanum;
		
		tyhjennaNakyma();
		System.out.println("Opintotyï¿½kalu ï¿½  Kurssin muokkaus");
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
		
		//Kysytï¿½ï¿½n syï¿½tettï¿½ niin kauan kunnes annetaan kokonaislukusyï¿½te
		while(nappaimisto.hasNextInt() != true) {
			
			System.out.println("Virheellinen syï¿½te");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
			
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysytï¿½ï¿½n valikkonumeroa kunnes se on oikea
		while(valintaTenttiPoistoValikko(valintanum) == 1) {
			System.out.print("Valinta:");
			nappaimisto = new Scanner(System.in);
			  
			//Kysytï¿½ï¿½n syï¿½tettï¿½ niin kauan kunnes annetaan kokonaislukusyï¿½te
			while(nappaimisto.hasNextInt() != true) {
				System.out.println("Virheellinen syï¿½te");
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

