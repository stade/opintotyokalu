/**
 * Luokkakuvaus tähän
 * @author ryhmä
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *	Käyttöliittymä -luokka luo tekstipohjaiset valikot ja mahdollistaa niissä liikkumisen.
 */
public class Kayttoliittyma {

	private SimpleDateFormat paivaysMalli; // yhteinen malli päivänmäärille
	private Keraaja tiedot;
	private SaverLoader saveLoad = new SaverLoader();

	public Kayttoliittyma() {
		 this.paivaysMalli = new SimpleDateFormat("dd.MM.yy HH");	//Käyttäjän syötettävä ajat tässä muodossa
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
	 * 	Siirtää alavalikkoon pääsvalikosta annetun valintanumeron mukaan.
	 * 	Palauttaa 1, jos virheellinen valinta. 0 jos halutaan poistua ohjelmasta.
	 *
	 *	@param valintanum
	 *	@return
	 */
	public int valintaAloitusValikko(int valintanum) {

		switch (valintanum) {

	        case 1: avaaTiedostostaAlussaValikko();	break;
	        case 2: return 0;
	        default : System.out.println("Virheellinen sy�te");  return 1;

		}
		return 0;
	}
	
	/**
	 * 
	 * @param valintanum
	 * @return
	 */
	public int valintaPaaValikko(int valintanum) {

		switch (valintanum) {

	        case 1: kurssiValikko();     						break;
	        case 2: tenttiValikko();    						break;
	        case 3: raporttiValikko();   						break;
	        case 4: tallennaValikko();							break;
	        case 0: lopetusValikko();	 						return 0;
	        default : System.out.println("Virheellinen syöte"); return 1;

		}
		return 0;
	}

	/**
	 * Siirtää alavalikkoon tai päävalikkoon kurssivalikosta annetun
	 * valintanumeron mukaan. Palauttaa 1, jos virheellinen valinta.
	 *
	 * @param valintanum
	 * @return int
	 */
	public int valintaKurssiValikko(int valintanum) {

		switch (valintanum) {

	        case 1: lisaaKurssiValikko();     					break;
	        case 2: muokkaaKurssiValikko();    					break;
	        case 3: poistaKurssiValikko();   					break;
	        case 0: paaValikko();								break;
	        default : System.out.println("Virheellinen syöte"); return 1;
		}
		return 0;
	}

	/**
	 *	Siirtää alavalikkoon tai päävalikkoon tenttivalikosta annetun
	 *  valintanumeron mukaan. Palauttaa 1, jos virheellinen valinta.
	 *
	 *  @param valintanum
	 *  @return
	 */
	public int valintaTenttiValikko(int valintanum) {

		switch (valintanum) {

	        case 1: lisaaTenttiValikko();   				  	break;
	        case 2: muokkaaTenttiValikko();    					break;
	        case 3: poistaTenttiValikko();   					break;
	        case 0: paaValikko();								break;
	        default : System.out.println("Virheellinen syöte"); return 1;

		}
		return 0;

	}

	/**
	 *	Siirtää alavalikkoon tai päävalikkoon raporttivalikosta annetun
	 * 	valintanumeron mukaan. Palauttaa 1, jos virheellinen valinta.
	 *
	 * @param valintanum
	 * @return
	 */
	public int valintaRaporttiValikko(int valintanum) {

		switch (valintanum) {

	        case 1: tulostaKurssitValikko();			     	break;
	        case 2: tulostaLukkariValikko();    				break;
	        case 0: paaValikko();								break;
	        default : System.out.println("Virheellinen syöte");	return 1;

		}
		return 0;

	}

	/**
	 *	Siirtää alavalikkoon tai päävalikkoon tallennavalikosta annetun
	 *  valintanumeron mukaan. Palauttaa 1, jos virheellinen valinta.
	 *
	 *  @param valintanum
	 *  @return
	 */
	public int valintaTallennaValikko(int valintanum) {

		switch (valintanum) {

	        case 1: tallennaTiedostoonValikko();				break;
	        case 2: avaaTiedostostaValikko();					break;
	        case 0: paaValikko();								break;
	        default : System.out.println("Virheellinen syöte"); return 1;

		}
		return 0;
	}

	/**
	 *	Muokataan kursseja tai siirrytään kurssivalikkoon kurssien muokkausvalikosta
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
			// Kurssien numerot valikossa alkavat 1:stä, ArrayListissä 0:sta, siispä vähennetään yksi
			tietynKurssinMuokkausValikko(valintanum-1);
			kurssiValikko();
			return 0;
		}
		else {
			System.out.println("Virheellinen syöte");
			return 1;
		}
	}

	/**
	 *	Poistetaan kursseja tai siirrytään kurssivalikkoon kurssien poistovalikosta
	 *  annetun valintanumeron mukaan.
	 *
	 *  @param valintanum käyttäjän valitseman toiminnon numero
	 *  @return Palauttaa 1, jos virheellinen valinta.
	 */
	public int valintaKurssiPoistoValikko(int valintanum) {

		//tähän parempi virheenkäsittely esim isInteger
		if (valintanum == 0) {
			kurssiValikko();
			return 0;
		}
		else if (valintanum > 0 && valintanum <= this.tiedot.getKurssit().size()) {
			//Kurssien numerot valikossa alkavat 1:stä, ArrayListissä 0:sta, siispä vähennetään yksi
			this.tiedot.getKurssit().remove(valintanum-1);
			kurssiValikko();
			return 0;
		}
		else {
			System.out.println("Virheellinen syöte");
			return 1;
		}
	}

	/**
	 *
	 * @param valintanum
	 * @return
	 */
	public int valintaTenttiMuokkausValikko(int valintanum) {

		switch (valintanum) {
	        //Keskeneräinen ei toimintoja
	        case 1: System.out.print("tästä 1. tentin muokkaus");   break;
	        case 2: System.out.print("tästä 2. tentin muokkaus");   break;
	        case 3: System.out.print("tästä 3. tentin muokkaus");   break;
	        case 4: System.out.print("tästä lisää tenttejä");		break;
	        case 0: tenttiValikko();								break;
	        default : System.out.println("Virheellinen syöte");  	return 1;

		}
		return 0;
	}

	/**
	 *
	 * @param valintanum
	 * @return
	 */
	public int valintaTenttiPoistoValikko(int valintanum) {

		//tähän parempi virheenk�sittely esim isInteger
		if (valintanum == 0) {
			tenttiValikko();
			return 0;
		}
		else if (valintanum > 0 && valintanum <= this.tiedot.getTentit().size()) {
			//Kurssien numerot valikossa alkavat 1:stä, ArrayListissä 0:sta, siispä vähennetään yksi
			this.tiedot.getTentit().remove(valintanum-1);
			tenttiValikko();
			return 0;
		}
		else {
			System.out.println("Virheellinen syöte");
			return 1;
		}
	}

	/**
	 *
	 */
	public int valintaLopetusValikko(int valintanum) {

		switch (valintanum) {
		
	        case 1: tallennaTiedostoonLopetusValikko();			break;
	        case 2: System.out.println("Näkemiin!");			return 0;
	        case 0: paaValikko();								break;
	        default : System.out.println("Virheellinen syöte"); return 1;

		}
		return 0;
	}


	/**
	 *
	 */
	public void aloitusValikko() {

		int valintanum;
		Scanner nappaimisto;

		tyhjennaNakyma();
		System.out.println("Opintotyökalu");
		System.out.println("");
		System.out.println("1. Lataa tiedot");
		System.out.println("");
		System.out.println("2. Aloita lataamatta tietoja");
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

		//Kysytään valikkonumeroa kunnes se on oikea
		while(valintaAloitusValikko(valintanum) == 1) {

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
	 *	Käyttöliittymän päävalikko.
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

		//Kysytään valikkonumeroa kunnes se on oikea
		while(valintaPaaValikko(valintanum) == 1) {

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
	 *	Käyttöliittymän kurssivalikko.
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
		System.out.println("0. Palaa takaisin");
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

		//Kysytään valikkonumeroa kunnes se on oikea
		while(valintaKurssiValikko(valintanum) == 1) {

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
	 *	Käyttöliittymän tenttivalikko.
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
		System.out.println("0. Palaa takaisin");
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

		//Kysytään valikkonumeroa kunnes se on oikea
		while(valintaTenttiValikko(valintanum) == 1) {
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
	 *	Käyttöliittymän raporttivalikko.
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
		System.out.println("0. Palaa takaisin");
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

		//Kysytään valikkonumeroa kunnes se on oikea
		while(valintaRaporttiValikko(valintanum) == 1) {
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
	 *	Käyttöliittymän tallennusvalikko.
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
		System.out.println("0. Palaa takaisin");
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

		//Kysytään valikkonumeroa kunnes se on oikea
		while(valintaTallennaValikko(valintanum) == 1) {
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
	 *
	 */
	public void lisaaTenttiValikko() {
		
		Scanner nappaimisto;

		//nämä korvataan oikeilla tietotyypeillä
		String tenttinimi;
		String luento;

		tyhjennaNakyma();
		System.out.println("Opintotyökalu - Tentin lisäys");
		System.out.println("");
		System.out.print("Anna tentin nimi: ");

		nappaimisto = new Scanner(System.in);
		tenttinimi = nappaimisto.nextLine();

		tyhjennaNakyma();
		System.out.println("Opintotyökalu - Tentin lisäys");
		System.out.println("");
		System.out.println(tenttinimi);
		System.out.println("");
		System.out.println("Anna tentin ajankohta esim. 16.12. 10-12");
        System.out.print("Tentin Ajankohta: ");

        nappaimisto = new Scanner(System.in);
        luento = nappaimisto.nextLine();

        // Ei lisätä mitään jos käyttäjä ei syötä ajankohtaa.
        if(!luento.equals("")) {

        	tyhjennaNakyma();
        	System.out.println("Opintotyökalu - Tenttien lisäys");
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

        	Date[] taulukkoAjoista = palautaStringDatena(luento);
        	lisattyTapahtuma.setAlku(taulukkoAjoista[0]);
        	lisattyTapahtuma.setLoppu(taulukkoAjoista[1]);
        }

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
		System.out.println("Opintotyökalu - Tenttien muokkaus");
		System.out.println("");
		System.out.println("Muokkaa");

		System.out.println("1. Tentti 1.");
		System.out.println("2. Tentti 2.");
		System.out.println("3. Tentti 3.");
		System.out.println("4. Lisää tenttejä");
		System.out.println("0. Palaa takaisin");
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

		//Kysytään valikkonumeroa kunnes se on oikea
		while(valintaTenttiMuokkausValikko(valintanum) == 1) {
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
	 *
	 */
	public void poistaTenttiValikko() {

		Scanner nappaimisto;
		int valintanum;

		ArrayList<Tapahtuma> tentit = this.tiedot.getTentit();

		tyhjennaNakyma();
		System.out.println("Opintotyökalu - Tenttien poisto");
		System.out.println("");
		System.out.println("Poista");

		for(int i =0; i<tentit.size(); i++) {
			System.out.println(i+1 + ". " + tentit.get(i).getNimi());
		}
		
		System.out.println("0. Palaa takaisin");
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

		//Kysytään valikkonumeroa kunnes se on oikea
		while(valintaTenttiPoistoValikko(valintanum) == 1) {
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
	 *	Käyttöliittymän kurssin lisäysvalikko. Ei käytä vielä oikeita tietorakenteita.
	 *  Tapahtumien lisäyksen toteutus vajaa. Ei virheellisten syötteiden käsittelyä.
	 */
	public void lisaaKurssiValikko() {

		Scanner nappaimisto;

		//nämä korvataan oikeilla tietotyypeillä
		String kurssinimi;
		int op;
		String luento;
		String sijainti;
		ArrayList<Tapahtuma> uudetTapahtumat = new ArrayList<Tapahtuma>();
		Tapahtuma uusiTapahtuma;

		tyhjennaNakyma();
		System.out.println("Opintotyökalu - Kurssin lisäys");
		System.out.println("");
		System.out.print("Anna kurssin nimi: ");

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


		Kurssi lisattyKurssi = new Kurssi(kurssinimi, op);
	    this.tiedot.addKurssi(lisattyKurssi);

		//Loopataan kunnes tyhja syöte. Niihin voidaan lisätään useampia tapahtumia peräkkäin.
		do {
			tyhjennaNakyma();
			System.out.println("Opintotyökalu - Kurssien lisäys");
			System.out.println("");
			System.out.println(kurssinimi);
			System.out.println(op + "op");

			//tulostetaan lisätyt tapahtumat
			for(int i=0; i<uudetTapahtumat.size(); i++){
				System.out.println(uudetTapahtumat.get(i).getNimi());
			}

			System.out.println("");

			System.out.println("Anna kurssin opetustiedot pilkulla erottaen esim.");
			System.out.println("16.7. 10-12 Harjoitukset");
			System.out.println("HUOM: Anna TENTIT muodossa 16.7. 10-12 tentti");
			System.out.println("Voit syöttää useampia tapahtumia, aina yhden kerrallaan. Pelkkä tyhjä syöte lopettaa lisäämisen.");
			System.out.print("Opetusajat: ");

			nappaimisto = new Scanner(System.in);
			luento = nappaimisto.nextLine();

			if(luento.equals("")) break;

			System.out.println("Anna vielä sijainti(voit jättää tyhjäksi): ");

			nappaimisto = new Scanner(System.in);
			sijainti = nappaimisto.nextLine();

			//lisätään kurssi kerääjään.

			uusiTapahtuma = new Tapahtuma(luento);
			uusiTapahtuma.setKuuluuKurssiinNimelta(lisattyKurssi.getNimi());

			Date[] taulukkoAjoista = palautaStringDatena(luento);
			uusiTapahtuma.setAlku(taulukkoAjoista[0]);
			uusiTapahtuma.setLoppu(taulukkoAjoista[1]);
			uusiTapahtuma.setToistuva(true);
			uusiTapahtuma.setSijainti(sijainti);

			String[] parametrit = luento.split(" ", 3);

			//Viimeinen parametri on tapahtuman nimi, jos parametreja ei ole tarpeeksi, säilyy nimenä käyttäjän syöte.
			if(parametrit.length > 2) {
				uusiTapahtuma.setNimi(parametrit[2]);
				if(parametrit[2].equalsIgnoreCase("Tentti")) {
					this.tiedot.getTentit().add(uusiTapahtuma);
					uusiTapahtuma.setToistuva(false);
				}
				else {
					this.tiedot.getTapahtumat().add(uusiTapahtuma);
				}

			}
			else {
				this.tiedot.getTapahtumat().add(uusiTapahtuma);
			}

			uudetTapahtumat.add(uusiTapahtuma);

		} while (!luento.equals(""));

        tyhjennaNakyma();
		System.out.println("Opintotyökalu - Kurssien lisäys");
		System.out.println("");
		System.out.println(kurssinimi);
		System.out.println(op + "op");
		for(int i=0; i<uudetTapahtumat.size(); i++){
			System.out.println(uudetTapahtumat.get(i).getNimi());
		}
		System.out.println("");
        System.out.print("Paina enter palataksesi takaisin");

        nappaimisto = new Scanner(System.in);
        nappaimisto.nextLine();

        //Palataan kurssivalikkoon.
        kurssiValikko();
	}

	/**
	 *	Muuttaa käyttäjän String muodossa antaman ajan Date-olioksi ja palauttaa sen.
	 *  Ei toteutettu virheenhallintaa kunnolla!
	 *
	 *  @param str merkkijono josta aika parsetaan
	 *  @return Date olio jos onnistutaan ja null jos catchataan poikkeus
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
	 *	Käyttöliittymän kurssin muokkausvalikko. Keskeneräinen.
	 */
	public void muokkaaKurssiValikko() {

		Scanner nappaimisto;
		int valintanum;

		ArrayList<Kurssi> kurssit = this.tiedot.getKurssit();

		tyhjennaNakyma();
		System.out.println("Opintotyökalu - Kurssien muokkaus");
		System.out.println("");
		System.out.println("Muokkaa");

		for(int i =0; i<kurssit.size(); i++) {
			System.out.println(i+1 + ". " + kurssit.get(i).getNimi());
		}

		System.out.println("0. Palaa takaisin");
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

		//Kysytään valikkonumeroa kunnes se on oikea
		while(valintaKurssiMuokkausValikko(valintanum) == 1) {
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
	 *	Käyttöliittymän kurssin poistovalikko. Keskeneräinen.
	 */
	public void poistaKurssiValikko() {

		Scanner nappaimisto;
		int valintanum;


		ArrayList<Kurssi> kurssit = this.tiedot.getKurssit();

		tyhjennaNakyma();
		System.out.println("Opintoty�kalu - Kurssien poisto");
		System.out.println("");
		System.out.println("Poista");
		
		for(int i =0; i<kurssit.size(); i++) {
			System.out.println(i+1 + ". " + kurssit.get(i).getNimi());
		}

		System.out.println(kurssit.size()+1 + ". Lisää kursseja");
		System.out.println("0. Palaa takaisin");
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

		//Kysytään valikkonumeroa kunnes se on oikea
		while(valintaKurssiPoistoValikko(valintanum) == 1) {
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
	 *
	 */
	public void tulostaKurssitValikko() {
		Exporter.printCourses(this.tiedot);
		this.raporttiValikko();
	}

	/**
	 *
	 */
	public void tulostaLukkariValikko() {
		Exporter.printTimetable(this.tiedot);
		this.raporttiValikko();
	}

	/**
	 *	Tallentaan tiedostoon annetun tiedostopolun mukaan.
	 */
	public void tallennaTiedostoonValikko() {

		Scanner nappaimisto;
		String tallennuspolku;

		tyhjennaNakyma();
		System.out.println("Opintotyökalu - Tallennus tiedostoon");
		System.out.println("");
		System.out.println("Syötä tiedostonimi ja paina enter.");
		System.out.println("");
		System.out.print("Tiedostonimi: ");

		nappaimisto = new Scanner(System.in);
		tallennuspolku = nappaimisto.nextLine();

		//Tässä tallennetaan annetun tiedostonimen perusteella
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

	public void tallennaTiedostoonLopetusValikko() {

		Scanner nappaimisto;
		String tallennuspolku;

		tyhjennaNakyma();
		System.out.println("Opintotyökalu - Tallennus tiedostoon");
		System.out.println("");
		System.out.println("Syötä tiedostonimi ja paina enter.");
		System.out.println("");
		System.out.print("Tiedostonimi: ");

		nappaimisto = new Scanner(System.in);
		tallennuspolku = nappaimisto.nextLine();

		//Tässä tallennetaan annetun tiedostonimen perusteella
		if (this.saveLoad.saveObject(this.tiedot, tallennuspolku)) {
			System.out.println("Tallentaminen onnistui!");
		}
		else {
			System.out.println("Tallentaminen epäonnistui.");
		}

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Näkemiin");

	}
	
	/**
	 *	Avaa tiedoston annetun tiedostopolun mukaan.
	 */
	public void avaaTiedostostaAlussaValikko() {

		Scanner nappaimisto;
		String avauspolku;

		tyhjennaNakyma();
		System.out.println("Opintotyökalu - Tiedostosta avaaminen");
		System.out.println("");
		System.out.println("Syötä tiedostonimi ja paina enter.");
		System.out.println("");
		System.out.print("Tiedostonimi: ");

		nappaimisto = new Scanner(System.in);
		avauspolku = nappaimisto.nextLine();

		try {
			//Tässä avataan tiedostosta annetun tiedostonimen perusteella
			this.tiedot = (Keraaja)this.saveLoad.loadObject(avauspolku);
			if (!(this.tiedot instanceof Keraaja)) {
				System.out.println("Lataaminen epäonnistui!");
				this.tiedot = new Keraaja();
			}
			else {
				System.out.println("Lataaminen onnistui!");
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 *	Avaa tiedoston annetun tiedostopolun mukaan.
	 */
	public void avaaTiedostostaValikko() {

		Scanner nappaimisto;
		String avauspolku;

		tyhjennaNakyma();
		System.out.println("Opintotyökalu - Tiedostosta avaaminen");
		System.out.println("");
		System.out.println("Syötä tiedostonimi ja paina enter.");
		System.out.println("");
		System.out.print("Tiedostonimi: ");

		nappaimisto = new Scanner(System.in);
		avauspolku = nappaimisto.nextLine();

		try {
			//Tässä avataan tiedostosta annetun tiedostonimen perusteella
			this.tiedot = (Keraaja)this.saveLoad.loadObject(avauspolku);
			
			if (!(this.tiedot instanceof Keraaja)) {
				System.out.println("Lataaminen epäonnistui!");
				this.tiedot = new Keraaja();
			}
			else {
				System.out.println("Lataaminen onnistui!");
			}
			
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		paaValikko();
	}

	/**
	 * 
	 * @param kurssiIndeksi
	 */
	public void tietynKurssinMuokkausValikko(int kurssiIndeksi) {
		
		ArrayList<Kurssi> kurssit = this.tiedot.getKurssit();
		ArrayList<Tapahtuma> tapahtumat = this.tiedot.getTapahtumat();
		ArrayList<Tapahtuma> tentit = this.tiedot.getTentit();

		Scanner nappaimisto;
		int valintanum;
		ArrayList<Tapahtuma> valikonTapahtumat = new ArrayList<Tapahtuma>();

		tyhjennaNakyma();
		System.out.println("Opintoty�kalu -  Kurssin muokkaus");
		System.out.println("");
		System.out.println("Muokkaa");

		System.out.println("1." + kurssit.get(kurssiIndeksi).getNimi());
		System.out.println("2." + kurssit.get(kurssiIndeksi).getLaajuus());

		String kurssinNimi = kurssit.get(kurssiIndeksi).getNimi();
		
		for(int i = 0; i < tapahtumat.size(); i++) {
			if(kurssinNimi.equals(tapahtumat.get(i).getKuuluuKurssiinNimelta())) {
				valikonTapahtumat.add(tapahtumat.get(i));
			}
		}

		for(int i = 0; i < tentit.size(); i++) {
			if(kurssinNimi.equals(tentit.get(i).getKuuluuKurssiinNimelta())) {
				valikonTapahtumat.add(tentit.get(i));
			}
		}

		//Tulostetaan valittavissa olevat tapahtumat
		for(int i = 0; i < valikonTapahtumat.size(); i++){
			System.out.println(3+i + ". " + valikonTapahtumat.get(i).getNimi());
		}

		System.out.println("0. Palaa takaisin");
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

		//Kysytään valikkonumeroa kunnes se on oikea
		while(kasitteleAnnettuValintaKurssinmuokkausvalikossa(valintanum, kurssit.get(kurssiIndeksi),valikonTapahtumat) == 1) {
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
	public void lopetusValikko() {

		Scanner nappaimisto;
		int valintanum;


		System.out.println("Opintotyökalu - Lopetus");
		System.out.println("");
		System.out.println("1. Tallenna ja lopeta");
		System.out.println("");
		System.out.println("2. Lopeta tallentamatta");
		System.out.println("");
		System.out.println("3. Palaa päävalikkoon");
		System.out.println("");
		System.out.print("Valinta: ");

		nappaimisto = new Scanner(System.in);

		//Kysytään syötettä niin kauan kunnes annetaan kokonaislukusyöte
		while(nappaimisto.hasNextInt() != true) {

			System.out.println("Virheellinen syöte");
			System.out.println("");
			System.out.print("Valinta:");

			nappaimisto = new Scanner(System.in);
		}

		valintanum = nappaimisto.nextInt();

		//Kysytään valikkonumeroa kunnes se on oikea
		while(valintaLopetusValikko(valintanum) == 1) {

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
	 * 
	 * @param valintanum
	 * @param kurssi
	 * @param valikonTapahtumat
	 * @return
	 */
	private int kasitteleAnnettuValintaKurssinmuokkausvalikossa(int valintanum, 
		Kurssi kurssi, ArrayList<Tapahtuma> valikonTapahtumat) {

		switch(valintanum) {

			case 1:
				kurssi.setNimi(lueString());
				return 0;
			case 2:
				kurssi.setLaajuus(lueInt());
				return 0;
			case 0:
				return 0;
			default:
				tapahtumanMuokkausValikko(valikonTapahtumat.get(valintanum-3));
				return 0;
		}
	}

	/**
	 * 
	 * @param tapahtuma
	 */
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
			case 1:tapahtuma.setNimi(lueString()); 		break;
			case 2:tapahtuma.setSijainti(lueString()); 	break;
			case 3:tapahtuma.setAlku(lueYksiPVM());
			case 4:tapahtuma.setLoppu(lueYksiPVM());
			case 0:break;
			default:break;
		}

	}
	
	/**
	 * 
	 * @return
	 */
	private Date lueYksiPVM() {
		Scanner nappaimisto = new Scanner(System.in);

		System.out.println("Anna aika:");
		return palautaStringDatena(nappaimisto.nextLine())[0];
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	private Date[] palautaStringDatena(String str){

		Date currenttime = new Date(System.currentTimeMillis());
		DateFormat dateFormat = new SimpleDateFormat("yy");

		//Ajan parseaminen käyttäjän syötteestä ja sen lisääminen tapahtumaan
        String[] parametrit = str.split(" ", 3);

        //Aika1 ja Aika2:een muodostetaan stringit joista parseri sitten luo Date-oliot.

        //lisätään päivänmäärät
        String aika1 = parametrit[0];
        String aika2 = parametrit[0];

        //lisätään nykyinen vuosi
        aika1 += dateFormat.format(currenttime);
        aika2 += dateFormat.format(currenttime);

        //Käsitellään käyttäjän antama tuntisyöte esim. 10-12

        //Jaetaan koko käyttäjän antama syöte kahtia "-" merkistä
        String[] tunnit = str.split("-");

        //Otetaan vasemman splitin kaksi viimeistä merkkiä ja lisätään parserille tarjottavaan stringiin
        aika1 += " " + tunnit[0].charAt(tunnit[0].length()-2);
        aika1 += tunnit[0].charAt(tunnit[0].length()-1);

        //Otetaan kaksi ensimmäistä oikealta puolelta ja lisätään ne toiseen parserille tarjottavaan stringiin
        aika2 += " " + tunnit[1].charAt(0);
        aika2 += tunnit[1].charAt(1);

        //Lopuksi nämä stringit parsetaan ja aika talletetaan tapahtumaaan.

        Date[] ret = new Date[2];
        ret[0] = parseKayttajanAntamaAika(aika1);
        ret[1] = parseKayttajanAntamaAika(aika2);

        return ret;
	}

	private String lueString() {
		Scanner nappaimisto = new Scanner(System.in);

		System.out.println("Syötä teksti:");
		return nappaimisto.nextLine();
	}

	private int lueInt() {
		Scanner nappaimisto = new Scanner(System.in);

		System.out.println("Sy�t� luku:");
		return nappaimisto.nextInt();
	}

	private int getValikkoValinta() {
		Scanner nappaimisto = new Scanner(System.in);

		//Kysytään syötettä niin kauan kunnes annetaan kokonaislukusyöte
		while(nappaimisto.hasNextInt() != true) {

			System.out.println("Virheellinen syöte");
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

