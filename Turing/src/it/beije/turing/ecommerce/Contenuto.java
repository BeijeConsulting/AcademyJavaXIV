package it.beije.turing.ecommerce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contenuto")
public class Contenuto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name = "id_carrello")
	private int id_carrello;
	
	@Column(name = "id_prodotto")
	private int id_prodotto;
	
	@Column(name = "quantita")
	private String quantita;
	
	public int getId_carrello() {
		return id_carrello;
	}

	
	public int getId_prodotto() {
		return id_prodotto;
	}
	
	
	public String getQuantita() {
		return quantita;
	}
	public void setQuantita(String quantita) {
		this.quantita = quantita;
	}
	
	
	public int getId() {
		return id;
	}
	
	

}
