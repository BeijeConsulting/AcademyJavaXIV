package it.beije.turing.rubrica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contatto {
	
	private String nome;
	private String cognome;
	private String telefono;
	private String email;
	private String note;
	
	
	public Contatto() {
		
	}
	
	public Contatto(String nome, String cognome, String telefono, String email) {
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;

	}
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
	

	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ cognome : ").append(this.cognome)
				.append(", nome : ").append(this.nome)
				.append(", telefono : ").append(this.telefono)
				.append(", email : ").append(this.email)
				.append(", note : ").append(this.note).append(" }");
		
		return builder.toString();
	}
	
	public static Contatto read() {
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
	
		System.out.print("Inserisci Nome:");
		String nome = in.nextLine();
		if(nome.equals("")) {return null;}
		
		System.out.print("inserisci Cognome :");
		String cognome= in.nextLine();
		if(cognome.equals("")) {return null;}
		
		System.out.print("inserisci telefono :");
		String telefono = in.nextLine();
		if(telefono.equals("")) {return null;}
		
		System.out.print("Email :");
		String email = in.nextLine();
		if(email.equals("")) {return null;}

		
		return new Contatto(nome, cognome, telefono, email);
		
	}
	
	public void stampa() {
		
		System.out.println ("Nome: "+ nome+ " Cognome : "+ cognome + " Tel: " + telefono+ " Email : "+ email);
		
	}
		
	
}
