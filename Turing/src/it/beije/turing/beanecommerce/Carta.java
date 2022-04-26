package it.beije.turing.beanecommerce;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author Giuseppe Raddato
 * Data: 26 apr 2022
 */

@Entity
@Table(name = "carte")
public class Carta{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "codice")
    private String codice;
    @Column(name = "data_scadenza")
    private Date data_scadenza;
    @Column(name = "provider")
    private String provider;
    @Column(name = "cvv")
    private String cvv;
    @Column(name = "utente_id")
    private String utente_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public Date getData_scadenza() {
        return data_scadenza;
    }

    public void setData_scadenza(Date data_scadenza) {
        this.data_scadenza = data_scadenza;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getUtente_id() {
        return utente_id;
    }

    public void setUtente_id(String utente_id) {
        this.utente_id = utente_id;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "id=" + id +
                ", codice='" + codice + '\'' +
                ", data_scadenza=" + data_scadenza +
                ", provider='" + provider + '\'' +
                ", cvv='" + cvv + '\'' +
                ", utente_id='" + utente_id + '\'' +
                '}';
    }
}