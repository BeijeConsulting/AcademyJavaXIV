package esercizi;
/*Realizzare un programma che, ricevuta in input una data in formato 13/09/2021 stampi le seguenti informazioni:
Lunedì 13 Settembre, giorno 256 dell'anno 2021, settimana numero 37
in italiano od inglese, va bene comunque*/

import java.time.*;
import java.time.temporal.ChronoField;
import java.util.Scanner;
public class Date {

	public static void main(String[] args) {
		
		Scanner tst = new Scanner(System.in);
		
	
		System.out.println("write a date (format: DD/MM/YYYY) ");
		String date2 = tst.next();
		
		int d = Integer.parseInt(date2.substring(0, 2));
		int m = Integer.parseInt(date2.substring(3, 5));
		int y = Integer.parseInt(date2.substring(6));
		
		LocalDate date = LocalDate.of(y, m, d);
		
		
		int dayOfYear = date.getDayOfYear();
		int number = date.getDayOfMonth();
	
		int year = date.getYear();
		
		Month mnt = date.getMonth();
		int weekOfYear = date.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
		String month = mnt.toString();
		
		DayOfWeek gg = date.getDayOfWeek();
		String dayOfWeek = gg.toString();
		
		
		
		String dateFinal = dayOfWeek + " " + number + " " + month + ", day " + dayOfYear + " of year " + year + ", " + "week number " + weekOfYear  ;  
		
		System.out.println(date);
		System.out.println(dateFinal);

		
		
		
		
	}


	
	

}
