package it.beije.xiv.esercizi.corpicelesti;


public abstract class CorpoCeleste {

    protected abstract void setNome(String nomeCorpoCeleste);

    public abstract String getNome();

    protected abstract void setDimensione(int dimensione);

    public abstract int getDimensione();

    protected abstract void setDurataRotazion(int durata);

    public abstract int getDurataRotazione();


    public abstract void setEta(String eta);

    public abstract String getEta();

    @Override
    public String toString() {
        String s="Nome: "+getNome() +
                " Dimensione: "+getDimensione()+
                " Età: "+getEta() +"";

        return s+=(getDurataRotazione()>=0? " DurataOrbita: "+getDurataRotazione():"");
    }
}
