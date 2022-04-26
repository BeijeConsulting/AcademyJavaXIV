package it.beije.turing.beanecommerce;

import javax.persistence.*;

/**
 * @author Giuseppe Raddato
 * Data: 26 apr 2022
 */

@Entity
@Table(name = "carrelli")
public class Carrello {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "id_prodotto")
    private int id_prodotto;
    @Column(name = "quantità")
    private int quantita;
    @Column(name = "id_utente")
    private Integer id_utente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_prodotto() {
        return id_prodotto;
    }

    public void setId_prodotto(int id_prodotto) {
        this.id_prodotto = id_prodotto;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public Integer getId_utente() {
        return id_utente;
    }

    public void setId_utente(Integer id_utente) {
        this.id_utente = id_utente;
    }

    @Override
    public String toString() {
        return "Carrello{" +
                "id=" + id +
                ", id_prodotto=" + id_prodotto +
                ", quantita=" + quantita +
                ", id_utente=" + id_utente +
                '}';
    }
}
