package it.beije.turing.Ecomm.Beans;

import javax.persistence.*;

@Entity
@Table(name="acquisto")
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

    public Acquisto(){
        this(0, 0.00);
    }
    public Acquisto( int idProdotto, double quantita) {

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

    @Override
    public String toString() {
        return "Acquisto  [" +
                " idAcquisto =" + idAcquisto +
                " , idOrdine =" + idOrdine +
                " , idProdotto =" + idProdotto +
                " , quantita =" + quantita +
                " ]";
    }
}
