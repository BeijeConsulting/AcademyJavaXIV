package it.beije.turing;

import javax.persistence.*;

@Entity
@Table(name = "strutture")
public class Struttura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // @Column(name = "tipo")
    // private String tipo;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)//, fetch = FetchType.LAZY
    @JoinColumn(name="tipologia_struttura_id")
    private TipoStruttura tipologiaStrutturaId;

    @Column(name = "descrizione")
    private String descrizione;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="id", referencedColumnName = "host_id")
    private Indirizzo indirizzo;

  /*  @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="host_id")
    private Utente utente;

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
*/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /*public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }*/

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

    @Override
    public String toString() {
        return "Struttura{" +
                "id=" + id +
               // ", tipo='" + tipo + '\'' +
                ", tipologiaStrutturaId=" + tipologiaStrutturaId +
                ", descrizione='" + descrizione + '\'' +
                ", indirizzo=" + indirizzo +
              //  ", utenti=" + utente +
                '}';
    }
}
