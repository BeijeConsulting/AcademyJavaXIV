package it.beije.turing.rubrica;

public class Contatto {
	
	private String nome;
	private String cognome;
	private String telefono;
	private String email;
	private String note;
	
	

	public Contatto(String nome, String cognome, String telefono, String email, String note) {
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;
		this.note = note;
	}
	
	public Contatto() {
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
				.append("{ COGNOME : ").append(this.cognome)
				.append(" , NOME : ").append(this.nome)
				.append(" , TELEFONO : ").append(this.telefono)
				.append(" , EMAIL : ").append(this.email)
				.append(" , NOTE : ").append(this.note).append(" }");
		
		return builder.toString();
	}

}
