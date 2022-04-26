package it.beije.turing.Ecomm.Beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cognome")
    private String cognome;
    @Column(name = "indirizzo")
    private String indirizzo;
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy="idCliente")
    private List<Ordine> ordini;

    public Cliente()
    {
    	this("","","","");
    }
    public Cliente(String nome, String cognome, String indirizzo, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.email = email;
        this.ordini = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente [ " +
                "Id =" + id +
                " , Nome ='" + nome + '\'' +
                " , Cognome ='" + cognome + '\'' +
                " , Indirizzo ='" + indirizzo + '\'' +
                " , Email='" + email + '\'' +
                " ]";
    }
	public List<Ordine> getOrdini() {
		return ordini;
	}
	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}
}
