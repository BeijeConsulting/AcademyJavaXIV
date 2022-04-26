package it.beije.turing.ecommerce;

public class Prodotto {
	private int id;
	private String nome;
	private String codice;
	private String immagine;
	private String prezzo;
	private String descrizione;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	
	
	public String getImmagine() {
		return immagine;
	}
	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}
	
	
	public String getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
	}
	
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
	public int getId() {
		return id;
	}
	
	

}
