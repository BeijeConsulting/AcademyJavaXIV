package it.beije.xiv.esercizi.discipline;

import it.beije.xiv.esercizi.giochiOlimpici.WinterOlympicGame;

public class Snowboard extends WinterOlympicGame{

    @Override
    public int getNumberOfPlayers() {
        return 0;
    }

    @Override
    public void setNumberOfPlayers(int numberOfPlayers) {

    }

    @Override
    public boolean checkReady() {
        return false;
    }

    @Override
    public void startCompetition() {

    }

    @Override
    public void checkWinner() {

    }

    @Override
    public boolean checkNewWorldRecord() {
        return false;
    }

    @Override
    public boolean dopingTest() {
        return false;
    }
}
