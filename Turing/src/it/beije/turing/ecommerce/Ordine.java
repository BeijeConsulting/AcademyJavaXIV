package it.beije.turing.ecommerce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ordine")
public class Ordine
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "id_utente")
	private int id_utente;
	
	@Column(name = "id_carrello")
	private int id_carrello;
	
	@Column(name = "numero")
	private String numero;
	
	@Column(name = "totale")
	private String totale;
	
	@Column(name = "data")
	private String data;
	
	public int getId()
	{
		return id;
	}
	
	public int getId_utente()
	{
		return id_utente;
	}
	
	public int getId_carrello()
	{
		return id_carrello;
	}
	
	public String getNumero()
	{
		return numero;
	}
	
	public void setNumero(String numero)
	{
		this.numero = numero;
	}
	
	public String getTotale()
	{
		return totale;
	}
	
	public void setTotale(String totale)
	{
		this.totale = totale;
	}
	
	public String getData()
	{
		return data;
	}
	
	public void setData(String data)
	{
		this.data = data;
	}
}