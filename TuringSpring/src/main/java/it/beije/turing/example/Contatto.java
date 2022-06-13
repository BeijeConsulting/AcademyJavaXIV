//package it.beije.turing.example;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import javax.persistence.Transient;
//
//import com.fasterxml.jackson.annotation.JsonGetter;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonSetter;
//import com.fasterxml.jackson.annotation.JsonInclude.Include;
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//
//@Entity
//@Table(name = "rubrica")
//@JsonInclude(Include.NON_NULL)
//public class Contatto {
//
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="id")
//	private Integer id;
//
//	@Column(name = "email")
//	private String email;

	//SELECT * FROM rubrica r JOIN rubrica_contatti rc ON r.id = rc.rubrica_id WHERE id = X
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)//, fetch = FetchType.LAZY
	@JoinColumn(name="rubrica_id")
	private List<RiferimentiContatto> riferimenti;
//
	@Column(name = "note")
	private String note;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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

//	public String getTelefono() {
//		return telefono;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getNome() {
//		return nome;
//	}
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
//	public String getCognome() {
//		return cognome;
//	}
//	public void setCognome(String cognome) {
//		this.cognome = cognome;
//	}
//
////	public String getTelefono() {
////		return telefono;
////	}
////	public void setTelefono(String telefono) {
////		this.telefono = telefono;
////	}
////
////	public String getEmail() {
////		return email;
////	}
////	public void setEmail(String email) {
////		this.email = email;
////	}
//
//	public List<RiferimentiContatto> getRiferimenti() {
//		return riferimenti;
//	}
//	public void setRiferimenti(List<RiferimentiContatto> riferimenti) {
//		this.riferimenti = riferimenti;
//	}
//
//	public String getNote() {
//		return note;
//	}
//	public void setNote(String note) {
//		this.note = note;
//	}
//
//
//	public LocalDate getDataNascita() {
//		return dataNascita;
//	}
//
//	@JsonGetter(value = "data_nascita")
//	public String getDataNascitaAsString() {
//		return dataNascita.toString();
//	}
//
//	public void setDataNascita(LocalDate dataNascita) {
//		this.dataNascita = dataNascita;
//	}
//
//	@JsonSetter(value = "data_nascita")
//	public void setDataNascita(String dataNascita) {
//		this.dataNascita = LocalDate.parse(dataNascita);
//	}
//
//
//
//	public String toString() {
//		StringBuilder builder = new StringBuilder()
//				.append("{ id : ").append(this.id)
//				.append(", cognome : ").append(this.cognome)
//				.append(", nome : ").append(this.nome)
////				.append(", telefono : ").append(this.telefono)
////				.append(", email : ").append(this.email)
//				.append(", riferimenti : ").append(this.riferimenti)
//				.append(", note : ").append(this.note).append(" }");
//
//		return builder.toString();
//	}
//
//}
