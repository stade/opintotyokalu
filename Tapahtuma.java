import java.util.*;

public class Tapahtuma {

	private Date alku, loppu;
	private boolean toistuva;
	private String tyyppi;
	private String nimi;
	private String sijainti;
	private String kuuluuKurssiinNimelta;
	
	 public Tapahtuma(String nimi) {
		this.nimi = nimi;	
	}
	 
	public void setTyyppi(String tyyppi){
	  this.tyyppi = tyyppi;	
	}
	
	public void setNimi(String nimi){
		  this.nimi = nimi;	
		}
	
	public void setSijainti(String sijainti){
		  this.sijainti = sijainti;	
		}
	public void setToistuva(boolean toistuva){
		  this.toistuva = toistuva;	
		}
	
	public void setAlku(Date alku){
		  this.alku = alku;	
		}
	
	public void setLoppu(Date loppu){
		  this.loppu = loppu;
		}

	public Object getNimi() {
		return this.nimi;
		}

	public String getKuuluuKurssiinNimelta() {
		return kuuluuKurssiinNimelta;
	}

	public void setKuuluuKurssiinNimelta(String kuuluuKurssiinNimelta) {
		this.kuuluuKurssiinNimelta = kuuluuKurssiinNimelta;
	}

}
