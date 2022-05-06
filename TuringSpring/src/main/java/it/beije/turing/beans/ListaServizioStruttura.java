package it.beije.turing.beans;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lista_servizi_strutture")
public class ListaServizioStruttura {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "servizio_id")
	private Servizio servizioId;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "struttura_id")
	private Struttura strutturaId;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Servizio getAnnuncioId() {
		return servizioId;
	}
	
	public void setAnnuncioId(Struttura strutturaId) {
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