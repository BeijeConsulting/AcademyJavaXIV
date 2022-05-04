package it.beije.turing.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 CREATE TABLE `rubrica_contatti` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rubrica_id` int(11) NOT NULL,
  `contatto` varchar(100) DEFAULT NULL,
  `tipologia` varchar(45) DEFAULT NULL,
  `tipo_contatto` char(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `rubrica_fk_idx` (`rubrica_id`),
  CONSTRAINT `rubrica_fk` FOREIGN KEY (`rubrica_id`) REFERENCES `rubrica` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
 */

@Entity
@Table(name = "rubrica_contatti")
public class RiferimentiContatto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name = "rubrica_id")
	private Integer contattoId;
	
	@Column(name = "contatto")
	private String riferimento;
	
	@Column(name = "tipologia")
	private String tipologia;

	@Column(name = "tipo_contatto")
	private String tipoRiferimento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getContattoId() {
		return contattoId;
	}

	public void setContattoId(Integer contattoId) {
		this.contattoId = contattoId;
	}

	public String getRiferimento() {
		return riferimento;
	}

	public void setRiferimento(String riferimento) {
		this.riferimento = riferimento;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getTipoRiferimento() {
		return tipoRiferimento;
	}

	public void setTipoRiferimento(String tipoRiferimento) {
		this.tipoRiferimento = tipoRiferimento;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(this.id)
				.append(", contattoId : ").append(this.contattoId)
				.append(", riferimento : ").append(this.riferimento)
				.append(", tipoRiferimento : ").append(this.tipoRiferimento)
				.append(", tipologia : ").append(this.tipologia).append(" }");
		
		return builder.toString();
	}
	
}
