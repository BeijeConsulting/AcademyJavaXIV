package it.beije.turing.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "annunci")
public class Annuncio
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name = "titolo")
	private String titolo;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	@Column(name = "num_posti_letto")
	private Integer numPostiLetto;
	
	@Column(name = "prezzo")
	private Double prezzo;
	
	@Column(name = "struttura_id")					//TODO CAMBIARE IN STRUTTURA
	private Struttura strutturaId;

	
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Integer getNumPostiLetto() {
		return numPostiLetto;
	}

	public void setNumPostiLetto(Integer numPostiLetto) {
		this.numPostiLetto = numPostiLetto;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public Struttura getStrutturaId() {
		return strutturaId;
	}

	public void setStrutturaId(Struttura strutturaId) {
		this.strutturaId = strutturaId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}