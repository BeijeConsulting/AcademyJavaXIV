package it.beije.xiv.esercizi.giochiOlimpici;

public abstract class OlympicSport {
	public int numberOfPlayers;
	
	public int getSportsNumber() {
		return 33;
	};
	
	public abstract int getNumberOfPlayers();
	
	public abstract void setNumberOfPlayers(int numberOfPlayers);
	
	public abstract boolean checkReady();
	
	public abstract void checkWinner();
	
	public abstract boolean checkNewWorldRecord();
	
	public abstract boolean dopingTest();
	
	public void startCompetition() {
		if(checkReady()) {
			System.out.println("3... 2... 1... Go. ");
		} else {
			System.out.println("The competion isn't ready to start. ");
		}
	};
	
}
