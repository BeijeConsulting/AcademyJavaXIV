package it.beije.xiv.esercizi.corpicelesti;


public class Terra extends Pianeta{

    private String nomeCorpoCeleste;
    private int dimensione;
    private int durataOrbita;
    private String eta;

    public Terra(int dimensione, int durataRotazione, String eta){
        setNome("Terra");
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


}
