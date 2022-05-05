package it.beije.turing.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "messaggi")
public class Messaggio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name = "testo")
	private String testo;
	
	@Column(name = "reciver_id")
	private Integer reciverId;
	
	@Column(name="data_ora")
	private Date dataOra;
	
	@Column(name = "sender_id")
	private Integer senderId;

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

	public Integer getReciverId() {
		return reciverId;
	}
	public void setReciverId(int reciverId) {
		this.reciverId = reciverId;
	}

	public Date getDataOra() {
		return dataOra;
	}
	public void setDataOra(Date dataOra) {
		this.dataOra = dataOra;
	}

	public Integer getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(this.id)
				.append(", testo : ").append(this.testo)
				.append(", reciverId : ").append(this.reciverId)
				.append(", dataOra : ").append(this.dataOra)
				.append(", senderId : ").append(this.senderId)
				.append(" }")
		;
		
		
		return builder.toString();
	}


}