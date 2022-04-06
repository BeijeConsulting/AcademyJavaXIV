package it.beije.xiv.esercizi.corpicelesti;

import java.util.Arrays;



public class Sole extends Stella {
    private String nomeCorpoCeleste;
    private int dimensione;
    private int durataOrbita;
    private String eta;
    private String[] elemen;

    public Sole(int dimensione, int durataRotazione, String eta){
        setNome("Sole");
        setDurataRotazion(durataRotazione);
        setEta(eta);
        setDimensione(dimensione);
    }


    @Override
    protected void setNome(String nomePianeta) {
        this.nomeCorpoCeleste=nomePianeta;
    }

    public String getNome() {
        return nomeCorpoCeleste;
    }

    @Override
    protected void setDimensione(int dimensione) {
        this.dimensione=dimensione;
    }

    @Override
    public int getDimensione() {
        return this.dimensione;
    }

    @Override
    protected void setDurataRotazion(int durata) {
        this.durataOrbita=durata;
    }

    @Override
    public int getDurataRotazione() {
        return this.durataOrbita;

    }


    @Override
    public void setEta(String eta) {
        this.eta=eta;
    }

    @Override
    public String getEta() {
        return eta;
    }

    @Override
    public void setListaElementi(String... element) {
        this.elemen=element;

    }

    @Override
    public String[] getListaElementi() {
        return elemen;
    }


}
