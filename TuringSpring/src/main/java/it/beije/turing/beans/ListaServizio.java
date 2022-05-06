package it.beije.turing.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lista_servizi")
public class ListaServizio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "struttura_id")
	private Struttura strutturaId;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "servizio_id")
	private Servizio servizioId;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "annuncio_id")
	private Servizio annuncioId;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Struttura getStrutturaId() {
		return strutturaId;
	}
	
	public void setAnnuncioId(Struttura strutturaId) {
		this.strutturaId = strutturaId;
	}

	public Servizio getAnnuncioId() {
		return servizioId;
	}
	
	public void setStrutturaId(Struttura strutturaId) {
		this.strutturaId = strutturaId;
	}

	public Servizio getServizioId() {
		return servizioId;
	}

	public void setServizioId(Servizio servizioId) {
		this.servizioId = servizioId;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder().append("Id: " + this.id).append("{ Struttura id : ").append(this.strutturaId)
				.append("{ Servizio id : ").append(this.servizioId);
		return builder.toString();
	}
}
