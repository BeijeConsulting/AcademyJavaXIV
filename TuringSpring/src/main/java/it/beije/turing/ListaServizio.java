package it.beije.turing;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "struttura_id")
	private Struttura strutturaId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "servizio_id")
	private List<Servizio> servizioId;

	public Struttura getStrutturaId() {
		return strutturaId;
	}

	public void setStrutturaId(Struttura strutturaId) {
		this.strutturaId = strutturaId;
	}

	public List<Servizio> getServizioId() {
		return servizioId;
	}

	public void setServizioId(List<Servizio> servizioId) {
		this.servizioId = servizioId;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder().append("{ Struttura id : ").append(this.strutturaId)
				.append("{ Servizio id : ").append(this.servizioId);
		return builder.toString();
	}
}
