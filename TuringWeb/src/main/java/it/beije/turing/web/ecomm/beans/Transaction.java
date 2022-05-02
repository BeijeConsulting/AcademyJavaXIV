package it.beije.turing.web.ecomm.beans;

import javax.persistence.*;

@Entity
@Table(name="acquisto")
public class Transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int idAcquisto;
    @ManyToOne
    @JoinColumn(name = "idOrdine")
    private Order idOrdine;
    @Column(name = "idProdotto")
    private int idProdotto;
    @Column(name = "quantita")
    private int quantita;

    public Transaction(){
        this(0, 0);
    }
    public Transaction( int idProdotto, int quantita) {

        this.idProdotto = idProdotto;
        this.quantita = quantita;
    }

    public int getIdAcquisto() {
        return idAcquisto;
    }

    public void setIdAcquisto(int idAcquisto) {
        this.idAcquisto = idAcquisto;
    }

    public Order getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(Order idOrdine) {
        this.idOrdine = idOrdine;
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }
    
    public String toString()
    {
    	return Integer.valueOf(this.getQuantita()).toString();
    }
}