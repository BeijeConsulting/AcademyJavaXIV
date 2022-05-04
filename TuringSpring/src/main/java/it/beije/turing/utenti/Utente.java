package it.beije.turing.utenti;

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
    @Column(name = "id")
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "receiver_id")
    private List<Messaggio> messaggiRicevuti;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "sender_id")
    private List<Messaggio> messaggiInviati;

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

}
