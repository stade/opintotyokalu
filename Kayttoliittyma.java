import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *      Käyttöliittymä-luokka luo tekstipohjaiset valikot ja mahdollistaa niissä liikkumisen.
 */
public class Kayttoliittyma {
	SimpleDateFormat paivaysMalli; // yhteinen malli päivämäärille
	
	public Kayttoliittyma() {
		 paivaysMalli = new SimpleDateFormat("dd.MM hh");	//Käyttäjä syöttää ajat tässä muodossa
		 
	}
	
	/**
	 *    Attribuutit
	 */
	private Keraaja tiedot;
	
	/**
	 *    Siirtää alavalikkoon päävalikosta annetun valintanumeron mukaan.
	 *    Palauttaa 1, jos virheellinen valinta. 0 jos halutaan poistua ohjelmasta.
	 */
	public int valintaPaaValikko(int valintanum) {
		
		switch (valintanum) {
	       
	        case 1: kurssiValikko();     			break;
	        case 2: tenttiValikko();    			break;
	        case 3: raporttiValikko();   			break;
	        case 4: tallennaValikko();				break;
	        case 0: System.out.println("näkemiin");	 return 0;
	        default : System.out.println("Virheellinen syöte");  return 1;
	        
		}	
		return 0;
	}
	/**
	 *    Siirtää alavalikkoon tai päävalikkoon kurssivalikosta annetun 
	 *    valintanumeron mukaan. Palauttaa 1, jos virheellinen valinta.
	 */
	public int valintaKurssiValikko(int valintanum) {
	
		switch (valintanum) {
	       
	        case 1: lisaaKurssiValikko();     	break;
	        case 2: muokkaaKurssiValikko();    	break;
	        case 3: poistaKurssiValikko();   	break;
	        case 0: paaValikko();				break;
	        default : System.out.println("Virheellinen syöte");  return 1;
		}
		return 0;
	}
	/**
	 *    Siirtää alavalikkoon tai päävalikkoon tenttivalikosta annetun 
	 *    valintanumeron mukaan. Palauttaa 1, jos virheellinen valinta.
	 */
	public int valintaTenttiValikko(int valintanum) {
	
		switch (valintanum) {
	       
	        case 1: lisaaTenttiValikko();     	break;
	        case 2: muokkaaTenttiValikko();    	break;
	        case 3: poistaTenttiValikko();   	break;
	        case 0: paaValikko();				break;
	        default : System.out.println("Virheellinen syöte");  return 1;

		}
		return 0;
		
	}
	/**
	 *    Siirtää alavalikkoon tai päävalikkoon raporttivalikosta annetun 
	 *    valintanumeron mukaan. Palauttaa 1, jos virheellinen valinta.
	 */
	public int valintaRaporttiValikko(int valintanum) {
	
		switch (valintanum) {
	       
	        case 1: tulostaKurssitValikko();     	break;
	        case 2: tulostaLukkariValikko();    	break;
	        case 0: paaValikko();					break;
	        default : System.out.println("Virheellinen syöte");  return 1;

		}
		return 0;
		
	}
	/**
	 *    Siirtää alavalikkoon tai päävalikkoon tallennavalikosta annetun 
	 *    valintanumeron mukaan. Palauttaa 1, jos virheellinen valinta.
	 */
	public int valintaTallennaValikko(int valintanum) {
	
		switch (valintanum) {
	       
	        case 1: tallennaTiedostoonValikko();     	break;
	        case 2: avaaTiedostostaValikko();    		break;
	        case 0: paaValikko();						break;
	        default : System.out.println("Virheellinen syöte");  return 1;

		}
		return 0;
		
	}
	/**
	 *    Muokataan kursseja tai siirrytään kurssivalikkoon kurssien muokkausvalikosta 
	 *    annetun valintanumeron mukaan.
	 *    Palauttaa 1, jos virheellinen valinta.
	 */
	public int valintaKurssiMuokkausValikko(int valintanum) {
		
		switch (valintanum) {
	       
	        case 1: System.out.print("tästä 1. kurssin muokkaus");     	break;
	        case 2: System.out.print("tästä 2. kurssin muokkaus");     	break;
	        case 3: System.out.print("tästä 3. kurssin muokkaus");   	break;
	        case 4: System.out.print("tästä lisää kursseja");			break;
	        case 0: kurssiValikko();									break;
	        default : System.out.println("Virheellinen syöte");  return 1;

		}
		return 0;
		
	}	
	public int valintaKurssiPoistoValikko(int valintanum) {
		
		switch (valintanum) {
	       
	        case 1: System.out.print("tästä 1. kurssin poisto");     	break;
	        case 2: System.out.print("tästä 2. kurssin poisto");     	break;
	        case 3: System.out.print("tästä 3. kurssin poisto");   		break;
	        case 4: System.out.print("tästä lisää kursseja");			break;
	        case 0: kurssiValikko();									break;
	        default : System.out.println("Virheellinen syöte");  return 1;

		}
		return 0;
		
	}	
	
