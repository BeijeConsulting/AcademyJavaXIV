package it.beije.turing;

import javax.persistence.*;

@Entity
@Table(name = "strutture")
public class Struttura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tipo")
    private String tipo;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)//, fetch = FetchType.LAZY
    @JoinColumn(name="tipologia_struttura_id")
    private TipoStruttura tipologiaStrutturaId;

    @Column(name = "descrizione")
    private String descrizione;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)//, fetch = FetchType.LAZY
    @JoinColumn(name="indirizzo_id")
    private Indirizzo indirizzo;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)//, fetch = FetchType.LAZY
    @JoinColumn(name="host_id")
    private Utente utenti;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public TipoStruttura getTipologiaStrutturaId() {
        return tipologiaStrutturaId;
    }

    public void setTipologiaStrutturaId(TipoStruttura tipologiaStrutturaId) {
        this.tipologiaStrutturaId = tipologiaStrutturaId;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    public Utenti getUtenti() {
        return utenti;
    }

    public void setUtenti(Utenti utenti) {
        this.utenti = utenti;
    }

    @Override
    public String toString() {
        return "Struttura{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", tipologiaStrutturaId=" + tipologiaStrutturaId +
                ", descrizione='" + descrizione + '\'' +
                ", indirizzo=" + indirizzo +
                ", utenti=" + utenti +
                '}';
    }
}
