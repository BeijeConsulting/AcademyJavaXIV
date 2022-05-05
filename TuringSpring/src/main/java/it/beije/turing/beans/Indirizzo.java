package it.beije.turing.beans;

import javax.persistence.*;

@Entity
@Table(name = "indirizzo" )
public class Indirizzo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="cap")
    private String cap;
    @Column(name="citta")
    private String citta;
    @Column(name="provincia")
    private String provincia;
    @Column(name="via")
    private String via;
    @Column(name="stato")
    private String stato;
    @Column(name="numero_civico")
    private String numeroCivico;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public String getNumeroCivico() {
        return numeroCivico;
    }

    public void setNumeroCivico(String numeroCivico) {
        this.numeroCivico = numeroCivico;
    }

    @Override
    public String toString() {
        return "Indirizzo{" +
                "id=" + id +
                ", cap='" + cap + '\'' +
                ", citta='" + citta + '\'' +
                ", provincia='" + provincia + '\'' +
                ", via='" + via + '\'' +
                ", stato='" + stato + '\'' +
                ", numeroCivico='" + numeroCivico + '\'' +
                '}';
    }
}
