package it.beije.turing;

public class Contatto {

	private int id;
	
	private String nome;
	
	private String cognome;
	
	private String telefono;
	
	private String email;
	
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
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(this.id)
				.append(", cognome : ").append(this.cognome)
				.append(", nome : ").append(this.nome)
				.append(", telefono : ").append(this.telefono)
				.append(", email : ").append(this.email)
				.append(", note : ").append(this.note).append(" }");
		
		return builder.toString();
	}

}