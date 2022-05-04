package it.beije.turing.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lista_regole")
public class ListaRegole
{
	@Id
	@Column(name="annuncio_id")
	private Annuncio annuncioId;
	
	@Column(name="regola_id")
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

	public void setCompletamento(String completamento) {
		this.completamento = completamento;
	}
}