package it.beije.xiv.esercizi.giochiOlimpici;

public abstract class SummerOlympicGame extends OlympicSport{
	
	public int getSportsNumber() {
		return 46;
	}
	
	public boolean isLeapYear(int year) {
		return (year % 4 == 0);
	}
}
