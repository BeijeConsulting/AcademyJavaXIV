package it.beije.turing.beans;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "utenti")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "email")
    private String email;

    @Column(name = "psw")
    private String password;

    @Column(name = "data_nascita")
    private Date dataNascita;

    @Column(name = "cod_documenti")
    private String codiceDocumento;

    @Column(name = "indirizzo_id")
    private Integer indirizzoId;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "contatto_emergenza")
    private String contattoEmergenza;

    @Column(name = "url_immagine")
    private String urlImmagine;

    @Column(name = "livello")
    private Integer livello;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "receiver_id")
    private Set<Messaggio> messaggiRicevuti;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "sender_id")
    private Set<Messaggio> messaggiInviati;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "utente_id")
    private Set<Recensione> recensione;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "utente_id")
    private Set<Carta> carte;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDataNascita() {
        return dataNascita;
    }
    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getCodiceDocumento() {
        return codiceDocumento;
    }
    public void setCodiceDocumento(String codiceDocumento) {
        this.codiceDocumento = codiceDocumento;
    }

    public Integer getIndirizzoId() {
        return indirizzoId;
    }
    public void setIndirizzoId(Integer indirizzoId) {
        this.indirizzoId = indirizzoId;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContattoEmergenza() {
        return contattoEmergenza;
    }
    public void setContattoEmergenza(String contattoEmergenza) {
        this.contattoEmergenza = contattoEmergenza;
    }

    public String getUrlImmagine() {
        return urlImmagine;
    }
    public void setUrlImmagine(String urlImmagine) {
        this.urlImmagine = urlImmagine;
    }

    public Integer getLivello() {
        return livello;
    }
    public void setLivello(Integer livello) {
        this.livello = livello;
    }

    public Set<Messaggio> getMessaggiRicevuti() {
        return messaggiRicevuti;
    }
    public void setMessaggiRicevuti(Set<Messaggio> messaggiRicevuti) {
        this.messaggiRicevuti = messaggiRicevuti;
    }

    public Set<Messaggio> getMessaggiInviati() {
        return messaggiInviati;
    }
    public void setMessaggiInviati(Set<Messaggio> messaggiInviati) {
        this.messaggiInviati = messaggiInviati;
    }

    public Set<Recensione> getRecensione() {
        return recensione;
    }
    public void setRecensione(Set<Recensione> recensione) {
        this.recensione = recensione;
    }

    public Set<Carta> getCarte() {
        return carte;
    }
    public void setCarte(Set<Carta> carte) {
        this.carte = carte;
    }


    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dataNascita=" + dataNascita +
                ", codiceDocumento='" + codiceDocumento + '\'' +
                ", indirizzoId=" + indirizzoId +
                ", telefono='" + telefono + '\'' +
                ", contattoEmergenza='" + contattoEmergenza + '\'' +
                ", urlImmagine='" + urlImmagine + '\'' +
                ", livello=" + livello +
                ", messaggiRicevuti=" + messaggiRicevuti +
                ", messaggiInviati=" + messaggiInviati +
                ", recensione=" + recensione +
                ", carte=" + carte +
                '}';
    }
}
