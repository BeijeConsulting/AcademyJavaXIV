package it.beije.turing.beanecommerce;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author Giuseppe Raddato
 * Data: 26 apr 2022
 */

@Entity
@Table(name = "carte")
public class Indirizzo{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "utente_id")
    private int utente_id;
    @Column(name = "via")
    private Date data_scadenza;
    @Column(name = "civico")
    private String civico;
    @Column(name = "città")
    private String citta;
    @Column(name = "cap")
    private String cap;
    @Column(name = "nazione")
    private String nazione;
    @Column(name = "telefono")
    private String telefono;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUtente_id() {
        return utente_id;
    }

    public void setUtente_id(int utente_id) {
        this.utente_id = utente_id;
    }

    public Date getData_scadenza() {
        return data_scadenza;
    }

    public void setData_scadenza(Date data_scadenza) {
        this.data_scadenza = data_scadenza;
    }

    public String getCivico() {
        return civico;
    }

    public void setCivico(String civico) {
        this.civico = civico;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Indirizzo{" +
                "id=" + id +
                ", utente_id=" + utente_id +
                ", data_scadenza=" + data_scadenza +
                ", civico='" + civico + '\'' +
                ", citta='" + citta + '\'' +
                ", cap='" + cap + '\'' +
                ", nazione='" + nazione + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}