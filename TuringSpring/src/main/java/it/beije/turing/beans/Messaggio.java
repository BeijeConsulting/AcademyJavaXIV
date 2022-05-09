package it.beije.turing.beans;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;



@Entity
@Table(name = "messaggi")
@JsonInclude(Include.NON_NULL)
public class Messaggio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty("id")
	@Column(name = "id")
	private Integer id;
	
	@JsonProperty("text")
	@Column(name = "testo")
	private String testo;
	
	@JsonProperty("receiver_id")
	@Column(name = "receiver_id")
	private Integer receiverId;
	
	@JsonProperty("date_and_time")
	@Column(name="data_ora")
	private String dataOra;
	
	@JsonProperty("sender_id")
	@Column(name = "sender_id")
	private Integer senderId;

	@JsonProperty("announcement_id")
	@Column(name = "annuncio_id")
	private Integer annuncioId;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}

	public Integer getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(Integer receiverId) {
		this.receiverId = receiverId;
	}

	public String getDataOra() {
		return dataOra;
	}
	public void setDataOra(String dataOra) {
		this.dataOra = dataOra;
	}
	
	@JsonIgnore
	public LocalDate getDataOraExp() {
		return LocalDate.parse(dataOra);
	}

	public Integer getSenderId() {
		return senderId;
	}
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}

	public Integer getAnnuncioId() {
		return annuncioId;
	}
	public void setAnnuncioId(Integer annuncioId) {
		this.annuncioId = annuncioId;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(this.id)
				.append(", testo : ").append(this.testo)
				.append(", receiverId : ").append(this.receiverId)
				.append(", dataOra : ").append(this.dataOra)
				.append(", senderId : ").append(this.senderId)
				.append(", annuncioId : ").append(this.annuncioId)
				.append(" }")
		;
		
		
		return builder.toString();
	}


}
