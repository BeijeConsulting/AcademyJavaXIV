package it.beije.xiv.esercizi.corpicelesti;


public abstract class Stella extends CorpoCeleste implements Elementi{
    private int luminosita=0;
    public   void setLuminosita(int luminosita){
        this.luminosita=luminosita;
    }

    public int getLuminosita(){
        return luminosita;
    }

    @Override
    public String toString() {
        return super.toString() +" Luminosità: "+ getLuminosita();
    }
}
