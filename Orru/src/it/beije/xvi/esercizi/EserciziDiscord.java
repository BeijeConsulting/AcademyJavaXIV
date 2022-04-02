package it.beije.xvi.esercizi;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class EserciziDiscord {
	
	/*Scrivere un programma che chieda agli utenti due stringhe in ingresso, le stringhe possono valere solo: “carta”, “forbice” o “sasso”. Il programma dovrà quindi effettuare 
	i dovuti controlli e dichiarare il vincitore secondo le note regole della “morra cinese” (forbice vince su carta, carta vince su sasso, sasso vince su forbice).*/
	public void morra() {
		System.out.println("Inserisci i due utenti (carta, sasso, forbice)");
		Scanner kb = new Scanner(System.in);
		String[] a = new String[2];
		for(int i = 0; i<a.length; i++) {
			System.out.print("Utente " +i+ ":");
			a[i] = kb.next();
			switch(a[i]) {
				case "carta":
				case "forbice":
				case "sasso":
					System.out.print("Utente" +i+ " valido.\n");
					break;
				default:
					System.out.print("Utente" +i+ " non valido.\n");
					return;
			}
		}
		
		if(a[0].equals(a[1])) {
			System.out.print("Nessuno ha vinto.\n");
		} else if (a[0].equals("carta")) {
			if(a[1].equals("forbice")) {
				System.out.println("Ha vinto l'utente 2!\n");
			} else {
				System.out.println("Ha vinto l'utente 1!\n");
			}
		} else if (a[0].equals("forbice")) {
			if(a[1].equals("sasso")) {
				System.out.println("Ha vinto l'utente 2!\n");
			} else {
				System.out.println("Ha vinto l'utente 1!\n");
			}
		} else if (a[0].equals("sasso")) {
			if(a[1].equals("carta")) {
				System.out.println("Ha vinto l'utente 2!\n");
			} else {
				System.out.println("Ha vinto l'utente 1!\n");
			}
		}
		
	}
	
	//Realizzare un programma che, ricevuta in input una data in formato 13/09/2021 stampi le seguenti informazioni:Lunedì 13 Settembre, giorno 256 dell'anno 2021, settimana numero 37
	public void printDate(String date) {
		int day = Integer.parseInt(date.substring(0, 2));
		String m = date.substring(3, 5);
		int month = 0;
		if(m.substring(0, 1).equals("0")) {
			month = Integer.parseInt(m.substring(1, 2));
		} else {
			month = Integer.parseInt(m);
		}
		int year = Integer.parseInt(date.substring(6, 10));
		
		LocalDate dateF = LocalDate.of(year, month, day);
		Calendar calndr = new GregorianCalendar(year, month, day);
		
		// create WeekFields
        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY, calndr.getMinimalDaysInFirstWeek());
  
        // apply weekOfYear()
        TemporalField weekOfYear
            = weekFields.weekOfYear();
  
        // get week of year for localdate
        int wY = dateF.get(weekOfYear);
		
		
		System.out.println(dateF.getDayOfWeek() +" "+ dateF.getDayOfMonth() +" "+ dateF.getMonth() +", day "+dateF.getDayOfYear()+ " of the year "+ dateF.getYear() +", week number " +wY);
	}
	

	public static void main(String[] args) {
		EserciziDiscord esercizi = new EserciziDiscord();
		//Call morra
		//esercizi.morra();

		//Call printDate
		esercizi.printDate("13/09/2021");
	}

}
