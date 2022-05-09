package it.beije.turing.beans;


import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "carte")
@JsonInclude(Include.NON_NULL)
public class Carta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

//	@ManyToOne()
	@JsonProperty("user_id")
	@Column(name="utente_id")
	private Integer utenteId;
	
	@JsonProperty("card_number")
	@Column(name = "numero_carta")	
	private String numeroCarta;
	
	@JsonProperty("expiration_date")
	@Column(name = "data_scadenza")
	private String dataScadenza;
	
	@JsonProperty("ccv")
	@Column(name = "ccv")
	private String ccv;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getUtenteId() {
		return utenteId;
	}
	public void setUtenteId(Integer utenteId) {
		this.utenteId = utenteId;
	}

	public String getNumeroCarta() {
		return numeroCarta;
	}
	public void setNumeroCarta(String numero_carta) {
		this.numeroCarta = numero_carta;
	}
	
	public String getDataScadenza() {
		return dataScadenza;
	}
	
	@JsonIgnore
	public LocalDate getLocalDateExp() {
		return LocalDate.parse(dataScadenza);
	}
	
	public void setDataScadenza(String dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	
	public String getCcv() {
		return ccv;
	}
	public void setCcv(String ccv) {
		this.ccv = ccv;
	}
		
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(this.id)
				.append(", numero_carta : ").append(this.numeroCarta)
				.append(", data scadenza : ").append(this.dataScadenza)
				.append(", ccv : ").append(this.ccv)
				.append(" }")
		;
		
		
		return builder.toString();
	}


}
