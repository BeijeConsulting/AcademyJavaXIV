package it.beije.turing.ecommerce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carrello")
public class Carrello {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "id_utente")
	private int id_utente;
	
	@Column(name = "totale")
	private String totale;
	
	public int getId_utente() {
		return id_utente;
	}
	
	
	
	public String getTotale() {
		return totale;
	}
	public void setTotale(String totale) {
		this.totale = totale;
	}
	
	
	public int getId() {
		return id;
	}
	
	

}
