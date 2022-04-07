package it.beije.xiv.esercizi.discipline;

import it.beije.xiv.esercizi.giochiOlimpici.WinterOlympicGame;
import it.beije.xiv.esercizi.sport.Ski;

public class Snowboard extends WinterOlympicGame implements Ski{

    @Override
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    @Override
    public void setNumberOfPlayers(int numberOfPlayers) {
    	this.numberOfPlayers = numberOfPlayers;
    }

    @Override
    public boolean checkReady() {
        return true;
    }

    @Override
    public void checkWinner() {
    	System.out.println("This winner is GNOGNO!");
    }

    @Override
    public boolean checkNewWorldRecord() {
        return true;
    }

    @Override
    public boolean dopingTest() {
        return true;
    }

	@Override
	public boolean avalancheControl() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean equipmentList() {
		// TODO Auto-generated method stub
		System.out.println("Attrezzi per sciare pronti");
		return true;
	}

	@Override
	public boolean checkEquipment() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public String toString() {
		if(dopingTest()) System.out.println("Doping test superato");
		else System.out.println("Doping test non superato");
		
		
		if(avalancheControl()) {
			
			
			if(checkReady() && !dopingTest() && equipmentList()) {
				startCompetition();
				checkWinner();
			} else System.out.println("Giocatore non ha superato i test");
			if(checkNewWorldRecord()) {
				System.out.print("Record mondiale di: ");
				checkWinner();
			}
		} else System.out.println("Valanga prevista, competizione annullata");
		return "Competizione di valanghe terminata";
	}
}
