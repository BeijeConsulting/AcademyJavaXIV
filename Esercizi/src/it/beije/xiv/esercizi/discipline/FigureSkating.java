package it.beije.xiv.esercizi.discipline;

import it.beije.xiv.esercizi.giochiOlimpici.WinterOlympicGame;
import it.beije.xiv.esercizi.sport.Cycling;
import it.beije.xiv.esercizi.sport.Gymnastic;

public class FigureSkating extends WinterOlympicGame implements Gymnastic, Cycling{

	@Override
	public int getNumberOfPlayers() {
		// TODO Auto-generated method stub
		return numberOfPlayers;
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
	public void checkWinner() {
			System.out.println("Il vincitore è Potato Mom. ");
		}
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
	public boolean checkEquipment() {
		// TODO Auto-generated method stub
		System.out.println("L'equippagiamento è pronto per la competizione. ");
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
