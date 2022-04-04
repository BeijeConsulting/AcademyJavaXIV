package it.beije.xiv.nardella;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.WeekFields;
import java.util.Locale;


/*
 * Realizzare un programma che, ricevuta in input una data in formato 13/09/2021 stampi le seguenti informazioni:
 * Lunedì 13 Settembre, giorno 256 dell'anno 2021, settimana numero 37 
 * in italiano od inglese, va bene comunque
 * 
 */

public class EsercizioData {

	public static void main(String[] args) {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse("13/09/2015", f);		
		Locale locale = new Locale.Builder().setLanguage("it").setRegion("IT").build();
		System.out.println(date.getDayOfWeek() + " " + date.getDayOfMonth() + " " + date.getMonth() + ", giorno " +  date.getDayOfYear() +
				" dell'anno " + date.getYear() + " settimana numero " + 	date.get(WeekFields.of(locale).weekOfYear()));
		
	}
}
