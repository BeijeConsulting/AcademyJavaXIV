package it.beije.turing.web.rubrica;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rubrica")
public class Contatto implements Comparable {

	public Contatto() {
	}

	public Contatto(String nome, String cognome, String telefono, String email, String note) {
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;
		this.note = note;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder().append("{ id : ").append(this.id).append(", cognome : ")
				.append(this.cognome).append(", nome : ").append(this.nome).append(", telefono : ")
				.append(this.telefono).append(", email : ").append(this.email).append(", note : ").append(this.note)
				.append(" }");

		return builder.toString();
	}

	@Override
	public int compareTo(Object o) {
		Contatto c = (Contatto)o;
		if (this.cognome == c.cognome)
			return 0;
		else if (this.cognome == c.cognome)
			return 1;
		else
			return -1;
	}

}