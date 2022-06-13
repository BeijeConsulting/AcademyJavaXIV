package it.beije.turing.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "servizi")
@JsonInclude(Include.NON_NULL)
public class Servizio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@JsonProperty("nome")
	@Column(name = "nome")
	private String nome;
	
	@JsonProperty("url_img")
	@Column(name = "url_img")
	private String urlImg;

	
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
	
	public String getUrlImg() {
		return urlImg;
	}
	public void setUrlImg(String nome) {
		this.urlImg = nome;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(this.id)
				.append(", urlImg : ").append(this.urlImg)
				.append(", nome : ").append(this.nome);
		return builder.toString();
	}
}
