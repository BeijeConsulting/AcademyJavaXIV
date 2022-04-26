package it.beije.turing.ecommerce;

public class Indirizzo
{
	private int id;
	private int id_fatturazione;
	private String citta;
	private String via;
	private String numero;
	private String cap;
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