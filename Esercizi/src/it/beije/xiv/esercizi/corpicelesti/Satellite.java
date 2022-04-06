package it.beije.xiv.esercizi.corpicelesti;


public abstract class Satellite extends CorpoCeleste implements CaratteristicheSatellite{
    protected Pianeta pianeta;


    public void setPianeta(Pianeta pianeta) {
        this.pianeta=pianeta;

    }


    public Pianeta getPianeta() {
        return pianeta;
    }


    @Override
    public String toString() {
        return "nomeCorpoCeleste='" + getNome() + '\'' +
                ", dimensione=" + getDimensione() +
                ", eta='" + getEta() + '\'' +
                ", DurataRotazione=" + getDurataRotazione()+
                " Pianeta Orbitante= { "+pianeta+ " }\n";
    }
}
