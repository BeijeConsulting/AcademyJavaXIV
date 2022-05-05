package it.beije.turing.utenti;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carte")
public class Carta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="utente_id")
	private Integer utenteId;
	
	@Column(name = "numero_carta")	
	private String numeroCarta;
	
	@Column(name = "data_scadenza")
	private Date dataScadenza;
	
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

	public String getNumero_carta() {
		return numeroCarta;
	}

	public void setNumero_carta(String numero_carta) {
		this.numeroCarta = numero_carta;
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
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
