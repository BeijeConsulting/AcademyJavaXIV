package it.beije.turing.ecommerce;

public class Ordine
{
	private int id;
	private int id_utente;
	private int id_carrello;
	private String numero;
	private String totale;
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