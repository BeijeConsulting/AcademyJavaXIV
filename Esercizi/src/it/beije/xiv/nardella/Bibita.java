package it.beije.xiv.nardella;

public class Bibita {
	private int content;
	private int evapPerDay;
	private int threshold;

	public static void main(String[] args) {
		Bibita bibita = new Bibita(500, 5, 50);
		System.out.println(bibita.calcolaGiorniImbottigliamento());
	}

	public Bibita(int content, int evapPerDay, int threshold) {
		this.content = content;
		this.evapPerDay = evapPerDay;
		this.threshold = threshold;
	}

	public int calcolaGiorniImbottigliamento() {
		int count = 0;
		float current = content;
		float limit = (float)(content * threshold / 100);
		
		while(current >= limit) {
			current -= (float)current * evapPerDay / 100;
			count++;
		}
		
		return count;
	}

}
