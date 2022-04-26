package it.beije.turing.Ecomm.Beans;

import javax.persistence.*;


public class Acquisto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int idAcquisto;

    @Column(name = "idOrdine")
    private int idOrdine;
    @Column(name = "idProdotto")
    private int idProdotto;
    @Column(name = "quantita")
    private double quantita;

    public Acquisto(int idAcquisto, int idOrdine, int idProdotto, double quantita) {
        this.idAcquisto = idAcquisto;
        this.idOrdine = idOrdine;
        this.idProdotto = idProdotto;
        this.quantita = quantita;
    }

    public int getIdAcquisto() {
        return idAcquisto;
    }

    public void setIdAcquisto(int idAcquisto) {
        this.idAcquisto = idAcquisto;
    }

    public int getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    public double getQuantita() {
        return quantita;
    }

    public void setQuantita(double quantita) {
        this.quantita = quantita;
    }
}
