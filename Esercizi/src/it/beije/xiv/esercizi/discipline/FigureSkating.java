package it.beije.xiv.esercizi.discipline;

import it.beije.xiv.esercizi.giochiOlimpici.WinterOlympicGame;
import it.beije.xiv.esercizi.sport.Skating;

public class FigureSkating extends WinterOlympicGame implements Skating{

	@Override
	public int getNumberOfPlayers() {
		// TODO Auto-generated method stub
		return numberOfPlayers;
	}

	@Override
	public void setNumberOfPlayers(int numberOfPlayers) {
		// TODO Auto-generated method stub
		this.numberOfPlayers = numberOfPlayers;
		
	}

	@Override
	public boolean checkReady() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void checkWinner() {
			System.out.println("Il vincitore è Potato Mom. ");
	}

	@Override
	public boolean checkNewWorldRecord() {
		System.out.println("Potato Mom non ha effettuato un record mondiale.");
		return false;
	}

	@Override
	public boolean dopingTest() {
		System.out.println("Nessun giocatore risulta in condizoni di doping.");
		return false;
	}

	@Override
	public void flattingFloor() {
		if(isFloorReady()) {
			System.out.println("The floor is already flat.");
		} else {
			System.out.println("The floor has been flatted.");
		}
	}

	@Override
	public boolean isFloorReady() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public String toString() {
		flattingFloor();
		
		if(checkReady() && !dopingTest()) {
			startCompetition();
			checkWinner();
			checkNewWorldRecord();
		}
		return "La competizione di Figure Staking è finita. ";
	}

}
