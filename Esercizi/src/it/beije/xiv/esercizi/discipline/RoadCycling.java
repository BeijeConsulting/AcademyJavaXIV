package it.beije.xiv.esercizi.discipline;

import it.beije.xiv.esercizi.giochiOlimpici.SummerOlympicGame;
import it.beije.xiv.esercizi.sport.Cycling;

public class RoadCycling extends SummerOlympicGame implements Cycling{

	@Override
	public boolean isBikeAdaptForCompetion() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean security() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getNumberOfPlayers() {
		// TODO Auto-generated method stub
		return this.numberOfPlayers;
	}

	@Override
	public void setNumberOfPlayers(int numberOfPlayers) {
		// TODO Auto-generated method stub
		this.numberOfPlayers = numberOfPlayers;
	}

	@Override
	public boolean checkReady() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void checkWinner() {
		// TODO Auto-generated method stub
		System.out.println("Potato Potatoooo!");
	}

	@Override
	public boolean checkNewWorldRecord() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dopingTest() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String toString() {
		if(dopingTest()) System.out.println("Doping test superato");
		else System.out.println("Doping test non superato, la competizione non iniziera.");
		
		if(checkReady() && !dopingTest()) {
			startCompetition();
			checkWinner();
		}
		if(checkNewWorldRecord()) {
			System.out.print("Record mondiale di: ");
			checkWinner();
		}
		return "Competizione Bici su strada terminata";
	}
	
}
