package it.beije.xiv.esercizi.giochiOlimpici;

public abstract class OlympicSport {
	
	public int getSportsNumber() {
		return 33;
	};
	
	public abstract int getNumberOfPlayers();
	
	public abstract void setNumberOfPlayers();
	
	public abstract boolean checkReady();
	
	public abstract void startCompetition();
	
	public abstract void checkWinner();
	
	public abstract boolean checkNewWorldRecord();
	
	public abstract boolean dopingTest();
	
}
