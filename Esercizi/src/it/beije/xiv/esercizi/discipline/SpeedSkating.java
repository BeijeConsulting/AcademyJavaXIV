package it.beije.xiv.esercizi.discipline;

import it.beije.xiv.esercizi.giochiOlimpici.WinterOlympicGame;
import it.beije.xiv.esercizi.sport.Skating;

public class SpeedSkating extends WinterOlympicGame implements Skating{
	
	public boolean flattingFloor;
	public boolean ready;
	
	public SpeedSkating(boolean flattingFloor, int numberOfPlayers, boolean ready) {
		this.flattingFloor = flattingFloor;
		this.numberOfPlayers = numberOfPlayers;
		this.ready = ready;
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
		return  (int) (Math.random() * 10 + 1);
	}

	@Override
	public void setNumberOfPlayers(int numberOfPlayers) {
		// TODO Auto-generated method stub
		this.numberOfPlayers = numberOfPlayers;
	}

	@Override
	public boolean checkReady() {
		// TODO Auto-generated method stub
		return ready;
	}

	@Override
	public void startCompetition() {
		// TODO Auto-generated method stub
		System.out.println("");
	}

	@Override
	public void checkWinner() {
		// TODO Auto-generated method stub
		
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

}