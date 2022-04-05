package it.beije.xiv.eserciziCOM;



public class Bibita {

	public static void main(String[] args) {
		Bibita.Sgasa(1_000_000, 1 ,60);
		
	}
	
	public static void Sgasa(int content, int evaporPerDay, int threshold) {
		
		int i = 0;
		int giorni = 0; 
		
		while( i <= (100-threshold)) {
			
			i += evaporPerDay;
			giorni++;
			
		}
		
		System.out.println("Scadenza tra " + giorni +" giorni");
}

}
