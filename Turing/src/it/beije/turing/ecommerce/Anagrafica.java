package it.beije.turing.ecommerce;

public class Anagrafica
{
	private int id;
	private int id_utente;
	private String nome;
	private String cognome;
	private String telefono;
	private String citta;		//città nascita
	private String data;		//data nascita
	
	public int getId()
	{
		return id;
	}
	
	public int getId_utente()
	{
		return id_utente;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public String getCognome()
	{
		return cognome;
	}
	
	public void setCognome(String cognome)
	{
		this.cognome = cognome;
	}
	
	public String getTelefono()
	{
		return telefono;
	}
	
	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}
	
	public String getCitta()
	{
		return citta;
	}
	
	public void setCitta(String citta)
	{
		this.citta = citta;
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