package tests;

import java.util.*;

import opintotyokalu.*;

import opintotyokalu.Exporter;
import opintotyokalu.Keraaja;
import opintotyokalu.Kurssi;
import opintotyokalu.Tapahtuma;

import junit.framework.TestCase;

public class KayttoliittymaTest extends TestCase {

	Kayttoliittyma testi;
	Keraaja tiedot;
	
	public KayttoliittymaTest(String name) {
		super(name);
	}
	
	public KayttoliittymaTest() {
		testi = new Kayttoliittyma();
		tiedot = new Keraaja();
	}
	
	//getTiedot()
	
	public void testgetTiedot() {	
		assertTrue(testi.getTiedot() instanceof Keraaja);
	}
	
	//valintaAloitusValikko()
	
	public void testvalintaAloitusValikkoArvoYksi() {
		assertTrue(testi.valintaAloitusValikko(1) == 0);
	}
	
	public void testvalintaAloitusValikkoArvoKaksi() {
		assertTrue(testi.valintaAloitusValikko(2) == 0);
	}
	
	public void testvalintaAloitusValikkoArvo0() {
		assertTrue(testi.valintaAloitusValikko(0) == 1);
	}
	
	public void testvalintaAloitusValikkoArvo12() {
		assertTrue(testi.valintaAloitusValikko(12) == 1);
	}
	
	//valintaPaaValikki(int)

	public void testvalintaPaaValikko1() {
		assertTrue(testi.valintaPaaValikko(1) == 0);
	}
	
	public void testvalintaPaaValikko2() {
		assertTrue(testi.valintaPaaValikko(2) == 0);
	}
	
	public void testvalintaPaaValikko3() {
		assertTrue(testi.valintaPaaValikko(3) == 0);
	}
	
	public void testvalintaPaaValikko4() {
		assertTrue(testi.valintaPaaValikko(4) == 0);
	}
	
	public void testvalintaPaaValikko0() {
		assertTrue(testi.valintaPaaValikko(0) == 0);
	}
	
	public void testvalintaPaaValikko15() {
		assertTrue(testi.valintaPaaValikko(15) == 1);
	}
	
	//valintaKurssiValikko(int valintanum)
	
	public void testvalintaKurssiValikko1() {
		assertTrue(testi.valintaKurssiValikko(1) == 0);
	}
	
	public void testvalintaKurssiValikko2() {
		assertTrue(testi.valintaKurssiValikko(2) == 0);
	}
	
	public void testvalintaKurssiValikko3() {
		assertTrue(testi.valintaKurssiValikko(3) == 0);
	}
	
	public void testvalintaKurssiValikko0() {
		assertTrue(testi.valintaKurssiValikko(0) == 0);
	}
	
	public void testvalintaKurssiValikkofail() {
		assertTrue(testi.valintaKurssiValikko(98) == 1);
	}
	
	
	//valintaTenttiValikko(int valintanum)
	public void testvalintaTenttiValikko0() {
		assertTrue(testi.valintaTenttiValikko(0) == 0);
	}
	
	public void testvalintaTenttiValikko1() {
		assertTrue(testi.valintaTenttiValikko(1) == 0);
	}
	
	public void testvalintaTenttiValikko2() {
		assertTrue(testi.valintaTenttiValikko(2) == 0);
	}
	
	public void testvalintaTenttiValikko3() {
		assertTrue(testi.valintaTenttiValikko(3) == 0);
	}
	
	public void testvalintaTenttiValikko4() {
		assertTrue(testi.valintaTenttiValikko(4) == 0);
	}
	
	public void testvalintaTenttiValikkofail() {
		assertTrue(testi.valintaTenttiValikko(12313) == 1);
	}
	
	//valintaRaporttiValikko(int valintanum)
	
	public void testvalintaRaporttiValikko0() {
		assertTrue(testi.valintaRaporttiValikko(0) == 0);
	}
	
	public void testvalintaRaporttiValikko1() {
		assertTrue(testi.valintaRaporttiValikko(1) == 0);
	}
	
	public void testvalintaRaporttiValikko2() {
		assertTrue(testi.valintaRaporttiValikko(2) == 0);
	}
	
	public void testvalintaRaporttiValikkofail() {
		assertTrue(testi.valintaRaporttiValikko(1231) == 1);
	}
	
	//valintaTallennaValikko(int valintanum)
	public void testvalintaTallennaValikko0() {
		assertTrue(testi.valintaRaporttiValikko(0) == 0);
	}
	
	public void testvalintaTallennaValikko1() {
		assertTrue(testi.valintaRaporttiValikko(1) == 0);
	}
	
	public void testvalintaTallennaValikko2() {
		assertTrue(testi.valintaRaporttiValikko(2) == 0);
	}
	
	public void testvalintaTallennaValikkofail() {
		assertTrue(testi.valintaRaporttiValikko(1231) == 1);
	}
	
	//valintaKurssiMuokkausValikko(int valintanum)
	public void testvalintaKurssiMuokkausValikko0() {
		assertTrue(testi.valintaKurssiMuokkausValikko(0) == 0);
	}
	
	public void testvalintaKurssiMuokkausValikkofail() {
		assertTrue(testi.valintaKurssiMuokkausValikko(10000) == 1);
	}
	
	public void testvalintaKurssiMuokkausValikko1() {
		assertTrue(testi.valintaKurssiMuokkausValikko(1) == 0);
	}
	
