package it.beije.turing;

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
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "telefono")
	private String telefono;
		
	@Column(name = "note")
	private String note;
	
	
	public Contatto()
	{
		this.nome = "";
		this.cognome = "";
		this.email = "";
		this.telefono = "";
		this.note = "";
	}
	
	public Contatto(String nome, String cognome, String email, String telefono, String note)
	{
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.telefono = telefono;
		this.note = note;
	}
	
	public Contatto(int id, String nome, String cognome, String email, String telefono, String note)
	{
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.telefono = telefono;		
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
				.append(", email : ").append(this.email)
				.append(", telefono : ").append(this.telefono)
				.append(", note : ").append(this.note).append(" }");
		
		return builder.toString();
	}
	
	public String toFile(String separator)
	{
		return nome + separator + cognome + separator + email + separator + telefono + separator + note + "\n";
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