import java.util.Scanner;

/**
 *      Käyttöliittymä-luokka luo tekstipohjaiset valikot ja mahdollistaa niissä liikkumisen.
 */
public class Kayttoliittyma {
	
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
	 *    Siirtää alavalikkoon päävalikosta annetun valintanumeron mukaan.
	 *    Palauttaa 1, jos virheellinen valinta.
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
	 *    Siirtää alavalikkoon tai päävalikkoon kurssivalikosta annetun valintanumeron mukaan.
	 *    Palauttaa 1, jos virheellinen valinta.
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
	 *    Siirtää alavalikkoon tai päävalikkoon tenttivalikosta annetun valintanumeron mukaan.
	 *    Palauttaa 1, jos virheellinen valinta.
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
	 *    Siirtää alavalikkoon tai päävalikkoon raporttivalikosta annetun valintanumeron mukaan.
	 *    Palauttaa 1, jos virheellinen valinta.
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
	 *    Siirtää alavalikkoon tai päävalikkoon tallennavalikosta annetun valintanumeron mukaan.
	 *    Palauttaa 1, jos virheellinen valinta.
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
		
		System.out.println("täällä tapahtuu tenttien lisäys");
		
	}
	public void muokkaaTenttiValikko() {
		
		System.out.println("täällä tapahtuu tenttien muokkaus");
		
	}
	public void poistaTenttiValikko() {
		
		System.out.println("täällä tapahtuu tenttien poisto");
		
	}
	public void lisaaKurssiValikko() {
		
		System.out.println("täällä tapahtuu kurssien lisäys");
		
	}
	public void muokkaaKurssiValikko() {
		
		System.out.println("täällä tapahtuu kurssien muokkaus");
		
	}
	public void poistaKurssiValikko() {
		
		System.out.println("täällä tapahtuu kurssien muokkaus");
		
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

