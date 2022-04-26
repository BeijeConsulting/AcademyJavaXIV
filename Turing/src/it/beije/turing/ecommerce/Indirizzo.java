package it.beije.turing.ecommerce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "indirizzo")
public class Indirizzo
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "id_fatturazione")
	private int id_fatturazione;
	
	@Column(name = "citta")
	private String citta;
	
	@Column(name = "via")
	private String via;
	
	@Column(name = "numero")
	private String numero;
	
	@Column(name = "cap")
	private String cap;
	
	@Column(name = "provincia")
	private String provincia;
	
	public int getId()
	{
		return id;
	}
	
	public int getId_fatturazione()
	{
		return id_fatturazione;
	}
	
	public String getCitta()
	{
		return citta;
	}
	
	public void setCitta(String citta)
	{
		this.citta = citta;
	}
	
	public String getVia()
	{
		return via;
	}
	
	public void setVia(String via)
	{
		this.via = via;
	}
	
	public String getNumero()
	{
		return numero;
	}
	
	public void setNumero(String numero)
	{
		this.numero = numero;
	}
	
	public String getCap()
	{
		return cap;
	}
	
	public void setCap(String cap)
	{
		this.cap = cap;
	}
	
	public String getProvincia()
	{
		return provincia;
	}
	
	public void setProvincia(String provincia)
	{
		this.provincia = provincia;
	}
}