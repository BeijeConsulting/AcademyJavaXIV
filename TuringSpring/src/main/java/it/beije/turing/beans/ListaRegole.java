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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "lista_regole")
public class ListaRegole
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@ManyToOne(cascade=CascadeType.MERGE, fetch = FetchType.EAGER)//, fetch = FetchType.LAZY
	@JoinColumn(name="annuncio_id")
	private Annuncio annuncioId;
	
	@ManyToOne(cascade=CascadeType.DETACH, fetch = FetchType.EAGER)//, fetch = FetchType.LAZY
	@JoinColumn(name="regola_id")
	private Regola regolaId;
	
	@Column(name="completamento")
	private String completamento;

	public Annuncio getAnnuncioId() {
		return annuncioId;
	}

	public void setAnnuncioId(Annuncio annuncioId) {
		this.annuncioId = annuncioId;
	}

	public Regola getRegolaId() {
		return regolaId;
	}

	public void setRegolaId(Regola regolaId) {
		this.regolaId = regolaId;
	}

	public String getCompletamento() {
		return completamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCompletamento(String completamento) {
		this.completamento = completamento;
	}

	@Override
	public String toString() {
		return "ListaRegole [id=" + id + ", annuncioId=" + annuncioId + ", regolaId=" + regolaId + ", completamento="
				+ completamento + "]";
	}
}