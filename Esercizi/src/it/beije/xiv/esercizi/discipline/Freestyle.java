package it.beije.xiv.esercizi.discipline;

import it.beije.xiv.esercizi.giochiOlimpici.WinterOlympicGame;
import it.beije.xiv.esercizi.sport.Ski;

public class Freestyle extends WinterOlympicGame implements Ski {

    @Override
    public int getNumberOfPlayers() {
        return 5;
    }

    @Override
    public void setNumberOfPlayers(int numberOfPlayers) {
    this.numberOfPlayers=numberOfPlayers;
    }

    @Override
    public boolean checkReady() {
        System.out.println("Pronti per la gara...");
        return false;
    }

    @Override
    public void checkWinner() {
        System.out.println("Il vincitore è Peppinho");
    }

    @Override
    public boolean checkNewWorldRecord() {
        System.out.println("Nuovo record!!!");
        return false;
    }

    @Override
    public boolean dopingTest() {
        System.out.println("Check doping: ");
        return true;
    }

    @Override
    public boolean avalancheControl() {
        System.out.println("Check valanga: ");
        return true;
    }

    @Override
    public boolean equipmentList() {
        System.out.println("Skis bindings; boots; rackets.");
        return false;
    }

    @Override
    public boolean checkEquipment() {
        return false;
    }

    public String toString() {
        if(dopingTest()) {
            System.out.println("Tutti i partecipanti sono Dopati");
        }
        else {
            System.out.println("Doping test superato");
            if (checkReady()) {
                startCompetition();
                checkWinner();
            }
            if (checkNewWorldRecord()) {
                System.out.print("Record mondiale di: ");
                checkWinner();
            }
        }
        return "Competizione terminata";
    }
}
