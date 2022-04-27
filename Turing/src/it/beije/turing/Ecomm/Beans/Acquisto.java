package it.beije.turing.Ecomm.Beans;

import javax.persistence.*;

@Entity
@Table(name="acquisto")
public class Acquisto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int idAcquisto;
    @ManyToOne
    @JoinColumn(name = "idOrdine")
    private int idOrdine;
    @Column(name = "idProdotto")
    private int idProdotto;
    @Column(name = "quantita")
    private int quantita;

    public Acquisto(){
        this(0, 0);
    }
    public Acquisto( int idProdotto, int quantita) {

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
