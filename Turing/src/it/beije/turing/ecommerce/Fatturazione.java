package it.beije.turing.ecommerce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fatturazione")
public class Fatturazione
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "id_utente")
	private int id_utente;
	
	public int getId()
	{
		return id;
	}
	
	public int getId_utente()
	{
		return id_utente;
	}
}