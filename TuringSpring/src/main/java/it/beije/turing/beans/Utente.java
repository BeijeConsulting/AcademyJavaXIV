package it.beije.turing.beans;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "utenti")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "utente_id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "email")
    private String email;

    @Column(name = "pwd")
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

    @Column(name = "tipo_utente")
    private String tipoUtente;

    @Column(name = "livello")
    private Integer livello;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id")
    private List<Messaggio> messaggiRicevuti;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private List<Messaggio> messaggiInviati;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "utente_id")
    private List<Recensione> recensione;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "utente_id")
    private List<Carta> carte;

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

    public String getTipoUtente() {
        return tipoUtente;
    }
    public void setTipoUtente(String tipoUtente) {
        this.tipoUtente = tipoUtente;
    }

    public Integer getLivello() {
        return livello;
    }
    public void setLivello(Integer livello) {
        this.livello = livello;
    }

    public List<Messaggio> getMessaggiRicevuti() {
        return messaggiRicevuti;
    }
    public void setMessaggiRicevuti(List<Messaggio> messaggiRicevuti) {
        this.messaggiRicevuti = messaggiRicevuti;
    }

    public List<Messaggio> getMessaggiInviati() {
        return messaggiInviati;
    }
    public void setMessaggiInviati(List<Messaggio> messaggiInviati) {
        this.messaggiInviati = messaggiInviati;
    }

    public List<Recensione> getRecensione() {
        return recensione;
    }
    public void setRecensione(List<Recensione> recensione) {
        this.recensione = recensione;
    }

    public List<Carta> getCarte() {
        return carte;
    }
    public void setCarte(List<Carta> carte) {
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
                ", tipoUtente='" + tipoUtente + '\'' +
                ", livello=" + livello +
                ", messaggiRicevuti=" + messaggiRicevuti +
                ", messaggiInviati=" + messaggiInviati +
                ", recensione=" + recensione +
                ", carte=" + carte +
                '}';
    }
}
