package it.beije.turing.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "foto_annuncio")
public class FotoAnnuncio
{
	@Id
	@Column(name = "annuncio_id")
	private Annuncio annuncio;
	
	@Column(name = "immagine_id")
	private Immagine immagineId;
	
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
}