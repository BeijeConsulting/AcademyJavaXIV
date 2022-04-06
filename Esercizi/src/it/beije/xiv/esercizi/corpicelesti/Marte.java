package it.beije.xiv.esercizi.corpicelesti;


public class Marte extends Pianeta{

    private String nomeCorpoCeleste;
    private int dimensione;
    private int durataOrbita;
    private String eta;

    public Marte(int dimensione, int durataOrbita, String eta){
        setNome("Marte");
        setDurataOrbita(durataOrbita);
        setEta(eta);
        setDimensione(dimensione);
    }

    public Marte(int dimensione, String eta){
        setNome("Marte");
        setDurataOrbita(-1);
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
    protected void setDurataOrbita(int durata) {
        this.durataOrbita=durata;
    }

    @Override
    public int getDurataOrbita() {
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
