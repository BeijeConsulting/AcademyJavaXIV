package it.beije.xiv.esercizi.discipline;

import it.beije.xiv.esercizi.giochiOlimpici.WinterOlympicGame;
import it.beije.xiv.esercizi.sport.Skating;

public class SpeedSkating extends WinterOlympicGame implements Skating{
	
	public boolean flattingFloor;
	public boolean ready;
	
	public SpeedSkating() {
		this.flattingFloor = false;
		this.numberOfPlayers = (int) (Math.random() * 10 + 1);
		this.ready = true;
	}

	@Override
	public void flattingFloor() {
		// TODO Auto-generated method stub
		if(!flattingFloor) {
			System.out.println("The floor has been flatted.");
			this.flattingFloor = true;
		} else {
			System.out.println("The floor is already flat.");
		}
	}

	@Override
	public boolean isFloorReady() {
		// TODO Auto-generated method stub
		if(flattingFloor) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getNumberOfPlayers() {
		// TODO Auto-generated method stub
		return  numberOfPlayers;
	}

	@Override
	public void setNumberOfPlayers(int numberOfPlayers) {
		// TODO Auto-generated method stub
		this.numberOfPlayers = numberOfPlayers;
	}

	@Override
	public boolean checkReady() {
		// TODO Auto-generated method stub
		System.out.println("Tutte le squadre sono pronte. ");
		return ready;
	}

	@Override
	public void checkWinner() {
		// TODO Auto-generated method stub
		System.out.println("Il vincitore è potato jr.");
	}

	@Override
	public boolean checkNewWorldRecord() {
		// TODO Auto-generated method stub
		System.out.println("Potato jr. ha fatto un nuovo world record. ");
		return false;
	}

	@Override
	public boolean dopingTest() {
		// TODO Auto-generated method stub
		System.out.println("Tutti i giocatori non sono dopati. ");
		return false;
	}
	
	public String toString() {
		flattingFloor();
		
		if(checkReady() && !dopingTest()) {
			startCompetition();
			checkWinner();
			checkNewWorldRecord();
		}
		return "La competizione di Speed Staking è finita. ";
	}

}
