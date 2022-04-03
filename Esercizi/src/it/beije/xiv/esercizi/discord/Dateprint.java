package it.beije.xiv.esercizi.discord;
import java.time.*;
import java.time.temporal.IsoFields;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//Realizzare un programma che, 
//ricevuta in input una data in 
//formato 13/09/2021 stampi le 
//seguenti informazioni:
//Lunedì 13 Settembre, 
//giorno 256 dell'anno 2021, 
//settimana numero 37

public class Dateprint {

	public static void main(String[] args) {
		
		DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");		//format for parsing
		Scanner scan = new Scanner(System.in);  					
		System.out.println("Enter a date (dd/mm/yyyy) please:");
		String s1 = scan.nextLine();								//scan for date
		LocalDate date = LocalDate.parse(s1,f1);					//create LocalDate object by parsing the scanned string
		scan.close();
		
		int weekNumber=date.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);	//get week number (complex operation) from IsoFields Class
		
		System.out.println((date.getDayOfWeek()+" "+date.getDayOfMonth()+" of "+date.getMonth()+", day "+date.getDayOfYear()+" of the year "+date.getYear()+", week number "+weekNumber+".").toLowerCase());
	}

}
