package it.beije.turing.rubrica;

import java.io.File;
import java.util.Scanner;

public class Contatto {
	
	private String nome;
	private String cognome;
	private String telefono;
	private String email;
	private String note;
	
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
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public static Contatto writeContatti() {
		Contatto contatto = new Contatto();
		Scanner scan = new Scanner(System.in);
		System.out.println("Se vuoi saltare il campo non inserire nessun carattere e premi invio. ");
		System.out.println("Inserisci il nome: ");
		contatto.setNome(scan.nextLine());
		System.out.println("Inserisci il cognome: ");
		contatto.setCognome(scan.nextLine());
		System.out.println("Inserisci l'email: ");
		contatto.setEmail(scan.nextLine());
		System.out.println("Inserisci il numero di telefono: ");
		contatto.setTelefono(scan.nextLine());
		System.out.println("Inserisci delle note: ");
		contatto.setNote(scan.nextLine());
		return contatto;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ cognome : ").append(this.cognome)
				.append(", nome : ").append(this.nome)
				.append(", telefono : ").append(this.telefono)
				.append(", email : ").append(this.email)
				.append(", note : ").append(this.note).append(" }");
		
		return builder.toString();
	}

}
