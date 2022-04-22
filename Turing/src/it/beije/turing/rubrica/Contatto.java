package it.beije.turing.rubrica;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import it.beije.turing.db.ListStringConverter;


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
	//@ElementCollection
	@Convert(converter = ListStringConverter.class)
	private List<String> telefono;
	
	@Column(name = "email")
	@Convert(converter = ListStringConverter.class)
	//@ElementCollection
	private List<String> email;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "nascita")
	private String Birthday;
	
	@Column(name = "indirizzo")
	private String Address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public List<String> getTelefono() {
		return telefono;
	}
	public void setTelefono(List<String> telefono) {
		this.telefono = telefono;
	}
	
	public List<String> getEmail() {
		return email;
	}
	public void setEmail(List<String> email) {
		this.email = email;
	}
	
	
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public String getBirthday() {
		return Birthday;
	}
	public void setBirthday(String birthday) {
		Birthday = birthday;
	}
	
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(this.id)
				.append(", cognome : ").append(this.cognome)
				.append(", nome : ").append(this.nome)
				.append(", telefono : ").append(this.telefono)
				.append(", email : ").append(this.email)
				.append(", data di nascita :").append(this.Birthday)
				.append(",indirizzo :").append(this.Address)
				.append(", note : ").append(this.note).append(" }");
		
		return builder.toString();
	}
	public boolean equals(Contatto c)
	{
		if(this.getNome()!=null&&c.getNome()!=null&&!this.getNome().equalsIgnoreCase(c.getNome()))
		{
			return false;
		}
		if(this.getCognome()!=null&&c.getCognome()!=null&&!this.getCognome().equalsIgnoreCase(c.getCognome()))
		{
			return false;
		}
		if(this.getNote()!=null&&c.getNote()!=null&&!this.getNote().equalsIgnoreCase(c.getNote()))
		{
			return false;
		}
		if(this.getBirthday()!=null&&c.getBirthday()!=null&&!this.getBirthday().equalsIgnoreCase(c.getBirthday()))
		{
			return false;
		}
		if(this.getAddress()!=null&&c.getAddress()!=null&&!this.getAddress().equalsIgnoreCase(c.getAddress()))
		{
			return false;
		}
		return true;
	}
	

}
