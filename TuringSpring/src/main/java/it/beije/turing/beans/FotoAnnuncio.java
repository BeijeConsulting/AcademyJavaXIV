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
@Table(name = "foto_annuncio")
public class FotoAnnuncio
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@ManyToOne(cascade=CascadeType.DETACH, fetch = FetchType.EAGER)//, fetch = FetchType.LAZY
	@JoinColumn(name="annuncio_id")
	private Annuncio annuncio;
	
	
	@ManyToOne(cascade=CascadeType.DETACH, fetch = FetchType.EAGER)//, fetch = FetchType.LAZY
	@JoinColumn(name="immagine_id")
	private Immagine immagineId;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
	public Annuncio getAnnuncio() {
		return annuncio;
	}

	public void setAnnuncio(Annuncio annuncio) {
		this.annuncio = annuncio;
	}

	public Immagine getImmagineId() {
		return immagineId;
	}

	public void setImmagineId(Immagine immagineId) {
		this.immagineId = immagineId;
	}

	@Override
	public String toString() {
		return "FotoAnnuncio [id=" + id + ", annuncio=" + annuncio + ", immagineId=" + immagineId + "]";
	}
	
	
}