	public void testvalintaKurssiMuokkausValikko3() {
		assertTrue(testi.valintaKurssiMuokkausValikko(3) == 0);
	}
	
	//valintaKurssiPoistoValikko(int valintanum)
	
	public void testvalintaKurssiPoistoValikko0() {
		assertTrue(testi.valintaKurssiPoistoValikko(0) == 0);
	}
	
	public void testvalintaKurssiPoistoValikkofail() {
		assertTrue(testi.valintaKurssiPoistoValikko(1234128340) == 1);
	}
	
	public void testvalintaKurssiPoistoValikko1s() {
		assertTrue(testi.valintaKurssiPoistoValikko(1) == 0);
	}
	
	//valintaLopetusValikko(int valintanum)
	
	public void testvalintaLopetusValikko1() {
		assertTrue(testi.valintaLopetusValikko(1) == 0);
	}
	
	public void testvalintaLopetusValikko2() {
		assertTrue(testi.valintaLopetusValikko(2) == 0);
	}
	
	public void testvalintaLopetusValikko0() {
		assertTrue(testi.valintaLopetusValikko(0) == 0);
	}
	
	public void testvalintaLopetusValikkofail() {
		assertTrue(testi.valintaLopetusValikko(123121) == 1);
	}
	
	
	//aloitusValikko()
	//vaikeahko testata koska käyttäjän syötteitä tarvitaan
	public void testaloitusValikko() {
		
	}
	
	//paaValikko()
	//vaikeahko testata koska käyttäjän syötteitä tarvitaan
	public void testpaaValikko() {
		
	}
	
	//kurssiValikko()
	//vaikeahko testata koska käyttäjän syötteitä tarvitaan
	public void testkurssiValikko() {
		
	}
	
	//tenttiValikko()
	//vaikeahko testata koska käyttäjän syötteitä tarvitaan
	public void testtenttiValikko() {
		
	}
	
	//raporttiValikko()
	//vaikeahko testata koska käyttäjän syötteitä tarvitaan
	public void testraporttiValikko() {
		
	}
	
	//tallennaValikko()
	//vaikeahko testata koska käyttäjän syötteitä tarvitaan
	public void testtallennaValikko() {
		
	}
	
	//lisaaTenttiValikko()
	//vaikeahko testata koska käyttäjän syötteitä tarvitaan
	public void testlisaaTenttiValikko() {
		
	}
	
	//muokkaaTenttiValikko()
	//vaikeahko testata koska käyttäjän syötteitä tarvitaan
	public void testmuokkaaTenttiValikko() {
		
	}
	
	//poistaTenttiValikko()
	//vaikeahko testata koska käyttäjän syötteitä tarvitaan
	public void testpoistaTenttiValikko() {
		
	}
	
	//tulevatTentitValikko
	//vaikeahko testata koska käyttäjän syötteitä tarvitaan
	public void testtulevatTentitValikko() {
		
	}
	
	//lisaaKurssiValikko()
	//vaikeahko testata koska käyttäjän syötteitä tarvitaan
	public void testlisaaKurssiValikko() {
		
	}
	
	//parseKayttajanAntamaAika(String str)
	public void testparseKayttajanAntamaAika() {
		assertTrue(testi.parseKayttajanAntamaAika("10") instanceof Date);
	}
	
	public void testparseKayttajanAntamaAikafail() {
		assertFalse(testi.parseKayttajanAntamaAika("15.5 10-12 tentti") instanceof Date);
	}
	
	//muokkaaKurssiValikko() 
	//vaikeahko testata koska käyttäjän syötteitä tarvitaan
	public void testmuokkaaKurssiValikko() {
		
	}
	
	//poistaKurssiValikko()
	//vaikeahko testata koska käyttäjän syötteitä tarvitaan
	public void testpoistaKurssiValikko() {
		
	}
	
	//tulostaKurssitValikko()
	public void testtulostaKurssitValikko() {
		
	}
	
	//tallennaTiedostoonValikko()
	//vaikeahko testata koska käyttäjän syötteitä tarvitaan
	public void testtallennaTiedostoonValikko() {
		
	}
	
	//tallennaTiedostoonLopetusValikko()
	//vaikeahko testata koska käyttäjän syötteitä tarvitaan
	public void testtallennaTiedostoonLopetusValikko() {
		
	}
	
	//avaaTiedostostaAlussaValikko()
	//vaikeahko testata koska käyttäjän syötteitä tarvitaan
	public void testavaaTiedostostaAlussaValikko() {
		
	}
	
	//avaaTiedostostaValikko()
	//vaikeahko testata koska käyttäjän syötteitä tarvitaan
	public void testavaaTiedostostaValikko() {
		
	}
	
	//tietynKurssinMuokkausValikko(int kurssiIndeksi)
	//vaikeahko testata koska käyttäjän syötteitä tarvitaan
	public void testtietynKurssinMuokkausValikko() {
		//assertTrue(testi.tietynKurssinMuokkausValikko(int kurssiIndeksi));
	}
	
	//lopetusValikko()
	//vaikeahko testata koska käyttäjän syötteitä tarvitaan
	public void testlopetusValikko() {
		
	}
	
	//kasitteleAnnettuValintaKurssinmuokkausvalikossa(int valintanum, Kurssi kurssi, ArrayList<Tapahtuma> valikonTapahtumat)
	//vaatii käyttäjän syötteitä
	public void testkasitteleAnnettuValintaKurssinmuokkausValikossa() {
		
	}
	

}
