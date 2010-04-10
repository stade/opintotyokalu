/**
 * Kuvaus luokasta tähän
 * 
 * @author ryhmä?
 */

import java.util.*;

public class Tapahtuma {

	private Date alku, loppu;
	private boolean toistuva;
	private String tyyppi;
	private String nimi;
	private String sijainti;
	private String kuuluuKurssiinNimelta;
	
	/**
	 * 
	 * @param nimi
	 */
	public Tapahtuma(String nimi) {
		this.nimi = nimi;	
	}
	
	/**
	 * 
	 * @param tyyppi
	 */
	public void setTyyppi(String tyyppi){
	  this.tyyppi = tyyppi;	
	}
	
	/**
	 * 
	 * @param nimi
	 */
	public void setNimi(String nimi){
		this.nimi = nimi;	
	}
	
	/**
	 * 
	 * @param sijainti
	 */
	public void setSijainti(String sijainti){
		this.sijainti = sijainti;	
	}
	
	/**
	 * 
	 * @param toistuva
	 */
	public void setToistuva(boolean toistuva){
		this.toistuva = toistuva;	
	}
	
	/**
	 * 
	 * @param alku
	 */
	public void setAlku(Date alku){
		this.alku = alku;	
	}
	
	/**
	 * 
	 * @param loppu
	 */
	public void setLoppu(Date loppu){
		this.loppu = loppu;
	}

	/**
	 * 
	 * @return
	 */
	public Object getNimi() {
		return this.nimi;
	}
	
	/**
	 * 
	 * @return
	 */
	public Date getAlku() {
		return this.alku;
	}
	/**
	 * 
	 * @return
	 */
	public String getSijainti() {
		return this.sijainti;
	}
	/**
	 * 
	 * @return
	 */
	public String getKuuluuKurssiinNimelta() {
		return kuuluuKurssiinNimelta;
	}

	/**
	 * 
	 * @param kuuluuKurssiinNimelta
	 */
	public void setKuuluuKurssiinNimelta(String kuuluuKurssiinNimelta) {
		this.kuuluuKurssiinNimelta = kuuluuKurssiinNimelta;
	}

}
