package it.beije.xiv.esercizi;

public class GasEvap
{
	/*
	 *	Calcola giorni utili per imbottigliare la bibita conoscendo:
	 *			- quantità bibita pronta nella cisterna ("content", in ml)
	 *			- percentuale di gas che evapora in 24 ore ("evapPerDay")
	 *			- soglia percentuale oltre la quale la bibita non è più apprezzabile ("threshold")
	 *
	 *	Il programma restituisce poi il numero del giorno oltre la quale la bibità non sarà più vendibile (non più sufficientemente gasata)
	 * 
	 */
	
	public static void main(String[] args)
	{
		GasEvap ge = new GasEvap();
		int content = 5000;
		int evapPerDay = 300;
		int threshold = 3000;
		int scadenza = ge.giorniScadenza(content, evapPerDay, threshold);
		scadenza = (scadenza > 0) ? scadenza : 0;
		
		System.out.println((scadenza > 0) ? ("La bibita non sara' piu' vendibile tra: " + scadenza + ((scadenza == 1) ? " giorno." : " giorni.")) : "La bibita' non e' piu' vendibile.");
	}
	
	public int giorniScadenza(int content, int evapPerDay, int threshold)
	{
		if (threshold > content) return 0;
		
		int scadenza = 0;
		
		for(; content > threshold; scadenza++, content-=evapPerDay) {}
		
		return scadenza;
	}
}
