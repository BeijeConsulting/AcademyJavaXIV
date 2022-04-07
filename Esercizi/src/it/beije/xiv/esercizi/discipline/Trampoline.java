package it.beije.xiv.esercizi.discipline;

import it.beije.xiv.esercizi.giochiOlimpici.SummerOlympicGame;
import it.beije.xiv.esercizi.sport.Gymnastic;

public class Trampoline extends SummerOlympicGame implements Gymnastic {

	@Override
	public boolean checkEquipment() {
		return true;
	}

	@Override
	public String equipmentList() {
		return "Rope, hoop, ball, clubs and ribbon";
	}

	@Override
	public int getNumberOfPlayers() {
		return 3;
	}

	@Override
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers=numberOfPlayers;
	}

	@Override
	public boolean checkReady() {
		System.out.println("Squadre pronte");
		return true;
	}

	@Override
	public void checkWinner() {
		System.out.println("The winner is Peppinho");
	}

	@Override
	public boolean checkNewWorldRecord() {
		System.out.println("Nuovo record!!!");
		return true;
	}

	@Override
	public boolean dopingTest() {
		System.out.println("Tutti i giocatori sono in condizione di giocare");
		return false;
	}

	public String toString() {

		if(checkReady() && !dopingTest()) {
			startCompetition();
			checkWinner();
			checkNewWorldRecord();
		}
		return "La competizione di salto sul trampolino è finita. ";
	}
}
