package it.beije.xiv.eserciziCOM;


import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, ParseException {
		
		
		Scanner scC = new Scanner(new File("C:\\Users\\luigi\\OneDrive\\Documenti\\GitHub\\AcademyJavaXIV\\Esercizi\\src\\it\\beije\\xiv\\eserciziCOM\\dati.txt"));
		Banca a = new Banca(scC);
		
		System.out.println("Le operazioni lette sono: "+ a.getAzione().size());
		
		double buy= a.totAcquisti();
		double sell= a.totVendite();
		
		a.stampaRisultati(a.getAzione().size(), buy, sell);
		

	}

}