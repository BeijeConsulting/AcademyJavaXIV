package it.beije.turing.rubrica;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "rubrica")
public class Contatto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "note")
	private String note;
	
	
	public Contatto()
	{
		this.id = -1;
		this.nome = "";
		this.cognome = "";
		this.telefono = "";
		this.email = "";
		this.note = "";
	}
	
	public Contatto(String nome, String cognome, String telefono, String email, String note)
	{
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;
		this.note = note;
	}
	
	public Contatto(int id, String nome, String cognome, String telefono, String email, String note)
	{
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;
		this.note = note;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getNote()
	{
		return note;
	}
	public void setNote(String note)
	{
		this.note = note;
	}
	
	public String toString()
	{
		StringBuilder builder = new StringBuilder()

				.append("{ id : ").append(this.id)
				.append(", nome : ").append(this.nome)
				.append(", cognome : ").append(this.cognome)
				.append(", telefono : ").append(this.telefono)
				.append(", email : ").append(this.email)
				.append(", note : ").append(this.note).append(" }");
		
		return builder.toString();
	}
	
	public String toFile(String separator)
	{
		return nome + separator + cognome + separator + telefono + separator + email + separator + note + "\n";
	}
	
	 public boolean equals(Object obj)
	 {
		if (obj == this)
		{
			return true;
		}
		if (!(obj instanceof Contatto))
		{
		return false;
		}
		
		Contatto contatto = (Contatto) obj;
		return nome.equals(contatto.getNome()) && cognome.equals(contatto.getCognome()) && telefono.equals(contatto.getTelefono()) && email.equals(contatto.getEmail()) && note.equals(contatto.getNote());
	}
}