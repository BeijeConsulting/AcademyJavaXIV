package it.beije.turing.beans;

import javax.persistence.*;

@Entity
@Table(name = "strutture")
public class Struttura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(cascade=CascadeType.DETACH, fetch = FetchType.EAGER)//, fetch = FetchType.LAZY
    @JoinColumn(name="tipologia_struttura_id")
    private TipoStruttura tipologiaStruttura;

    @Column(name = "descrizione")
    private String descrizione;

    @OneToOne(cascade=CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name="indirizzo_id")
    private Indirizzo indirizzo;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="host_id")
    private Utente utente;

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public TipoStruttura getTipologiaStrutturaId() {
        return tipologiaStruttura;
    }

    public void setTipologiaStrutturaId(TipoStruttura tipologiaStrutturaId) {
        this.tipologiaStruttura = tipologiaStrutturaId;
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

    @Override
    public String toString() {
        return "Struttura{" +
                "id=" + id +
                ", tipologiaStrutturaId=" + tipologiaStruttura +
                ", descrizione='" + descrizione + '\'' +
                ", indirizzo=" + indirizzo +
                ", utenti=" + utente +
                '}';
    }
}
