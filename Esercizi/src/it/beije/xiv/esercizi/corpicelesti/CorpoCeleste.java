package it.beije.xiv.esercizi.corpicelesti;


public abstract class CorpoCeleste {

    protected abstract void setNome(String nomeCorpoCeleste);

    public abstract String getNome();

    protected abstract void setDimensione(int dimensione);

    public abstract int getDimensione();

    protected abstract void setDurataOrbita(int durata);

    public abstract int getDurataOrbita();


    public abstract void setEta(String eta);

    public abstract String getEta();

    @Override
    public String toString() {
        String s="Nome: "+getNome() +
                " Dimensione: "+getDimensione()+
                " Età: "+getEta() +"";

        return s+=(getDurataOrbita()>0? " DurataOrbita: "+getDurataOrbita():"");
    }
}
