package it.beije.turing.ecommerce;

public class Login
{
	private int id;
	private int id_utente;
	private String email;
	private String password;
	
	public int getId()
	{
		return id;
	}
	
	public int getId_utente()
	{
		return id_utente;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
}