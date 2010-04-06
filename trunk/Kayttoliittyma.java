import java.util.Scanner;

/**
 *      K�ytt�liittym�-luokka luo tekstipohjaiset valikot ja mahdollistaa niiss� liikkumisen.
 */
public class Kayttoliittyma {
	
	/**
	 *    K�ytt�liittym�n p��valikko.
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
		while ( valintaPaaValikko(valintanum) == 1) {
			  
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
	 *    Siirt�� alavalikkoon p��valikosta annetun valintanumeron mukaan.
	 *    Palauttaa 1, jos virheellinen valinta.
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
	 *    Siirt�� alavalikkoon tai p��valikkoon kurssivalikosta annetun valintanumeron mukaan.
	 *    Palauttaa 1, jos virheellinen valinta.
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
	 *    Siirt�� alavalikkoon tai p��valikkoon tenttivalikosta annetun valintanumeron mukaan.
	 *    Palauttaa 1, jos virheellinen valinta.
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
	 *    Siirt�� alavalikkoon tai p��valikkoon raporttivalikosta annetun valintanumeron mukaan.
	 *    Palauttaa 1, jos virheellinen valinta.
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
	 *    Siirt�� alavalikkoon tai p��valikkoon tallennavalikosta annetun valintanumeron mukaan.
	 *    Palauttaa 1, jos virheellinen valinta.
	 */
	public int valintaTallennaValikko(int valintanum) {
		
			
			switch (valintanum) {
	       
	        	case 1: tallennaTiedostoonValikko();     	break;
	        	case 2: avaaTiedostostaValikko();    		break;
	        	case 0: paaValikko();						break;
	        	default : System.out.println("Virheellinen sy�te");  return 1;

			}
		
		return 0;
		
	}
	/**
	 *    K�ytt�liittym�n kurssivalikko.
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
		System.out.println("0. Paluu alkuun");
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
		while ( valintaKurssiValikko(valintanum) == 1) {
			  
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
	 *    K�ytt�liittym�n tenttivalikko.
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
		System.out.println("0. Paluu alkuun");
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
		while ( valintaTenttiValikko(valintanum) == 1) {
			  
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
	 *    K�ytt�liittym�n raporttivalikko.
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
		System.out.println("0. Paluu alkuun");
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
		while ( valintaRaporttiValikko(valintanum) == 1) {
			  
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
	 *    K�ytt�liittym�n tallennusvalikko.
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
		System.out.println("0. Paluu alkuun");
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
		while ( valintaTallennaValikko(valintanum) == 1) {
			  
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
	
	
	public void lisaaTenttiValikko() {
		
		System.out.println("t��ll� tapahtuu tenttien lis�ys");
		
	}
	public void muokkaaTenttiValikko() {
		
		System.out.println("t��ll� tapahtuu tenttien muokkaus");
		
	}
	public void poistaTenttiValikko() {
		
		System.out.println("t��ll� tapahtuu tenttien poisto");
		
	}
	public void lisaaKurssiValikko() {
		
		System.out.println("t��ll� tapahtuu kurssien lis�ys");
		
	}
	public void muokkaaKurssiValikko() {
		
		System.out.println("t��ll� tapahtuu kurssien muokkaus");
		
	}
	public void poistaKurssiValikko() {
		
		System.out.println("t��ll� tapahtuu kurssien muokkaus");
		
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
		
		System.out.println("t��ll� tapahtuu tiedostoon tallentaminen");
			
	}
	public void avaaTiedostostaValikko() {
		
		System.out.println("t��ll� tapahtuu tiedoston avaaminen");
		
	}
	
	//"Tyhjent��" konsolin�kym�n;
	public static void tyhjennaNakyma() {
		int i = 0;
		
		for(i=0;i<300;i++) {
	
			System.out.println("\n");

		}
	}

}

