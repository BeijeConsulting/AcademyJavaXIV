package it.beije.xiv.esercizi.completi;

public class BibitaGassata {

	public static void main(String[] args) {
		BibitaGassata.stampaScadenza(1000000, 100, 60000);
	}
	
	public static void stampaScadenza(int content, int evaporPerDay, int threshold) {
		int nGiorni = 0;
		int actualState = content;
		for(nGiorni = 0; actualState >= threshold; nGiorni++) {
			actualState -= evaporPerDay;
		}
		System.out.println("La bibita scadrà fra " + nGiorni +" giorni");
	}
}
