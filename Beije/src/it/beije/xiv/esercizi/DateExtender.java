package it.beije.xiv.esercizi;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateExtender
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		
		String dateString = null;
		
		LocalDate date ;
		
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");;
		
		dateString = kb.next();
		kb.close();
		
		date = LocalDate.parse(dateString, f);
		
		System.out.print(date.getDayOfWeek() + " " + date.getDayOfMonth() + " " + date.getMonth() + ", giorno " + date.getDayOfYear() + " dell'anno " + date.getYear() + 
				", settimana numero " + date.getDayOfYear()/7+1);
	}
}