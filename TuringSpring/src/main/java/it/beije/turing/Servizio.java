package it.beije.turing;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "servizi")
public class Servizio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "nome")
	private String nome;
	
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
	
	public String getUrl_img() {
		return urlImg;
	}
	public void setUrl_img(String nome) {
		this.urlImg = urlImg;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(this.id)
				.append(", cognome : ").append(this.urlImg)
				.append(", nome : ").append(this.nome);
		return builder.toString();
	}
}
