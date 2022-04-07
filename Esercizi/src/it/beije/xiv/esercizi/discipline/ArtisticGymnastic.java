package it.beije.xiv.esercizi.discipline;

import it.beije.xiv.esercizi.giochiOlimpici.SummerOlympicGame;
import it.beije.xiv.esercizi.sport.Gymnastic;

public class ArtisticGymnastic extends SummerOlympicGame implements Gymnastic {

    @Override
    public boolean checkEquipment() {
        return true;
    }

    @Override
    public String equipmentList() {
        return "Rings, Pommel horse, symmetrical parallels, bar";
    }

    @Override
    public int getNumberOfPlayers() {
        return 10;
    }

    @Override
    public void setNumberOfPlayers(int numberOfPlayers) {
    this.numberOfPlayers=numberOfPlayers;
    }

    @Override
    public boolean checkReady() {
        return true;
    }

    @Override
    public void checkWinner() {
    System.out.println("The winner is Peppinho");
    }

    @Override
    public boolean checkNewWorldRecord() {
        return true;
    }

    @Override
    public boolean dopingTest() {
        return true;
    }
}
