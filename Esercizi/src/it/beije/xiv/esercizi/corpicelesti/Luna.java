package it.beije.xiv.esercizi.corpicelesti;


public class Luna extends Satellite{
    private String nomeCorpoCeleste;
    private int dimensione;
    private int durataOrbita;
    private String eta;
    private int rivoluzione;


    public Luna(int dimensione, int durataRotazione, String eta, Pianeta pianeta, int rivoluzione ){
        setNome("Luna");
        setDurataRotazion(durataRotazione);
        setEta(eta);
        setDimensione(dimensione);
        setPianeta(pianeta);
        setRivoluzione(rivoluzione);

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
    public void setRivoluzione(int rivoluzione) {
        this.rivoluzione=rivoluzione;

    }

    @Override
    public int getRivoluzione() {
        return this.rivoluzione;
    }


}
