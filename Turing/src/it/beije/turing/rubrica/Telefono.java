package it.beije.turing.rubrica;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "telefono")
public class Telefono {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	@Column(name="idrubrica")
	private int idRubrica;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public int getIdRubrica() {
		return idRubrica;
	}
	public void setIdRubrica(int idRubrica) {
		this.idRubrica = idRubrica;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(this.id)
				.append(", telefono : ").append(this.telefono)
				.append(", descrizione : ").append(this.descrizione).append(" }");
		
		return builder.toString();
	}
}
