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
@Table(name = "lista_servizi")
public class ListaServizio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "servizio_id")
	private Servizio servizioId;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "annuncio_id")
	private Annuncio annuncioId;
	
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "struttura_id")
	private Struttura strutturaId;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Struttura getStrutturaId() {
		return strutturaId;
	}
	
	public void setStrutturaId(Struttura strutturaId) {
		this.strutturaId = strutturaId;
	}
	public Annuncio getAnnuncioId() {
		return annuncioId;
	}
	
	public void setAnnuncioId(Annuncio annuncioId) {
		this.annuncioId = annuncioId;
	}

	public Servizio getServizioId() {
		return servizioId;
	}

	public void setServizioId(Servizio servizioId) {
		this.servizioId = servizioId;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder().append("Id: " + this.id).append("{ Annuncio id : ").append(this.annuncioId)
				.append("{ Servizio id : ").append(this.servizioId).append("{ Struttura id : ").append(this.strutturaId);
		return builder.toString();
	}
}
