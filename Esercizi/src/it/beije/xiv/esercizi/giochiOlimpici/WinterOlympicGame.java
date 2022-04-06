package it.beije.xiv.esercizi.giochiOlimpici;

public abstract class WinterOlympicGame extends OlympicSport{
	
	public int getSportsNumber() {
		return 15;
	}
	
	public boolean isWinterYear(int year) {
		return (year % 2 == 0 && year % 4 != 0);
	}
}
