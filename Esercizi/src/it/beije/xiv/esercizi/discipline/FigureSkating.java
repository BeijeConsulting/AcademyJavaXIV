package it.beije.xiv.esercizi.discipline;

import it.beije.xiv.esercizi.giochiOlimpici.WinterOlympicGame;
import it.beije.xiv.esercizi.sport.Cycling;
import it.beije.xiv.esercizi.sport.Gymnastic;

public class FigureSkating extends WinterOlympicGame implements Gymnastic, Cycling{

	@Override
	public int getNumberOfPlayers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setNumberOfPlayers(int numberOfPlayers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkReady() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void startCompetition() {
		// TODO Auto-generated method stub
		if(checkReady()) {
			System.out.println("Inizia la competizione di " + getClass());
			this.boolean = true;
	}

	@Override
	public void checkWinner() {
		// TODO Auto-generated method stub
		if(boolean) {
			System.out.println("Il vincitore è ");
		}
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

	@Override
	public boolean checkEquipment() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String equipmentList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isBikeAdaptForCompetion() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean security() {
		// TODO Auto-generated method stub
		return false;
	}

}
