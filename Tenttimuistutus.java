import java.util.Scanner;

public class Tenttimuistutus {
	

	//Muistuttaa tulevista tenteistä
	public void muistuta(String[] tentit) {
		
		Scanner nappaimisto;
		
		tulostaVali(10);
		
		System.out.print("Huom!");
		
		tulostaVali(10);
	
		rivinvaihto(2);
		
		tulostaVali(5);
		
		System.out.print("Tulevat tentit:");
		
		tulostaVali(5);
		
		rivinvaihto(2);
		
		//Tulostaa tulevat tentit
		for (int i = 0; i < tentit.length; i++ ) {
			
			tulostaVali(1);
			
			System.out.print(tentit[i]);
			
			tulostaVali(1);
			
			rivinvaihto(1);
			
		}
		
		rivinvaihto(1);
		
		tulostaVali(3);
		
		System.out.print("Paina enter jatkaaksesi!");
		
		tulostaVali(3);
		
		rivinvaihto(1);
		
		nappaimisto = new Scanner(System.in);
		
		//odottaa kunnes painetaan enter
		nappaimisto.nextLine();
		
		Kayttoliittyma.tyhjennaNakyma();
		
	}
	
	//Tulostaa tyhjän välin
	public void tulostaVali(int k) {
	
		while (0 < k) {
			
			System.out.print(" ");
			k--;
		}
		
		
	}
	//Vaihtaa rivin
	public void rivinvaihto(int k) {
		
		while(0 < k) {
			
			System.out.println("");
			k--;
			
		}
		
	}
}
