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
		return this.numberOfPlayer;
	}

	@Override
	public void setNumberOfPlayers(int numberOfPlayer) {
		// TODO Auto-generated method stub
		this.numberOfPlayer = numberOfPlayer;
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
	
}
