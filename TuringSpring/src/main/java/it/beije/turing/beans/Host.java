package it.beije.turing.beans;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "hosts")
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonProperty("user")
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @JsonProperty("PIVA")
    @Column(name = "partita_iva")
    private String partitaIva;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }
    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public String getPartitaIva() {
        return partitaIva;
    }
    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", utente=" + utente +
                ", partitaIva=" + partitaIva +
                '}';
    }
}
