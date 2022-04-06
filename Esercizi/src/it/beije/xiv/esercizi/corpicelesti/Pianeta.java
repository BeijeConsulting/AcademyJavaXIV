package it.beije.xiv.esercizi.corpicelesti;


public abstract class Pianeta extends CorpoCeleste{
    boolean abitabile=false;

    public boolean isAbitabile() {
        return abitabile;
    }

    public void setAbitabile(boolean abitabile) {
        this.abitabile = abitabile;
    }


}