	/**
	 *    Käyttöliittymän päävalikko.
	 */
	public void paaValikko() {
		
		int valintanum;
		Scanner nappaimisto;
		
		tyhjennaNakyma();
		System.out.println("Opintotyökalu");
		System.out.println("");
		System.out.println("1. Hallinnoi kursseja");
		System.out.println("");
		System.out.println("2. Hallinnoi tenttejä");
		System.out.println("");
		System.out.println("3. Tulosta raportteja");
		System.out.println("");
		System.out.println("4. Tallenna tai lataa");
		System.out.println("");
		System.out.println("0. Poistu sovelluksesta");
		System.out.println("");
		System.out.print("Valinta:");
		
		nappaimisto = new Scanner(System.in);
		
		//Kysytään syötettä niin kauan kunnes annetaan kokonaislukusyöte
		while(nappaimisto.hasNextInt() != true) {
			
			System.out.println("Virheellinen syöte");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
			
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysytään valikkonumeroa kunnes se on oikea
		while ( valintaPaaValikko(valintanum) == 1) {
			  
			  System.out.print("Valinta:");
			
			  nappaimisto = new Scanner(System.in);
			  //Kysytään syötettä niin kauan kunnes annetaan kokonaislukusyöte
			  while(nappaimisto.hasNextInt() != true) {
					
					System.out.println("Virheellinen syöte");
					System.out.println("");
					System.out.print("Valinta:");
					
					nappaimisto = new Scanner(System.in);	
					
			 }
			 valintanum = nappaimisto.nextInt(); 	
		}
	}
	
	
	/**
	 *    Käyttöliittymän kurssivalikko.
	 */
	public void kurssiValikko() {
		
		
		int valintanum;
		Scanner nappaimisto;
		
		tyhjennaNakyma();
		System.out.println("Opintotyökalu - Hallinoi kursseja");
		System.out.println("");
		System.out.println("1. Lisää kursseja");
		System.out.println("");
		System.out.println("2. Muokkaa kursseja");
		System.out.println("");
		System.out.println("3. Poista kursseja");
		System.out.println("");
		System.out.println("0. Paluu alkuun");
		System.out.println("");
		System.out.println("");
		System.out.print("Valinta:");
		
		nappaimisto = new Scanner(System.in);
		
		//Kysytään syötettä niin kauan kunnes annetaan kokonaislukusyöte
		while(nappaimisto.hasNextInt() != true) {
			
			System.out.println("Virheellinen syöte");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
			
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysytään valikkonumeroa kunnes se on oikea
		while ( valintaKurssiValikko(valintanum) == 1) {
			  
			  System.out.print("Valinta:");
			
			  nappaimisto = new Scanner(System.in);
			  
			  //Kysytään syötettä niin kauan kunnes annetaan kokonaislukusyöte
			  while(nappaimisto.hasNextInt() != true) {
					
					System.out.println("Virheellinen syöte");
					System.out.println("");
					System.out.print("Valinta:");
					
					nappaimisto = new Scanner(System.in);	
					
			 }
			 valintanum = nappaimisto.nextInt(); 	
		}
		
	}
	/**
	 *    Käyttöliittymän tenttivalikko.
	 */
	public void tenttiValikko() {
		
		int valintanum;
		Scanner nappaimisto;
		
		tyhjennaNakyma();
		System.out.println("Opintotyökalu - Hallinnoi tenttejä");
		System.out.println("");
		System.out.println("1. Lisää tenttejä");
		System.out.println("");
		System.out.println("2. Muokkaa tenttejä");
		System.out.println("");
		System.out.println("3. Poista tenttejä");
		System.out.println("");
		System.out.println("0. Paluu alkuun");
		System.out.println("");
		System.out.println("");
		System.out.print("Valinta:");
		
		nappaimisto = new Scanner(System.in);
		
		//Kysytään syötettä niin kauan kunnes annetaan kokonaislukusyöte
		while(nappaimisto.hasNextInt() != true) {
			
			System.out.println("Virheellinen syöte");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
			
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysytään valikkonumeroa kunnes se on oikea
		while ( valintaTenttiValikko(valintanum) == 1) {
			  
			  System.out.print("Valinta:");
			
			  nappaimisto = new Scanner(System.in);
			  //Kysytään syötettä niin kauan kunnes annetaan kokonaislukusyöte
			  while(nappaimisto.hasNextInt() != true) {
					
					System.out.println("Virheellinen syöte");
					System.out.println("");
					System.out.print("Valinta:");
					
					nappaimisto = new Scanner(System.in);	
					
			 }
			 valintanum = nappaimisto.nextInt(); 	
		}
		
	}
		
	/**
	 *    Käyttöliittymän raporttivalikko.
	 */
	public void raporttiValikko() {
		
		int valintanum;
		Scanner nappaimisto;
		
		tyhjennaNakyma();
		System.out.println("Opintotyökalu - Tulosta raportteja");
		System.out.println("");
		System.out.println("1. Tulosta suoritetut kurssit");
		System.out.println("");
		System.out.println("2. Tulosta lukujärjestys");
		System.out.println("");
		System.out.println("0. Paluu alkuun");
		System.out.println("");
		System.out.println("");
		System.out.print("Valinta:");
		nappaimisto = new Scanner(System.in);
		
		//Kysytään syötettä niin kauan kunnes annetaan kokonaislukusyöte
		while(nappaimisto.hasNextInt() != true) {
			
			System.out.println("Virheellinen syöte");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
			
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysytään valikkonumeroa kunnes se on oikea
		while ( valintaRaporttiValikko(valintanum) == 1) {
			  
			  System.out.print("Valinta:");
			
			  nappaimisto = new Scanner(System.in);
			  //Kysytään syötettä niin kauan kunnes annetaan kokonaislukusyöte
			  while(nappaimisto.hasNextInt() != true) {
					
					System.out.println("Virheellinen syöte");
					System.out.println("");
					System.out.print("Valinta:");
					
					nappaimisto = new Scanner(System.in);	
					
			 }
			 valintanum = nappaimisto.nextInt(); 	
		}
		
	}
		
	/**
	 *    Käyttöliittymän tallennusvalikko.
	 */
	public void tallennaValikko() {
		
		int valintanum;
		Scanner nappaimisto;
		
		tyhjennaNakyma();
		System.out.println("Opintotyökalu - Tallenna tai lataa");
		System.out.println("");
		System.out.println("1. Tallenna tiedostoon");
		System.out.println("");
		System.out.println("2. Lataa tiedostosta");
		System.out.println("");
		System.out.println("0. Paluu alkuun");
		System.out.println("");
		System.out.println("");
		System.out.print("Valinta:");
		nappaimisto = new Scanner(System.in);
		
		//Kysytään syötettä niin kauan kunnes annetaan kokonaislukusyöte
		while(nappaimisto.hasNextInt() != true) {
			
			System.out.println("Virheellinen syöte");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
			
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysytään valikkonumeroa kunnes se on oikea
		while ( valintaTallennaValikko(valintanum) == 1) {
			  
			  System.out.print("Valinta:");
			
			  nappaimisto = new Scanner(System.in);
			  //Kysytään syötettä niin kauan kunnes annetaan kokonaislukusyöte
			  while(nappaimisto.hasNextInt() != true) {
					
					System.out.println("Virheellinen syöte");
					System.out.println("");
					System.out.print("Valinta:");
					
					nappaimisto = new Scanner(System.in);	
					
			 }
			 valintanum = nappaimisto.nextInt(); 	
		}
		
	}
	
	
	public void lisaaTenttiValikko() {

		
		/* Alla osa tarvittavat koodista tenttien tietorakenteisiin lisäämistä varten,
		 * Ei vielä kysy käyttäjältä mitään! 
		 *  
		 */
		Tapahtuma lisattavaTentti = new Tapahtuma(null);
		
		System.out.println("Tentin lisääminen:");
		System.out.println("Anna ajat muodossa " + paivaysMalli.toPattern() + " esim. 15.01 14");
		
		lisattavaTentti.setNimi("Käyttäjän syöttämä kurssinimi");
		Date alkuAika = null;
		try {
			alkuAika = paivaysMalli.parse("15.01 14");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lisattavaTentti.setAlku(alkuAika);
		
		}
	
	public void muokkaaTenttiValikko() {
		
		System.out.println("täällä tapahtuu tenttien muokkaus");
		
	}
	public void poistaTenttiValikko() {
		
		System.out.println("täällä tapahtuu tenttien poisto");
		
	}
	/**
	 *    Käyttöliittymän kurssin lisäysvalikko. Ei käytä vielä oikeita tietorakenteita. 
	 *    Tapahtumien lisäyksen toteutus vajaa. Ei virheellisten syötteiden käsittelyä
	 */
	public void lisaaKurssiValikko() {
		
		
		
		Scanner nappaimisto;
		
		//Nämä korvataan oikeilla tietotyypeillä
		String kurssinimi;
		int op;
		String luento;
		
		
		tyhjennaNakyma();
		System.out.println("Opintotyökalu - Kurssin lisäys");
		System.out.println("");
		System.out.print("Anna kurssin nimitys: ");
	
		nappaimisto = new Scanner(System.in);
		kurssinimi = nappaimisto.nextLine();
		
		tyhjennaNakyma();
		System.out.println("Opintotyökalu - Kurssin lisäys");
		System.out.println("");
		System.out.println(kurssinimi);
		System.out.println("");
		System.out.print("Anna kurssin laajuus opintopisteinä: ");
		
		nappaimisto = new Scanner(System.in);
		op = nappaimisto.nextInt();
		
		tyhjennaNakyma();
		System.out.println("Opintotyökalu - Kurssien lisäys");
		System.out.println("");
		System.out.println(kurssinimi);
		System.out.println(op + "op");
		System.out.println("");
		System.out.println("Anna kurssin opetusajat");
		System.out.println("Esim. TI 10-12 Harjoitukset");
        System.out.println("Voit syöttää useampia aikoja, mutta vain yhden kerrallaan");
        System.out.print("Opetusajat: ");
        
        nappaimisto = new Scanner(System.in);
        luento = nappaimisto.nextLine();
        
        tyhjennaNakyma();
		System.out.println("Opintotyökalu - Kurssien lisäys");
		System.out.println("");
		System.out.println(kurssinimi);
		System.out.println(op + "op");
		System.out.println(luento);
		System.out.println("");
        System.out.print("Paina enter palataksesi kurssien hallinnointi valikkoon");
        
        nappaimisto = new Scanner(System.in);
        nappaimisto.nextLine();
        
        //Luodaan jossain vaiheessa uusi kurssi olio lisätään tässä anetut tiedot sille ja 
        //lisätään se kerääjään
        
  
        //Palataan kurssivalikkoon.
        kurssiValikko();
        
		
		
		
	}
	
	/**
	 *    Käyttöliittymän kurssin muokkausvalikko.  
	 *    
	 */
	public void muokkaaKurssiValikko() {
		
		Scanner nappaimisto;
		int valintanum;
		
		tyhjennaNakyma();
		System.out.println("Opintotyökalu – Kurssien muokkaus");
		System.out.println("");
		System.out.println("Muokkaa");
		
		System.out.println("1. Kurssi 1.");
		System.out.println("2. Kurssi 2.");
		System.out.println("3. Kurssi 3.");
		System.out.println("4. Lisää kursseja");
		System.out.println("0. Palaa Ylempään valikkoon");
		System.out.println("");
		System.out.print("Valinta:");
		
		nappaimisto = new Scanner(System.in);
		
		//Kysytään syötettä niin kauan kunnes annetaan kokonaislukusyöte
		while(nappaimisto.hasNextInt() != true) {
			
			System.out.println("Virheellinen syöte");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
			
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysytään valikkonumeroa kunnes se on oikea
		while ( valintaKurssiMuokkausValikko(valintanum) == 1) {
			  
			  System.out.print("Valinta:");
			
			  nappaimisto = new Scanner(System.in);
			  
			  //Kysytään syötettä niin kauan kunnes annetaan kokonaislukusyöte
			  while(nappaimisto.hasNextInt() != true) {
					
					System.out.println("Virheellinen syöte");
					System.out.println("");
					System.out.print("Valinta:");
					
					nappaimisto = new Scanner(System.in);	
					
			 }
			 valintanum = nappaimisto.nextInt(); 	
		}
		
		
	}
	public void poistaKurssiValikko() {
		
		Scanner nappaimisto;
		int valintanum;
		
		tyhjennaNakyma();
		System.out.println("Opintotyökalu – Kurssien poisto");
		System.out.println("");
		System.out.println("Poista");
		
		System.out.println("1. Kurssi 1.");
		System.out.println("2. Kurssi 2.");
		System.out.println("3. Kurssi 3.");
		System.out.println("4. Lisää kursseja");
		System.out.println("0. Palaa Ylempään valikkoon");
		System.out.println("");
		System.out.print("Valinta:");
		
		nappaimisto = new Scanner(System.in);
		
		//Kysytään syötettä niin kauan kunnes annetaan kokonaislukusyöte
		while(nappaimisto.hasNextInt() != true) {
			
			System.out.println("Virheellinen syöte");
			System.out.println("");
			System.out.print("Valinta:");
			
			nappaimisto = new Scanner(System.in);	
			
		}
		
		valintanum = nappaimisto.nextInt();
		
		//kysytään valikkonumeroa kunnes se on oikea
		while ( valintaKurssiPoistoValikko(valintanum) == 1) {
			  
			  System.out.print("Valinta:");
			
			  nappaimisto = new Scanner(System.in);
			  
			  //Kysytään syötettä niin kauan kunnes annetaan kokonaislukusyöte
			  while(nappaimisto.hasNextInt() != true) {
					
					System.out.println("Virheellinen syöte");
					System.out.println("");
					System.out.print("Valinta:");
					
					nappaimisto = new Scanner(System.in);	
					
			 }
			 valintanum = nappaimisto.nextInt(); 	
		}
		
	}
	public void tulostaKurssitValikko() {
		Exporter.printCourses();
		this.raporttiValikko();

	}
	public void tulostaLukkariValikko() {
		Exporter.printTimetable();
		this.raporttiValikko();

	}
	public void tallennaTiedostoonValikko() {
		
		System.out.println("täällä tapahtuu tiedostoon tallentaminen");
			
	}
	public void avaaTiedostostaValikko() {
		
		System.out.println("täällä tapahtuu tiedoston avaaminen");
		
	}
	
	//"Tyhjentää" konsolinäkymän;
	public static void tyhjennaNakyma() {
		int i = 0;
		
		for(i=0;i<300;i++) {
	
			System.out.println("\n");

		}
	}

}

